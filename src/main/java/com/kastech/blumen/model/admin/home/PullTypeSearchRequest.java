package com.kastech.blumen.model.admin.home;

public class PullTypeSearchRequest {
    private String description;
    private String pullType ;
    private Long programType;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPullType() {
        return pullType;
    }

    public void setPullType(String pullType) {
        this.pullType = pullType;
    }

    public Long getProgramType() {
        return programType;
    }

    public void setProgramType(Long programType) {
        this.programType = programType;
    }
}
