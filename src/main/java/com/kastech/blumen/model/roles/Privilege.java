package com.kastech.blumen.model.roles;

import com.kastech.blumen.model.keycloak.Privileges;

import java.util.List;

public class Privilege {
    private Long id;
    private String name;
    private Long code;
    private String accessType;
    private Long orgId;
    private Long parentCode;
    private List<Privilege> privileges;

    public Privilege(Privileges privileges) {
        this.id = privileges.getId();
        this.name = privileges.getName();
        this.accessType = privileges.getAccessType();
        this.orgId = privileges.getOrgId();
        this.code = privileges.getCode();
        this.parentCode = privileges.getParentCode();
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

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
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

    public Long getParentCode() {
        return parentCode;
    }

    public void setParentCode(Long parentCode) {
        this.parentCode = parentCode;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

}