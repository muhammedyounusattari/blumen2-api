package com.kastech.blumen.service.keycloak;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.utility.KeycloakConstants;
import com.kastech.blumen.utility.KeycloakPropertyReader;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.io.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class KeycloakAdminClientService {

    private String authServerUrl;
    private String realm;
    private String clientId;
    private String clientSecret;

    @Autowired
    private KeycloakPropertyReader keycloakPropertyReader;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private RestTemplate restTemplate;

    private KeycloakConfigurationValues loadValues(String realmId) {
        KeycloakConfigurationValues keycloakConfigurationValues = new KeycloakConfigurationValues();
        try {
            Resource res = applicationContext.getResource("classpath:" + realmId + "-keycloak.json");
            Map propertyMap = new ObjectMapper().readValue(res.getInputStream(), Map.class);
            keycloakConfigurationValues.setClientId(propertyMap.get("resource").toString());
            Map credentialsMap = (Map) propertyMap.get("credentials");
            keycloakConfigurationValues.setClientSecret(credentialsMap.get("secret").toString());
            keycloakConfigurationValues.setAuthServerUrl(propertyMap.get("auth-server-url").toString());
        }catch(java.io.IOException ioException) {

        }
        return keycloakConfigurationValues;

    }

    public Object login(LoginRequest loginRequest, String realmId) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", keycloakConfigurationValues.getClientSecret());
        clientCredentials.put("grant_type", "password");
        Configuration configuration = new Configuration(keycloakConfigurationValues.getAuthServerUrl(), realmId, keycloakConfigurationValues.getClientId(), clientCredentials, null);
        AuthzClient authzClient = AuthzClient.create(configuration);
        AccessTokenResponse response = authzClient.obtainAccessToken(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    public List listUsers(String token, String realmId) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserListUrl = "/admin/realms/realm-to-be-replaced/users";
        keycloakUserListUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserListUrl;
        keycloakUserListUrl = keycloakUserListUrl.replace("realm-to-be-replaced",realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        return restTemplate.getForObject(keycloakUserListUrl, List.class, request);
    }

    public Object createUser(String token, User user, String realmId) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakCreateUserUrl = "/admin/realms/realm-to-be-replaced/users";
        keycloakCreateUserUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakCreateUserUrl;
        keycloakCreateUserUrl = keycloakCreateUserUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        return restTemplate.postForObject(keycloakCreateUserUrl, httpEntity, String.class);
    }

    public Object getUserInfo(String token, String realmId, String id) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        return restTemplate.getForObject(keycloakUserInfoUrl, String.class, request);
    }

    public void resetPassword(String token, Credentials credentials, String realmId, String id) {
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
    }

    public void updateUser(String token, User user, String realmId, String id) {
        KeycloakConfigurationValues keycloakConfigurationValues = loadValues(realmId);
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced";
        keycloakUserInfoUrl = keycloakConfigurationValues.getAuthServerUrl() + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        restTemplate.put(keycloakUserInfoUrl, request);
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
        return restTemplate.postForObject(keycloakUserInfoUrl, request, String.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
