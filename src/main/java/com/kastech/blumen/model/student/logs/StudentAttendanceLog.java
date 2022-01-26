package com.kastech.blumen.model.student.logs;

import com.kastech.blumen.model.customize.PullDown;

import javax.persistence.*;

@Entity
@Table(name = "student_attendance_log", schema = "blumen2")
public class StudentAttendanceLog {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_attendance_log_seq_gen")
    @SequenceGenerator(name = "student_attendance_log_seq_gen", sequenceName = "STUDENT_ATTENDANCE_LOG_SEQ")
    private Long id;
    private String ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String attendanceDate;
    private boolean dontApplyStipend;
    private String attendanceAmount;
    private String attendanceNotes;
    private String attendanceLogged;


    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String councelor;
    private String school;
    private String standing;

    public StudentAttendanceLog() {
    }

    public StudentAttendanceLog(Long id, String ssno, String firstName, String lastName, String phoneNumber, String attendanceDate, boolean dontApplyStipend, String attendanceAmount, String attendanceNotes, String attendanceLogged, String fiscalYear, boolean active, boolean served, boolean reported, String councelor, String school, String standing) {
        this.id = id;
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.attendanceDate = attendanceDate;
        this.dontApplyStipend = dontApplyStipend;
        this.attendanceAmount = attendanceAmount;
        this.attendanceNotes = attendanceNotes;
        this.attendanceLogged = attendanceLogged;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.councelor = councelor;
        this.school = school;
        this.standing = standing;
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

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public boolean isDontApplyStipend() {
        return dontApplyStipend;
    }

    public void setDontApplyStipend(boolean dontApplyStipend) {
        this.dontApplyStipend = dontApplyStipend;
    }

    public String getAttendanceAmount() {
        return attendanceAmount;
    }

    public void setAttendanceAmount(String attendanceAmount) {
        this.attendanceAmount = attendanceAmount;
    }

    public String getAttendanceNotes() {
        return attendanceNotes;
    }

    public void setAttendanceNotes(String attendanceNotes) {
        this.attendanceNotes = attendanceNotes;
    }

    public String getAttendanceLogged() {
        return attendanceLogged;
    }

    public void setAttendanceLogged(String attendanceLogged) {
        this.attendanceLogged = attendanceLogged;
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
        return "StudentAttendanceLog{" +
                "id=" + id +
                ", ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", attendanceDate='" + attendanceDate + '\'' +
                ", dontApplyStipend=" + dontApplyStipend +
                ", attendanceAmount='" + attendanceAmount + '\'' +
                ", attendanceNotes='" + attendanceNotes + '\'' +
                ", attendanceLogged='" + attendanceLogged + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", councelor='" + councelor + '\'' +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                '}';
    }
}
