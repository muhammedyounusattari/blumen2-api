package com.kastech.blumen.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "table_field_columns" ,schema = "blumen2")
public class TableFieldColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne
    private TableNames tableNames;

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

    public TableNames getTableNames() {
        return tableNames;
    }

    public void setTableNames(TableNames tableNames) {
        this.tableNames = tableNames;
    }
}
