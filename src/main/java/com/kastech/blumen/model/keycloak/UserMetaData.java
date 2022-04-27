package com.kastech.blumen.model.keycloak;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@IdClass(UserMetaDataId.class)
@Table(name = "user_metadata" ,schema = "blumen2")
public class UserMetaData implements Serializable {

    @Id
	private String id;
    @Id
    private String orgId;

    private String roleName;
    private String siteLocation;
    private boolean active;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String mobile;
    private String phone2;
    private String fax;
    private String notes;
    private boolean sendMail;
    private boolean temporary;

    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isSendMail() {
        return sendMail;
    }

    public void setSendMail(boolean sendMail) {
        this.sendMail = sendMail;
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

    public UserMetaData(String id, String orgId, String roleName,
                        String siteLocation, boolean active, boolean temporary, String address1, String address2,
                        String city, String state, String zipcode, String mobile,
                        String phone2, String fax, String notes, boolean sendMail){
        this.id = id;
        this.orgId = orgId;
        this.roleName = roleName;
        this.siteLocation = siteLocation;
        this.active = active;
        this.temporary = temporary;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.mobile = mobile;
        this.phone2 = phone2;
        this.fax = fax;
        this.notes = notes;
        this.sendMail = sendMail;
    }

    @Override
    public String toString() {
        return "UserMetaData{" +
                "id=" + id +
                ", orgId='" + orgId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", siteLocation='" + siteLocation + '\'' +
                ", active='" + active + '\'' +
                ", temporary='" + temporary + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", fax='" + fax + '\'' +
                ", notes='" + notes + '\'' +
                ", sendMail'" + sendMail + '\'' +
                '}';
    }
}
