package com.kastech.blumen.model.student;

import javax.validation.constraints.NotNull;

public class StudentFilterDto extends PageableDto{
   @NotNull
    private Integer financialYear;
    private String active;
    private String served;
    private String reported;


    public Integer getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(Integer financialYear) {
        this.financialYear = financialYear;
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


}
