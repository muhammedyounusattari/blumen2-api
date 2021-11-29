package com.kastech.blumen.model.student.dataentry;

public class AdvancedFilter {

    private String semesterCurrentYear;
    private String semesterFiscalYear;
    private String semester;
    private String active;
    private String served;
    private String reported;
    private String semesterGpa;
    private String semesterCumulativeGpa;
    private String semesterStanding;

    public AdvancedFilter() {
    }

    public AdvancedFilter(String semesterCurrentYear, String semesterFiscalYear, String semester, String active, String served, String reported, String semesterGpa, String semesterCumulativeGpa, String semesterStanding) {
        this.semesterCurrentYear = semesterCurrentYear;
        this.semesterFiscalYear = semesterFiscalYear;
        this.semester = semester;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.semesterGpa = semesterGpa;
        this.semesterCumulativeGpa = semesterCumulativeGpa;
        this.semesterStanding = semesterStanding;
    }

    public String getSemesterCurrentYear() {
        return semesterCurrentYear;
    }

    public void setSemesterCurrentYear(String semesterCurrentYear) {
        this.semesterCurrentYear = semesterCurrentYear;
    }

    public String getSemesterFiscalYear() {
        return semesterFiscalYear;
    }

    public void setSemesterFiscalYear(String semesterFiscalYear) {
        this.semesterFiscalYear = semesterFiscalYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
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

    public String getSemesterGpa() {
        return semesterGpa;
    }

    public void setSemesterGpa(String semesterGpa) {
        this.semesterGpa = semesterGpa;
    }

    public String getSemesterCumulativeGpa() {
        return semesterCumulativeGpa;
    }

    public void setSemesterCumulativeGpa(String semesterCumulativeGpa) {
        this.semesterCumulativeGpa = semesterCumulativeGpa;
    }

    public String getSemesterStanding() {
        return semesterStanding;
    }

    public void setSemesterStanding(String semesterStanding) {
        this.semesterStanding = semesterStanding;
    }

    @Override
    public String toString() {
        return "AdvancedFilter{" +
                "semesterCurrentYear='" + semesterCurrentYear + '\'' +
                ", semesterFiscalYear='" + semesterFiscalYear + '\'' +
                ", semester='" + semester + '\'' +
                ", active='" + active + '\'' +
                ", served='" + served + '\'' +
                ", reported='" + reported + '\'' +
                ", semesterGpa='" + semesterGpa + '\'' +
                ", semesterCumulativeGpa='" + semesterCumulativeGpa + '\'' +
                ", semesterStanding='" + semesterStanding + '\'' +
                '}';
    }
}
