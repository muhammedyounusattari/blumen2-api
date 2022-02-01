package com.kastech.blumen.model.keycloak;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
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
