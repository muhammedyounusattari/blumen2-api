package com.kastech.blumen.model.student.logs;

public class StudentAttendanceLog {


    private String ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String attendanceDate;
    private String attendanceAmount;
    private String attendanceLogged;
    private String maxMarks;
    private String letterGrade;

    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String councelor;
    private String school;
    private String standing;

    public StudentAttendanceLog() {
    }

    public StudentAttendanceLog(String ssno, String firstName, String lastName, String phoneNumber, String attendanceDate, String attendanceAmount, String attendanceLogged, String maxMarks, String letterGrade, String fiscalYear, boolean active, boolean served, boolean reported, String councelor, String school, String standing) {
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.attendanceDate = attendanceDate;
        this.attendanceAmount = attendanceAmount;
        this.attendanceLogged = attendanceLogged;
        this.maxMarks = maxMarks;
        this.letterGrade = letterGrade;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.councelor = councelor;
        this.school = school;
        this.standing = standing;
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

    public String getAttendanceAmount() {
        return attendanceAmount;
    }

    public void setAttendanceAmount(String attendanceAmount) {
        this.attendanceAmount = attendanceAmount;
    }

    public String getAttendanceLogged() {
        return attendanceLogged;
    }

    public void setAttendanceLogged(String attendanceLogged) {
        this.attendanceLogged = attendanceLogged;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
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
                "ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", attendanceDate='" + attendanceDate + '\'' +
                ", attendanceAmount='" + attendanceAmount + '\'' +
                ", attendanceLogged='" + attendanceLogged + '\'' +
                ", maxMarks='" + maxMarks + '\'' +
                ", letterGrade='" + letterGrade + '\'' +
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
