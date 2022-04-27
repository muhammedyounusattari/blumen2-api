package com.kastech.blumen.service.admin;

import com.kastech.blumen.constants.ErrorMessageConstants;
import com.kastech.blumen.exception.DataModificationException;
import com.kastech.blumen.exception.DataNotFoundException;
import com.kastech.blumen.mail.EmailService;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.repository.roles.RolesRepository;
import com.kastech.blumen.service.superadmin.OrganizationService;
import com.kastech.blumen.utility.CommonUtil;
import com.kastech.blumen.utility.DateUtil;
import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.kastech.blumen.constants.ErrorMessageConstants.*;

@Service
public class LoggedUserServiceV1 {

    @Autowired
    LoggedUserRepository loggedUserRepository;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    private EmailService sendMailService;
    //SendMailService sendMailService;

    @Value("${blumen2.url}")
    private String blumenUrl;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggedUserServiceV1.class);

    public LoggedUser doService(String reqBody) {

        LoggedUser loggedUser = CommonUtil.convertJsonStringToPojoForLoggedUser(reqBody);
        return loggedUser;

    }

    public LoggedUser addLoggedUser(LoggedUser loggedUser) {
        return loggedUserRepository.save(loggedUser);
    }

    public Optional<LoggedUser> findLoggedUser(String email, String orgCode) {
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findByUserEmailAndOrgCode(email, orgCode);
        return optionalLoggedUser;
    }

    public Optional<LoggedUser> findLoggedUserById(Long id) {
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findById(id);
        return optionalLoggedUser;
    }

    public void deleteById(Long id) {
        loggedUserRepository.deleteById(id);
    }

    public List<LoggedUser> findByOrgId(Long orgCode) {
        return loggedUserRepository.findByOrgId(orgCode);
    }

    public List<LoggedUser> findLoggedUserDetails(String userName, String password, String orgCode) {
        List<LoggedUser> loggedUsers = loggedUserRepository.findByUserDetails(userName, password, orgCode);
        return loggedUsers;
    }

    public LoggedUser createUser(LoggedUser loggedUser) {
        //only Admin can create users with in organization/// add role to method

        Long orgIdOfUserLoggedIn = SecurityUtil.getUserOrgId();
        //if login with org admin, get org id from jwt token.
        if (orgIdOfUserLoggedIn != 0) { //org admin
            loggedUser.setOrgId(SecurityUtil.getUserOrgId());
            loggedUser.setOrgCode(SecurityUtil.getUserOrgCode());
        } else if (orgIdOfUserLoggedIn == 0 && loggedUser.getOrgId() != null) {
            //super admin - expect org type, org id from ui
            loggedUser.setOrgId(loggedUser.getOrgId());
            loggedUser.setOrgCode(loggedUser.getOrgCode());
        }

        List<Roles> roles = rolesRepository.findByOrgIdAndRole(loggedUser.getOrgId(), loggedUser.getRoleName());
        if (roles.isEmpty() || roles.get(0).getPrivileges().isEmpty()) {
            LOGGER.error("Organization {} don't have role {} or privileges for new user", loggedUser.getOrgId(), loggedUser.getRoleName());
            throw new DataNotFoundException(ErrorMessageConstants.ORGANIZATION_ROLE_SETUP_MISSING);
        }
        loggedUser.setRoles((roles.stream().collect(Collectors.toSet())));
        loggedUser.setLastLogin(DateUtil.setDates(0));

        try {
            loggedUser = loggedUserRepository.save(loggedUser);
        } catch(Exception e) {
            LOGGER.error("Saving User failed for user {}", loggedUser, e);
            throw new DataModificationException(ErrorMessageConstants.USER_CREATE_FAILED);
        }

        Organization organization = new Organization();
        organization.setOrgId(loggedUser.getOrgId());

        try {
            organizationService.batchUpdateForOrgAdmin(loggedUser, organization);
        } catch(Exception e) {
            LOGGER.error("Configuring User config with org failed user {}", loggedUser, e);
            throw new DataNotFoundException(ErrorMessageConstants.USER_COPY_CONFIG_FAILED);
        }

        //send email service

        String uuid = UUID.randomUUID().toString();
        loggedUser.setHashedCode(uuid);
        loggedUser.setCreatedDate(new Date());
        String tempLink = blumenUrl + "reset-password/#" + uuid;
        loggedUser.setTempLink(tempLink);
        //set expiry of link to 1 day
        loggedUser.setLinkExpiryDate(DateUtil.setDates(1));
        loggedUserRepository.save(loggedUser);
        sendMailService.sendMail(loggedUser.getEmail(),"Usercreated password link","Congratulation your account with orgCode "+loggedUser.getOrgCode()+" and email "+loggedUser.getEmail()+" and password set link "+loggedUser.getTempLink());

        return loggedUser;
    }

    public LoggedUser updateUser(LoggedUser loggedUser) {
        //only Admin can create users with in organization/// add role to method
        Optional<LoggedUser> users = loggedUserRepository.findById(loggedUser.getId());
        LoggedUser existingUser = null;
        if(users.isEmpty()) {
            LOGGER.error("UserId {} not found in database", loggedUser.getId());
            throw new UsernameNotFoundException("UserId not found");
        } else {
            existingUser = users.get();
            if (existingUser.getOrgId() != loggedUser.getOrgId()) {
                LOGGER.error("Organization of user - {} can't be changed", existingUser.getOrgId());
                throw new DataModificationException(ORG_USER_MOVE_NOT_ALLWOED);
            }
        }

        existingUser.setUsername(loggedUser.getUsername());
        existingUser.setActive(loggedUser.getActive());
        existingUser.setFirstName(loggedUser.getFirstName());
        existingUser.setLastName(loggedUser.getLastName());
        existingUser.setAddress1(loggedUser.getAddress1());
        existingUser.setAddress2(loggedUser.getAddress2());
        existingUser.setCity(loggedUser.getCity());
        existingUser.setState(loggedUser.getState());
        existingUser.setZipcode(loggedUser.getZipcode());
        existingUser.setMobile(loggedUser.getMobile());
        existingUser.setPhone1(loggedUser.getPhone1());
        existingUser.setPhone2(loggedUser.getPhone2());
        existingUser.setFax(loggedUser.getFax());
        existingUser.setEmail(loggedUser.getEmail());
        existingUser.setNotes(loggedUser.getNotes());
        existingUser.setSiteLocation(loggedUser.getSiteLocation());
        existingUser.setEditedDate(new Date());
        existingUser.setEditedBy(SecurityUtil.getEmail());

        //future
        // existingUser.setBolt(loggedUser.getBolt());

        if(!loggedUser.getRoleName().equalsIgnoreCase(existingUser.getRoleName())) {
            List<Roles> roles = rolesRepository.findByOrgIdAndRole(loggedUser.getOrgId(), loggedUser.getRoleName());
            if (roles.isEmpty() || roles.get(0).getPrivileges().isEmpty()) {
                LOGGER.error("Organization {} don't have role {} or its privileges", loggedUser.getOrgId(), loggedUser.getRoleName());
                throw new DataNotFoundException(ORGANIZATION_ROLE_SETUP_MISSING);
            }
            existingUser.setRoles((roles.stream().collect(Collectors.toSet())));
        }
        existingUser.setRoleName(loggedUser.getRoleName());

        try {
            loggedUser = loggedUserRepository.save(existingUser);
        } catch (Exception e) {
            throw new DataModificationException(USER_UPDATE_FAILED);
        }
        return loggedUser;
    }


    public List<LoggedUser> loadUsers(Long userOrgId) {
        return loggedUserRepository.getUsersList(userOrgId);
    }

    public String resetPasswordForUser(String email, String orgCode) throws Exception {
        LOGGER.info("call made for resetPasswordForUser under {}", this.getClass());
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findByUserEmailAndOrgCode(email, orgCode);
        if (optionalLoggedUser.isEmpty()) {
            LOGGER.error("Username {} not found in database", email);
            throw new UsernameNotFoundException("Username not found");
        }

        LoggedUser loggedUser = optionalLoggedUser.get();
        String uuid = UUID.randomUUID().toString();
        loggedUser.setHashedCode(uuid);
        loggedUser.setCreatedDate(new Date());
        String tempLink = blumenUrl + "reset-password/#" + uuid;
        loggedUser.setTempLink(tempLink);
        //set expiry of link to 1 day
        loggedUser.setLinkExpiryDate(DateUtil.setDates(1));
        loggedUserRepository.save(loggedUser);
        String subject = "Reset your password";
        String content = "<h1>Please click on below link to reset password</h1> <h3>" + tempLink + "</h3>";

        sendMailService.sendMail(loggedUser.getEmail(), subject, content);
        return content;
        //check if the user exist in database or not
    }


    public Map<String, String> updatePassword(String updatePassword, String hashedCode) {
        Map<String, String> statusMap = new HashMap<>();
        if (hashedCode != null) {

            Optional<LoggedUser> loggedUsers = loggedUserRepository.findByHashedCode(hashedCode);
            if (loggedUsers.isEmpty()) {
                statusMap.put("message", "Invalid Link");
                statusMap.put("status", "404");
                return statusMap;
            }

            LoggedUser loggedUser = loggedUsers.get();
            Date date = new Date();
            if (!date.before(loggedUser.getLinkExpiryDate())) {
                statusMap.put("message", "Link got expired, please regenerate by access blumen application--> forgot password.");
                statusMap.put("status", "404");
                return statusMap;
            }

            loggedUser.setExpiryDate(DateUtil.setDates(-1));
            loggedUser.setPassword(updatePassword);
            loggedUserRepository.save(loggedUser);
            statusMap.put("message", "Password Updated successfully");
            statusMap.put("status", "200");
        }
        return statusMap;
    }

    public Map<String, String> validateOrgCode(String orgCode) {
        Map<String, String> statusMap = new HashMap<>();
        Optional<Organization> organizations = organizationRepository.findByOrgCode(orgCode);

        if (organizations.isEmpty()) {
            statusMap.put("message", "Invalid OrgCode.");
            statusMap.put("status", "404");
            return statusMap;
        }
        statusMap.put("status", "200");
        return statusMap;

    }

    public Map<String, String> getSecurityQuestions(String orgCode, String email) {
        Map<String, String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUserFound = loggedUserRepository.findByEmailAndOrgCode(email, orgCode);
        if (loggedUserFound.isEmpty()) {
            statusMap.put("message", "Invalid Credentials.");
            statusMap.put("status", "404");
            return statusMap;
        } else {
            LoggedUser loggedUser = loggedUserFound.get();
            statusMap.put("SecurityQuestion1", loggedUser.getSecurityQuestion1());
            statusMap.put("SecurityQuestion2", loggedUser.getSecurityQuestion2());
            statusMap.put("status", "200");
            return statusMap;
//            } else {
//                return statusMap;
//            }
        }
        //  statusMap.put("message", "Invalid Credentials.");
        //    statusMap.put("status", "404");
        //    return statusMap;
    }

    public Map<String, String> checkCredentials(String orgCode, String email, String securityAnswer1, String securityAnswer2) {
        Map<String, String> statusMap = new HashMap<>();
        LOGGER.info("Call made to checkCredentials of {}", this.getClass());
        try {
            Optional<LoggedUser> loggedUserFound = loggedUserRepository.findByEmailAndOrgCode(email, orgCode);
            if (!loggedUserFound.isEmpty()) {
                LOGGER.info("user with email {} and orgCode {} is valid", email, orgCode);
                LoggedUser loggedUser = loggedUserFound.get();
                Integer wrongAttempts = loggedUser.getWrongAttempt();
                if (wrongAttempts != null && wrongAttempts > 4) {
                    LOGGER.warn("WARNING: Your Account with email {} is locked. Please contact to support team or admin.", email);
                    statusMap.put("message", "WARNING: Your Account is locked. Please contact to support team or admin.");
                    statusMap.put("status", "403");
                    statusMap.put("wrongAttempts", "" + wrongAttempts);
                    return statusMap;
                }

                if (!securityAnswer1.equalsIgnoreCase(loggedUser.getSecurityAnswer1())) {
                    statusMap.put("message", "Invalid Security Answer1");
                    statusMap.put("status", "404");
                    return statusMap;
                }

                if (!securityAnswer2.equalsIgnoreCase(loggedUser.getSecurityAnswer2())) {
                    statusMap.put("message", "Invalid Security Answer2");
                    statusMap.put("status", "404");
                    return statusMap;
                }
                loggedUser.setHashedCode(UUID.randomUUID().toString());
                loggedUser.setLinkExpiryDate(DateUtil.setDates(1));

                String maskEmail = email;
                if (maskEmail != null) {
                    maskEmail = maskEmail.charAt(0) + "*****" + maskEmail.charAt(maskEmail.length() - 1);
                }
                String tempLink = blumenUrl + "reset-password/#" + loggedUser.getHashedCode();
                loggedUser.setTempLink(tempLink);
                loggedUserRepository.save(loggedUser);

                String subject = "Reset your password";
                String content = "<h1>Please click on below link to reset password</h1> <h3>" + tempLink + "</h3>";

                sendMailService.sendMail(loggedUser.getEmail(), subject, content);
                statusMap.put("message", "Email has been sent to your registered mail id " + maskEmail + " and link is " + tempLink);
                statusMap.put("status", "200");
                return statusMap;
            } else {
                statusMap.put("message", "Invalid Credentials");
                statusMap.put("status", "400");
                return statusMap;
            }
        } catch (Exception e) {
            LOGGER.error("Exception occured while we tried to forgot password {}", e.getMessage());
            statusMap.put("message", "Exception occured while we tried to forgot password " + e.getMessage());
            statusMap.put("status", "500");
            return statusMap;
        }

    }

    public Map<String,String> changePassword(Map<String, String> requestPaylaod) {
        String email = SecurityUtil.getEmail();
        String orgCode = SecurityUtil.getUserOrgCode();
        String password = requestPaylaod.get("password");
        String confPassword = requestPaylaod.get("confPassword");
        String securityQuestion1 = requestPaylaod.get("securityQuestion1");
        String securityQuestion2 = requestPaylaod.get("securityQuestion2");
        String securityAnswer1 = requestPaylaod.get("securityAnswer1");
        String securityAnswer2 = requestPaylaod.get("securityAnswer2");
        List<LoggedUser> loggedUsers = null;
        //Basic validation
        Map<String,String> successMap = new HashMap<>();
        if(StringUtils.isEmpty(password)){
            successMap.put("message", "Password missing");
            successMap.put("status", "400");
            return successMap;
        }

        //check if password exist
        if(!StringUtils.isEmpty(password)){
         loggedUsers =   loggedUserRepository.findByUserDetails(email, password,orgCode);
         if(loggedUsers.isEmpty()){
             successMap.put("message", "Current Password is Invalid");
             successMap.put("status", "400");
             return successMap;
         }
        }

        if(!(StringUtils.isEmpty(confPassword) || StringUtils.isEmpty(securityQuestion1) || StringUtils.isEmpty(securityQuestion2) ||  StringUtils.isEmpty(securityAnswer1 ) || StringUtils.isEmpty(securityAnswer2))){
            LoggedUser loggedUser = loggedUsers.get(0);
            loggedUser.setPassword(confPassword);
            loggedUser.setSecurityQuestion1(securityQuestion1);
            loggedUser.setSecurityQuestion2(securityQuestion2);
            loggedUser.setSecurityAnswer1(securityAnswer1);
            loggedUser.setSecurityAnswer2(securityAnswer2);
            loggedUserRepository.save(loggedUser);
            successMap.put("message", "Password updated successfully");
            successMap.put("status", "200");
            return successMap;
        }
        return successMap;
    }

    public Map<String,Object> validateEmailAndOrgCode(String email, String orgCode) {
      LOGGER.info("call made to validateEmailAndOrgCode");
//      String nonSSo =   loggedUserRepository.findByUserAndOrgCode(email,orgCode);
      Map<String,Object> map = new HashMap<>();
      Optional<LoggedUser> loggedUsers = loggedUserRepository.findByEmailAndOrgCode(email,orgCode);
      if(loggedUsers.isEmpty()){
          LOGGER.error("Not a valid email or orgid ");
          throw new DataNotFoundException(ErrorMessageConstants.INVALID_ORGCODE_EMAIL_ID);
      }
      LoggedUser loggedUser = loggedUsers.get();
      map.put("isFirstTime",loggedUser.getFirstTime());
      map.put("isSSOEnabled", null);
      map.put("status", 200);
      return map;
    }

    public Map<String,Object> logoutUser() {
        String email = SecurityUtil.getEmail();
        String orgCode = SecurityUtil.getUserOrgCode();
        Map<String,Object> payload = new HashMap<>();
        Optional<LoggedUser> loggedUsers = loggedUserRepository.findByEmailAndOrgCode(email,orgCode);
        if(!loggedUsers.isEmpty()){
          LoggedUser  loggedUserDb = loggedUsers.get();
          loggedUserDb.setLastLogout(DateUtil.setDates(0));
          loggedUserRepository.save(loggedUserDb);
          payload.put("message", "user logout successfully");
          payload.put("status", 200);
        } else {
            payload.put("message", "user is already loggedout");
            payload.put("status", 400);
        }
        return payload;
    }
}