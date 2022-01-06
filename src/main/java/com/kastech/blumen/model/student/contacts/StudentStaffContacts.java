package com.kastech.blumen.model.student.contacts;

import com.kastech.blumen.model.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student_staff_contacts", schema = "blumen2")
public class StudentStaffContacts {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="stu_staff_contact_list_seq_gen")
    @SequenceGenerator(name="stu_staff_contact_list_seq_gen", sequenceName="STUDENT_STAFF_CONTACT_LIST_SEQ")
    private Long ssno;

    @OneToOne(cascade = {CascadeType.ALL})
    private Student student;

    @OneToMany(cascade = {CascadeType.ALL})
    List<ActivityRendered> activityRenderedList;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String contactDate;
    private String staff;
    private String contactTime;
    private String recontactDate;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String school;
    private String standing;
    private String fiscalYear;

    private boolean staffCounselor;
    private boolean staffTeacher;
    private boolean staffLab;

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


    public StudentStaffContacts() {
    }

    public StudentStaffContacts(Long ssno, Student student, List<ActivityRendered> activityRenderedList, String firstName, String lastName, String phoneNumber, String contactDate, String staff, String contactTime, String recontactDate, boolean active, boolean served, boolean reported, String school, String standing, String fiscalYear, boolean staffCounselor, boolean staffTeacher, boolean staffLab, String staffFirstName, String staffLastName, String staffPhoneNumber, String staffContactTime, boolean staffBolt, String staffContactDate, String staffFiscalYear, String staffRecontactDate, boolean staffRecontacted, String staffContactCounselor, String staffComponents, String staffAprSubject, String staffContactType, String staffSubject, String stafInstruction, String stafActivityService, String stafTotalTime, String stafActivityServiceRendered, String stafActivityTime, String staffNotes, String staffContactStaff, String staffContactTeacher, String staffContactTutor, String staffContactLab) {
        this.ssno = ssno;
        this.student = student;
        this.activityRenderedList = activityRenderedList;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.contactDate = contactDate;
        this.staff = staff;
        this.contactTime = contactTime;
        this.recontactDate = recontactDate;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.school = school;
        this.standing = standing;
        this.fiscalYear = fiscalYear;
        this.staffCounselor = staffCounselor;
        this.staffTeacher = staffTeacher;
        this.staffLab = staffLab;
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
    }

    public Long getSsno() {
        return ssno;
    }

    public void setSsno(Long ssno) {
        this.ssno = ssno;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getStaff() {
        return staff;
    }

    public void setStaff(String staff) {
        this.staff = staff;
    }

    public String getContactTime() {
        return contactTime;
    }

    public void setContactTime(String contactTime) {
        this.contactTime = contactTime;
    }

    public String getRecontactDate() {
        return recontactDate;
    }

    public void setRecontactDate(String recontactDate) {
        this.recontactDate = recontactDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isServed() {
        return served;
    }

    public void setServed(boolean served) {
        this.served = served;
    }

    public boolean isReported() {
        return reported;
    }

    public void setReported(boolean reported) {
        this.reported = reported;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStanding() {
        return standing;
    }

    public void setStanding(String standing) {
        this.standing = standing;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<ActivityRendered> getActivityRenderedList() {
        return activityRenderedList;
    }

    public void setActivityRenderedList(List<ActivityRendered> activityRenderedList) {
        this.activityRenderedList = activityRenderedList;
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

    @Override
    public String toString() {
        return "StudentStaffContacts{" +
                "ssno=" + ssno +
                ", student=" + student +
                ", activityRenderedList=" + activityRenderedList +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", contactDate='" + contactDate + '\'' +
                ", staff='" + staff + '\'' +
                ", contactTime='" + contactTime + '\'' +
                ", recontactDate='" + recontactDate + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", staffCounselor=" + staffCounselor +
                ", staffTeacher=" + staffTeacher +
                ", staffLab=" + staffLab +
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
                '}';
    }

    /* public StudentStaffContacts updateWith(StudentStaffContacts item) {
        return new StudentStaffContacts(
                this.ssno,
                item.firstName,
                item.lastName,
                item.phoneNumber,
                item.contactDate,
                item.staff,
                item.contactTime,
                item.recontactDate,
                item.active,
                item.served,
                item.reported,
                item.school,
                item.standing,
                item.fiscalYear
        );
    }*/
}
