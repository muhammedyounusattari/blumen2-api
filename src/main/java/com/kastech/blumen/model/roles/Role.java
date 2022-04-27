package com.kastech.blumen.model.roles;

import com.kastech.blumen.model.keycloak.Roles;
import java.util.List;

public class Role {
    private Long id;
    private String name;
    private String code;
    private Boolean isDefault;
    private Long orgId;
    private String copyRoleName;
    private List<Privilege> privileges;

    public Role(Roles roles) {
        this.id = roles.getId();
        this.name = roles.getName();
        this.code = roles.getCode();
        this.isDefault = roles.getDefault();
        this.orgId = roles.getOrgId();
        this.copyRoleName = roles.getCopyRoleName();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public String getCopyRoleName() {
        return copyRoleName;
    }

    public void setCopyRoleName(String copyRoleName) {
        this.copyRoleName = copyRoleName;
    }
}