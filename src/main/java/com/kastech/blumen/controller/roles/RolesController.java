package com.kastech.blumen.controller.roles;

import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.model.roles.RolesService;
import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RolesController.class);



    @ResponseBody
    @GetMapping(path = "/getRoles/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Roles>> getRolesList() {
        Long orgId = SecurityUtil.getUserOrgId();
        LOGGER.info("Call made to getRolesList for orgId {}", orgId);
        return ResponseEntity.accepted().body(rolesService.getRolesByOrgId(orgId));
    }
//
//    @ResponseBody
//    @PostMapping(path = "/getPriviledgeListByRoleId/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public GenerateResponse getPriviledgeListByRoleId(@RequestBody Long roleId) {
//        return userServices.getPriviledgeListByRoleId(roleId);
//    }
}
