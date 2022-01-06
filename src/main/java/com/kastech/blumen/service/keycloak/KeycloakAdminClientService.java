package com.kastech.blumen.service.keycloak;


import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.utility.KeycloakConstants;
import com.kastech.blumen.utility.KeycloakPropertyReader;
import org.keycloak.authorization.client.AuthzClient;
import org.keycloak.authorization.client.Configuration;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeycloakAdminClientService {

    @Value("${keycloak.resource}")
    private String keycloakClient;

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.resource}")
    private String clientId;

    @Value("${keycloak.credentials.secret}")
    private String clientSecret;


    @Autowired
    private KeycloakPropertyReader keycloakPropertyReader;

    @Autowired
    private RestTemplate restTemplate;

    public Object login(LoginRequest loginRequest, String realmId) {
        Map<String, Object> clientCredentials = new HashMap<>();
        clientCredentials.put("secret", clientSecret);
        clientCredentials.put("grant_type", "password");
        Configuration configuration = new Configuration(authServerUrl, realmId, KeycloakConstants.KEYCLOAK_ADMIN_CLIENT_ID, clientCredentials, null);
        AuthzClient authzClient = AuthzClient.create(configuration);
        AccessTokenResponse response = authzClient.obtainAccessToken(loginRequest.getUsername(), loginRequest.getPassword());
        return ResponseEntity.ok(response);
    }

    public List listUsers(String token, String realmId) {
        String keycloakUserListUrl = "/admin/realms/realm-to-be-replaced/users";
        keycloakUserListUrl = authServerUrl + keycloakUserListUrl;
        keycloakUserListUrl = keycloakUserListUrl.replace("realm-to-be-replaced",realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        return restTemplate.getForObject(keycloakUserListUrl, List.class, request);
    }

    public Object createUser(String token, CreateUserRequest createUserRequest, String realmId) {
        String keycloakCreateUserUrl = "/admin/realms/realm-to-be-replaced/users";
        keycloakCreateUserUrl = authServerUrl + keycloakCreateUserUrl;
        keycloakCreateUserUrl = keycloakCreateUserUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<CreateUserRequest> httpEntity = new HttpEntity<>(createUserRequest, headers);
        return restTemplate.postForObject(keycloakCreateUserUrl, httpEntity, String.class);
    }

    public String getUserInfo(String token, String realmId, String id) {
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced";
        keycloakUserInfoUrl = authServerUrl + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced", realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null, headers);
        return restTemplate.getForObject(keycloakUserInfoUrl, String.class, request);
    }

    public void resetPassword(String token, Credentials credentials, String realmId, String id) {
        String keycloakUserInfoUrl = "/admin/realms/realm-to-be-replaced/users/user-id-to-be-replaced/reset-password";
        keycloakUserInfoUrl = authServerUrl + keycloakUserInfoUrl;
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("user-id-to-be-replaced", id);
        keycloakUserInfoUrl = keycloakUserInfoUrl.replace("realm-to-be-replaced",realmId);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Authorization", token);
        headers.add("Content-Type", "application/json");
        HttpEntity<Credentials> request = new HttpEntity<>(credentials, headers);
        restTemplate.put(keycloakUserInfoUrl, request);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
