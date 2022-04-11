package com.kastech.blumen.model.keycloak;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(LoggedUserId.class)
@Table(name = "logged_user" ,schema = "blumen2")
public class LoggedUser implements Serializable {

    @Id
	private String id;

    @Id
    private String orgId;

    private int ita;

    private int exp;

    private Date issueDate;
    private Date expiryDate;

    @Nullable
    private Integer wrongAttempt;

    @Nullable
    private Boolean firstTime;

    @Nullable
    private String tempLink;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String organizationType;

    @Column(nullable = false)
    private String scope;

    @Column(nullable = true)
    private String createdBy;

    @Column(nullable = true)
    private Date createdDate;

    @Column(nullable = true)
    private Date editedDate;

    @Column(nullable = true)
    private Date lastLogin;

    @OneToOne(cascade = CascadeType.ALL)
    private UserSecurityInfo userSecurityInfo;

    public LoggedUser() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public int getIta() {
        return ita;
    }

    public void setIta(int ita) {
        this.ita = ita;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Nullable
    public Integer getWrongAttempt() {
        return wrongAttempt;
    }

    public void setWrongAttempt(@Nullable Integer wrongAttempt) {
        this.wrongAttempt = wrongAttempt;
    }

    @Nullable
    public Boolean getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(@Nullable Boolean firstTime) {
        this.firstTime = firstTime;
    }

    @Nullable
    public String getTempLink() {
        return tempLink;
    }

    public void setTempLink(@Nullable String tempLink) {
        this.tempLink = tempLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public UserSecurityInfo getUserSecurityInfo() {
        return userSecurityInfo;
    }

    public void setUserSecurityInfo(UserSecurityInfo userSecurityInfo) {
        this.userSecurityInfo = userSecurityInfo;
    }

    public LoggedUser(String id, String orgId, int ita, int exp, Date issueDate, Date expiryDate, @Nullable Integer wrongAttempt, @Nullable Boolean firstTime, @Nullable String tempLink, String password, String organizationType, String scope, String createdBy, Date createdDate, Date editedDate, Date lastLogin, UserSecurityInfo userSecurityInfo) {
        this.id = id;
        this.orgId = orgId;
        this.ita = ita;
        this.exp = exp;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.wrongAttempt = wrongAttempt;
        this.firstTime = firstTime;
        this.tempLink = tempLink;
        this.password = password;
        this.organizationType = organizationType;
        this.scope = scope;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.editedDate = editedDate;
        this.lastLogin = lastLogin;
        this.userSecurityInfo = userSecurityInfo;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", ita=" + ita +
                ", exp=" + exp +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", wrongAttempt=" + wrongAttempt +
                ", firstTime=" + firstTime +
                ", tempLink='" + tempLink + '\'' +
                ", password='" + password + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", scope='" + scope + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate=" + createdDate +
                ", editedDate=" + editedDate +
                ", lastLogin=" + lastLogin +
                ", userSecurityInfo=" + userSecurityInfo +
                '}';
    }
}
