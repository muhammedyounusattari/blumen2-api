package com.kastech.blumen.controller.keycloak;

import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.service.keycloak.KeycloakAdminClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/blumen-api/keycloak", produces = MediaType.APPLICATION_JSON_VALUE)
public class KeycloakController {

    @Autowired
    private KeycloakAdminClientService keycloakAdminClientService;

    @GetMapping(value = "{realmId}/userInfo/v1/{id}")
    public ResponseEntity<String> getUserInfo(@RequestHeader("Authorization") String authHeader,
                                              @PathVariable String realmId,
                                              @PathVariable String id) {
        return ResponseEntity.ok(keycloakAdminClientService.getUserInfo(authHeader, realmId, id));
    }

    @GetMapping(value = "{realmId}/userList/v1")
    public ResponseEntity<List> getUserList(@RequestHeader("Authorization") String authHeader,
                                            @PathVariable String realmId) {
        return ResponseEntity.ok(keycloakAdminClientService.listUsers(authHeader, realmId));
    }

    @PutMapping(value = "{realmId}/resetPassword/v1/{id}")
    public void resetPassword(@RequestHeader("Authorization") String authHeader,
                                            @RequestBody Credentials credentials,
                                            @PathVariable String realmId,
                                            @PathVariable String id) {
        keycloakAdminClientService.resetPassword(authHeader, credentials, realmId, id);
    }

    @PostMapping(value = "{realmId}/createUser/v1")
    public ResponseEntity<Object> createUser(@RequestHeader("Authorization") String authHeader,
                                             @RequestBody CreateUserRequest createUserRequest,
                                             @PathVariable String realmId) {
        return ResponseEntity.ok(keycloakAdminClientService.createUser(authHeader, createUserRequest, realmId));
    }

    @PostMapping(path = "{realmId}/login/v1")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest,
                                   @PathVariable String realmId) {
        return ResponseEntity.ok(keycloakAdminClientService.
                login(loginRequest, realmId));
    }
}
