package com.kastech.blumen.model.keycloak;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles" ,schema = "blumen2")
public class Roles implements Serializable {

    @Id
    @Column(name="role_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @Column(nullable = true)
    private Boolean isDefault;

    @Column(nullable = false)
    private Long orgId;

    @Column(nullable = true)
    private String copyRoleName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("parent_code, code")
    @JoinTable(
            name = "roles_privileges",schema = "blumen2",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id")
    )
    private Set<Privileges> privileges = new HashSet<>();



    public Roles() {
    }

    public Roles(Long id, String name, String code, Boolean isDefault, Long orgId,
                 Set<Privileges> privileges, String copyRoleName) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.isDefault = isDefault;
        this.orgId = orgId;
        this.privileges = privileges;
        this.copyRoleName = copyRoleName;

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

    public Set<Privileges> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privileges> privileges) {
        this.privileges = privileges;
    }

    public String getCopyRoleName() {
        return this.copyRoleName;
    }

    public void setCopyRoleName(String copyRoleName) {
        this.copyRoleName = copyRoleName;
    }
}
