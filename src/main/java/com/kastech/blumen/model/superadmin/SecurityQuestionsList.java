package com.kastech.blumen.model.superadmin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address" ,schema = "blumen2")
public class SecurityQuestionsList {

    @Id
    private Long id;

    @Column(length = 1000)
    private String name;

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

    public SecurityQuestionsList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "SecurityQuestionsList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
