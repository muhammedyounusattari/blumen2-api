package com.kastech.blumen.model.keycloak;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String orgId;
    private String roleName;
    private String siteLocation;
    private boolean active;
    private boolean emailVerified;
    private boolean enabled;
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

    private BOLT bolt;

    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setSendMail(boolean sendMail) {
        this.sendMail = sendMail;
    }

    public BOLT getBolt() {
        return bolt;
    }

    public void setBolt(BOLT bolt) {
        this.bolt = bolt;
    }

    public UserInfo() {}

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getFax() {
        return fax;
    }

    public String getNotes() {
        return notes;
    }

    public boolean isSendMail() {
        return sendMail;
    }

    public UserInfo(UserInfoBuilder userInfoBuilder) {
        this.id = userInfoBuilder.id;
        this.username = userInfoBuilder.username;
        this.firstName = userInfoBuilder.firstName;
        this.lastName = userInfoBuilder.lastName;
        this.email = userInfoBuilder.email;
        this.orgId = userInfoBuilder.orgId;
        this.roleName = userInfoBuilder.roleName;
        this.siteLocation = userInfoBuilder.siteLocation;
        this.active = userInfoBuilder.active;
        this.emailVerified = userInfoBuilder.emailVerified;
        this.enabled = userInfoBuilder.enabled;
        this.address1 = userInfoBuilder.address1;
        this.address2 = userInfoBuilder.address2;
        this.city = userInfoBuilder.city;
        this.state = userInfoBuilder.state;
        this.zipcode = userInfoBuilder.zipcode;
        this.mobile = userInfoBuilder.mobile;
        this.phone2 = userInfoBuilder.phone2;
        this.fax = userInfoBuilder.fax;
        this.notes = userInfoBuilder. notes;
        this.sendMail = userInfoBuilder.sendMail;
    }

    public UserInfo(String id, String username, String firstName, String lastName, String email, String orgId, String roleName, String siteLocation, boolean active, boolean emailVerified, boolean enabled, String address1, String address2, String city, String state, String zipcode, String mobile, String phone2, String fax, String notes, boolean sendMail, BOLT bolt) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.orgId = orgId;
        this.roleName = roleName;
        this.siteLocation = siteLocation;
        this.active = active;
        this.emailVerified = emailVerified;
        this.enabled = enabled;
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
        this.bolt = bolt;
    }

    public String getId() {
        return id;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public boolean isActive() {
        return active;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public static class UserInfoBuilder {
        private String id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String orgId;
        private String roleName;
        private String siteLocation;
        private boolean active;
        private boolean emailVerified;
        private boolean enabled;
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

        public UserInfoBuilder() {

        }

        public UserInfoBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserInfoBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserInfoBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserInfoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserInfoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public UserInfoBuilder orgId(String orgId) {
            this.orgId = orgId;
            return this;
        }

        public UserInfoBuilder roleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public UserInfoBuilder siteLocation(String siteLocation) {
            this.siteLocation = siteLocation;
            return this;
        }

        public UserInfoBuilder active(boolean active) {
            this.active = active;
            return this;
        }

        public UserInfoBuilder address1(String address1) {
            this.address1 = address1;
            return this;
        }

        public UserInfoBuilder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public UserInfoBuilder city(String address2) {
            this.address2 = address2;
            return this;
        }

        public UserInfoBuilder state(String address2) {
            this.address2 = address2;
            return this;
        }

        public UserInfoBuilder zipcode(String address2) {
            this.address2 = address2;
            return this;
        }

        public UserInfoBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public UserInfoBuilder phone2(String phone2) {
            this.phone2 = phone2;
            return this;
        }

        public UserInfoBuilder fax(String fax) {
            this.fax = fax;
            return this;
        }

        public UserInfoBuilder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public UserInfoBuilder sendMail(boolean sendMail) {
            this.sendMail = sendMail;
            return this;
        }

        public UserInfoBuilder enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public UserInfoBuilder emailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
            return this;
        }

        public UserInfo buildUserInfo() {
            return new UserInfo(this);
        }
    }
}
