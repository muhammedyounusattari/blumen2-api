package com.kastech.blumen.model.roles;

import com.kastech.blumen.model.keycloak.Privileges;

import java.util.List;

public class Privilege {
    private Long id;
    private String name;
    private String accessType;
    private Long orgId;
    private String parentId;
    private List<Privilege> privileges;

    public Privilege(Privileges privileges) {
        this.id = privileges.getId();
        this.name = privileges.getName();
        this.accessType = privileges.getAccessType();
        this.orgId = privileges.getOrgId();
        this.parentId = privileges.getParentId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

}