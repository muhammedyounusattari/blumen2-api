package com.kastech.blumen.model.keycloak;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kastech.blumen.model.admin.home.Organization;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", schema = "blumen2")
public class LoggedUser implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orgType;

    private Long orgId;

    private String username;

    private String email;

    private String password;

    private String roleName;

    private String firstName;

    private String lastName;

    private String scope;

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

    @OneToOne
    private BOLT bolt;

    private int ita;

    private int exp;

    private Date issueDate;

    private Date expiryDate;

    @Nullable
    private Integer wrongAttempt;

    @Nullable
    private Boolean firstTime;

    @Nullable
    private String tempLink;

    @Column(nullable = true)
    private Date createdDate;

    @Column(nullable = true)
    private Date editedDate;

    @Column(nullable = true)
    private Date lastLogin;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",schema = "blumen2",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
  //  @JsonIgnore
    private Set<Roles> roles = new HashSet<>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    private Set<Organization> organizationSet = new HashSet<>();

    @Nullable
    private String hashedCode;

    @Nullable
    private Date linkExpiryDate;

    public LoggedUser() {
    }

    public LoggedUser(Long id, String orgType, Long orgId, String username, String email, String password, String roleName, String firstName, String lastName, String scope, String address1, String address2, String city, String state, String zipcode, String mobile, String phone1, String phone2, String fax, String notes, String siteLocation, Boolean active, String createdBy, String editedBy, String securityQuestion1, String securityAnswer1, String securityQuestion2, String securityAnswer2, BOLT bolt, int ita, int exp, Date issueDate, Date expiryDate, @Nullable Integer wrongAttempt, @Nullable Boolean firstTime, @Nullable String tempLink, Date createdDate, Date editedDate, Date lastLogin, Set<Roles> roles, @Nullable String hashedCode, @Nullable Date linkExpiryDate, Set<Organization> organizationSet ) {
        this.id = id;
        this.orgType = orgType;
        this.orgId = orgId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roleName = roleName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.scope = scope;
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
        this.createdBy = createdBy;
        this.editedBy = editedBy;
        this.securityQuestion1 = securityQuestion1;
        this.securityAnswer1 = securityAnswer1;
        this.securityQuestion2 = securityQuestion2;
        this.securityAnswer2 = securityAnswer2;
        this.bolt = bolt;
        this.ita = ita;
        this.exp = exp;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.wrongAttempt = wrongAttempt;
        this.firstTime = firstTime;
        this.tempLink = tempLink;
        this.createdDate = createdDate;
        this.editedDate = editedDate;
        this.lastLogin = lastLogin;
        this.roles = roles;
        this.hashedCode = hashedCode;
        this.linkExpiryDate = linkExpiryDate;
        this.organizationSet = organizationSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
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

    public BOLT getBolt() {
        return bolt;
    }

    public void setBolt(BOLT bolt) {
        this.bolt = bolt;
    }

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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Nullable
    public Integer getWrongAttempt() {
        return wrongAttempt;
    }

    public void setWrongAttempt(@Nullable Integer wrongAttempt) {
        this.wrongAttempt = wrongAttempt;
    }

    @Nullable
    public Boolean getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(@Nullable Boolean firstTime) {
        this.firstTime = firstTime;
    }

    @Nullable
    public String getTempLink() {
        return tempLink;
    }

    public void setTempLink(@Nullable String tempLink) {
        this.tempLink = tempLink;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
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

    public Set<Organization> getOrganizationSet() {
        return organizationSet;
    }

    public void setOrganizationSet(Set<Organization> organizationSet) {
        this.organizationSet = organizationSet;
    }
}
