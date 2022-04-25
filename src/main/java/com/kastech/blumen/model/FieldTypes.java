package com.kastech.blumen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "field_types" ,schema = "blumen2")
public class FieldTypes  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
