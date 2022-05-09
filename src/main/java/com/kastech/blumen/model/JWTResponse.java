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
    private Boolean twoFactorEnabled;
    private String maskedEmail;

    private Boolean orgSiteLocation;

    private Boolean isFirstTime;

    private Integer orgDaysToExpire;

    private Integer orgRemindOne;

    private Integer orgRemindTwo;

    public JWTResponse(String access_token, String iat, String exp, Integer status, String orgName,
                       Long orgId, String programType, String orgCode, String roleName, Boolean twoFactorEnabled,
                       String maskedEmail, Boolean orgSiteLocation, Boolean isFirstTime,
                       Integer orgDaysToExpire, Integer orgRemindOne, Integer orgRemindTwo) {
        this.access_token = access_token;
        this.iat = iat;
        this.exp = exp;
        this.status = status;
        this.orgName = orgName;
        this.orgId = orgId;
        this.programType = programType;
        this.orgCode = orgCode;
        this.roleName = roleName;
        this.twoFactorEnabled = twoFactorEnabled;
        this.maskedEmail =maskedEmail;
        this.isFirstTime = isFirstTime;
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

    public Boolean getTwoFactorEnabled() {
        return twoFactorEnabled;
    }

    public void setTwoFactorEnabled(Boolean twoFactorEnabled) {
        this.twoFactorEnabled = twoFactorEnabled;
    }

    public String getMaskedEmail() {
        return maskedEmail;
    }

    public void setMaskedEmail(String maskedEmail) {
        this.maskedEmail = maskedEmail;
    }

    public Boolean getOrgSiteLocation() {
        return orgSiteLocation;
    }

    public void setOrgSiteLocation(Boolean orgSiteLocation) {
        this.orgSiteLocation = orgSiteLocation;
    }

    public Boolean getFirstTime() {
        return isFirstTime;
    }

    public void setFirstTime(Boolean firstTime) {
        isFirstTime = firstTime;
    }

    public Integer getOrgDaysToExpire() {
        return orgDaysToExpire;
    }

    public void setOrgDaysToExpire(Integer orgDaysToExpire) {
        this.orgDaysToExpire = orgDaysToExpire;
    }

    public Integer getOrgRemindOne() {
        return orgRemindOne;
    }

    public void setOrgRemindOne(Integer orgRemindOne) {
        this.orgRemindOne = orgRemindOne;
    }

    public Integer getOrgRemindTwo() {
        return orgRemindTwo;
    }

    public void setOrgRemindTwo(Integer orgRemindTwo) {
        this.orgRemindTwo = orgRemindTwo;
    }
}
