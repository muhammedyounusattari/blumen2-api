package com.kastech.blumen.model;

public class StudentStipendLog {

    private String ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String stipendDate;
    private String stipendAmount;
    private String checkNumber;
    private String checkDispensed;
    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String councelor;
    private String school;
    private String standing;

    public StudentStipendLog() {
    }

    public StudentStipendLog(String ssno, String firstName, String lastName, String phoneNumber, String stipendDate, String stipendAmount, String checkNumber, String checkDispensed, String fiscalYear, boolean active, boolean served, boolean reported, String councelor, String school, String standing) {
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.stipendDate = stipendDate;
        this.stipendAmount = stipendAmount;
        this.checkNumber = checkNumber;
        this.checkDispensed = checkDispensed;
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

    public String getStipendDate() {
        return stipendDate;
    }

    public void setStipendDate(String stipendDate) {
        this.stipendDate = stipendDate;
    }

    public String getStipendAmount() {
        return stipendAmount;
    }

    public void setStipendAmount(String stipendAmount) {
        this.stipendAmount = stipendAmount;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getCheckDispensed() {
        return checkDispensed;
    }

    public void setCheckDispensed(String checkDispensed) {
        this.checkDispensed = checkDispensed;
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
        return "StudentStipendLog{" +
                "ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", stipendDate='" + stipendDate + '\'' +
                ", stipendAmount='" + stipendAmount + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                ", checkDispensed='" + checkDispensed + '\'' +
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
