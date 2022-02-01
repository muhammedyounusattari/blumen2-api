package com.kastech.blumen.model.keycloak;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@IdClass(UserSecurityInfoId.class)
@Table(name = "user_security_info" ,schema = "blumen2")
public class UserSecurityInfo implements Serializable {

    @Id
	private String id;
    @Id
    private String orgId;

    private String username;
    private String password;
    private String securityQuestion1;
    private String securityAnswer1;
    private String securityQuestion2;
    private String securityAnswer2;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSecurityInfo() {}

    public UserSecurityInfo(String id, String orgId, String username, String password, String securityQuestion1, String securityAnswer1, String securityQuestion2, String securityAnswer2){
        this.id = id;
        this.orgId = orgId;
        this.username = username;
        this.password = password;
        this.securityQuestion1 = securityQuestion1;
        this.securityAnswer1 = securityAnswer1;
        this.securityQuestion2 = securityQuestion2;
        this.securityAnswer2 = securityAnswer2;
    }

    @Override
    public String toString() {
        return "UserSecurityInformation{" +
                "id=" + id +
                "orgId=" + orgId +
                "username=" + username +
                ", password=" + password +
                ", securityQuestion1=" + securityQuestion1 +
                ", securityAnswer1=" + securityAnswer1 +
                ", securityQuestion2=" + securityQuestion2 +
                ", securityAnswer2=" + securityAnswer2 +
                '}';
    }
}
