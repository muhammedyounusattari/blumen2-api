package com.kastech.blumen.model.response;

import com.kastech.blumen.model.keycloak.BOLT;

public class LoggedUserResponse {

    private String orgType;
    private Long orgId;
    private String username;
    private String email;
    private String password;
    private String roleName;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private Boolean active;
    private String city;
    private String state;
    private String zipcode;
    private String mobile;
    private String phone1;
    private String phone2;
    private String fax;
    private String notes;
    private String siteLocation;
    private String createdBy;
    private String editedBy;
    private BOLT bolt;

    public LoggedUserResponse(){
        super();
    }

    public LoggedUserResponse(String orgType, Long orgId, String username, String email, String password, String roleName, String firstName, String lastName, String address1, String address2, Boolean active, String city, String state, String zipcode, String mobile, String phone1, String phone2, String fax, String notes, String siteLocation, String createdBy, String editedBy, BOLT bolt) {
        this.orgType = orgType;
        this.orgId = orgId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleName = roleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.active = active;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.mobile = mobile;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.fax = fax;
        this.notes = notes;
        this.siteLocation = siteLocation;
        this.createdBy = createdBy;
        this.editedBy = editedBy;
        this.bolt = bolt;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public BOLT getBolt() {
        return bolt;
    }

    public void setBolt(BOLT bolt) {
        this.bolt = bolt;
    }
}
