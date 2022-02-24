package com.kastech.blumen.model.Configurations;

import com.kastech.blumen.model.customize.PullDownItem;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "student_datafield_def" ,schema = "blumen2")
public class StudentDataFieldDefinitions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @SequenceGenerator(name="student_data_field_definitions_seq_gen", sequenceName="student_data_field_definitions_seq")
    private Long Id;
    private String fieldDescription;
    private Integer studentDataTabsId;
    private  Integer studentDataFieldMasterId;
    private boolean isBluItem;
    private boolean isAPR;
    private boolean isPIField;
    private boolean isImportFileField;
    private boolean isPullDownList;
    private boolean isMandetory;
    private int pullTypeId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name =  "pull_down_items_mapping",
            joinColumns = @JoinColumn(name = "pullId"))
    private List<PullDownItem> pullDownItems;

    @OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="studentDataFieldMasterId", insertable = false, updatable = false)
    private StudentDataFieldMaster studentDataFieldMasters;

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

    public Integer getStudentDataTabsId() {
        return studentDataTabsId;
    }

    public void setStudentDataTabsId(Integer studentDataTabsId) {
        this.studentDataTabsId = studentDataTabsId;
    }

    public Integer getStudentDataFieldMasterId() {
        return studentDataFieldMasterId;
    }

    public void setStudentDataFieldMasterId(Integer studentDataFieldMasterId) {
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

    public int getPullTypeId() {
        return pullTypeId;
    }

    public void setPullTypeId(int pullTypeId) {
        this.pullTypeId = pullTypeId;
    }

    public List<PullDownItem> getPullDownItems() {
        return pullDownItems;
    }

    public void setPullDownItems(List<PullDownItem> pullDownItems) {
        this.pullDownItems = pullDownItems;
    }

    public StudentDataFieldMaster getStudentDataFieldMasters() {
        return studentDataFieldMasters;
    }

    public void setStudentDataFieldMasters(StudentDataFieldMaster studentDataFieldMasters) {
        this.studentDataFieldMasters = studentDataFieldMasters;
    }
}

