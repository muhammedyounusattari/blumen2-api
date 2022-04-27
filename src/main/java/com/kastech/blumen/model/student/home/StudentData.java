package com.kastech.blumen.model.student.home;

import javax.persistence.*;

@Entity
@Table(name = "student_data" ,schema = "blumen2")
public class StudentData {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student-data_list_seq_gen")
    @SequenceGenerator(name="student-data_list_seq_gen", sequenceName="STUDENT_DATA_LIST_SEQ")
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String counselor;
    private String school;
    private String standing;

    public StudentData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isServed() {
        return served;
    }

    public void setServed(boolean served) {
        this.served = served;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", counselor='" + counselor + '\'' +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                '}';
    }
}
