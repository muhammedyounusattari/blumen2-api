package com.kastech.blumen.model.keycloak;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "privileges" ,schema = "blumen2")
public class Privileges implements Serializable {

    @Id
    @Column(name = "privilege_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private Long code;

    @Column(nullable = false)
    private String accessType;

    private Long orgId;

    @Column(nullable = true)
    private Long parentCode;

    @Column(nullable = true)
    private String roleCode;

    public Privileges() {
    }

    public Privileges(Long id, String name, Long code, String accessType, Long orgId, Long parentCode) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.accessType = accessType;
        this.orgId = orgId;
        this.parentCode = parentCode;
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

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
