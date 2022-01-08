package com.kastech.blumen.model.student;

import com.kastech.blumen.controller.student.Activities;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "student" ,schema = "blumen2")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_seq_gen")
    @SequenceGenerator(name="student_seq_gen", sequenceName="student_SEQ")
    private Long ssno;
    private String orgId;
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
    private String grade;
    private String gradeNotes;

    //private EndOfYearStatus endOfYearStatus;
    @OneToOne(cascade = {CascadeType.ALL})
    private GraduatedInformation graduatedInformation;
    //  private Activities activities;

    public Student() {
    }

    public Student(Long ssno, String orgId, String firstName, String lastName, String phoneNumber, String contactDate, String staff, String contactTime, String recontactDate, String active, String served, String reported, String school, String standing, String fiscalYear, GraduatedInformation graduatedInformation) {
        this.ssno = ssno;
        this.orgId = orgId;
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
        this.graduatedInformation = graduatedInformation;
    }

    public Long getSsno() {
        return ssno;
    }

    public void setSsno(Long ssno) {
        this.ssno = ssno;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getServed() {
        return served;
    }

    public void setServed(String served) {
        this.served = served;
    }

    public String getReported() {
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

    public GraduatedInformation getGraduatedInformation() {
        return graduatedInformation;
    }

    public void setGraduatedInformation(GraduatedInformation graduatedInformation) {
        this.graduatedInformation = graduatedInformation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeNotes() {
        return gradeNotes;
    }

    public void setGradeNotes(String gradeNotes) {
        this.gradeNotes = gradeNotes;
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
