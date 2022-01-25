package com.kastech.blumen.model.keycloak;

import javax.persistence.*;

@Entity
@Table(name = "logged_user" ,schema = "blumen2")
public class LoggedUser {

    @Id
	private String id;

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

    public LoggedUser(String id, int ita, int exp, String issueDate, String expiryDate, String userName){
        this.id = id;
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
                ", ita='" + ita + '\'' +
                ", exp='" + exp + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
