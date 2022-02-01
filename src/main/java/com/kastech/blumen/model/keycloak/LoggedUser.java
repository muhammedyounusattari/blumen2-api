package com.kastech.blumen.model.keycloak;

import javax.persistence.*;
import java.io.Serializable;

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
    public LoggedUser() {}

    public LoggedUser(String id, String orgId, int ita, int exp, String issueDate, String expiryDate, String userName){
        this.id = id;
        this.orgId = orgId;
        this.ita = ita;
        this.exp = exp;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "id=" + id +
                "orgId=" + orgId +
                ", ita='" + ita + '\'' +
                ", exp='" + exp + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
