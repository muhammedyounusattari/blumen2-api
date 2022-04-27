package com.kastech.blumen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kastech.blumen.model.Configurations.OrganizationType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mega_dataOrgTypeFields" ,schema = "blumen2")
public class MegaDataOrgTypeFields implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fieldDescription;

    private int sortOrder;

    private boolean isDeleted;

    private boolean isHide;

    @ManyToOne
    private OrganizationType projectType;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private MegaMaintenanceData megaMaintenanceData;

    @Transient
    private long megaMaintenanceDataId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isHide() {
        return isHide;
    }

    public void setHide(boolean hide) {
        isHide = hide;
    }

    public OrganizationType getProjectType() {
        return projectType;
    }

    public void setProjectType(OrganizationType projectType) {
        this.projectType = projectType;
    }

    public MegaMaintenanceData getMegaMaintenanceData() {
        return megaMaintenanceData;
    }

    public void setMegaMaintenanceData(MegaMaintenanceData megaMaintenanceData) {
        this.megaMaintenanceData = megaMaintenanceData;
    }

    public long getMegaMaintenanceDataId() {
        return megaMaintenanceDataId;
    }

    public void setMegaMaintenanceDataId(long megaMaintenanceDataId) {
        this.megaMaintenanceDataId = megaMaintenanceDataId;
    }
}
