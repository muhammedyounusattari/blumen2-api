package com.kastech.blumen.service.keycloak;

import com.kastech.blumen.exception.LoginAttemptsException;
import com.kastech.blumen.mailinator.BlumenMail;
import org.keycloak.authorization.client.util.HttpResponseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
import com.kastech.blumen.service.admin.UserMetaDataServiceV1;
import com.kastech.blumen.service.admin.UserSecurityInfoServiceV1;
import com.kastech.blumen.utility.KeycloakPropertyReader;
import com.kastech.blumen.utility.KeycloakUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.representations.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.io.Resource;

import java.io.UnsupportedEncodingException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class KeycloakAdminClientService {

    private String authServerUrl;
    private String realm;
    private String clientId;
    private String clientSecret;

    @Autowired
    private KeycloakPropertyReader keycloakPropertyReader;

    @Autowired
    private UserMetaDataServiceV1 userMetaDataServiceV1;

    @Autowired
    private UserSecurityInfoServiceV1 userSecurityInfoServiceV1;

    @Autowired
    private BlumenMail blumenMail;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoggedUserServiceV1 loggedUserServiceV1;

    private  final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private KeycloakConfigurationValues loadValues(String realmId) {
        KeycloakConfigurationValues keycloakConfigurationValues = new KeycloakConfigurationValues();
        try {
            Resource res = applicationContext.getResource("classpath:" + realmId + "-keycloak.json");
            Map propertyMap = new ObjectMapper().readValue(res.getInputStream(), Map.class);
            keycloakConfigurationValues.setClientId(propertyMap.get("resource").toString());
            Map credentialsMap = (Map) propertyMap.get("credentials");
            keycloakConfigurationValues.setClientSecret(credentialsMap.get("secret").toString());
            keycloakConfigurationValues.setAuthServerUrl(propertyMap.get("auth-server-url").toString());
            keycloakConfigurationValues.setRealm(propertyMap.get("realm").toString());
        } catch (java.io.IOException ioException) {

        }
        return keycloakConfigurationValues;

    }

    public Map<String, String> login(LoginRequest loginRequest, String realmId) throws HttpResponseException {

        AccessTokenResponse response = null;
        Map<String, String> statusMap = new HashMap<>();
        Integer wrongAttempts = 0;
        LoggedUser loggedUser = new LoggedUser();

        try {
            KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
            Map<String, Object> clientCredentials = new HashMap<>();
            clientCredentials.put("secret", keycloakConfigurationValues.getClientSecret());
            clientCredentials.put("grant_type", "password");
            Configuration configuration = new Configuration(keycloakConfigurationValues.getAuthServerUrl(), realmId, keycloakConfigurationValues.getClientId(), clientCredentials, null);
            AuthzClient authzClient = AuthzClient.create(configuration);
            statusMap.put("status", "200");

            loggedUser = new LoggedUser();
            Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(loginRequest.getUsername(), realmId);
            if (!loggedUserFound.isEmpty()) {
                loggedUser = loggedUserFound.get();
                wrongAttempts = loggedUser.getWrongAttempt();
                if (wrongAttempts != null && wrongAttempts > 4) {
                    throw new LoginAttemptsException();
                }
            } else {
                // response = authzClient.obtainAccessToken(loginRequest.getUsername(), loginRequest.getPassword());
           /*     LoggedUserId loggedUserId = new LoggedUserId();
               // loggedUserServiceV1.deleteById(loggedUserId);
                UserSecurityInfo userSecurityInfo = new UserSecurityInfo();
                userSecurityInfo.setOrgId(realmId);
                userSecurityInfo.setId(realmId);
                userSecurityInfo = userSecurityInfoServiceV1.addUserSecurityInfo(userSecurityInfo);

                String uuid = UUID.randomUUID().toString();
                loggedUser.setId(realmId);
                loggedUser.setUserName(loginRequest.getUsername());
                loggedUser.setOrgId(realmId);
                loggedUser.setFirstTime(Boolean.TRUE);
                loggedUser.setUserSecurityInfo(userSecurityInfo);
                loggedUserServiceV1.addLoggedUser(loggedUser);
               */
                throw new UsernameNotFoundException("Username not found");
            }
            response = authzClient.obtainAccessToken(loginRequest.getUsername(), loginRequest.getPassword());
            statusMap.put("access_token", response.getToken());
            statusMap.put("isFirstTime", "" + loggedUser.getFirstTime());
            //logic to decrypt the access token and insert the user details into the database.
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String[] chunks = response.getToken().split("\\.");
            String header = new String(decoder.decode(chunks[0]));
            String payload = new String(decoder.decode(chunks[1]));

            JSONObject accessTokenPayloadJSON = new JSONObject(new String(decoder.decode(chunks[1]), "UTF-8"));
            int iat = (Integer) accessTokenPayloadJSON.get("iat");
            int exp = (Integer) accessTokenPayloadJSON.get("exp");
            String jti = accessTokenPayloadJSON.getString("jti");
            String email = accessTokenPayloadJSON.getString("email");
            LocalDateTime issueDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(iat), ZoneId.systemDefault());
            LocalDateTime expiryDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(exp), ZoneId.systemDefault());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
            String issueDateStr = issueDate.format(dateTimeFormatter);
            String expiryDateStr = expiryDate.format(dateTimeFormatter);
            loggedUser.setWrongAttempt(0);
            UserSecurityInfo userSecurityInfo = null;
            if (loggedUser.getUserSecurityInfo() == null) {
                userSecurityInfo = new UserSecurityInfo();
                userSecurityInfo.setAccessToken(response.getToken());
                userSecurityInfo.setOrgId(realmId);
                userSecurityInfo.setId(realmId);
                userSecurityInfo.setUsername(loginRequest.getUsername());
                userSecurityInfo = userSecurityInfoServiceV1.addUserSecurityInfo(userSecurityInfo);
                loggedUser.setUserSecurityInfo(userSecurityInfo);
            }

            loggedUser.getUserSecurityInfo().setAccessToken(response.getToken());
            if (loggedUserFound.isPresent()) {
                LoggedUserId loggedUserId = new LoggedUserId(loggedUserFound.get().getId(), realmId);
                loggedUserServiceV1.deleteById(loggedUserId);
                loggedUserServiceV1.addLoggedUser(loggedUser);
            } else {
                loggedUserServiceV1.addLoggedUser(loggedUser);
            }

        } catch (UsernameNotFoundException e) {
            statusMap.put("message", "Invalid Username.");
            statusMap.put("status", "404");
            return statusMap;
        } catch (JSONException | UnsupportedEncodingException ie) {
            statusMap.put("message", "Invalid Credentials.");
            statusMap.put("status", "401");
            return statusMap;
        } catch (LoginAttemptsException e) {
            statusMap.put("message", "WARNING: Your Account is locked. Please contact to support team or admin.");
            statusMap.put("status", "403");
            statusMap.put("wrongAttempts", "" + wrongAttempts);
            return statusMap;
        } catch (IllegalArgumentException e) {
            statusMap.put("message", "OrganizationId is invalid");
            statusMap.put("status", "404");
            return statusMap;
        } catch (Exception e1) {

            if (wrongAttempts == null) {
                wrongAttempts = 0;
            }
            wrongAttempts++;
            loggedUser.setWrongAttempt(wrongAttempts);

            if (e1 instanceof HttpResponseException) {

                String message = "WARNING: Your Account will be Locked after " + (4 - wrongAttempts) + " more unsuccessful attempts. Please check your credentials and try again or click on 'Forgot Password?'";
                statusMap.put("message", message);
                statusMap.put("status", "401");
                statusMap.put("wrongAttempts", "" + wrongAttempts);
                loggedUser = loggedUserServiceV1.addLoggedUser(loggedUser);
                return statusMap;
            } else {
                statusMap.put("message", "Invalid Organization.");
                statusMap.put("status", "401");
                return statusMap;
            }

        }

        return statusMap;
    }

    public List listUsersRest(String token, String realmId) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserListUrl = "/admin/realms/realm-to-be-replaced/users";
        keycloakUserListUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserListUrl;
        keycloakUserListUrl = keycloakUserListUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        return restTemplate.getForObject(keycloakUserListUrl, List.class, request);
    }

    public List<UserInfo> listUsers(String token, String realmId) {
        List<UserInfo> userInfoList = new ArrayList<>();
        List<LinkedHashMap> usersList = listUsersRest(token, realmId);
        String userId = null;
        Optional<UserMetaData> optionalUserMetaData = null;
        for (LinkedHashMap linkedHashMap : usersList) {
            if (linkedHashMap != null) {
                if (linkedHashMap.get("id") != null) {
                    userId = linkedHashMap.get("id").toString();
                    UserMetaDataId userMetaDataId = new UserMetaDataId(userId, realmId);
                    optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
                }
            }
            UserInfo userInfo = KeycloakUtil.convertUserLinkedHashmapToUserInfo(linkedHashMap, optionalUserMetaData);
            if (userInfo != null) {
                UserInfo userInfoClone = new UserInfo();
                userInfoClone.setId(userInfo.getId());
                userInfoClone.setUsername(userInfo.getUsername());
                userInfoClone.setFirstName(userInfo.getFirstName());
                userInfoClone.setLastName(userInfo.getLastName());
                userInfoClone.setOrgId(userInfo.getOrgId());
                userInfoClone.setEmail(userInfo.getEmail());
                userInfoClone.setSiteLocation(userInfo.getSiteLocation());
                userInfoClone.setActive(userInfo.isActive());
                userInfoClone.setRoleName(userInfo.getRoleName());

                userInfoList.add(userInfoClone);
            }
        }
        return userInfoList;
    }

    public UserInfo createUser(String token, UserInfo userInfo, String realmId, String user) {
        @SuppressWarnings("unchecked")
        //validate if the user exist or not
        Optional<LoggedUser> loggedUserOptional = loggedUserServiceV1.findLoggedUser(userInfo.getUsername(), userInfo.getOrgId());
        if(loggedUserOptional.isEmpty()) {
         loggedUserOptional =   loggedUserServiceV1.findLoggedUser(user, realmId);
         if(!loggedUserOptional.isEmpty()){
             UserSecurityInfo userSecurityInfo = loggedUserOptional.get().getUserSecurityInfo();
             if(userSecurityInfo !=null && userSecurityInfo.getAccessToken() !=null){
                 token = userSecurityInfo.getAccessToken();
             }
         }
        } else {
            //throw exception here
        }

        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String loggedInUserId = principal.getKeycloakSecurityContext().getToken().getSubject();

        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String userCreatedId = null;
        UserMetaData userMetaData = null;
        String password = "PASSWORD_NOT_SET";
        String keycloakCreateUserUrl = "/admin/realms/realm-to-be-replaced/users";
        keycloakCreateUserUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakCreateUserUrl;
        keycloakCreateUserUrl = keycloakCreateUserUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        //Create the random password.
        String randomPassword = RandomStringUtils.randomAlphanumeric(15);
        User userToBeCreated = KeycloakUtil.convertUserInfoToUser(userInfo, true, randomPassword);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<User> httpEntity = new HttpEntity<>(userToBeCreated, headers);
        try{
            Object object = restTemplate.postForObject(keycloakCreateUserUrl, httpEntity, String.class);
        } catch(Exception e){
            e.printStackTrace();;
           String errorMessage =  ((HttpClientErrorException.Conflict) e).getResponseBodyAsString();
           LOGGER.error("detailed errorMessage is {}", errorMessage);
        }

        List<LinkedHashMap> userList = listUsersRest(token, realmId);
        for (LinkedHashMap userObj : userList) {
            if (userInfo.getUsername().equals(userObj.get("username"))) {
                userCreatedId = (String) userObj.get("id");
                break;
            }
        }

        String orgId = realmId;
        if (userInfo.getOrgId() != null) {
            orgId = userInfo.getOrgId();
        }
        if (userCreatedId != null) {
            userMetaData = new UserMetaData(userInfo.getUsername(), orgId, userInfo.getRoleName(),
                    userInfo.getSiteLocation(), userInfo.isActive(), true, userInfo.getAddress1(),
                    userInfo.getAddress2(), userInfo.getCity(), userInfo.getState(),
                    userInfo.getZipcode(), userInfo.getMobile(), userInfo.getPhone2(),
                    userInfo.getFax(), userInfo.getNotes(), userInfo.isSendMail());
            userMetaDataServiceV1.addUserMetaData(userMetaData);
            UserSecurityInfo userSecurityInfo = new //UserSecurityInfo(userCreatedId, realmId, userInfo.getUsername(), randomPassword, null, null, null, null, null, null, null, null);
             UserSecurityInfo(userCreatedId, realmId, userInfo.getUsername(), userInfo.getFirstName(), userInfo.getLastName(), randomPassword, userInfo.getAddress1(), userInfo.getAddress2(), userInfo.getCity(), userInfo.getState(), userInfo.getZipcode(), userInfo.getMobile(), userInfo.getPhone2(), userInfo.getPhone2(), userInfo.getFax(), userInfo.getNotes(), userInfo.getRoleName(), userInfo.getSiteLocation(), userInfo.isActive(), null, null, null, null, userInfo.getEmail(), null, null, null, null);
            userSecurityInfoServiceV1.addUserSecurityInfo(userSecurityInfo);
        }

        userInfo = KeycloakUtil.convertUserPlusMetaToUserInfo(userToBeCreated, userMetaData);
        addDefaultRealmManagementRoleToUser(token, realmId, loggedInUserId, userCreatedId, keycloakConfigurationValues);

        return userInfo;

    }

    private void addDefaultRealmManagementRoleToUser(String token, String realmId, String loggedInUserId, String createdUserId,
                                                     KeycloakConfigurationValues keycloakConfigurationValues) {
        //First get the clients for the given realm id and get the realm-management-client client id.
        String keyCloakClientsUnderRealmUrl = "/admin/realms/realm-to-be-replaced/clients/";
        keyCloakClientsUnderRealmUrl = keycloakConfigurationValues.getAuthServerUrl() + keyCloakClientsUnderRealmUrl;
        keyCloakClientsUnderRealmUrl = keyCloakClientsUnderRealmUrl.replace("realm-to-be-replaced", realmId);
        String idForClient = null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        List<LinkedHashMap> clientsList = restTemplate.getForObject(keyCloakClientsUnderRealmUrl, List.class, request);
        for (LinkedHashMap clientObj : clientsList) {
            if (clientObj != null && clientObj.get("clientId") != null && "realm-management".equals(clientObj.get("clientId"))) {
                if (clientObj.get("id") != null)
                    idForClient = clientObj.get("id").toString();
                break;
            }
        }

        MultiValueMap<String, String> headersForAdd = new LinkedMultiValueMap<String, String>();
        headersForAdd.add("Authorization", token);
        headersForAdd.add("Content-Type", "application/json");

        //Get all the role-mappings under the realm-management client for the logged in user
        String keyCloakRoleMappingsUnderRealmManagementUrl = "/admin/realms/realm-to-be-replaced/users/userid-to-be-replaced/role-mappings/clients/clientid-to-be-replaced";
        keyCloakRoleMappingsUnderRealmManagementUrl = keycloakConfigurationValues.getAuthServerUrl() + keyCloakRoleMappingsUnderRealmManagementUrl;
        keyCloakRoleMappingsUnderRealmManagementUrl = keyCloakRoleMappingsUnderRealmManagementUrl.replace("realm-to-be-replaced", realmId);
        keyCloakRoleMappingsUnderRealmManagementUrl = keyCloakRoleMappingsUnderRealmManagementUrl.replace("userid-to-be-replaced", loggedInUserId);
        keyCloakRoleMappingsUnderRealmManagementUrl = keyCloakRoleMappingsUnderRealmManagementUrl.replace("clientid-to-be-replaced", idForClient);

        List<LinkedHashMap> roleMappingsList = restTemplate.getForObject(keyCloakRoleMappingsUnderRealmManagementUrl, List.class, request);

        //Assign the realm-management-role-mappings to the newly created user id.
        //Get all the role-mappings under the realm-management client for the logged in user
        String keyCloakAddRoleMappingToClientUrl = "/admin/realms/realm-to-be-replaced/users/userid-to-be-replaced/role-mappings/clients/clientid-to-be-replaced";
        keyCloakAddRoleMappingToClientUrl = keycloakConfigurationValues.getAuthServerUrl() + keyCloakAddRoleMappingToClientUrl;
        keyCloakAddRoleMappingToClientUrl = keyCloakAddRoleMappingToClientUrl.replace("realm-to-be-replaced", realmId);
        keyCloakAddRoleMappingToClientUrl = keyCloakAddRoleMappingToClientUrl.replace("userid-to-be-replaced", createdUserId);
        keyCloakAddRoleMappingToClientUrl = keyCloakAddRoleMappingToClientUrl.replace("clientid-to-be-replaced", idForClient);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<List<LinkedHashMap>> httpEntity = new HttpEntity<>(roleMappingsList, headersForAdd);
        Object object = restTemplate.postForObject(keyCloakAddRoleMappingToClientUrl, httpEntity, String.class);
    }

    public UserInfo getUserInfo(String token, String realmId, String id) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        LinkedHashMap userLinkedHashMap = (LinkedHashMap) restTemplate.getForObject(keycloakUserInfoUrl, LinkedHashMap.class, request);
        Optional<UserMetaData> optionalUserMetaData = null;
        String userId = null;
        if (userLinkedHashMap != null) {
            if (userLinkedHashMap.get("id") != null) {
                userId = userLinkedHashMap.get("id").toString();
                UserMetaDataId userMetaDataId = new UserMetaDataId(userId, realmId);
                optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
            }
        }
        UserInfo userInfo = KeycloakUtil.convertUserLinkedHashmapToUserInfo(userLinkedHashMap, optionalUserMetaData);
        return userInfo;
    }

    public UserInfo getCurrentUser(String token, String realmId) {

        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String userId = principal.getKeycloakSecurityContext().getToken().getSubject();

        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", userId);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        LinkedHashMap userLinkedHashMap = (LinkedHashMap) restTemplate.getForObject(keycloakUserInfoUrl, LinkedHashMap.class, request);
        Optional<UserMetaData> optionalUserMetaData = null;
        if (userLinkedHashMap != null) {
            if (userLinkedHashMap.get("id") != null) {
                userId = userLinkedHashMap.get("id").toString();
                UserMetaDataId userMetaDataId = new UserMetaDataId(userId, realmId);
                optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
            }
        }
        UserInfo userInfo = KeycloakUtil.convertUserLinkedHashmapToUserInfo(userLinkedHashMap, optionalUserMetaData);
        return userInfo;
    }

    public void changePassword(String token, UserSecurityInfo userSecurityInfo, String realmId, String id) {
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

    public void resetPassword(String token, String realmId, String id) {
        //Generate the random password. Right now the email functionality is not present, but need to email this
        //randomly generated password to the email.
        //Create the random password.
        String randomPassword = RandomStringUtils.randomAlphanumeric(15);
        Credentials.CredentialsBuilder credentialsBuilder = new Credentials.CredentialsBuilder();
        Credentials credentials = credentialsBuilder.type("password")
                .value(randomPassword)
                .temporary(false)
                .buildCredentials();

        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced/reset-password";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<Credentials> request = new HttpEntity<>(credentials, headers);
        restTemplate.put(keycloakUserInfoUrl, request);

        //Update the UserSecurityInfo object to update the newly created password.
        UserSecurityInfoId userSecurityInfoId = new UserSecurityInfoId(id, realmId);
        Optional<UserSecurityInfo> optionalUserSecurityInfo = userSecurityInfoServiceV1.findUserSecurityInfoById(userSecurityInfoId);
        if (optionalUserSecurityInfo.isPresent()) {
            UserSecurityInfo userSecurityInfo = optionalUserSecurityInfo.get();
            userSecurityInfo.setPassword(randomPassword);
            userSecurityInfoServiceV1.updateUserSecurityInfo(userSecurityInfo);
        }

        //Update the user Meta data
        Optional<UserMetaData> optionalUserMetaData = null;
        UserMetaDataId userMetaDataId = new UserMetaDataId(id, realmId);
        optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
        if (optionalUserMetaData.isPresent()) {
            UserMetaData userMetaData = optionalUserMetaData.get();
            userMetaData.setTemporary(true);
            userMetaDataServiceV1.updateUserMetaData(userMetaData);
        }
    }

    public Map<String, String> forgotPassword(String realmId, String username) {
        Map<String, String> statusMap = new HashMap<>();

        Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(username, realmId);
        if (!loggedUserFound.isEmpty()) {
            LoggedUser loggedUser = loggedUserFound.get();
            if (loggedUser != null && loggedUser.getUserSecurityInfo() != null) {
                UserSecurityInfo userSecurityInfo = loggedUser.getUserSecurityInfo();
                statusMap.put("SecurityQuestion1", userSecurityInfo.getSecurityQuestion1());
                statusMap.put("SecurityQuestion2", userSecurityInfo.getSecurityQuestion2());
                statusMap.put("status", "200");
                return statusMap;
            }
        }
        statusMap.put("message", "Invalid details");
        statusMap.put("status", "404");
        return statusMap;
    }

    public Map<String, String> validateUser(String orgCode, String user){
        Map<String,String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(user, orgCode);
        if (!loggedUserFound.isEmpty()) {
            statusMap.put("status", "404");
            statusMap.put("message", "User "+user+" already exist");
            return statusMap;
        }
        statusMap.put("status", "200");
        return statusMap;
    }

    public Map<String, String> forgotPassword(String realmId, String username, String securityAnswer1, String securityAnswer2) {
        Map<String, String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(username, realmId);
        if (!loggedUserFound.isEmpty()) {
            LoggedUser loggedUser = loggedUserFound.get();
            if (loggedUser != null && loggedUser.getUserSecurityInfo() != null) {

                Integer wrongAttempts = loggedUser.getWrongAttempt();
                if (wrongAttempts != null && wrongAttempts > 4) {
                    statusMap.put("message", "WARNING: Your Account is locked. Please contact to support team or admin.");
                    statusMap.put("status", "403");
                    statusMap.put("wrongAttempts", "" + wrongAttempts);
                    return statusMap;
                }
            }

            UserSecurityInfo userSecurityInfo = loggedUser.getUserSecurityInfo();
            if (!securityAnswer1.equalsIgnoreCase(userSecurityInfo.getSecurityAnswer1())) {
                statusMap.put("message", "Invalid Security Answer1");
                statusMap.put("status", "404");
                return statusMap;
            }

            if (!securityAnswer2.equalsIgnoreCase(userSecurityInfo.getSecurityAnswer2())) {
                statusMap.put("message", "Invalid Security Answer2");
                statusMap.put("status", "404");
                return statusMap;
            }
            userSecurityInfo.setHashedCode(UUID.randomUUID().toString());
            userSecurityInfo.setLinkExpiryDate(setDate(1));
            userSecurityInfo = userSecurityInfoServiceV1.addUserSecurityInfo(userSecurityInfo);
            loggedUser.setUserSecurityInfo(userSecurityInfo);
            loggedUserServiceV1.addLoggedUser(loggedUser);
            String maskEmail = userSecurityInfo.getEmail();
            if (maskEmail != null)
                maskEmail = maskEmail.charAt(0) + "*****" + maskEmail.charAt(maskEmail.length() - 1);
            statusMap.put("message", "Email has been sent to your registered mail id " + userSecurityInfo.getEmail());
            statusMap.put("status", "200");
            return statusMap;
        }

        statusMap = validateOrgCode(realmId);
        if (statusMap.get("status").equals("200")) {

            statusMap.put("message", "Invalid username");
            statusMap.put("status", "404");
            return statusMap;
        } else {
            return statusMap;
        }

    }

    public Map<String,String> resetUserPassword(String orgCode, String user){
        Map<String,String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(user, orgCode);
        if (!loggedUserFound.isEmpty()) {
            statusMap.put("status", "404");
            statusMap.put("message", "User "+user+" already exist");
            return statusMap;
        }

        LoggedUser loggedUser = loggedUserFound.get();
        if(loggedUser.getUserSecurityInfo()!=null){
            UserSecurityInfo userSecurityInfo = loggedUser.getUserSecurityInfo();
            userSecurityInfo.setHashedCode(UUID.randomUUID().toString());
            userSecurityInfo.setLinkExpiryDate(setDate(1));
            userSecurityInfo = userSecurityInfoServiceV1.addUserSecurityInfo(userSecurityInfo);
            loggedUser.setUserSecurityInfo(userSecurityInfo);
            loggedUserServiceV1.addLoggedUser(loggedUser);
            String maskEmail = userSecurityInfo.getEmail();
            if (maskEmail != null)
                maskEmail = maskEmail.charAt(0) + "*****" + maskEmail.charAt(maskEmail.length() - 1);
            statusMap.put("message", "Email has been sent to your registered mail id " + maskEmail +"with hashed code "+userSecurityInfo.getHashedCode());
            statusMap.put("status", "200");
            return statusMap;
        }

        statusMap.put("status", "404");
        statusMap.put("message", "User doesn't exist");
        return statusMap;
    }

    public void forgotPassword(String token, String realmId, String id) {
        //Generate the random password. Right now the email functionality is not present, but need to email this
        //randomly generated password to the email.1
        //Create the random password.
        String randomPassword = RandomStringUtils.randomAlphanumeric(15);
        Credentials.CredentialsBuilder credentialsBuilder = new Credentials.CredentialsBuilder();
        Credentials credentials = credentialsBuilder.type("password")
                .value(randomPassword)
                .temporary(false)
                .buildCredentials();

        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced/reset-password";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<Credentials> request = new HttpEntity<>(credentials, headers);
        restTemplate.put(keycloakUserInfoUrl, request);

        //Update the UserSecurityInfo object to update the newly created password.
        UserSecurityInfoId userSecurityInfoId = new UserSecurityInfoId(id, realmId);
        Optional<UserSecurityInfo> optionalUserSecurityInfo = userSecurityInfoServiceV1.findUserSecurityInfoById(userSecurityInfoId);
        if (optionalUserSecurityInfo.isPresent()) {
            UserSecurityInfo userSecurityInfo = optionalUserSecurityInfo.get();
            userSecurityInfo.setPassword(randomPassword);
            userSecurityInfoServiceV1.updateUserSecurityInfo(userSecurityInfo);
        }

        //Update the user Meta data
        Optional<UserMetaData> optionalUserMetaData = null;
        UserMetaDataId userMetaDataId = new UserMetaDataId(id, realmId);
        optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
        if (optionalUserMetaData.isPresent()) {
            UserMetaData userMetaData = optionalUserMetaData.get();
            userMetaData.setTemporary(true);
            userMetaDataServiceV1.updateUserMetaData(userMetaData);
        }
    }

    public void updateUser(String token, UserInfo userInfo, String realmId, String id) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        User userToBeUpdated = KeycloakUtil.convertUserInfoToUser(userInfo, false, null);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<User> request = new HttpEntity<>(userToBeUpdated, headers);
        restTemplate.put(keycloakUserInfoUrl, request);

        //Update the user metadata
        Optional<UserMetaData> optionalUserMetaData = null;
        UserMetaDataId userMetaDataId = new UserMetaDataId(id, realmId);
        optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
        if (optionalUserMetaData.isPresent()) {
            UserMetaData userMetaData = optionalUserMetaData.get();
            userMetaData.setTemporary(true);
            userMetaDataServiceV1.updateUserMetaData(userMetaData);
        }

    }

    public void deleteUser(String token, String realmId, String id) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        restTemplate.delete(keycloakUserInfoUrl, request);
    }

    public Object logoutUser(String token, String realmId, String id) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced/logout";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        try {
            KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                    .getAuthentication().getPrincipal();
            String tokenString = principal.getKeycloakSecurityContext().getTokenString();
            //logic to decrypt the access token and insert the user details into the database.
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String[] chunks = tokenString.split("\\.");
            String header = new String(decoder.decode(chunks[0]));
            String payload = new String(decoder.decode(chunks[1]));

            JSONObject accessTokenPayloadJSON = new JSONObject(new String(decoder.decode(chunks[1]), "UTF-8"));
            int iat = (Integer) accessTokenPayloadJSON.get("iat");
            int exp = (Integer) accessTokenPayloadJSON.get("iat");
            String jti = accessTokenPayloadJSON.getString("jti");
            String email = accessTokenPayloadJSON.getString("email");
            LoggedUserId loggedUserId = new LoggedUserId(jti, realmId);
            Optional<LoggedUser> optionalLoggedUser = loggedUserServiceV1.findLoggedUserById(loggedUserId);
            if (optionalLoggedUser.isPresent()) {
                loggedUserServiceV1.deleteById(loggedUserId);
            }
        } catch (JSONException | UnsupportedEncodingException ie) {
            throw new IllegalStateException("Error in decrypting the access token object");
        }
        return restTemplate.postForObject(keycloakUserInfoUrl, request, String.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public ResponseEntity<?> generateTempLink(String realmId, String username) {
        LoggedUser loggedUser = new LoggedUser();
        Map<String, String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(username, realmId);
        if (loggedUserFound.isEmpty()) {
            statusMap.put("message", "Invalid Username.");
            statusMap.put("status", "404");
            return new ResponseEntity<>(statusMap, HttpStatus.NOT_FOUND);
        }
        if (!loggedUserFound.isEmpty()) {
            loggedUser = loggedUserFound.get();
            String uuid = UUID.randomUUID().toString();
            loggedUser.setTempLink(uuid);
            loggedUser.setCreatedDate(new Date());
            statusMap.put("hashedCode", loggedUser.getTempLink());
            loggedUser = loggedUserServiceV1.addLoggedUser(loggedUser);
            // blumenMail.sendMail(loggedUser);
        }

        statusMap.put("status", "200");
        statusMap.put("message", "Email sent successfully");
        return new ResponseEntity<>(statusMap, HttpStatus.OK);
    }

    public Map<String, String> getSecurityQuestions(String orgCode, String username) {
        Map<String, String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(username, orgCode);
        if (!loggedUserFound.isEmpty()) {
            LoggedUser loggedUser = loggedUserFound.get();
            if (loggedUser != null && loggedUser.getUserSecurityInfo() != null) {
                UserSecurityInfo userSecurityInfo = loggedUser.getUserSecurityInfo();
                statusMap.put("SecurityQuestion1", userSecurityInfo.getSecurityQuestion1());
                statusMap.put("SecurityQuestion2", userSecurityInfo.getSecurityQuestion2());
                statusMap.put("status", "200");
                return statusMap;
            }
        } else {
            statusMap = validateOrgCode(orgCode);
            if (statusMap.get("status").equals("200")) {
                statusMap.put("message", "Invalid username");
                statusMap.put("status", "404");
                return statusMap;
            } else {
                return statusMap;
            }
        }
        statusMap.put("message", "Invalid Credentials.");
        statusMap.put("status", "404");
        return statusMap;
    }

    public Map<String, String> validateOrgCode(String orgCode) {
        Map<String, String> statusMap = new HashMap<>();
        Optional<LoggedUser> loggedUser = loggedUserServiceV1.findByOrgId(orgCode);

        if (loggedUser.isEmpty()) {
            statusMap.put("message", "Invalid OrgCode.");
            statusMap.put("status", "404");
            return statusMap;
        }
        statusMap.put("status", "200");
        return statusMap;

    }

    private Date setDate(int day){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();

        return dt;
    }

    public Map<String, String> changePassword(String hashedCode, String password) {
       Map<String,String> statusMap = new HashMap<>();
       Optional<UserSecurityInfo> userSecurityInfoList = userSecurityInfoServiceV1.validateHashedCode(hashedCode);
       if(userSecurityInfoList.isEmpty()){
           statusMap.put("message", "Invalid Link");
           statusMap.put("status", "404");
           return statusMap;
       }

       if(!userSecurityInfoList.isEmpty()){
           UserSecurityInfo userSecurityInfo = userSecurityInfoList.get();
           if(userSecurityInfo.getHashedCode()!=null && userSecurityInfo.getLinkExpiryDate()!=null){
               Date date = new Date();
               if(!date.before(userSecurityInfo.getLinkExpiryDate())){
                   statusMap.put("message", "Link got expired, please regenerate by access blumen application--> forgot password.");
                   statusMap.put("status", "404");
                   return statusMap;
               }
               try {
                   userSecurityInfo.setPassword(password);
                   changePassword(userSecurityInfo.getAccessToken(), userSecurityInfo, userSecurityInfo.getOrgId(), userSecurityInfo.getUsername() );
                   userSecurityInfo.setHashedCode(UUID.randomUUID().toString());
                   userSecurityInfoServiceV1.addUserSecurityInfo(userSecurityInfo);

                   statusMap.put("message", "Password updated successfully.");
                   statusMap.put("status", "200");
                   return statusMap;
               } catch (Exception e) {
                   statusMap.put("message", e.getMessage());
                   statusMap.put("status", "400");
                   return statusMap;
               }
           }
       }
       statusMap.put("status", "200");
       return statusMap;
    }

    public Map<String, String> updateSecurityQuestion(Map<String,String> requestPaylaod) {
        String realmId = requestPaylaod.get("orgCode");
        String username = requestPaylaod.get("username");
        String securityQuestion1 = requestPaylaod.get("securityQuestion1");
        String securityQuestion2 = requestPaylaod.get("securityQuestion2");
        String securityAnswer1 = requestPaylaod.get("securityAnswer1");
        String securityAnswer2 = requestPaylaod.get("securityAnswer2");
        String securityAnswerId1 = requestPaylaod.get("securityAnswer1");
        String securityAnswerId2 = requestPaylaod.get("securityAnswer2");

        Map<String,String> statusMap = new HashMap<>();

        if(StringUtils.isEmpty(securityAnswerId1)||StringUtils.isEmpty(securityAnswerId2)){
            statusMap.put("message","SecurityQuestionsId is missing");
            statusMap.put("status", "404");
            return statusMap;
        }

       Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(username,realmId);
       if(!loggedUserFound.isEmpty()){
           LoggedUser loggedUser = loggedUserFound.get();
           UserSecurityInfo userSecurityInfo = loggedUser.getUserSecurityInfo();
           if(userSecurityInfo!=null){
               userSecurityInfo.setSecurityQuestion1(securityQuestion1);
               userSecurityInfo.setSecurityQuestion1(securityQuestion2);
               userSecurityInfo.setSecurityAnswer1(securityAnswer1);
               userSecurityInfo.setSecurityAnswer2(securityAnswer2);
               userSecurityInfo = userSecurityInfoServiceV1.addUserSecurityInfo(userSecurityInfo);
               loggedUser.setFirstTime(Boolean.FALSE);
               loggedUser.setUserSecurityInfo(userSecurityInfo);
               loggedUserServiceV1.addLoggedUser(loggedUser);

               statusMap.put("message", "Security Questions are successfully updated.");
               statusMap.put("status", "200");
               return statusMap;
           }

       }
        statusMap.put("message", "User not found");
        statusMap.put("status", "404");
        return statusMap;
    }

    public Map<String,String> unlockUser(String user, String realmId) {
        Map<String,String> statusMap = new HashMap<>();

        Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(user,realmId);
        if(!loggedUserFound.isEmpty()){
            LoggedUser loggedUser = loggedUserFound.get();
                loggedUser.setWrongAttempt(0);
                loggedUserServiceV1.addLoggedUser(loggedUser);

                statusMap.put("message", "User Account is unlocked, and attempts made is set to 0");
                statusMap.put("status", "200");
                return statusMap;
            }

        statusMap.put("message", "User not found");
        statusMap.put("status", "404");
        return statusMap;
    }
}
