package com.kastech.blumen.service.keycloak;


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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
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
    ApplicationContext applicationContext;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired LoggedUserServiceV1 loggedUserServiceV1;

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
        }catch(java.io.IOException ioException) {

        }
        return keycloakConfigurationValues;

    }

    public Object login(LoginRequest loginRequest, String realmId)  {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", keycloakConfigurationValues.getClientSecret());
        clientCredentials.put("grant_type", "password");
        Configuration configuration = new Configuration(keycloakConfigurationValues.getAuthServerUrl(), realmId, keycloakConfigurationValues.getClientId(), clientCredentials, null);
        AuthzClient authzClient = AuthzClient.create(configuration);
        AccessTokenResponse response = authzClient.obtainAccessToken(loginRequest.getUsername(), loginRequest.getPassword());

        try {
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

            LoggedUser loggedUser = new LoggedUser(jti, realmId, iat, exp, issueDateStr, expiryDateStr, loginRequest.getUsername());
            Optional<LoggedUser> loggedUserFound = loggedUserServiceV1.findLoggedUser(loginRequest.getUsername(), realmId);
            if(loggedUserFound.isPresent()) {
                LoggedUserId loggedUserId = new LoggedUserId(loggedUserFound.get().getId(), realmId);
                loggedUserServiceV1.deleteById(loggedUserId);
                loggedUserServiceV1.addLoggedUser(loggedUser);
            } else {
                loggedUserServiceV1.addLoggedUser(loggedUser);
            }

        } catch(JSONException|UnsupportedEncodingException ie) {
            throw new IllegalStateException("Error in decrypting the access token object");
        }

        return ResponseEntity.ok(response);
    }

    public List listUsersRest(String token, String realmId) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserListUrl = "/admin/realms/realm-to-be-replaced/users";
        keycloakUserListUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserListUrl;
        keycloakUserListUrl = keycloakUserListUrl.replace("realm-to-be-replaced",realmId);
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
        for(LinkedHashMap linkedHashMap : usersList) {
            if(linkedHashMap != null) {
                if(linkedHashMap.get("id") != null) {
                    userId = linkedHashMap.get("id").toString();
                    UserMetaDataId userMetaDataId = new UserMetaDataId(userId, realmId);
                    optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
                }
            }
            UserInfo userInfo = KeycloakUtil.convertUserLinkedHashmapToUserInfo(linkedHashMap,optionalUserMetaData );
            if(userInfo != null) {
                userInfoList.add(userInfo);
            }
        }
        return userInfoList;
    }

    public UserInfo createUser(String token, UserInfo userInfo, String realmId) {
        @SuppressWarnings("unchecked")
        KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal = (KeycloakPrincipal<RefreshableKeycloakSecurityContext>) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        String loggedInUserId = principal.getKeycloakSecurityContext().getToken().getSubject();

        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String userCreatedId = null;
        UserMetaData userMetaData = null;
        String password="PASSWORD_NOT_SET";
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
        Object object =  restTemplate.postForObject(keycloakCreateUserUrl, httpEntity, String.class);
        List<LinkedHashMap> userList = listUsersRest(token, realmId);
        for(LinkedHashMap userObj : userList) {
            if(userInfo.getUsername().equals(userObj.get("username"))) {
                userCreatedId = (String) userObj.get("id");
                break;
            }
        }

        String orgId = realmId;
        if(userInfo.getOrgId() != null) {
            orgId = userInfo.getOrgId();
        }
        if(userCreatedId != null) {
            userMetaData = new UserMetaData(userCreatedId, orgId, userInfo.getRoleName(),
                    userInfo.getSiteLocation(), userInfo.isActive(), true, userInfo.getAddress1(),
                    userInfo.getAddress2(), userInfo.getCity(), userInfo.getState(),
                    userInfo.getZipcode(), userInfo.getMobile(), userInfo.getPhone2(),
                    userInfo.getFax(), userInfo.getNotes(), userInfo.isSendMail());
            userMetaDataServiceV1.addUserMetaData(userMetaData);
            UserSecurityInfo userSecurityInfo = new UserSecurityInfo(userCreatedId, realmId, userInfo.getUsername(), randomPassword, null, null, null, null);
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
        for(LinkedHashMap clientObj : clientsList) {
            if(clientObj != null && clientObj.get("clientId") != null && "realm-management".equals(clientObj.get("clientId"))) {
                if(clientObj.get("id") != null)
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
        Object object =  restTemplate.postForObject(keyCloakAddRoleMappingToClientUrl, httpEntity, String.class);
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
        LinkedHashMap userLinkedHashMap =  (LinkedHashMap) restTemplate.getForObject(keycloakUserInfoUrl, LinkedHashMap.class, request);
        Optional<UserMetaData> optionalUserMetaData = null;
        String userId = null;
        if(userLinkedHashMap != null) {
            if(userLinkedHashMap.get("id") != null) {
                userId = userLinkedHashMap.get("id").toString();
                UserMetaDataId userMetaDataId = new UserMetaDataId(userId, realmId);
                optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
            }
        }
        UserInfo userInfo = KeycloakUtil.convertUserLinkedHashmapToUserInfo(userLinkedHashMap,optionalUserMetaData );
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
        LinkedHashMap userLinkedHashMap =  (LinkedHashMap) restTemplate.getForObject(keycloakUserInfoUrl, LinkedHashMap.class, request);
        Optional<UserMetaData> optionalUserMetaData = null;
        if(userLinkedHashMap != null) {
            if(userLinkedHashMap.get("id") != null) {
                userId = userLinkedHashMap.get("id").toString();
                UserMetaDataId userMetaDataId = new UserMetaDataId(userId, realmId);
                optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
            }
        }
        UserInfo userInfo = KeycloakUtil.convertUserLinkedHashmapToUserInfo(userLinkedHashMap,optionalUserMetaData );
        return userInfo;
    }

    public void changePassword(String token, UserSecurityInfo userSecurityInfo, String realmId, String id) {
        String password = userSecurityInfo.getPassword();
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced/reset-password";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);

        //Build the Credentials object to pass it to the keycloak.
        Credentials.CredentialsBuilder credentialsBuilder = new Credentials.CredentialsBuilder();
        Credentials credentials = credentialsBuilder.type("password")
                .value(password)
                .temporary(false)
                .buildCredentials();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<Credentials> request = new HttpEntity<>(credentials, headers);
        restTemplate.put(keycloakUserInfoUrl, request);

        //Update the User Security Info with the new security question and answers

        UserSecurityInfoId userSecurityInfoId = new UserSecurityInfoId(id, realmId);
        Optional<UserSecurityInfo> optionalUserSecurityInfo = userSecurityInfoServiceV1.findUserSecurityInfoById(userSecurityInfoId);
        if(optionalUserSecurityInfo.isPresent()) {
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
        if(optionalUserMetaData.isPresent()) {
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
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<Credentials> request = new HttpEntity<>(credentials, headers);
        restTemplate.put(keycloakUserInfoUrl, request);

        //Update the UserSecurityInfo object to update the newly created password.
        UserSecurityInfoId userSecurityInfoId = new UserSecurityInfoId(id, realmId);
        Optional<UserSecurityInfo> optionalUserSecurityInfo = userSecurityInfoServiceV1.findUserSecurityInfoById(userSecurityInfoId);
        if(optionalUserSecurityInfo.isPresent()) {
            UserSecurityInfo userSecurityInfo = optionalUserSecurityInfo.get();
            userSecurityInfo.setPassword(randomPassword);
            userSecurityInfoServiceV1.updateUserSecurityInfo(userSecurityInfo);
        }

        //Update the user Meta data
        Optional<UserMetaData> optionalUserMetaData = null;
        UserMetaDataId userMetaDataId = new UserMetaDataId(id, realmId);
        optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
        if(optionalUserMetaData.isPresent()) {
            UserMetaData userMetaData = optionalUserMetaData.get();
            userMetaData.setTemporary(true);
            userMetaDataServiceV1.updateUserMetaData(userMetaData);
        }
    }

    public void forgotPassword(String token, String realmId, String id) {
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
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<Credentials> request = new HttpEntity<>(credentials, headers);
        restTemplate.put(keycloakUserInfoUrl, request);

        //Update the UserSecurityInfo object to update the newly created password.
        UserSecurityInfoId userSecurityInfoId = new UserSecurityInfoId(id, realmId);
        Optional<UserSecurityInfo> optionalUserSecurityInfo = userSecurityInfoServiceV1.findUserSecurityInfoById(userSecurityInfoId);
        if(optionalUserSecurityInfo.isPresent()) {
            UserSecurityInfo userSecurityInfo = optionalUserSecurityInfo.get();
            userSecurityInfo.setPassword(randomPassword);
            userSecurityInfoServiceV1.updateUserSecurityInfo(userSecurityInfo);
        }

        //Update the user Meta data
        Optional<UserMetaData> optionalUserMetaData = null;
        UserMetaDataId userMetaDataId = new UserMetaDataId(id, realmId);
        optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
        if(optionalUserMetaData.isPresent()) {
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
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<User> request = new HttpEntity<>(userToBeUpdated, headers);
        restTemplate.put(keycloakUserInfoUrl, request);

        //Update the user metadata
        Optional<UserMetaData> optionalUserMetaData = null;
        UserMetaDataId userMetaDataId = new UserMetaDataId(id, realmId);
        optionalUserMetaData = userMetaDataServiceV1.findUserMetaDataById(userMetaDataId);
        if(optionalUserMetaData.isPresent()) {
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
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);
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
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);
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
            if(optionalLoggedUser.isPresent()) {
                loggedUserServiceV1.deleteById(loggedUserId);
            }
        } catch(JSONException|UnsupportedEncodingException ie) {
            throw new IllegalStateException("Error in decrypting the access token object");
        }
        return restTemplate.postForObject(keycloakUserInfoUrl, request, String.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
