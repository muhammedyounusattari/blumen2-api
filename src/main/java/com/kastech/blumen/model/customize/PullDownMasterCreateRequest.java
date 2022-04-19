package com.kastech.blumen.model.customize;

import javax.validation.constraints.NotNull;

public class PullDownMasterCreateRequest {
    @NotNull
    private Long organizationid;
    @NotNull
    private Long projtype;
    @NotNull
    private String pulltype;
    @NotNull
    private Long pullId;
    @NotNull
    private String pullname;
    @NotNull
    private Boolean inoriginal;
    @NotNull
    private String longpullna;
    @NotNull
    private String userName;

    public Long getOrganizationid() {
        return organizationid;
    }

    public void setOrganizationid(Long organizationid) {
        this.organizationid = organizationid;
    }

    public Long getProjtype() {
        return projtype;
    }

    public void setProjtype(Long projtype) {
        this.projtype = projtype;
    }

    public String getPulltype() {
        return pulltype;
    }

    public void setPulltype(String pulltype) {
        this.pulltype = pulltype;
    }

    public Long getPullId() {
        return pullId;
    }

    public void setPullId(Long pullId) {
        this.pullId = pullId;
    }

    public String getPullname() {
        return pullname;
    }

    public void setPullname(String pullname) {
        this.pullname = pullname;
    }

    public Boolean getInoriginal() {
        return inoriginal;
    }

    public void setInoriginal(Boolean inoriginal) {
        this.inoriginal = inoriginal;
    }

    public String getLongpullna() {
        return longpullna;
    }

    public void setLongpullna(String longpullna) {
        this.longpullna = longpullna;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
