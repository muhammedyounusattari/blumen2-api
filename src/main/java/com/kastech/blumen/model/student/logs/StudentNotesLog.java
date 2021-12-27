package com.kastech.blumen.model.student.logs;

import javax.persistence.*;

@Entity
@Table(name = "student_notes_log" ,schema = "blumen2")
public class StudentNotesLog {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_notes_log_seq_gen")
    @SequenceGenerator(name="student_notes_log_seq_gen", sequenceName="STUDENT_NOTES_LOG_SEQ")
    private Long ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String notesDate;
    private String notes;
    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String councelor;
    private String school;
    private String standing;

    public StudentNotesLog() {
    }

    public StudentNotesLog(Long ssno, String firstName, String lastName, String phoneNumber, String notesDate, String notes, String fiscalYear, boolean active, boolean served, boolean reported, String councelor, String school, String standing) {
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.notesDate = notesDate;
        this.notes = notes;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.councelor = councelor;
        this.school = school;
        this.standing = standing;
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

    public String getNotesDate() {
        return notesDate;
    }

    public void setNotesDate(String notesDate) {
        this.notesDate = notesDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    @Override
    public String toString() {
        return "StudentNotesLog{" +
                "ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", notesDate='" + notesDate + '\'' +
                ", notes='" + notes + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", councelor='" + councelor + '\'' +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                '}';
    }

    public StudentNotesLog updateWith(StudentNotesLog item) {
        return new StudentNotesLog(
                item.ssno,
                item.firstName,
                item.lastName,
                item.phoneNumber,
                item.notesDate,
                item.notes,
                item.fiscalYear,
                item.active,
                item.served,
                item.reported,
                item.councelor,
                item.school,
                item.standing
        );
    }
}
