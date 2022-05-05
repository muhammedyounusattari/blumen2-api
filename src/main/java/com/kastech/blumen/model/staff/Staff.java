package com.kastech.blumen.model.staff;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.kastech.blumen.model.Address;
import com.kastech.blumen.model.student.Student;

@Entity
@Table(name = "staff" ,schema = "blumen2")
public class Staff {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

  /*  @OneToOne(cascade = {CascadeType.ALL})
	private Student student;*/

    private String staffName;
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


    private String staffPicture;

    private String staffFirstName;
    private String staffLastName;
    private String staffPhoneNumber;

    private String staffContactTime;

    private boolean staffBolt;

    private String staffContactDate;
    private String staffFiscalYear;
    private String staffRecontactDate;
    private boolean staffRecontacted;
    private String staffContactCounselor;
    private String staffComponents;
    private String staffAprSubject;
    private String staffContactType;
    private String staffSubject;
    private String stafInstruction;
    private String stafActivityService;
    private String stafTotalTime;
    private String stafActivityServiceRendered;
    private String stafActivityTime;
    private String staffNotes;

    private String staffContactStaff;
    private String staffContactTeacher;
    private String staffContactTutor;
    private String staffContactLab;
    private boolean staff;

    private Date createdDate;
    private long createdBy;
    private Date modifiedDate;
    private long modifiedBy;
    private Date deletedDate;
    private long deletedBy;
    private long orgId;
    private long staffId;

    @Transient
    private long tempId;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Address> address;

    public Staff() {
    }

