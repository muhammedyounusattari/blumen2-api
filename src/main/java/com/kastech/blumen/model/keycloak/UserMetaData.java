package com.kastech.blumen.model.keycloak;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_metadata" ,schema = "blumen2")
public class UserMetaData {

    @Id
	private String id;
    private String orgId;
    private String roleName;
    private String siteLocation;
    private boolean active;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserMetaData() {}

    public UserMetaData(String id, String password, String orgId, String roleName, String siteLocation, boolean active){
        this.id = id;
        this.password = password;
        this.orgId = orgId;
        this.roleName = roleName;
        this.siteLocation = siteLocation;
        this.active = active;
    }

    @Override
    public String toString() {
        return "LoggedUser{" +
                "id=" + id +
                ", password=" + password +
                ", orgId='" + orgId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", siteLocation='" + siteLocation + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
