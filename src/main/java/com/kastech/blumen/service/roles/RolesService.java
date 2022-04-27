package com.kastech.blumen.service.roles;

import com.kastech.blumen.exception.DataModificationException;
import com.kastech.blumen.exception.DataNotFoundException;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.keycloak.Privileges;
import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.model.roles.Privilege;
import com.kastech.blumen.model.roles.Role;
import com.kastech.blumen.repository.roles.RolesRepository;
import com.kastech.blumen.utility.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import static com.kastech.blumen.constants.ErrorMessageConstants.*;


@Service
public class RolesService {

    @Autowired
    public RolesRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(RolesService.class);

    public List<Role> getRolesByOrgId(Long orgId) {
        LOGGER.info("call made to getRolesByOrgId for orgId {} ", orgId);
        List<Roles> roles = repository.findByOrgId(orgId);
        return roles.stream().map(r -> new Role(r)).collect(Collectors.toList());
    }

    //Privileges from JPA don't have node list kind of structure so  needs to create new Privilege class
    //send back map of role_name+_+role_code, privileges in tree structure.
    public List<Role> getRolesByOrgIdV2(Long orgId, String role) {
        LOGGER.info("call made to getRolesByOrgId for orgId {}, roleName {} ", orgId, role);
        List<Roles> rolesFromDB = null;

        if (StringUtils.isNotEmpty(role)) {
            rolesFromDB = repository.findByOrgIdAndRole(orgId, role);
        } else {
            rolesFromDB = repository.findByOrgId(orgId);
        }

        if (rolesFromDB.isEmpty()) {
            LOGGER.error("Role {} not configured for org {}",role, orgId);
            throw new DataNotFoundException("Role is not configured for logged user!!");
        }


        List<Role> rolesResponseList = new ArrayList<>();
        for (Roles r : rolesFromDB) {
            Role tmpRole = new Role(r);
            tmpRole.setPrivileges(buildPrivilegeTree(r.getPrivileges().stream().collect(Collectors.toList())));
            rolesResponseList.add(tmpRole);
        }
        return rolesResponseList;
    }

    private  List<Privilege>  buildPrivilegeTree(List<Privileges> privilegesFromDBList) {
        List<Privilege> treePrivileges = new  ArrayList<Privilege>();

        for(Privileges privilegesFromDB : getRootPrivileges(privilegesFromDBList)) {
            Privilege privilege = buildChildTree(privilegesFromDB, privilegesFromDBList);
            treePrivileges.add(privilege);
        }

        for(Privileges privilegesFromDB : getTopPrivileges(privilegesFromDBList)) {
            Privilege privilege = buildChildTree(privilegesFromDB, privilegesFromDBList);
            treePrivileges.add(privilege);
        }
        return treePrivileges;
    }

    private List<Privileges> getTopPrivileges(List<Privileges> privilegesList) {
        return privilegesList.stream().filter(privileges ->  privileges.getParentCode() != null && privileges.getParentCode() == 0).collect(Collectors.toList());
    }

    private List<Privileges> getRootPrivileges(List<Privileges> privilegesList) {
        return privilegesList.stream().filter(privileges -> privileges.getParentCode() == null).collect(Collectors.toList());
    }

    //Recursion, building subtree structure
    private Privilege buildChildTree(Privileges topLevelPrivilegeFromDB, List<Privileges> privilegesFromDBList){
        Privilege topPrivilege = new Privilege(topLevelPrivilegeFromDB);
        List<Privilege> childPrivileges =new  ArrayList<Privilege>();
        for(Privileges privilegesFromDB : privilegesFromDBList) {
            if((privilegesFromDB.getParentCode() == null ? -1 : privilegesFromDB.getParentCode()) == topLevelPrivilegeFromDB.getCode()) {
                childPrivileges.add(buildChildTree(privilegesFromDB, privilegesFromDBList));
            }
        }
        topPrivilege.setPrivileges(childPrivileges);
        return topPrivilege;
    }

    public  ResponseEntity<String>  deleteRole(Long roleId) {
        LOGGER.info("call made to deleteRole for orgId {} ", roleId);
        Optional<Roles> role = repository.findById(roleId);
        if (role.isEmpty()) {
            LOGGER.error(" Role Id {} not found", roleId);
            throw new DataNotFoundException(ROLE_NOT_FOUND);
        }
        //role.setDeletedBy(SecurityUtil.getUserId());
        //role.setDeletedDate(new Date());
        try {
            repository.delete(role.get());
        } catch (Exception e) {
            LOGGER.error("Delete of Role {} is not successful", role.get(), e);
            throw new DataModificationException(ROLE_DELETE_FAILED);
        }

        return new ResponseEntity(new Response(200, "Role deleted Successfully"), null, HttpStatus.OK);
    }

    public Roles updateRole(Roles roles) {
        LOGGER.info("call made to updateRole for orgId {}, roleCode {} ", roles.getOrgId(), roles.getCode());
        try {
            Roles  updatedRoles= repository.save(roles);
            return updatedRoles;
        } catch (Exception e) {
            LOGGER.error("Update Role {} is not successful", roles, e);
            throw new DataModificationException(ROLE_UPDATE_FAILED);
        }
    }

    public Roles addRole(Long orgId, String newRoleCode, String newRoleName,
                        String copyRoleName, boolean isDefault) {
        List<Roles> role = repository.findByOrgIdAndRole(orgId, copyRoleName);
        if (role.isEmpty()) {
            LOGGER.error(" Role  {} not found for Org {}", copyRoleName, orgId);
            throw new DataNotFoundException(ROLE_NOT_FOUND);
        }
        Roles newRole = new Roles();
        newRole.setDefault(isDefault);
        newRole.setName(newRoleName);
        newRole.setCode(newRoleCode);
        newRole.setOrgId(orgId);
        newRole.setCopyRoleName(copyRoleName);
        //newRole Id should be null
        newRole.setPrivileges(role.get(0).getPrivileges().stream().map(p -> {
            Privileges pp = new Privileges();
            pp.setAccessType(p.getAccessType());
            pp.setCode(p.getCode());
            pp.setOrgId(p.getOrgId());
            pp.setName(p.getName());
            pp.setRoleCode(newRoleCode);
            pp.setParentCode(p.getParentCode());
            return pp;
        }).collect(Collectors.toSet()));

        if (newRole.getPrivileges().isEmpty()) {
            LOGGER.error(" Role  {} with for Org {} don't have privileges configured", copyRoleName, orgId);
            throw new DataNotFoundException(ORGANIZATION_ROLE_SETUP_MISSING);
        }

        Roles returnRole = null;
        try {
            returnRole = repository.save(newRole);
        } catch (Exception e) {
            LOGGER.error("Add Role {} is not successful", role, e);
            throw new DataModificationException(ROLE_ADD_FAILED);
        }
        return returnRole;
    }

}
