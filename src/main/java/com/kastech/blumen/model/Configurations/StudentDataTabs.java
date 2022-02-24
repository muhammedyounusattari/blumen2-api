package com.kastech.blumen.model.Configurations;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student_data_tabs" ,schema = "blumen2")
public class StudentDataTabs {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="student_data_tabs_seq_gen")
    @SequenceGenerator(name="student_data_tabs_seq_gen", sequenceName="student_data_tabs_seq")
    private long studentDataTabsId;
    private String displayName;
    private int sequenceNo;
    private long organizationTypeId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name =  "student_data_field_definition_mapping",
            joinColumns = @JoinColumn(name = "studentDataTabsId"))
    private List<StudentDataFieldDefinitions> studentDataFieldDefinitions;

    public long getStudentDataTabsId() {
        return studentDataTabsId;
    }

    public void setStudentDataTabsId(long studentDataTabsId) {
        this.studentDataTabsId = studentDataTabsId;
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
