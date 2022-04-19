package com.kastech.blumen.service.admin;

import com.kastech.blumen.mail.SendMailService;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.service.superadmin.OrganizationService;
import com.kastech.blumen.utility.CommonUtil;
import com.kastech.blumen.utility.DateUtil;
import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class LoggedUserServiceV1 {

    @Autowired
    LoggedUserRepository loggedUserRepository;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    SendMailService sendMailService;

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

    public Optional<LoggedUser> findLoggedUser(String email, String orgType) {
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findByUserEmailAndOrgType(email, orgType);
        return optionalLoggedUser;
    }

    public Optional<LoggedUser> findLoggedUserById(Long id) {
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findById(id);
        return optionalLoggedUser;
    }

    public void deleteById(Long id) {
        loggedUserRepository.deleteById(id);
    }

    public Optional<LoggedUser> findByOrgId(Long orgCode) {
        return loggedUserRepository.findByOrgId(orgCode);
    }

    public List<LoggedUser> findLoggedUserDetails(String userName, String password, String orgId) {
        List<LoggedUser> loggedUsers = loggedUserRepository.findByUserDetails(userName, password, orgId);
        return loggedUsers;
    }

    public LoggedUser createUser(LoggedUser loggedUser) throws Exception {
        //only Admin can create users with in organization/// add role to method

        Long orgIdOfUserLoggedIn = SecurityUtil.getUserOrgId();
        //if login with org admin, get org id from jwt token.
        if (orgIdOfUserLoggedIn != 0) { //org admin
            loggedUser.setOrgId(SecurityUtil.getUserOrgId());
            loggedUser.setOrgType(SecurityUtil.getUserOrgType());
        } else if (orgIdOfUserLoggedIn == 0 && loggedUser.getOrgId() != null) {
            //super admin - expect org type, org id from ui
            loggedUser.setOrgId(loggedUser.getOrgId());
            loggedUser.setOrgType(loggedUser.getOrgType());
        }

        loggedUser = loggedUserRepository.save(loggedUser);
        Organization organization = new Organization();
        organization.setOrgId(loggedUser.getOrgId());
        organization.setOrgOrganizationType(loggedUser.getOrgType());
        organizationService.batchUpdateForOrgAdmin(loggedUser, organization);

        return loggedUser;
    }


    public List<LoggedUser> loadUsers(Long userOrgId) {
        return loggedUserRepository.getUsersList(userOrgId);
    }

    public String resetPasswordForUser(String email, String orgType) throws Exception {
        LOGGER.info("call made for resetPasswordForUser under {}", this.getClass());
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findByUserEmailAndOrgType(email, orgType);
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

    public Map<String, String> validateOrgType(String orgTyp) {
        Map<String, String> statusMap = new HashMap<>();
        Optional<Organization> organizations = organizationRepository.findByOrgType(orgTyp);

        if (organizations.isEmpty()) {
            statusMap.put("message", "Invalid OrgCode.");
            statusMap.put("status", "404");
            return statusMap;
        }
        statusMap.put("status", "200");
        return statusMap;

    }

    public Map<String, String> getSecurityQuestions(String orgType, String email) {
        Map<String, String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUserFound = loggedUserRepository.findByEmailAndOrgType(email, orgType);
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

    public Map<String, String> checkCredentials(String orgType, String email, String securityAnswer1, String securityAnswer2) {
        Map<String, String> statusMap = new HashMap<>();
        LOGGER.info("Call made to checkCredentials of ", this.getClass());
        try {
            Optional<LoggedUser> loggedUserFound = loggedUserRepository.findByEmailAndOrgType(email, orgType);
            if (!loggedUserFound.isEmpty()) {
                LOGGER.info("user with email {} and orgType {} is valid", email, orgType);
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

 /*   public void changePassword(String token, UserSecurityInfo userSecurityInfo, String realmId, String id) {
        {
            String password = userSecurityInfo.getPassword();
            KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
            String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced/reset-password";
            keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
            keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
            keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);

            //Build the Credentials object to pass it to the keycloak.
            Credentials.CredentialsBuilder credentialsBuilder = new Credentials.CredentialsBuilder();
            Credentials credentials = credentialsBuilder.type("password")
                    .value(password)
                    .temporary(false)
                    .buildCredentials();

            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Authorization", "Bearer "+token);
            headers.add("Content-Type", "application/json");
            HttpEntity<Credentials> request = new HttpEntity<>(credentials, headers);
            restTemplate.put(keycloakUserInfoUrl, request);

            //Update the User Security Info with the new security question and answers

            UserSecurityInfoId userSecurityInfoId = new UserSecurityInfoId(id, realmId);
            Optional<UserSecurityInfo> optionalUserSecurityInfo = userSecurityInfoServiceV1.findUserSecurityInfoById(userSecurityInfoId);
            if (optionalUserSecurityInfo.isPresent()) {
                UserSecurityInfo userSecurityInfoToBeUpdated = optionalUserSecurityInfo.get();
                userSecurityInfoToBeUpdated.setSecurityQuestion1(userSecurityInfo.getSecurityQuestion1());
                userSecurityInfoToBeUpdated.setSecurityAnswer1(userSecurityInfo.getSecurityAnswer1());
                userSecurityInfoToBeUpdated.setSecurityQuestion2(userSecurityInfo.getSecurityQuestion2());
                userSecurityInfoToBeUpdated.setSecurityAnswer2(userSecurityInfo.getSecurityAnswer2());
                userSecurityInfoToBeUpdated.setPassword(userSecurityInfo.getPassword());
                userSecurityInfoServiceV1.updateUserSecurityInfo(userSecurityInfoToBeUpdated);
            }


            //Update the metadata to convey that the password is now changed permanently.
            Optional<UserMetaData> optionalUserMetaData = null;
            UserMetaDataId userMetaDataId = new UserMetaDataId(id, realmId);
            optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
            if (optionalUserMetaData.isPresent()) {
                UserMetaData userMetaData = optionalUserMetaData.get();
                userMetaData.setTemporary(false);
            }

        }
} */

    public Map<String,String> changePassword(Map<String, String> requestPaylaod) {
        String email = SecurityUtil.getEmail();
        String orgType = SecurityUtil.getUserOrgType();
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
         loggedUsers =   loggedUserRepository.findByUserDetails(email, password,orgType);
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
}