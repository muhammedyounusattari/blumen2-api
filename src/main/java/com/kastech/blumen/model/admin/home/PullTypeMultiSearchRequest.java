package com.kastech.blumen.model.admin.home;

public class PullTypeMultiSearchRequest {
    private String pullType ;
    private Long programType;

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
