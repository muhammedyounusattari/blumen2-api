package com.kastech.blumen.model.admin;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff_classes" ,schema = "blumen2")
public class StaffClasses {

	@Id
	private Long id;
	private String currentYear;
	private String semester;
	private String tutorName;
	private String subject;
	private String classPeriod;
	private String meetingTime;
	private String days;
	private String room;
	private String studentAssigned;
	private String duration;
	private String maxLimit;
	private String notes;
	
	//this will be enabled with @OneToMany mapping
	//@OneToMany
	//List<Student> studentList;

	public StaffClasses(){
		super();
	}
	public StaffClasses(Long id, String currentYear, String semester, String tutorName, String subject,
			String classPeriod, String meetingTime, String days, String room, String studentAssigned, String duration,
			String maxLimit, String notes) {
		super();
		this.id = id;
		this.currentYear = currentYear;
		this.semester = semester;
		this.tutorName = tutorName;
		this.subject = subject;
		this.classPeriod = classPeriod;
		this.meetingTime = meetingTime;
		this.days = days;
		this.room = room;
		this.studentAssigned = studentAssigned;
		this.duration = duration;
		this.maxLimit = maxLimit;
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getClassPeriod() {
		return classPeriod;
	}

	public void setClassPeriod(String classPeriod) {
		this.classPeriod = classPeriod;
	}

	public String getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getStudentAssigned() {
		return studentAssigned;
	}

	public void setStudentAssigned(String studentAssigned) {
		this.studentAssigned = studentAssigned;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(String maxLimit) {
		this.maxLimit = maxLimit;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}