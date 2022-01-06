package com.kastech.blumen.model.student.contacts;

import com.kastech.blumen.model.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student_lab_contact", schema = "blumen2")
public class StudentLabContact {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_lab_contact_list_seq_gen")
	@SequenceGenerator(name="student_lab_contact_list_seq_gen", sequenceName="STUDENT_LAB_CONTACT_LIST_SEQ")
	private Integer id;

	@OneToOne(cascade = {CascadeType.ALL})
	private Student student;

	@OneToMany(cascade = {CascadeType.ALL})
	List<ActivityRendered> activityRenderedList;

	private String firstName;
	private String lastName;
	private String labDate;
	private String checkIn;
	private String checkOut;
	private String reasonForVisit;

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
	private boolean staff;

	public StudentLabContact() {
	}

	public StudentLabContact(Integer id, Student student, List<ActivityRendered> activityRenderedList, String firstName, String lastName, String labDate, String checkIn, String checkOut, String reasonForVisit, boolean staffCounselor, boolean staffTeacher, boolean staffLab, String staffFirstName, String staffLastName, String staffPhoneNumber, String staffContactTime, boolean staffBolt, String staffContactDate, String staffFiscalYear, String staffRecontactDate, boolean staffRecontacted, String staffContactCounselor, String staffComponents, String staffAprSubject, String staffContactType, String staffSubject, String stafInstruction, String stafActivityService, String stafTotalTime, String stafActivityServiceRendered, String stafActivityTime, String staffNotes, String staffContactStaff, String staffContactTeacher, String staffContactTutor, String staffContactLab, boolean staff) {
		this.id = id;
		this.student = student;
		this.activityRenderedList = activityRenderedList;
		this.firstName = firstName;
		this.lastName = lastName;
		this.labDate = labDate;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.reasonForVisit = reasonForVisit;
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
		this.staff = staff;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getLabDate() {
		return labDate;
	}

	public void setLabDate(String labDate) {
		this.labDate = labDate;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public String getReasonForVisit() {
		return reasonForVisit;
	}

	public void setReasonForVisit(String reasonForVisit) {
		this.reasonForVisit = reasonForVisit;
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

	public boolean isStaff() {
		return staff;
	}

	public void setStaff(boolean staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "StudentLabContact{" +
				"id=" + id +
				", student=" + student +
				", activityRenderedList=" + activityRenderedList +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", labDate='" + labDate + '\'' +
				", checkIn='" + checkIn + '\'' +
				", checkOut='" + checkOut + '\'' +
				", reasonForVisit='" + reasonForVisit + '\'' +
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
				", staff=" + staff +
				'}';
	}
}
