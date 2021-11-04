package com.kastech.blumen.model;

import java.util.List;

public class PullDown {

    private int id;
    private String name;
    private String selectionType;
    private String active;
    private String apr;
    private List<String> orgType;
    private String orgId;


    public PullDown() {
    }

    public PullDown(int id, String name, String selectionType, String active, String apr, List<String> orgType, String orgId) {
        this.id = id;
        this.name = name;
        this.selectionType = selectionType;
        this.active = active;
        this.apr = apr;
        this.orgType = orgType;
        this.orgId = orgId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
