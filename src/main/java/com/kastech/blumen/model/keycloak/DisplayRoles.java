package com.kastech.blumen.model.keycloak;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "display_roles" ,schema = "blumen2")
public class DisplayRoles implements Serializable {

    @Id
    private Long roleId;

    @Column
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "menu_display_roles",schema = "blumen2",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name="menu_id")
    )
    private Set<Menus> menus = new HashSet<>();


    public DisplayRoles() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long id) {
        this.roleId = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Menus> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menus> menus) {
        this.menus = menus;
    }
}
