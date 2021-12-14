package com.kastech.blumen.model.customize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pulldown" ,schema = "blumen2")
public class PullDown {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="pulldown_seq_gen")
    @SequenceGenerator(name="pulldown_seq_gen", sequenceName="PULLDOWN_SEQ")
    private Long id;
    private String name;
    private String selectionType;
    private String active;
    private String apr;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> orgType;
    private String orgId;


    public PullDown() {
    }

    public PullDown(Long id, String name, String selectionType, String active, String apr, List<String> orgType, String orgId) {
        this.id = id;
        this.name = name;
        this.selectionType = selectionType;
        this.active = active;
        this.apr = apr;
        this.orgType = orgType;
        this.orgId = orgId;
    }

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

    public String getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(String selectionType) {
        this.selectionType = selectionType;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public List<String> getOrgType() {
        return orgType;
    }

    public void setOrgType(List<String> orgType) {
        this.orgType = orgType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    @Override
    public String toString() {
        return "PullDown{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", selectionType='" + selectionType + '\'' +
                ", active='" + active + '\'' +
                ", apr='" + apr + '\'' +
                ", orgType=" + orgType +
                ", orgId='" + orgId + '\'' +
                '}';
    }

    public PullDown updateWith(PullDown item) {
        return new PullDown(
                this.id,
                item.name,
                item.selectionType,
                item.active,
                item.apr,
                item.orgType,
                item.orgId
        );
    }
}
