package com.kastech.blumen.model.student.contacts;

import javax.persistence.*;

@Entity
@Table(name = "counselor_contact_reminder" ,schema = "blumen2")
public class StudentDispCouContRemin {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="counselor_contact_reminder_list_seq_gen")
    @SequenceGenerator(name="counselor_contact_reminder_list_seq_gen", sequenceName="COUNSELOR_CONTACT_REMINDER_LIST_SEQ")
	private Long id;
    private String ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactDate;
    private String contactTime;
    private String recontactDate;

    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String councelor;
    private String school;
    private String standing;
    private transient boolean isReminder;

    public StudentDispCouContRemin() {
    }

    public StudentDispCouContRemin(Long id, String ssno, String firstName, String lastName, String phoneNumber, String contactDate, String contactTime, String recontactDate, String fiscalYear, boolean active, boolean served, boolean reported, String councelor, String school, String standing, boolean isReminder) {
        this.id = id;
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.contactDate = contactDate;
        this.contactTime = contactTime;
        this.recontactDate = recontactDate;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.councelor = councelor;
        this.school = school;
        this.standing = standing;
        this.isReminder = isReminder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
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

    public String getCouncelor() {
        return councelor;
    }

    public void setCouncelor(String councelor) {
        this.councelor = councelor;
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

    public boolean isReminder() {
        return isReminder;
    }

    public void setReminder(boolean reminder) {
        isReminder = reminder;
    }

    @Override
    public String toString() {
        return "StudentDispCouContRemin{" +
                "id=" + id +
                ", ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactDate='" + contactDate + '\'' +
                ", contactTime='" + contactTime + '\'' +
                ", recontactDate=" + recontactDate +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", councelor='" + councelor + '\'' +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                ", isReminder=" + isReminder +
                '}';
    }
}
