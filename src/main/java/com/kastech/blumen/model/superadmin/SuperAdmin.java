package com.kastech.blumen.model.superadmin;


import javax.persistence.*;

@Entity
@Table(name = "super_admin", schema = "blumen2")
public class SuperAdmin {
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String firstName;

    @Column(nullable = true)
    private String lastName;

    @Column(nullable = false)
    private String organizationType;

    @Column(nullable = false)
    private String scope;

    @Column(nullable = true)
    private String createdBy;

    @Column(nullable = true)
    private String createdDate;

    @Column(nullable = true)
    private String editedDate;

    @Column(nullable = true)
    private String lastLogin;

    public SuperAdmin() {
    }

    public SuperAdmin(Long id, String email, String password, String firstName, String lastName, String organizationType, String scope, String createdBy, String createdDate, String editedDate, String lastLogin) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.organizationType = organizationType;
        this.scope = scope;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.editedDate = editedDate;
        this.lastLogin = lastLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(String editedDate) {
        this.editedDate = editedDate;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "SuperAdmin{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", organizationType='" + organizationType + '\'' +
                ", scope='" + scope + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", editedDate='" + editedDate + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                '}';
    }
}
