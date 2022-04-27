package com.kastech.blumen.model;

public class JWTResponse {

    private String access_token;
    private String iat;
    private String exp;
    private Integer status;
    private String orgName;
    private Long orgId;
    private String programType;
    private String orgCode;
    private String roleName;

    public JWTResponse(String access_token, String iat, String exp, Integer status, String orgName, Long orgId, String programType, String orgCode, String roleName) {
        this.access_token = access_token;
        this.iat = iat;
        this.exp = exp;
        this.status = status;
        this.orgName = orgName;
        this.orgId = orgId;
        this.programType = programType;
        this.orgCode = orgCode;
        this.roleName = roleName;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getIat() {
        return iat;
    }

    public void setIat(String iat) {
        this.iat = iat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
