package com.kastech.blumen.model.utilities;

import java.util.List;

public class SemesterRequest {

    private List<String> ssnoList;
    private String semesterName;
    private String year;
    private String fiscalYear;

    public SemesterRequest() {
    }

    public SemesterRequest(List<String> ssnoList, String semesterName, String year, String fiscalYear) {
        this.ssnoList = ssnoList;
        this.semesterName = semesterName;
        this.year = year;
        this.fiscalYear = fiscalYear;
    }

    public List<String> getSsnoList() {
        return ssnoList;
    }

    public void setSsnoList(List<String> ssnoList) {
        this.ssnoList = ssnoList;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    @Override
    public String toString() {
        return "SemesterRequest{" +
                "ssnoList=" + ssnoList +
                ", semesterName='" + semesterName + '\'' +
                ", year='" + year + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                '}';
    }
}
