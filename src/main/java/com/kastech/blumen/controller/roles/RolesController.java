package com.kastech.blumen.controller.roles;

import com.kastech.blumen.exception.DataNotFoundException;
import com.kastech.blumen.model.keycloak.DisplayRoles;
import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.model.roles.Role;
import com.kastech.blumen.repository.roles.DisplayRoleRepository;
import com.kastech.blumen.repository.roles.RolesRepository;
import com.kastech.blumen.service.roles.RolesService;
import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kastech.blumen.utility.Constants.SUPER_ADMIN;

@RestController
@RequestMapping("/api/blumen-api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @Autowired
    DisplayRoleRepository displayRoleRepository;

    @Autowired
    RolesRepository rolesRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(RolesController.class);



    @ResponseBody
    @GetMapping(path = "/getRoles/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Roles_R','Roles_Y')")
    public ResponseEntity<List<Role>> getRolesList() {
        Long orgId = SecurityUtil.getUserOrgId();
        LOGGER.info("Call made to getRolesList for orgId {}", orgId);
        return ResponseEntity.accepted().body(rolesService.getRolesByOrgId(orgId));
    }

    //no role check
    @ResponseBody
    @GetMapping(path = "/getMenus/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<String>> getMenus() {
        LOGGER.info("Call made to getMenu");
        String roleName = SecurityUtil.getRoleName();
        List<String>  roleNames = new ArrayList<>();
        roleNames.add(roleName);
        //in case of role name as Super Admin - we know what menus to show since we configured for sure
        if (!roleName.equals(SUPER_ADMIN)) {
            List<Roles> roles = rolesRepository.findByOrgIdAndRole(SecurityUtil.getUserOrgId(), roleName);
            //In case, user is assigned with non-default role,
            // the menus will not be pulled since we configure menus with only default role
            //we need to get original default role (aka copyRole) of non-default role
            if (roles.get(0) != null && roles.get(0).getCopyRoleName() != null) {
                roleNames.add(roles.get(0).getCopyRoleName());
            }
        }

        if (roleNames.isEmpty()) {
            LOGGER.error("Roles s not configured for logged user {}", SecurityUtil.getEmail());
            throw new DataNotFoundException("Role is not configured for logged user!!");
        }

        List<DisplayRoles> displayRoles = displayRoleRepository.findByRoleName(roleNames);
        if (displayRoles.isEmpty()) {
            LOGGER.error("Menus are missing for user {} with Roles {}", SecurityUtil.getEmail(), roleNames);
            throw new DataNotFoundException("Roles missing for logged user!!");
        }

        List<String> menusToDisplay = displayRoles.get(0).getMenus().stream().map(m -> m.getName()).collect(Collectors.toList());
        return ResponseEntity.accepted().body(menusToDisplay);
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
