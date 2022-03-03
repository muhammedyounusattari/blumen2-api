package com.kastech.blumen.model.Configurations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_data_tabs" ,schema = "blumen2")
public class StudentDataTabs {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long Id;
    private String displayName;
    private int sequenceNo;
    private long organizationTypeId;


    @OneToMany(mappedBy = "studentDataTabsId")
    private List<StudentDataFieldDefinitions> studentDataFieldDefinitions  = new ArrayList<StudentDataFieldDefinitions>();;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public List<StudentDataFieldDefinitions> getStudentDataFieldDefinitions() {
        return studentDataFieldDefinitions;
    }

    public void setStudentDataFieldDefinitions(List<StudentDataFieldDefinitions> studentDataFieldDefinitions) {
        this.studentDataFieldDefinitions = studentDataFieldDefinitions;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public long getOrganizationTypeId() {
        return organizationTypeId;
    }

    public void setOrganizationTypeId(long organizationTypeId) {
        this.organizationTypeId = organizationTypeId;
    }
}
