package com.kastech.blumen.model.admin.home;

public class OrgInfo  {
    private Long orgId;
    private String orgName;
    private String orgCode;

    public OrgInfo() {
    }

    public OrgInfo(Organization o) {
        this.orgId = o.getOrgId();
        this.orgName = o.getOrgName();
        this.orgCode = o.getOrgCode();

    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
}
