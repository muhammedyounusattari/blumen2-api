package com.kastech.blumen.model.utilities;

import java.util.List;

public class FiscalGraduatedYearRequest {

    private List<String> ssnoList;
    private String fiscalYear;

    public FiscalGraduatedYearRequest() {
    }

    public FiscalGraduatedYearRequest(List<String> ssnoList, String fiscalYear) {
        this.ssnoList = ssnoList;
        this.fiscalYear = fiscalYear;
    }

    public List<String> getSsnoList() {
        return ssnoList;
    }

    public void setSsnoList(List<String> ssnoList) {
        this.ssnoList = ssnoList;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    @Override
    public String toString() {
        return "FiscalGraduatedYearRequest{" +
                "ssnoList=" + ssnoList +
                ", fiscalYear='" + fiscalYear + '\'' +
                '}';
    }
}
