package com.kastech.blumen.model.customize;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "college_school", schema = "blumen2")
public class CollegeSchool {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="college_school_seq_gen")
    @SequenceGenerator(name="college_school_seq_gen", sequenceName="COLLEGE_SCHOOL_SEQ")
    private long collegeSchoolId;

    private String orgName;
    private String orgType;
    private String name;
    private String codes;
    private String title;
    private String country;
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
    private String fiscalYear;
    private boolean inPullDown;
    private Date createdDate;
    private long createdBy;
    private Date modifiedDate;
    private long modifiedBy;
    private Date deletedDate;
    private long deletedBy;
    private long orgId;
    private boolean isSchool;
    private  String ncsIdFafsaId;

    public CollegeSchool() {
    }

    public CollegeSchool(long collegeSchoolId , String orgName, String orgType, String name, String codes, String title, String country, String address, String city, String states, String zipcode, String phone1, String phone2, String phone3, String website, String fax, String email, String notes, String fiscalYear, boolean inPullDown,
                         Date createdDate,long createdBy,Date modifiedDate,long modifiedBy,Date deletedDate,long deletedBy,long orgId, boolean isSchool, String ncsIdFafsaId) {
        this.collegeSchoolId = collegeSchoolId;
        this.orgName = orgName;
        this.orgType = orgType;
        this.name = name;
        this.codes = codes;
        this.title = title;
        this.country = country;
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
        this.fiscalYear = fiscalYear;
        this.inPullDown=inPullDown;
        this.createdDate=createdDate;
        this.createdBy=createdBy;
        this.modifiedDate=modifiedDate;
        this.deletedDate=deletedDate;
        this.modifiedBy=modifiedBy;
        this.deletedBy=deletedBy;
        this.orgId=orgId;
        this.isSchool = isSchool;
        this.ncsIdFafsaId = ncsIdFafsaId;
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

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }
    
    public boolean isInPullDown() {
		return inPullDown;
	}

	public void setInPullDown(boolean inPullDown) {
		this.inPullDown = inPullDown;
	}

    public Date getCreatedDate() {return createdDate;}

    public void setCreatedDate(Date createdDate) {this.createdDate = createdDate;}

    public long getCreatedBy() {return createdBy;}

    public void setCreatedBy(long createdBy) {this.createdBy = createdBy;}

    public Date getModifiedDate() {return modifiedDate;}

    public void setModifiedDate(Date modifiedDate) {this.modifiedDate = modifiedDate;}

    public long getModifiedBy() {return modifiedBy;}

    public void setModifiedBy(long modifiedBy) {this.modifiedBy = modifiedBy;}

    public Date getDeletedDate() {return deletedDate;}

    public void setDeletedDate(Date deletedDate) {this.deletedDate = deletedDate;}

    public long getDeletedBy() {return deletedBy;}

    public void setDeletedBy(long deletedBy) {this.deletedBy = deletedBy;}

    public long getOrgId() {return orgId;}

    public void setOrgId(long orgId) {this.orgId = orgId;}

    public long getCollegeSchoolId() {return collegeSchoolId;}

    public void setCollegeSchoolId(long collegeSchoolId) {this.collegeSchoolId = collegeSchoolId;}

    public boolean isSchool() {return isSchool;}

    public void setSchool(boolean school) {isSchool = school;}
    public String getNcsIdFafsaId() {return ncsIdFafsaId;}
    public void setNcsIdFafsaId(String ncsIdFafsaId) {this.ncsIdFafsaId = ncsIdFafsaId;}

    public CollegeSchool updateWith(CollegeSchool item) {
        return new CollegeSchool(
                item.collegeSchoolId,
                item.orgName,
                item.orgType,
                item.name,
                item.codes,
                item.title,
                item.country,
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
                item.fiscalYear,
                item.inPullDown,
                item.createdDate,
                item.createdBy,
                item.modifiedDate,
                item.modifiedBy,
                item.deletedDate,
                item.deletedBy,
                item.orgId,
                item.isSchool,
                item.ncsIdFafsaId
        );
    }
}
