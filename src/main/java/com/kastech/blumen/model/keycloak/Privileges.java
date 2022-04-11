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

    @Column(nullable = false)
    private String accessType;

    private Long orgId;

    @Column(nullable = true)
    private String parentId;

    public Privileges() {
    }

    public Privileges(Long id, String name, String accessType, Long orgId, String parentId) {
        this.id = id;
        this.name = name;
        this.accessType = accessType;
        this.orgId = orgId;
        this.parentId = parentId;
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
}
