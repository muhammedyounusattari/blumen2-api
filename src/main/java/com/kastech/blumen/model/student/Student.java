package com.kastech.blumen.model.student;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "student" ,schema = "blumen2")
public class Student implements Serializable {

	@Id
    private Long ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactDate;
    private String staff;
    private String contactTime;
    private String recontactDate;
    private String active;
    private String served;
    private String reported;
    private String school;
    private String standing;
    private String fiscalYear;

    //private EndOfYearStatus endOfYearStatus;
  //  private Activities activities;

    public Student() {
    }

    public Student(Long ssno, String firstName, String lastName, String phoneNumber, String contactDate, String staff, String contactTime, String recontactDate, String active, String served, String reported, String school, String standing, String fiscalYear) {
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.contactDate = contactDate;
        this.staff = staff;
        this.contactTime = contactTime;
        this.recontactDate = recontactDate;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.school = school;
        this.standing = standing;
        this.fiscalYear = fiscalYear;
    }

    public Long getSsno() {
        return ssno;
    }

    public void setSsno(Long ssno) {
        this.ssno = ssno;
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

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getContactTime() {
        return contactTime;
    }

    public void setContactTime(String contactTime) {
        this.contactTime = contactTime;
    }

    public String getRecontactDate() {
        return recontactDate;
    }

    public void setRecontactDate(String recontactDate) {
        this.recontactDate = recontactDate;
    }

    public String isActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String isServed() {
        return served;
    }

    public void setServed(String served) {
        this.served = served;
    }

    public String isReported() {
        return reported;
    }

    public void setReported(String reported) {
        this.reported = reported;
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

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    @Override
    public String toString() {
        return "StudentStaffContacts{" +
                "ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactDate='" + contactDate + '\'' +
                ", staff='" + staff + '\'' +
                ", contactTime='" + contactTime + '\'' +
                ", recontactDate='" + recontactDate + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                '}';
    }

//    class EndOfYearStatus {
//        private List<EndStatus> endStatusList;
//
//        public List<EndStatus> getEndStatusList() {
//            return endStatusList;
//        }
//
//        public void setEndStatusList(List<EndStatus> endStatusList) {
//            this.endStatusList = endStatusList;
//        }
//    }
//
//    class StudentActivities implements Serializable{
//        private Integer id;
//        private String name;
//
//    }
}
