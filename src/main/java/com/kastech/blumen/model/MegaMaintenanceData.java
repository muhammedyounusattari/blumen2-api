package com.kastech.blumen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "mega_maintenance_data" ,schema = "blumen2")
public class MegaMaintenanceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private TableNames tableNames;

    private String fieldDescription;

    @ManyToOne
    private TableFieldColumns fieldColumn;

    @ManyToOne
    private FieldTypes fieldType;

    private int sortOrder;

    private boolean isBluItems;

    private boolean isPullDownList;

    private boolean isAPR;

    private boolean isPullType;

    private boolean isPIFields;

    private boolean isImportFileFields;

    private boolean isDeleted;

    private String lastModifiedBy;

    private Timestamp lastModifiedDate;

    @OneToMany(mappedBy = "megaMaintenanceData")
    private List<MegaDataOrgTypeFields> megaDataOrgTypeFieldsList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TableNames getTableNames() {
        return tableNames;
    }

    public void setTableNames(TableNames tableNames) {
        this.tableNames = tableNames;
    }

    public List<MegaDataOrgTypeFields> getMegaDataOrgTypeFieldsList() {
        return megaDataOrgTypeFieldsList;
    }

    public void setMegaDataOrgTypeFieldsList(List<MegaDataOrgTypeFields> megaDataOrgTypeFieldsList) {
        this.megaDataOrgTypeFieldsList = megaDataOrgTypeFieldsList;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public TableFieldColumns getFieldColumn() {
        return fieldColumn;
    }

    public void setFieldColumn(TableFieldColumns fieldColumn) {
        this.fieldColumn = fieldColumn;
    }

    public FieldTypes getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldTypes fieldType) {
        this.fieldType = fieldType;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isBluItems() {
        return isBluItems;
    }

    public void setBluItems(boolean bluItems) {
        isBluItems = bluItems;
    }

    public boolean isPullDownList() {
        return isPullDownList;
    }

    public void setPullDownList(boolean pullDownList) {
        isPullDownList = pullDownList;
    }

    public boolean isAPR() {
        return isAPR;
    }

    public void setAPR(boolean APR) {
        isAPR = APR;
    }

    public boolean isPullType() {
        return isPullType;
    }

    public void setPullType(boolean pullType) {
        isPullType = pullType;
    }

    public boolean isPIFields() {
        return isPIFields;
    }

    public void setPIFields(boolean PIFields) {
        isPIFields = PIFields;
    }

    public boolean isImportFileFields() {
        return isImportFileFields;
    }

    public void setImportFileFields(boolean importFileFields) {
        isImportFileFields = importFileFields;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

}
