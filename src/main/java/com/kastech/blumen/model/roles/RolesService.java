package com.kastech.blumen.model.roles;

import com.kastech.blumen.model.keycloak.Privileges;
import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.repository.roles.RolesRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class RolesService {

    @Autowired
    public RolesRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(RolesService.class);

    public List<Roles> getRolesByOrgId(Long orgId) {
        LOGGER.info("call made to getRolesByOrgId for orgId {} ", orgId);
        return repository.findByOrgId(orgId);
    }

    //Privileges from JPA don't have node list kind of structure so need needs to create new Privilege class
    //send back map of role_name+_+role_code, privileges in tree structure.
    public Map<String, List<Privilege>> getRolesByOrgIdV2(Long orgId, String role) {
        LOGGER.info("call made to getRolesByOrgId for orgId {}, roleName {} ", orgId, role);
        List<Roles> roles = null;
        if (StringUtils.isNotEmpty(role)) {
            roles = repository.findByOrgIdAndRole(orgId, role);
        } else {
            roles = repository.findByOrgId(orgId);
        }
        Map<String, List<Privilege>> map = new TreeMap<>();
        for (Roles r : roles) {
            map.put(r.getName()+"::"+r.getCode(), buildPrivilegeTree(r.getPrivileges().stream().collect(Collectors.toList())));
        }
        return map;
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
