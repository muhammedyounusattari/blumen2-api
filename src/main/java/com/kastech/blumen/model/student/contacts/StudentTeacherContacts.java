package com.kastech.blumen.model.student.contacts;

import javax.persistence.*;

@Entity
@Table(name = "student_teacher_contacts", schema = "blumen2")
public class StudentTeacherContacts {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="stu_teachher_contact_list_seq_gen")
    @SequenceGenerator(name="stu_teacher_contact_list_seq_gen", sequenceName="STUDENT_TEACHER_CONTACT_LIST_SEQ")
    private Long ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactDate;
    private String teacher;
    private String contactTime;
    private String recontactDate;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String school;
    private String standing;
    private String fiscalYear;

    public StudentTeacherContacts() {
    }

    public StudentTeacherContacts(Long ssno, String firstName, String lastName, String phoneNumber, String contactDate, String teacher, String contactTime, String recontactDate, boolean active, boolean served, boolean reported, String school, String standing, String fiscalYear) {
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.contactDate = contactDate;
        this.teacher = teacher;
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

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
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
        return "StudentTeacherContacts{" +
                "ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactDate='" + contactDate + '\'' +
                ", teacher='" + teacher + '\'' +
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

    public StudentTeacherContacts updateWith(StudentTeacherContacts item) {
        return new StudentTeacherContacts(
                this.ssno,
                item.firstName,
                item.lastName,
                item.phoneNumber,
                item.contactDate,
                item.teacher,
                item.contactTime,
                item.recontactDate,
                item.active,
                item.served,
                item.reported,
                item.school,
                item.standing,
                item.fiscalYear
        );
    }
}
