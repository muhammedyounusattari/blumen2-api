package com.kastech.blumen.controller.student;

import java.io.Serializable;

public class Activities implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
