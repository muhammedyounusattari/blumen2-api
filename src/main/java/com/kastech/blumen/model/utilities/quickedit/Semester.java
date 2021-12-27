package com.kastech.blumen.model.utilities.quickedit;

public class Semester {

    private String semesterCurrentYear;
    private String semesterFiscalYear;
    private String semester;
    private String active;
    private String reported;
    private String served;
    private String semesterGpa;
    private String semesterCummulativeGpa;
    private String semesterStanding;

    public Semester() {
    }

    public Semester(String semesterCurrentYear, String semesterFiscalYear, String semester, String active, String reported, String served, String semesterGpa, String semesterCummulativeGpa, String semesterStanding) {
        this.semesterCurrentYear = semesterCurrentYear;
        this.semesterFiscalYear = semesterFiscalYear;
        this.semester = semester;
        this.active = active;
        this.reported = reported;
        this.served = served;
        this.semesterGpa = semesterGpa;
        this.semesterCummulativeGpa = semesterCummulativeGpa;
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

    public String getReported() {
        return reported;
    }

    public void setReported(String reported) {
        this.reported = reported;
    }

    public String getServed() {
        return served;
    }

    public void setServed(String served) {
        this.served = served;
    }

    public String getSemesterGpa() {
        return semesterGpa;
    }

    public void setSemesterGpa(String semesterGpa) {
        this.semesterGpa = semesterGpa;
    }

    public String getSemesterCummulativeGpa() {
        return semesterCummulativeGpa;
    }

    public void setSemesterCummulativeGpa(String semesterCummulativeGpa) {
        this.semesterCummulativeGpa = semesterCummulativeGpa;
    }

    public String getSemesterStanding() {
        return semesterStanding;
    }

    public void setSemesterStanding(String semesterStanding) {
        this.semesterStanding = semesterStanding;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "semesterCurrentYear='" + semesterCurrentYear + '\'' +
                ", semesterFiscalYear='" + semesterFiscalYear + '\'' +
                ", semester='" + semester + '\'' +
                ", active='" + active + '\'' +
                ", reported='" + reported + '\'' +
                ", served='" + served + '\'' +
                ", semesterGpa='" + semesterGpa + '\'' +
                ", semesterCummulativeGpa='" + semesterCummulativeGpa + '\'' +
                ", semesterStanding='" + semesterStanding + '\'' +
                '}';
    }
}
