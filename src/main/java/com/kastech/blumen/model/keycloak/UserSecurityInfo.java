package com.kastech.blumen.model.keycloak;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Deprecated
@Entity
@IdClass(UserSecurityInfoId.class)
@Table(name = "user_security_info" ,schema = "blumen2")
public class UserSecurityInfo implements Serializable {

    @Id
	private String id;
    @Id
    private String orgId;

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zipcode;
    private String mobile;
    private String phone1;
    private String phone2;
    private String fax;
    private String notes;
    private String siteLocation;
    private Boolean active;
    private String createdBy;
    private String editedBy;

    private String securityQuestion1;
    private String securityAnswer1;
    private String securityQuestion2;
    private String securityAnswer2;

    @Nullable
    private String hashedCode;

    @Nullable
    private Date linkExpiryDate;

    @OneToOne
    private BOLT bolt;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
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

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    @Nullable
    public String getHashedCode() {
        return hashedCode;
    }

    public void setHashedCode(@Nullable String hashedCode) {
        this.hashedCode = hashedCode;
    }

    @Nullable
    public Date getLinkExpiryDate() {
        return linkExpiryDate;
    }

    public void setLinkExpiryDate(@Nullable Date linkExpiryDate) {
        this.linkExpiryDate = linkExpiryDate;
    }

    public BOLT getBolt() {
        return bolt;
    }

    public void setBolt(BOLT bolt) {
        this.bolt = bolt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(String editedBy) {
        this.editedBy = editedBy;
    }

    public UserSecurityInfo(){
        super();
    }

    public UserSecurityInfo(String id, String orgId, String username, String firstName, String lastName, String password, String address1, String address2, String city, String state, String zipcode, String mobile, String phone1, String phone2, String fax, String notes, String siteLocation, Boolean active, String securityQuestion1, String securityAnswer1, String securityQuestion2, String securityAnswer2, @Nullable String hashedCode, @Nullable Date linkExpiryDate, BOLT bolt) {
        this.id = id;
        this.orgId = orgId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.mobile = mobile;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.fax = fax;
        this.notes = notes;
        this.siteLocation = siteLocation;
        this.active = active;
        this.securityQuestion1 = securityQuestion1;
        this.securityAnswer1 = securityAnswer1;
        this.securityQuestion2 = securityQuestion2;
        this.securityAnswer2 = securityAnswer2;
        this.hashedCode = hashedCode;
        this.linkExpiryDate = linkExpiryDate;
        this.bolt = bolt;
    }

    @Override
    public String toString() {
        return "UserSecurityInfo{" +
                "id='" + id + '\'' +
                ", orgId='" + orgId + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", fax='" + fax + '\'' +
                ", notes='" + notes + '\'' +
                ", siteLocation='" + siteLocation + '\'' +
                ", active=" + active +
                ", securityQuestion1='" + securityQuestion1 + '\'' +
                ", securityAnswer1='" + securityAnswer1 + '\'' +
                ", securityQuestion2='" + securityQuestion2 + '\'' +
                ", securityAnswer2='" + securityAnswer2 + '\'' +
                ", hashedCode='" + hashedCode + '\'' +
                ", linkExpiryDate=" + linkExpiryDate +
                ", bolt=" + bolt +
                '}';
    }
}
