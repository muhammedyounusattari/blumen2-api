package com.kastech.blumen.model.staff;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kastech.blumen.model.Address;

@Entity
@Table(name = "staff" ,schema = "blumen2")
public class Staff {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="staff_seq_gen")
    @SequenceGenerator(name="staff_seq_gen", sequenceName="STAFF_SEQ")
    private Long id;
    private String staffName;
    private String staffId;
    private String staffTitle;
    private boolean staffActive;
    private boolean staffTutor;

    private String staffSSNO;

    private boolean staffCounselor;
    private boolean staffTeacher;
    private boolean staffLab;

    private String staffCodes;
    private String staffDOB;
    private String staffSpouseName;
    private String staffHireDate;
    private String staffDriverLicense;
    private String staffTerminationDate;

    private String staffCustomFieldOne;
    private String staffCustomFieldTwo;
    private String staffCustomFieldThree;
    private String staffCustomFieldFour;

    private String staffNotes;
    private String staffPicture;

    private String staffFirstName;
    private String staffLastName;
    private String staffPhoneNumber;
    private String staffContactDate;
    private String staffContactTime;
    private String staffRecontactDate;
    private boolean staffBolt;



    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;

    public Staff() {
    }

    public Staff(Long id, String staffName, String staffId, String staffTitle, boolean staffActive, boolean staffTutor, String staffSSNO, boolean staffCounselor, boolean staffTeacher, boolean staffLab, String staffCodes, String staffDOB, String staffSpouseName, String staffHireDate, String staffDriverLicense, String staffTerminationDate, String staffCustomFieldOne, String staffCustomFieldTwo, String staffCustomFieldThree, String staffCustomFieldFour, String staffNotes, String staffPicture, String staffFirstName, String staffLastName, String staffPhoneNumber, String staffContactDate, String staffContactTime, String staffRecontactDate, boolean staffBolt, Address address) {
        this.id = id;
        this.staffName = staffName;
        this.staffId = staffId;
        this.staffTitle = staffTitle;
        this.staffActive = staffActive;
        this.staffTutor = staffTutor;
        this.staffSSNO = staffSSNO;
        this.staffCounselor = staffCounselor;
        this.staffTeacher = staffTeacher;
        this.staffLab = staffLab;
        this.staffCodes = staffCodes;
        this.staffDOB = staffDOB;
        this.staffSpouseName = staffSpouseName;
        this.staffHireDate = staffHireDate;
        this.staffDriverLicense = staffDriverLicense;
        this.staffTerminationDate = staffTerminationDate;
        this.staffCustomFieldOne = staffCustomFieldOne;
        this.staffCustomFieldTwo = staffCustomFieldTwo;
        this.staffCustomFieldThree = staffCustomFieldThree;
        this.staffCustomFieldFour = staffCustomFieldFour;
        this.staffNotes = staffNotes;
        this.staffPicture = staffPicture;
        this.staffFirstName = staffFirstName;
        this.staffLastName = staffLastName;
        this.staffPhoneNumber = staffPhoneNumber;
        this.staffContactDate = staffContactDate;
        this.staffContactTime = staffContactTime;
        this.staffRecontactDate = staffRecontactDate;
        this.staffBolt = staffBolt;
        this.address = address;
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public boolean isStaffActive() {
        return staffActive;
    }

    public void setStaffActive(boolean staffActive) {
        this.staffActive = staffActive;
    }

    public boolean isStaffTutor() {
        return staffTutor;
    }

    public void setStaffTutor(boolean staffTutor) {
        this.staffTutor = staffTutor;
    }

    public String getStaffSSNO() {
        return staffSSNO;
    }

    public void setStaffSSNO(String staffSSNO) {
        this.staffSSNO = staffSSNO;
    }

    public boolean isStaffCounselor() {
        return staffCounselor;
    }

    public void setStaffCounselor(boolean staffCounselor) {
        this.staffCounselor = staffCounselor;
    }

    public boolean isStaffTeacher() {
        return staffTeacher;
    }

    public void setStaffTeacher(boolean staffTeacher) {
        this.staffTeacher = staffTeacher;
    }

    public boolean isStaffLab() {
        return staffLab;
    }

    public void setStaffLab(boolean staffLab) {
        this.staffLab = staffLab;
    }

    public String getStaffCodes() {
        return staffCodes;
    }

    public void setStaffCodes(String staffCodes) {
        this.staffCodes = staffCodes;
    }

    public String getStaffDOB() {
        return staffDOB;
    }

    public void setStaffDOB(String staffDOB) {
        this.staffDOB = staffDOB;
    }

    public String getStaffSpouseName() {
        return staffSpouseName;
    }

    public void setStaffSpouseName(String staffSpouseName) {
        this.staffSpouseName = staffSpouseName;
    }

    public String getStaffHireDate() {
        return staffHireDate;
    }

    public void setStaffHireDate(String staffHireDate) {
        this.staffHireDate = staffHireDate;
    }

    public String getStaffDriverLicense() {
        return staffDriverLicense;
    }

    public void setStaffDriverLicense(String staffDriverLicense) {
        this.staffDriverLicense = staffDriverLicense;
    }

    public String getStaffTerminationDate() {
        return staffTerminationDate;
    }

    public void setStaffTerminationDate(String staffTerminationDate) {
        this.staffTerminationDate = staffTerminationDate;
    }

    public String getStaffCustomFieldOne() {
        return staffCustomFieldOne;
    }

    public void setStaffCustomFieldOne(String staffCustomFieldOne) {
        this.staffCustomFieldOne = staffCustomFieldOne;
    }

    public String getStaffCustomFieldTwo() {
        return staffCustomFieldTwo;
    }

    public void setStaffCustomFieldTwo(String staffCustomFieldTwo) {
        this.staffCustomFieldTwo = staffCustomFieldTwo;
    }

    public String getStaffCustomFieldThree() {
        return staffCustomFieldThree;
    }

    public void setStaffCustomFieldThree(String staffCustomFieldThree) {
        this.staffCustomFieldThree = staffCustomFieldThree;
    }

    public String getStaffCustomFieldFour() {
        return staffCustomFieldFour;
    }

    public void setStaffCustomFieldFour(String staffCustomFieldFour) {
        this.staffCustomFieldFour = staffCustomFieldFour;
    }

    public String getStaffNotes() {
        return staffNotes;
    }

    public void setStaffNotes(String staffNotes) {
        this.staffNotes = staffNotes;
    }

    public String getStaffPicture() {
        return staffPicture;
    }

    public void setStaffPicture(String staffPicture) {
        this.staffPicture = staffPicture;
    }

    public String getStaffFirstName() {
        return staffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName = staffFirstName;
    }

    public String getStaffLastName() {
        return staffLastName;
    }

    public void setStaffLastName(String staffLastName) {
        this.staffLastName = staffLastName;
    }

    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }

    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }

    public String getStaffContactDate() {
        return staffContactDate;
    }

    public void setStaffContactDate(String staffContactDate) {
        this.staffContactDate = staffContactDate;
    }

    public String getStaffContactTime() {
        return staffContactTime;
    }

    public void setStaffContactTime(String staffContactTime) {
        this.staffContactTime = staffContactTime;
    }

    public String getStaffRecontactDate() {
        return staffRecontactDate;
    }

    public void setStaffRecontactDate(String staffRecontactDate) {
        this.staffRecontactDate = staffRecontactDate;
    }

    public boolean isStaffBolt() {
        return staffBolt;
    }

    public void setStaffBolt(boolean staffBolt) {
        this.staffBolt = staffBolt;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
                ", staffId='" + staffId + '\'' +
                ", staffTitle='" + staffTitle + '\'' +
                ", staffActive=" + staffActive +
                ", staffTutor=" + staffTutor +
                ", staffSSNO='" + staffSSNO + '\'' +
                ", staffCounselor=" + staffCounselor +
                ", staffTeacher=" + staffTeacher +
                ", staffLab=" + staffLab +
                ", staffCodes='" + staffCodes + '\'' +
                ", staffDOB='" + staffDOB + '\'' +
                ", staffSpouseName='" + staffSpouseName + '\'' +
                ", staffHireDate='" + staffHireDate + '\'' +
                ", staffDriverLicense='" + staffDriverLicense + '\'' +
                ", staffTerminationDate='" + staffTerminationDate + '\'' +
                ", staffCustomFieldOne='" + staffCustomFieldOne + '\'' +
                ", staffCustomFieldTwo='" + staffCustomFieldTwo + '\'' +
                ", staffCustomFieldThree='" + staffCustomFieldThree + '\'' +
                ", staffCustomFieldFour='" + staffCustomFieldFour + '\'' +
                ", staffNotes='" + staffNotes + '\'' +
                ", staffPicture='" + staffPicture + '\'' +
                ", staffFirstName='" + staffFirstName + '\'' +
                ", staffLastName='" + staffLastName + '\'' +
                ", staffPhoneNumber='" + staffPhoneNumber + '\'' +
                ", staffContactDate='" + staffContactDate + '\'' +
                ", staffContactTime='" + staffContactTime + '\'' +
                ", staffRecontactDate='" + staffRecontactDate + '\'' +
                ", staffBolt=" + staffBolt +
                ", address=" + address +
                '}';
    }
}
