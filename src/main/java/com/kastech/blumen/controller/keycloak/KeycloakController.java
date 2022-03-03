package com.kastech.blumen.controller.keycloak;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.keycloak.*;
import com.kastech.blumen.service.keycloak.KeycloakAdminClientService;
import org.codehaus.plexus.util.StringUtils;
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
    public ResponseEntity<?> getUserList(@RequestHeader("Authorization") String authHeader,
                                            @PathVariable String realmId) {
        Map<String,List<UserInfo>> statusMap = new HashMap<>();
        try {
            statusMap.put("body", keycloakAdminClientService.listUsers(authHeader, realmId));
            return success(statusMap, 200);
        } catch(Exception e){
            return failure(statusMap, 400);
        }
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

    @GetMapping(value="tenant/{realmId}/unlockUser/v1/{user}")
    public ResponseEntity<?> unlockUser(@PathVariable String realmId, @PathVariable String user){
        return ResponseEntity.ok(keycloakAdminClientService.unlockUser(user, realmId));
    }

    @PutMapping(value = "updateSecurityQuestions")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String,String> requestPaylaod) {

        Map<String,String> responsePayload = new HashMap<>();
        Map<String, String> statusMap = keycloakAdminClientService.updateSecurityQuestion(requestPaylaod);
        return success(statusMap, Integer.parseInt(statusMap.get("status")));
    }


    @GetMapping(value="/validateUser/{orgId}")
    public ResponseEntity<?> validateUser( @PathVariable(value = "orgId", required = true) String orgId, @RequestParam(value="user", required = true) String user){
        Map<String,String> statusMap = keycloakAdminClientService.validateUser(orgId, user);
        return success(statusMap, Integer.parseInt(statusMap.get("status")));
    }

    @GetMapping(value = "/resetUserPassword/{orgId}/{user}")
    public ResponseEntity<?> resetUserPassword(@RequestHeader("Authorization") String authHeader, @PathVariable(value = "orgId", required = true) String orgId, @PathVariable(value="user", required = true) String user){
        Map<String,String> statusMap = keycloakAdminClientService.validateUser(orgId, user);
        String status = statusMap.get("status");

        keycloakAdminClientService.resetPassword(authHeader, orgId,user);
        return success(statusMap, Integer.parseInt(statusMap.get("status")));
    }

    @PostMapping(value = "forgotPassword")
    public ResponseEntity<?> getTempPassword(@RequestBody Map<String, String> requestPaylaod) {

        Map<String, String> responsePayload = new HashMap<>();
        String orgCode = requestPaylaod.get("orgCode");
        String username = requestPaylaod.get("username");
        String securityAnswer1 = requestPaylaod.get("securityAnswer1");
        String securityAnswer2 = requestPaylaod.get("securityAnswer2");

        if (StringUtils.isBlank(orgCode)) {
            responsePayload.put("message", "OrganizationCode is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(username) && StringUtils.isBlank(securityAnswer1) && StringUtils.isBlank(securityAnswer2)) {
            responsePayload = keycloakAdminClientService.validateOrgCode(orgCode);
            return success(responsePayload, Integer.parseInt(responsePayload.get("status")));
        }
        if (StringUtils.isBlank(username)) {
            responsePayload.put("message", "Username is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(securityAnswer1) && StringUtils.isBlank(securityAnswer2)) {
            responsePayload = keycloakAdminClientService.getSecurityQuestions(orgCode, username);
            return success(responsePayload, Integer.parseInt(responsePayload.get("status")));
        }

        if (StringUtils.isBlank(securityAnswer1)) {
            responsePayload.put("message", "SecurityAnswer1 is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(securityAnswer2)) {
            responsePayload.put("message", "SecurityAnswer2 is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        Map<String, String> statusMap = keycloakAdminClientService.forgotPassword(orgCode, username, securityAnswer1, securityAnswer2);
        return success(statusMap, Integer.parseInt(statusMap.get("status")));
    }

    @PostMapping(value = "resetPassword/{hashedCode}")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> requestPaylaod, @PathVariable(name = "hashedCode", required = true) String hashedCode) {
        Map<String, String> responsePayload = new HashMap<>();
        String password = requestPaylaod.get("password");
        String confPassword = requestPaylaod.get("confPassword");

        if (StringUtils.isBlank(password)) {
            responsePayload.put("message", "Password is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(confPassword)) {
            responsePayload.put("message", "Confirm password is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        responsePayload = keycloakAdminClientService.changePassword(hashedCode, confPassword);
        return success(responsePayload, Integer.parseInt(responsePayload.get("status")));
    }

    @PostMapping(value = "tenant/{realmId}/createUser/v1/{user}")
    public ResponseEntity<UserInfo> createUser(@RequestHeader("Authorization") String authHeader,@PathVariable("user") String user,
                                             @RequestBody UserInfo userInfo,
                                             @PathVariable String realmId) {
        return ResponseEntity.ok(keycloakAdminClientService.createUser(authHeader, userInfo, realmId, user));
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
