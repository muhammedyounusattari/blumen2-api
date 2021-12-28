package com.kastech.blumen.model.customize;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "college_school", schema = "blumen2")
public class CollegeSchool {

    @Id
    private String orgName;
    private String orgType;
    private String name;
    private String codes;
    private String title;
    private String country;
    private String ncesId;

    private String address;
    private String city;
    private String states;
    private String zipcode;
    private String phone1;
    private String phone2;
    private String phone3;
    private String website;
    private String fax;
    private String email;
    private String notes;

    private String fafsaId;
    private String fiscalYear;

    public CollegeSchool() {
    }

    public CollegeSchool(String orgName, String orgType, String name, String codes, String title, String country, String ncesId, String address, String city, String states, String zipcode, String phone1, String phone2, String phone3, String website, String fax, String email, String notes, String fafsaId, String fiscalYear) {
        this.orgName = orgName;
        this.orgType = orgType;
        this.name = name;
        this.codes = codes;
        this.title = title;
        this.country = country;
        this.ncesId = ncesId;
        this.address = address;
        this.city = city;
        this.states = states;
        this.zipcode = zipcode;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.website = website;
        this.fax = fax;
        this.email = email;
        this.notes = notes;
        this.fafsaId = fafsaId;
        this.fiscalYear = fiscalYear;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNcesId() {
        return ncesId;
    }

    public void setNcesId(String ncesId) {
        this.ncesId = ncesId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFafsaId() {
        return fafsaId;
    }

    public void setFafsaId(String fafsaId) {
        this.fafsaId = fafsaId;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public CollegeSchool updateWith(CollegeSchool item) {
        return new CollegeSchool(
                this.orgName,
                item.orgType,
                item.name,
                item.codes,
                item.title,
                item.country,
                item.ncesId,
                item.address,
                item.city,
                item.states,
                item.zipcode,
                item.phone1,
                item.phone2,
                item.phone3,
                item.website,
                item.fax,
                item.email,
                item.notes,
                item.fafsaId,
                item.fiscalYear
        );
    }
}
