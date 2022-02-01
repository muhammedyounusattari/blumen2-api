package com.kastech.blumen.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "address" ,schema = "blumen2")
public class Address {


	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="address_seq_gen")
    @SequenceGenerator(name="address_seq_gen", sequenceName="ADDRESS_SEQ")
	private Long id;
    private String staffName;
    private String staffAddress;
    private String staffCity;
    private String staffState;
    private String staffZipcodes;
    private String staffPhone1;
    private String staffPhone2;
    private String staffPhone3;
    private String staffPhoneType1;
    private String staffPhoneType2;
    private String staffPhoneType3;
    private String staffEmail;
    private String staffWebsite;
    private String staffFax;
    private String staffAdditionalNotes;
    private Boolean isPermanentAddress;
    private String staffMaillingName;
    private Boolean isUsedForMailling;


    public Address() {
    }

    public Address(String staffName, String staffAddress, String staffCity, String staffState, String staffZipcodes, String staffPhone1, String staffPhone2, String staffPhone3, String staffPhoneType1, String staffPhoneType2, String staffPhoneType3, String staffEmail, String staffWebsite, String staffFax, String staffAdditionalNotes, Boolean isPermanentAddress,  String staffMaillingName,
    Boolean isUsedForMailling) {
        this.staffName = staffName;
        this.staffAddress = staffAddress;
        this.staffCity = staffCity;
        this.staffState = staffState;
        this.staffZipcodes = staffZipcodes;
        this.staffPhone1 = staffPhone1;
        this.staffPhone2 = staffPhone2;
        this.staffPhone3 = staffPhone3;
        this.staffPhoneType1 = staffPhoneType1;
        this.staffPhoneType2 = staffPhoneType2;
        this.staffPhoneType3 = staffPhoneType3;
        this.staffEmail = staffEmail;
        this.staffWebsite = staffWebsite;
        this.staffFax = staffFax;
        this.staffAdditionalNotes = staffAdditionalNotes;
        this.isPermanentAddress = isPermanentAddress;
        this.staffMaillingName = staffMaillingName;
        this.isUsedForMailling = isUsedForMailling;
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getStaffCity() {
        return staffCity;
    }

    public void setStaffCity(String staffCity) {
        this.staffCity = staffCity;
    }

    public String getStaffState() {
        return staffState;
    }

    public void setStaffState(String staffState) {
        this.staffState = staffState;
    }

    public String getStaffZipcodes() {
        return staffZipcodes;
    }

    public void setStaffZipcodes(String staffZipcodes) {
        this.staffZipcodes = staffZipcodes;
    }

    public String getStaffPhone1() {
        return staffPhone1;
    }

    public void setStaffPhone1(String staffPhone1) {
        this.staffPhone1 = staffPhone1;
    }

    public String getStaffPhone2() {
        return staffPhone2;
    }

    public void setStaffPhone2(String staffPhone2) {
        this.staffPhone2 = staffPhone2;
    }

    public String getStaffPhone3() {
        return staffPhone3;
    }

    public void setStaffPhone3(String staffPhone3) {
        this.staffPhone3 = staffPhone3;
    }

    public String getStaffPhoneType1() {
        return staffPhoneType1;
    }

    public void setStaffPhoneType1(String staffPhoneType1) {
        this.staffPhoneType1 = staffPhoneType1;
    }

    public String getStaffPhoneType2() {
        return staffPhoneType2;
    }

    public void setStaffPhoneType2(String staffPhoneType2) {
        this.staffPhoneType2 = staffPhoneType2;
    }

    public String getStaffPhoneType3() {
        return staffPhoneType3;
    }

    public void setStaffPhoneType3(String staffPhoneType3) {
        this.staffPhoneType3 = staffPhoneType3;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffWebsite() {
        return staffWebsite;
    }

    public void setStaffWebsite(String staffWebsite) {
        this.staffWebsite = staffWebsite;
    }

    public String getStaffFax() {
        return staffFax;
    }

    public void setStaffFax(String staffFax) {
        this.staffFax = staffFax;
    }

    public String getStaffAdditionalNotes() {
        return staffAdditionalNotes;
    }

    public void setStaffAdditionalNotes(String staffAdditionalNotes) {
        this.staffAdditionalNotes = staffAdditionalNotes;
    }

    public Boolean getPermanentAddress() {
        return isPermanentAddress;
    }

    public void setPermanentAddress(Boolean permanentAddress) {
        isPermanentAddress = permanentAddress;
    }

    public String getStaffMaillingName() {
        return staffMaillingName;
    }

    public void setStaffMaillingName(String staffMaillingName) {
        this.staffMaillingName = staffMaillingName;
    }

    public Boolean getUsedForMailling() {
        return isUsedForMailling;
    }

    public void setUsedForMailling(Boolean usedForMailling) {
        isUsedForMailling = usedForMailling;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", staffAddress='" + staffAddress + '\'' +
                ", staffCity='" + staffCity + '\'' +
                ", staffState='" + staffState + '\'' +
                ", staffZipcodes='" + staffZipcodes + '\'' +
                ", staffPhone1='" + staffPhone1 + '\'' +
                ", staffPhone2='" + staffPhone2 + '\'' +
                ", staffPhone3='" + staffPhone3 + '\'' +
                ", staffPhoneType1='" + staffPhoneType1 + '\'' +
                ", staffPhoneType2='" + staffPhoneType2 + '\'' +
                ", staffPhoneType3='" + staffPhoneType3 + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", staffWebsite='" + staffWebsite + '\'' +
                ", staffFax='" + staffFax + '\'' +
                ", staffAdditionalNotes='" + staffAdditionalNotes + '\'' +
                ", isPermanentAddress=" + isPermanentAddress +
                ", staffMaillingName='" + staffMaillingName + '\'' +
                ", isUsedForMailling=" + isUsedForMailling +
                '}';
    }
}
