package com.kastech.blumen.model.student.dataentry;

public class NormalFilter {

    private String fiscalYear;
    private String active;
    private String served;
    private String reported;
    private String status;
    private String ethinicity;
    private String standing;
    private String counselor;
    private String school;
    private String eligibility;
    private String gender;

    public NormalFilter() {
    }

    public NormalFilter(String fiscalYear, String active, String served, String reported, String status, String ethinicity, String standing, String counselor, String school, String eligibility, String gender) {
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.status = status;
        this.ethinicity = ethinicity;
        this.standing = standing;
        this.counselor = counselor;
        this.school = school;
        this.eligibility = eligibility;
        this.gender = gender;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEthinicity() {
        return ethinicity;
    }

    public void setEthinicity(String ethinicity) {
        this.ethinicity = ethinicity;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
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

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "NormalFilter{" +
                "fiscalYear='" + fiscalYear + '\'' +
                ", active='" + active + '\'' +
                ", served='" + served + '\'' +
                ", reported='" + reported + '\'' +
                ", status='" + status + '\'' +
                ", ethinicity='" + ethinicity + '\'' +
                ", standing='" + standing + '\'' +
                ", counselor='" + counselor + '\'' +
                ", school='" + school + '\'' +
                ", eligibility='" + eligibility + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
