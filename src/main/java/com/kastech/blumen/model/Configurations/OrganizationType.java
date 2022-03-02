package com.kastech.blumen.model.Configurations;

import com.kastech.blumen.model.customize.PullDownItem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization_type" ,schema = "blumen2")
public class OrganizationType {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="organization_type_seq_gen")
    @SequenceGenerator(name="organization_type_seq_gen", sequenceName="organization_type_SEQ")
    private long Id;
    private String OrgType;
    private String Descriptions;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name =  "student_data_tabs_mapping",
            joinColumns = @JoinColumn(name = "organizationTypeId"))
    private List<StudentDataTabs> studentDataTabs;

    public List<StudentDataTabs> getStudentDataTabs() {
        return studentDataTabs;
    }

    public void setStudentDataTabs(List<StudentDataTabs> studentDataTabs) {
        this.studentDataTabs = studentDataTabs;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getOrgType() {
        return OrgType;
    }

    public void setOrgType(String orgType) {
        OrgType = orgType;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }
}
