package com.kastech.blumen.service.roles;

import com.kastech.blumen.model.keycloak.Privileges;
import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.model.roles.Privilege;
import com.kastech.blumen.model.roles.Role;
import com.kastech.blumen.repository.roles.RolesRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //Privileges from JPA don't have node list kind of structure so need needs to create new Privilege class
    //send back map of role_name+_+role_code, privileges in tree structure.
    public List<Role> getRolesByOrgIdV2(Long orgId, String role) {
        LOGGER.info("call made to getRolesByOrgId for orgId {}, roleName {} ", orgId, role);
        List<Roles> rolesFromDB = null;

        if (StringUtils.isNotEmpty(role)) {
            rolesFromDB = repository.findByOrgIdAndRole(orgId, role);
        } else {
            rolesFromDB = repository.findByOrgId(orgId);
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
        return privilegesList.stream().filter(privileges ->  StringUtils.isNotEmpty(privileges.getParentId()) && privileges.getParentId().equals("0")).collect(Collectors.toList());
    }

    private List<Privileges> getRootPrivileges(List<Privileges> privilegesList) {
        return privilegesList.stream().filter(privileges -> StringUtils.isEmpty(privileges.getParentId())).collect(Collectors.toList());
    }

    //Recursion, building subtree structure
    private Privilege buildChildTree(Privileges topLevelPrivilegeFromDB, List<Privileges> privilegesFromDBList){
        Privilege topPrivilege = new Privilege(topLevelPrivilegeFromDB);
        List<Privilege> childPrivileges =new  ArrayList<Privilege>();
        for(Privileges privilegesFromDB : privilegesFromDBList) {
            if((StringUtils.isEmpty(privilegesFromDB.getParentId())?"ROOT":privilegesFromDB.getParentId()).equals(topLevelPrivilegeFromDB.getId().toString())) {
                childPrivileges.add(buildChildTree(privilegesFromDB, privilegesFromDBList));
            }
        }
        topPrivilege.setPrivileges(childPrivileges);
        return topPrivilege;
    }


}
