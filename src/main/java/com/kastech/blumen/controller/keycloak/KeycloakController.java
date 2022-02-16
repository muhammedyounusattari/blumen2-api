package com.kastech.blumen.controller.keycloak;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.service.keycloak.KeycloakAdminClientService;
import org.keycloak.authorization.client.util.HttpResponseException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/blumen-api/keycloak", produces = MediaType.APPLICATION_JSON_VALUE)
public class KeycloakController {

    @Autowired
    private KeycloakAdminClientService keycloakAdminClientService;

    @GetMapping(value = "tenant/{realmId}/userInfo/v1/{id}")
    public ResponseEntity<UserInfo> getUserInfo(@RequestHeader("Authorization") String authHeader,
                                              @PathVariable String realmId,
                                              @PathVariable String id) {
        return ResponseEntity.ok(keycloakAdminClientService.getUserInfo(authHeader, realmId, id));
    }

    @GetMapping(value = "tenant/{realmId}/currentUser/v1")
    public ResponseEntity<UserInfo> getUserInfo(@RequestHeader("Authorization") String authHeader,
                                              @PathVariable String realmId) {
        return ResponseEntity.ok(keycloakAdminClientService.getCurrentUser(authHeader, realmId));
    }

    @GetMapping(value = "tenant/{realmId}/userList/v1")
    public ResponseEntity<List> getUserList(@RequestHeader("Authorization") String authHeader,
                                            @PathVariable String realmId) {
        return ResponseEntity.ok(keycloakAdminClientService.listUsers(authHeader, realmId));
    }

    @PutMapping(value = "tenant/{realmId}/changePassword/v1/{id}")
    public void changePassword(@RequestHeader("Authorization") String authHeader,
                              @RequestBody UserSecurityInfo userSecurityInfo,
                              @PathVariable String realmId,
                              @PathVariable String id) {
        keycloakAdminClientService.changePassword(authHeader, userSecurityInfo, realmId, id);
    }

    @PutMapping(value = "tenant/{realmId}/resetPassword/v1/{id}")
    public void resetPassword(@RequestHeader("Authorization") String authHeader,
                                            @PathVariable String realmId,
                                            @PathVariable String id) {
        keycloakAdminClientService.resetPassword(authHeader, realmId, id);
    }

    @GetMapping(value="tenant/{realmId}/generateTempPassword/v1/{id}")
    public ResponseEntity<?> generateTempPassword(@PathVariable String realmId, @PathVariable String username){
        return ResponseEntity.ok(keycloakAdminClientService.generateTempLink(realmId, username));
    }

    @PutMapping(value = "tenant/{realmId}/forgotPassword/v1/{id}")
    public void forgotPassword(@RequestHeader("Authorization") String authHeader,
                              @PathVariable String realmId,
                              @PathVariable String id) {
        keycloakAdminClientService.forgotPassword(authHeader, realmId, id);
    }

    @PostMapping(value = "tenant/{realmId}/createUser/v1")
    public ResponseEntity<UserInfo> createUser(@RequestHeader("Authorization") String authHeader,
                                             @RequestBody UserInfo userInfo,
                                             @PathVariable String realmId) {
        return ResponseEntity.ok(keycloakAdminClientService.createUser(authHeader, userInfo, realmId));
    }

    @PostMapping(path = "tenant/{realmId}/login/v1")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest,
                                   @PathVariable String realmId)  {

        Map<String,String> statusMap = keycloakAdminClientService.login(loginRequest, realmId);
        return success(statusMap, Integer.parseInt(statusMap.get("status")));

    }

    @PostMapping(value = "tenant/{realmId}/logout/v1/{id}")
    public ResponseEntity<Object> logout(@RequestHeader("Authorization") String authHeader,
                                         @PathVariable String realmId,
                                         @PathVariable String id) {
        return ResponseEntity.ok(keycloakAdminClientService.logoutUser(authHeader, realmId, id));
    }

    @PutMapping(value = "tenant/{realmId}/updateUser/v1/{id}")
    public void updateUser(@RequestHeader("Authorization") String authHeader,
                              @RequestBody UserInfo user,
                              @PathVariable String realmId,
                              @PathVariable String id) {
        keycloakAdminClientService.updateUser(authHeader, user, realmId, id);
    }

    @DeleteMapping(value = "tenant/{realmId}/deleteUser/v1/{id}")
    public void deleteUser(@RequestHeader("Authorization") String authHeader,
                                         @PathVariable String realmId,
                                         @PathVariable String id) {
        keycloakAdminClientService.deleteUser(authHeader, realmId, id);
    }

    private ResponseEntity<?> success(Object t, Integer status ){
        return new ResponseEntity(t,null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, int statusCode){
        return new ResponseEntity(t,null, HttpStatus.valueOf(statusCode));
    }
}
