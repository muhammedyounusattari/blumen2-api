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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private int ita;
    private int exp;

    private String issueDate;
    private String expiryDate;
    @Nullable
    private Integer wrongAttempt;

    @Nullable
    private Boolean firstTime;

    @Nullable
    private String tempLink;

    @Nullable
    private Date createdDate;

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getWrongAttempt() {
        return wrongAttempt;
    }

    public void setWrongAttempt(Integer wrongAttempt) {
        this.wrongAttempt = wrongAttempt;
    }

    private String userName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    @Nullable
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(@Nullable Date createdDate) {
        this.createdDate = createdDate;
    }

    public LoggedUser() {}

    public LoggedUser(String id, String orgId, int ita, int exp, String issueDate, String expiryDate, @Nullable Integer wrongAttempt, @Nullable Boolean firstTime, @Nullable String tempLink, @Nullable Date createdDate, String userName) {
        this.id = id;
        this.orgId = orgId;
        this.ita = ita;
        this.exp = exp;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.wrongAttempt = wrongAttempt;
        this.firstTime = firstTime;
        this.tempLink = tempLink;
        this.createdDate = createdDate;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", ita=" + ita +
                ", exp=" + exp +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", wrongAttempt=" + wrongAttempt +
                ", firstTime=" + firstTime +
                ", tempLink='" + tempLink + '\'' +
                ", createdDate=" + createdDate +
                ", userName='" + userName + '\'' +
                '}';
    }
}
