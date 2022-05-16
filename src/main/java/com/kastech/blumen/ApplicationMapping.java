package com.kastech.blumen;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "application_mapping" ,schema = "blumen2")
public class ApplicationMapping {

    @Id
    private long id;

    @Column(name="RDI_FIELD_DESC")
    private String rdiFieldDesc;

    @Column(name="TABLE_NAME")
    private String tableName;

    @Column(name="RDI_FLDNAM")
    private String rdiFLDNAM;

    @Column(name="IsBluItems")
    private Boolean isBluItems;

    @Column(name="IsPLFIELDS")
    private Boolean isPLFIELDS;

    @Column(name="IsIMPORTFILEFIELDS")
    private Boolean isIMPORTFILEFIELDS;

    @Column(name="IsPulldownlist")
    private Boolean isPulldownlist;

    @Column(name="isPULLTYPE")
    private Boolean isPULLTYPE;

    @Column(name="isAPR")
    private Boolean isAPR;

    @Column(name="iSDELETED")
    private Boolean ISDELETED;

    private Date lastmodifieddate;

    private String lastmodifiedby;

    @Column(name="M_SortOrder")
    private Integer mSortOrder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRdiFieldDesc() {
        return rdiFieldDesc;
    }

    public void setRdiFieldDesc(String rdiFieldDesc) {
        this.rdiFieldDesc = rdiFieldDesc;
    }

    public String getRdiFLDNAM() {
        return rdiFLDNAM;
    }

    public void setRdiFLDNAM(String rdiFLDNAM) {
        this.rdiFLDNAM = rdiFLDNAM;
    }

    public Boolean getBluItems() {
        return isBluItems;
    }

    public void setBluItems(Boolean bluItems) {
        isBluItems = bluItems;
    }

    public Boolean getPLFIELDS() {
        return isPLFIELDS;
    }

    public void setPLFIELDS(Boolean PLFIELDS) {
        isPLFIELDS = PLFIELDS;
    }

    public Boolean getIMPORTFILEFIELDS() {
        return isIMPORTFILEFIELDS;
    }

    public void setIMPORTFILEFIELDS(Boolean IMPORTFILEFIELDS) {
        isIMPORTFILEFIELDS = IMPORTFILEFIELDS;
    }

    public Boolean getPulldownlist() {
        return isPulldownlist;
    }

    public void setPulldownlist(Boolean pulldownlist) {
        isPulldownlist = pulldownlist;
    }

    public Boolean getPULLTYPE() {
        return isPULLTYPE;
    }

    public void setPULLTYPE(Boolean PULLTYPE) {
        isPULLTYPE = PULLTYPE;
    }

    public Boolean getAPR() {
        return isAPR;
    }

    public void setAPR(Boolean APR) {
        isAPR = APR;
    }

    public Boolean getISDELETED() {
        return ISDELETED;
    }

    public void setISDELETED(Boolean ISDELETED) {
        this.ISDELETED = ISDELETED;
    }

    public Date getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(Date lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public Integer getmSortOrder() {
        return mSortOrder;
    }

    public void setmSortOrder(Integer mSortOrder) {
        this.mSortOrder = mSortOrder;
    }
}