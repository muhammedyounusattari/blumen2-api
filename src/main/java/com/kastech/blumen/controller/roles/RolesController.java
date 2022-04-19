package com.kastech.blumen.controller.roles;

import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.model.roles.Role;
import com.kastech.blumen.service.roles.RolesService;
import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('Roles_R','Roles_Y')")
    public ResponseEntity<List<Role>> getRolesList() {
        Long orgId = SecurityUtil.getUserOrgId();
        LOGGER.info("Call made to getRolesList for orgId {}", orgId);
        return ResponseEntity.accepted().body(rolesService.getRolesByOrgId(orgId));
    }

    @ResponseBody
    @GetMapping(path = "/getRolesAsTree/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Roles_R','Roles_Y')")
    public ResponseEntity<List<Role>> getRolesTree(@RequestParam(defaultValue = "") String roleName) {
        Long orgId = SecurityUtil.getUserOrgId();
        LOGGER.info("Call made to getRolesList for orgId {}, {}", orgId, roleName);
        return ResponseEntity.accepted().body(rolesService.getRolesByOrgIdV2(orgId, roleName));
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteRole/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Roles_Y')")
    public ResponseEntity<String> deleteRole(@RequestParam Long roleId) {
        LOGGER.info("Call made to deleteRoleId for roleId, {}",roleId);
        return rolesService.deleteRole(roleId);
    }

    @ResponseBody
    @PostMapping(path = "/addRole/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Roles_Y')")
    public ResponseEntity<Roles> addRole(@RequestParam Long orgId, @RequestParam String newRoleCode, @RequestParam String newRoleName, @RequestParam String copyRoleName, @RequestParam boolean isDefault) {
        LOGGER.info("Call made to addRole with new Role Name, existing Role Name, default {}",newRoleName,  copyRoleName, isDefault);
        return ResponseEntity.accepted().body(rolesService.addRole(orgId, newRoleCode, newRoleName,  copyRoleName, isDefault));
    }

    @ResponseBody
    @PutMapping(path = "/updateRole/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Roles_Y')")
    public ResponseEntity<Roles> updateRole(@RequestBody Roles roles) {
        LOGGER.info("Call made to updateRole with new Role Name or new privileges {}",roles);
        return ResponseEntity.accepted().body(rolesService.updateRole(roles));
    }

//
//    @ResponseBody
//    @PostMapping(path = "/getPriviledgeListByRoleId/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public GenerateResponse getPriviledgeListByRoleId(@RequestBody Long roleId) {
//        return userServices.getPriviledgeListByRoleId(roleId);
//    }
}
