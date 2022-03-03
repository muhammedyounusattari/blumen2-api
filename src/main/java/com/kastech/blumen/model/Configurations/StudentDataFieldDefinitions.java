package com.kastech.blumen.model.Configurations;

import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.model.customize.PullDownItem;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "student_data_field_definitions", schema = "blumen2")
public class StudentDataFieldDefinitions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String fieldDescription;
    private long studentDataTabsId;
    private long studentDataFieldMasterId;
    private boolean isBluItem;
    private boolean isAPR;
    private boolean isPIField;
    private boolean isImportFileField;
    private boolean isPullDownList;
    private boolean isMandetory;
    private long pullTypeId;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id", updatable = false, insertable = false, nullable=false)
    private PullDown pullDownItems;


    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "studentDataFieldMasterId", updatable = false, insertable = false, nullable=false)
    private StudentDataFieldMaster studentDataFieldMasters;

    public PullDown getPullDownItems() {
        return pullDownItems;
    }


    public void setPullDownItems(PullDown pullDownItems) {
        this.pullDownItems = pullDownItems;}

    public StudentDataFieldMaster getStudentDataFieldMasters() {
        return studentDataFieldMasters;
    }

    public void setStudentDataFieldMasters(StudentDataFieldMaster studentDataFieldMasters) {
        this.studentDataFieldMasters = studentDataFieldMasters;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public long getStudentDataTabsId() {
        return studentDataTabsId;
    }

    public void setStudentDataTabsId(long studentDataTabsId) {
        this.studentDataTabsId = studentDataTabsId;
    }

    public Long getStudentDataFieldMasterId() {
        return studentDataFieldMasterId;
    }

    public void setStudentDataFieldMasterId(Long studentDataFieldMasterId) {
        this.studentDataFieldMasterId = studentDataFieldMasterId;
    }

    public boolean isBluItem() {
        return isBluItem;
    }

    public void setBluItem(boolean bluItem) {
        isBluItem = bluItem;
    }

    public boolean isAPR() {
        return isAPR;
    }

    public void setAPR(boolean APR) {
        isAPR = APR;
    }

    public boolean isPIField() {
        return isPIField;
    }

    public void setPIField(boolean PIField) {
        isPIField = PIField;
    }

    public boolean isImportFileField() {
        return isImportFileField;
    }

    public void setImportFileField(boolean importFileField) {
        isImportFileField = importFileField;
    }

    public boolean isPullDownList() {
        return isPullDownList;
    }

    public void setPullDownList(boolean pullDownList) {
        isPullDownList = pullDownList;
    }

    public boolean isMandetory() {
        return isMandetory;
    }

    public void setMandetory(boolean mandetory) {
        isMandetory = mandetory;
    }

    public long getPullTypeId() {
        return pullTypeId;
    }

    public void setPullTypeId(long pullTypeId) {
        this.pullTypeId = pullTypeId;
    }


}

