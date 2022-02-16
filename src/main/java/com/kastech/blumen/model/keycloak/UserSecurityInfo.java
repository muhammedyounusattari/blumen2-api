package com.kastech.blumen.model.keycloak;

import javax.annotation.Nullable;
import javax.persistence.*;
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

    @Nullable
    private String email;

    @Column(length =  5000)
    private String accessToken;

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

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    public UserSecurityInfo() {}

    public UserSecurityInfo(String id, String orgId, String username, String password, String securityQuestion1, String securityAnswer1, String securityQuestion2, String securityAnswer2, @Nullable String email, String accessToken) {
        this.id = id;
        this.orgId = orgId;
        this.username = username;
        this.password = password;
        this.securityQuestion1 = securityQuestion1;
        this.securityAnswer1 = securityAnswer1;
        this.securityQuestion2 = securityQuestion2;
        this.securityAnswer2 = securityAnswer2;
        this.email = email;
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "UserSecurityInfo{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", securityQuestion1='" + securityQuestion1 + '\'' +
                ", securityAnswer1='" + securityAnswer1 + '\'' +
                ", securityQuestion2='" + securityQuestion2 + '\'' +
                ", securityAnswer2='" + securityAnswer2 + '\'' +
                ", email='" + email + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