    public Staff(Long id, String staffName, String staffTitle, boolean staffActive, boolean staffTutor, String staffSSNO, boolean staffCounselor, boolean staffTeacher, boolean staffLab, String staffCodes, String staffDOB, String staffSpouseName, String staffHireDate, String staffDriverLicense, String staffTerminationDate, String staffCustomFieldOne, String staffCustomFieldTwo, String staffCustomFieldThree, String staffCustomFieldFour, String staffPicture, String staffFirstName, String staffLastName, String staffPhoneNumber, String staffContactTime, boolean staffBolt, String staffContactDate, String staffFiscalYear, String staffRecontactDate, boolean staffRecontacted, String staffContactCounselor, String staffComponents, String staffAprSubject, String staffContactType, String staffSubject, String stafInstruction, String stafActivityService, String stafTotalTime, String stafActivityServiceRendered, String stafActivityTime, String staffNotes, String staffContactStaff, String staffContactTeacher, String staffContactTutor, String staffContactLab, boolean staff, Date createdDate, long createdBy, Date modifiedDate, long modifiedBy, Date deletedDate, long deletedBy, long orgId, long staffId, long tempId,  List<Address> address) {
        this.id = id;
        this.staffName = staffName;
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
        this.staffPicture = staffPicture;
        this.staffFirstName = staffFirstName;
        this.staffLastName = staffLastName;
        this.staffPhoneNumber = staffPhoneNumber;
        this.staffContactTime = staffContactTime;
        this.staffBolt = staffBolt;
        this.staffContactDate = staffContactDate;
        this.staffFiscalYear = staffFiscalYear;
        this.staffRecontactDate = staffRecontactDate;
        this.staffRecontacted = staffRecontacted;
        this.staffContactCounselor = staffContactCounselor;
        this.staffComponents = staffComponents;
        this.staffAprSubject = staffAprSubject;
        this.staffContactType = staffContactType;
        this.staffSubject = staffSubject;
        this.stafInstruction = stafInstruction;
        this.stafActivityService = stafActivityService;
        this.stafTotalTime = stafTotalTime;
        this.stafActivityServiceRendered = stafActivityServiceRendered;
        this.stafActivityTime = stafActivityTime;
        this.staffNotes = staffNotes;
        this.staffContactStaff = staffContactStaff;
        this.staffContactTeacher = staffContactTeacher;
        this.staffContactTutor = staffContactTutor;
        this.staffContactLab = staffContactLab;
        this.staff = staff;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
        this.deletedDate = deletedDate;
        this.deletedBy = deletedBy;
        this.orgId = orgId;
        this.staffId = staffId;
        this.tempId = tempId;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
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

    public String getStaffContactTime() {
        return staffContactTime;
    }

    public void setStaffContactTime(String staffContactTime) {
        this.staffContactTime = staffContactTime;
    }

    public boolean isStaffBolt() {
        return staffBolt;
    }

    public void setStaffBolt(boolean staffBolt) {
        this.staffBolt = staffBolt;
    }

    public String getStaffContactDate() {
        return staffContactDate;
    }

    public void setStaffContactDate(String staffContactDate) {
        this.staffContactDate = staffContactDate;
    }

    public String getStaffFiscalYear() {
        return staffFiscalYear;
    }

    public void setStaffFiscalYear(String staffFiscalYear) {
        this.staffFiscalYear = staffFiscalYear;
    }

    public String getStaffRecontactDate() {
        return staffRecontactDate;
    }

    public void setStaffRecontactDate(String staffRecontactDate) {
        this.staffRecontactDate = staffRecontactDate;
    }

    public boolean isStaffRecontacted() {
        return staffRecontacted;
    }

    public void setStaffRecontacted(boolean staffRecontacted) {
        this.staffRecontacted = staffRecontacted;
    }

    public String getStaffContactCounselor() {
        return staffContactCounselor;
    }

    public void setStaffContactCounselor(String staffContactCounselor) {
        this.staffContactCounselor = staffContactCounselor;
    }

    public String getStaffComponents() {
        return staffComponents;
    }

    public void setStaffComponents(String staffComponents) {
        this.staffComponents = staffComponents;
    }

    public String getStaffAprSubject() {
        return staffAprSubject;
    }

    public void setStaffAprSubject(String staffAprSubject) {
        this.staffAprSubject = staffAprSubject;
    }

    public String getStaffContactType() {
        return staffContactType;
    }

    public void setStaffContactType(String staffContactType) {
        this.staffContactType = staffContactType;
    }

    public String getStaffSubject() {
        return staffSubject;
    }

    public void setStaffSubject(String staffSubject) {
        this.staffSubject = staffSubject;
    }

    public String getStafInstruction() {
        return stafInstruction;
    }

    public void setStafInstruction(String stafInstruction) {
        this.stafInstruction = stafInstruction;
    }

    public String getStafActivityService() {
        return stafActivityService;
    }

    public void setStafActivityService(String stafActivityService) {
        this.stafActivityService = stafActivityService;
    }

    public String getStafTotalTime() {
        return stafTotalTime;
    }

    public void setStafTotalTime(String stafTotalTime) {
        this.stafTotalTime = stafTotalTime;
    }

    public String getStafActivityServiceRendered() {
        return stafActivityServiceRendered;
    }

    public void setStafActivityServiceRendered(String stafActivityServiceRendered) {
        this.stafActivityServiceRendered = stafActivityServiceRendered;
    }

    public String getStafActivityTime() {
        return stafActivityTime;
    }

    public void setStafActivityTime(String stafActivityTime) {
        this.stafActivityTime = stafActivityTime;
    }

    public String getStaffNotes() {
        return staffNotes;
    }

    public void setStaffNotes(String staffNotes) {
        this.staffNotes = staffNotes;
    }

    public String getStaffContactStaff() {
        return staffContactStaff;
    }

    public void setStaffContactStaff(String staffContactStaff) {
        this.staffContactStaff = staffContactStaff;
    }

    public String getStaffContactTeacher() {
        return staffContactTeacher;
    }

    public void setStaffContactTeacher(String staffContactTeacher) {
        this.staffContactTeacher = staffContactTeacher;
    }

    public String getStaffContactTutor() {
        return staffContactTutor;
    }

    public void setStaffContactTutor(String staffContactTutor) {
        this.staffContactTutor = staffContactTutor;
    }

    public String getStaffContactLab() {
        return staffContactLab;
    }

    public void setStaffContactLab(String staffContactLab) {
        this.staffContactLab = staffContactLab;
    }

    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
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

    public long getStaffId() {return staffId;}

    public void setStaffId(long staffId) {this.staffId = staffId;}

    public long getTempId() {return tempId;}

    public void setTempId(long tempId) {this.tempId = tempId;}

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", staffName='" + staffName + '\'' +
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
                ", staffPicture='" + staffPicture + '\'' +
                ", staffFirstName='" + staffFirstName + '\'' +
                ", staffLastName='" + staffLastName + '\'' +
                ", staffPhoneNumber='" + staffPhoneNumber + '\'' +
                ", staffContactTime='" + staffContactTime + '\'' +
                ", staffBolt=" + staffBolt +
                ", staffContactDate='" + staffContactDate + '\'' +
                ", staffFiscalYear='" + staffFiscalYear + '\'' +
                ", staffRecontactDate='" + staffRecontactDate + '\'' +
                ", staffRecontacted=" + staffRecontacted +
                ", staffContactCounselor='" + staffContactCounselor + '\'' +
                ", staffComponents='" + staffComponents + '\'' +
                ", staffAprSubject='" + staffAprSubject + '\'' +
                ", staffContactType='" + staffContactType + '\'' +
                ", staffSubject='" + staffSubject + '\'' +
                ", stafInstruction='" + stafInstruction + '\'' +
                ", stafActivityService='" + stafActivityService + '\'' +
                ", stafTotalTime='" + stafTotalTime + '\'' +
                ", stafActivityServiceRendered='" + stafActivityServiceRendered + '\'' +
                ", stafActivityTime='" + stafActivityTime + '\'' +
                ", staffNotes='" + staffNotes + '\'' +
                ", staffContactStaff='" + staffContactStaff + '\'' +
                ", staffContactTeacher='" + staffContactTeacher + '\'' +
                ", staffContactTutor='" + staffContactTutor + '\'' +
                ", staffContactLab='" + staffContactLab + '\'' +
                ", staff=" + staff +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy=" + modifiedBy +
                ", deletedDate=" + deletedDate +
                ", deletedBy=" + deletedBy +
                ", orgId=" + orgId +
                ", staffId=" + staffId +
                ", tempId=" + tempId +
                ", address=" + address +
                '}';
    }
}
