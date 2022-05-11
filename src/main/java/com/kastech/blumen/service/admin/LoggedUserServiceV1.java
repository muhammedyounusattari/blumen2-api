package com.kastech.blumen.service.admin;

import com.kastech.blumen.constants.ErrorMessageConstants;
import com.kastech.blumen.exception.DataModificationException;
import com.kastech.blumen.exception.DataNotFoundException;
import com.kastech.blumen.exception.InputValidationException;
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

    @Value("${blumen2.url.forgot.password}")
    private String blumenUrl;

    @Value("${email.create.user.tile}")
    private String createUserTitle;

    @Value("${email.create.user.body}")
    private String createUserBody;

    @Value("${email.forgot.password.title}")
    private String forgotPasswordTitle;

    @Value("${email.forgot.password.body}")
    private String forgotPasswordBody;

    @Value("${email.reset.password.title}")
    private String resetPasswordTitle;

    @Value("${email.reset.password.body}")
    private String resetPasswordBody;


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

            Optional<Organization> optionalOrganization = organizationRepository.findByOrgId(loggedUser.getOrgId());
            if (optionalOrganization.isEmpty()) {
                LOGGER.error("Organization Id {} not found in database", loggedUser.getOrgId());
                throw new DataNotFoundException(INVALID_ORGANIZATION_CODE);
            }
            if (!optionalOrganization.get().getOrgActive()) {
                LOGGER.error("Organization is Inactive");
                throw new DataNotFoundException(ORGANIZATION_INACTIVE);
            }

            final String emailInput = loggedUser.getEmail();
            if (optionalOrganization.get().getUsers().stream()
                    .filter(o -> o.getEmail().equalsIgnoreCase(emailInput.toLowerCase())).count() > 0) {
                throw new DataNotFoundException(EMAIL_DUPLICATE);
            }
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
        String tempLink = blumenUrl + uuid;
        loggedUser.setTempLink(tempLink);
        //set expiry of link to 1 day
        loggedUser.setLinkExpiryDate(DateUtil.setDates(1));
        loggedUser = loggedUserRepository.save(loggedUser);
        createUserBody = createUserBody.replace("{0}", tempLink).replace("{1}", loggedUser.getOrgCode()).replace("{2}", loggedUser.getEmail());
        sendMailService.sendMail(loggedUser.getEmail(),createUserTitle,createUserBody);

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
        if(loggedUser.getActive()) {
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

            if (!loggedUser.getRoleName().equalsIgnoreCase(existingUser.getRoleName())) {
                List<Roles> roles = rolesRepository.findByOrgIdAndRole(loggedUser.getOrgId(), loggedUser.getRoleName());
                if (roles.isEmpty() || roles.get(0).getPrivileges().isEmpty()) {
                    LOGGER.error("Organization {} don't have role {} or its privileges", loggedUser.getOrgId(), loggedUser.getRoleName());
                    throw new DataNotFoundException(ORGANIZATION_ROLE_SETUP_MISSING);
                }
                existingUser.setRoles((roles.stream().collect(Collectors.toSet())));
            }
            existingUser.setRoleName(loggedUser.getRoleName());
        } else { //delete User meaning deactivate
            existingUser.setActive(loggedUser.getActive());
            existingUser.setEditedDate(new Date());
            existingUser.setEditedBy(SecurityUtil.getEmail());
        }
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

        Optional<Organization> optionalOrganization = organizationRepository.findByOrgCode(orgCode);
        if (optionalOrganization.isEmpty()) {
            LOGGER.error("Organization {} not found in database", orgCode);
            throw new DataNotFoundException(INVALID_ORGANIZATION_CODE);
        }

        if (!optionalOrganization.get().getOrgActive()) {
            LOGGER.error("Organization is Inactive");
            throw new DataNotFoundException(ORGANIZATION_INACTIVE);
        } else if (!optionalLoggedUser.get().getActive()) {
            LOGGER.error("User is Inactive");
            throw new DataNotFoundException(USER_INACTIVE);
        }

        LoggedUser loggedUser = optionalLoggedUser.get();
        String uuid = UUID.randomUUID().toString();
        loggedUser.setHashedCode(uuid);
        loggedUser.setCreatedDate(new Date());
        String tempLink = blumenUrl + uuid;
        loggedUser.setTempLink(tempLink);
        //set expiry of link based on org check
        loggedUser.setLinkExpiryDate(DateUtil.setDates(1));
        loggedUserRepository.save(loggedUser);
        resetPasswordBody = resetPasswordBody.replace("{0}", tempLink);
        sendMailService.sendMail(loggedUser.getEmail(), resetPasswordTitle, resetPasswordBody);
        return resetPasswordBody;

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

            Optional<Organization> organization = organizationRepository.findByOrgId(loggedUser.getOrgId());
            loggedUser.setPasswordExpiryDate(DateUtil.setDates(
                            organization.get().getOrgDaysToExpire() == null ? 30 : organization.get().getOrgDaysToExpire()));
            loggedUser.setLinkExpiryDate(DateUtil.setDates(-1));
            loggedUser.setPassword(updatePassword);
            loggedUser.setHashedCode("");
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

                String maskEmail = email;
                if (maskEmail != null) {
                    maskEmail = maskEmail.charAt(0) + "*****" + maskEmail.charAt(maskEmail.length() - 1);
                }
                loggedUser.setHashedCode(UUID.randomUUID().toString());
                String tempLink = blumenUrl + loggedUser.getHashedCode();
                loggedUser.setTempLink(tempLink);
                loggedUser.setLinkExpiryDate(DateUtil.setDates(1));
                loggedUserRepository.save(loggedUser);
                forgotPasswordBody = forgotPasswordBody.replace("{0}", tempLink);

                sendMailService.sendMail(loggedUser.getEmail(), forgotPasswordTitle, forgotPasswordBody);
                statusMap.put("message", "Email has been sent to your registered mail id " + maskEmail + " and link is " + tempLink);
                statusMap.put("status", "200");
                return statusMap;
            } else {
                statusMap.put("message", "Invalid Credentials");
                statusMap.put("status", "400");
                return statusMap;
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred while we tried to forgot password {}", e.getMessage());
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
        List<LoggedUser> loggedUserList = null;
        LoggedUser user = null;
        //Basic validation
        Map<String,String> successMap = new HashMap<>();


        //check if password exist
        if(!StringUtils.isEmpty(password)){
            loggedUserList =   loggedUserRepository.findByUserDetails(email, password,orgCode);
            if(loggedUserList.isEmpty()){
                successMap.put("message", "Current Password is Invalid");
                successMap.put("status", "400");
                return successMap;
            }
            user = loggedUserList.get(0);
        } else if  (!(StringUtils.isEmpty(securityQuestion1) || StringUtils.isEmpty(securityQuestion2) ||  StringUtils.isEmpty(securityAnswer1 ) || StringUtils.isEmpty(securityAnswer2))){
            Optional<LoggedUser> loggedUsers = loggedUserRepository.findByEmailAndOrgCode(email, orgCode);
            if(loggedUsers.isEmpty()){
                successMap.put("message", "Logged-In User Not Found");
                successMap.put("status", "400");
                return successMap;
            }
            user = loggedUsers.get();
        } else {
            if(StringUtils.isEmpty(password)){
                successMap.put("message", "Password missing");
                successMap.put("status", "400");
                return successMap;
            }  else {
                successMap.put("message", "Security Question/Answers missing");
                successMap.put("status", "400");
                return successMap;
            }
        }

        if(!StringUtils.isEmpty(confPassword)){
            LoggedUser loggedUser = user;
            user.setPassword(confPassword);
            Optional<Organization> organization = organizationRepository.findByOrgId(loggedUser.getOrgId());
            loggedUser.setPasswordExpiryDate(DateUtil.setDates(
                    organization.get().getOrgDaysToExpire() == null ? 30 : organization.get().getOrgDaysToExpire()));
            loggedUserRepository.save(loggedUser);
            successMap.put("message", "Password updated successfully");
            successMap.put("status", "200");
            return successMap;
        } else if (!(StringUtils.isEmpty(securityQuestion1) || StringUtils.isEmpty(securityQuestion2) ||  StringUtils.isEmpty(securityAnswer1 ) || StringUtils.isEmpty(securityAnswer2))){
            LoggedUser loggedUser = user;
            loggedUser.setSecurityQuestion1(securityQuestion1);
            loggedUser.setSecurityQuestion2(securityQuestion2);
            loggedUser.setSecurityAnswer1(securityAnswer1);
            loggedUser.setSecurityAnswer2(securityAnswer2);
            loggedUser.setFirstTime(false);
            loggedUserRepository.save(loggedUser);
            successMap.put("message", "Security Questions Updated successfully");
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

    public Map<String,Object> forceLoggedOutUser(long userId) {
        Map<String,Object> payload = new HashMap<>();
        Optional<LoggedUser> loggedUsers = loggedUserRepository.findById(userId);
        if(!loggedUsers.isEmpty()){
            LoggedUser  loggedUserDb = loggedUsers.get();
            loggedUserDb.setLastLogout(DateUtil.setDates(0));
            loggedUserDb.setEditedDate(new Date());
            loggedUserRepository.save(loggedUserDb);
            payload.put("message", "user logout successfully");
            payload.put("status", 200);
        } else {
            payload.put("message", "user is already loggedout");
            payload.put("status", 400);
        }
        return payload;
    }


    public Map<String,Object> generateCode() {
       LOGGER.info("call made to generateCode {}", this.getClass());
       Integer authCode = new Random().nextInt(999999);
        Optional<LoggedUser> loggedUsers = loggedUserRepository.findByEmailAndOrgCode(SecurityUtil.getEmail(), SecurityUtil.getUserOrgCode());
        Date codeExpiryDate  = new Date();
        if(!loggedUsers.isEmpty()) {
            LoggedUser loggedUserDb = loggedUsers.get();
            loggedUserDb.setAuthCode(authCode);
            loggedUserDb.setModifiedBy(SecurityUtil.getUserId());
            Optional<Organization> organization = organizationRepository.findByOrgId(loggedUserDb.getOrgId());
            loggedUserDb.setAuthCodeExpiryDate(DateUtil.setMinutes(
                    organization.get().getOrgExpiryTime() == null ? 10 : organization.get().getOrgExpiryTime()));
            codeExpiryDate = loggedUserDb.getAuthCodeExpiryDate();
            loggedUserRepository.save(loggedUserDb);
            sendMailService.sendMail(loggedUserDb.getEmail(),"Auth Code from blumen2", "Your authcode is "+authCode);
        }
        LOGGER.info("Code generated successfully {}", authCode);
        Map<String,Object> map = new HashMap<>();
        map.put("codeExpiryTime",codeExpiryDate);
        return map;
    }

    public void validateMFACode(Integer authCode) {
        LOGGER.info("call made to validateMFACode {}", this.getClass());
        Optional<LoggedUser> loggedUsers = loggedUserRepository.findByEmailAndOrgCode(SecurityUtil.getEmail(), SecurityUtil.getUserOrgCode());
        if(!loggedUsers.isEmpty()) {
            LoggedUser loggedUserDb = loggedUsers.get();
            Integer authCodeDB = loggedUserDb.getAuthCode();
            if(authCodeDB!=null && authCode.equals(authCodeDB)){
                if(!loggedUserDb.getAuthCodeExpiryDate().after(new Date())) {
                    throw new DataNotFoundException(ErrorMessageConstants.AUTHCODE_EXPIRED) {
                    };
                }
                loggedUserDb.setAuthCode(null);
                loggedUserDb.setModifiedBy(SecurityUtil.getUserId());
                loggedUserDb.setAuthCodeExpiryDate(null);
                loggedUserRepository.save(loggedUserDb);
            } else {
                throw new InputValidationException(AUTHCODE_INVALID);
            }
        }
    }
}