package com.kastech.blumen.model.keycloak;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menus" ,schema = "blumen2")
public class Menus implements Serializable {

    @Id
    @Column(name="menus_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Menus parentId;

    public Menus() {
    }

    public Menus(Long id, String name, Menus parentId) {
        this.id = id;
        this.name = name;
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

    public Menus getParentId() {
        return parentId;
    }

    public void setParentId(Menus parentId) {
        this.parentId = parentId;
    }

}
