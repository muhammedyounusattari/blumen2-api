package com.kastech.blumen.model.admin;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kastech.blumen.model.student.Student;

@Entity
@Table(name = "teacher_classes" ,schema = "blumen2")
public class TeacherClasses {

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="teacher_classes_seq_gen")
    @SequenceGenerator(name="teacher_classes_seq_gen", sequenceName="TEACHER_CLASSES_SEQ")
	private Long id;
	private String currentYear;
	private String semester;
	private String teacherName;
	private String subject;
	private String classPeriod;
	private String meetingTime;
	private String days;
	private String room;
	private String studentAssigned;
	private String duration;
	private String maxLimit;
	private String notes;
	
	//@JsonManagedReference
	//@JsonBackReference
	@ManyToMany
	@JoinTable(
			name =  "teacher_class_students",schema = "blumen2",
			joinColumns = @JoinColumn(name = "teacherclass_id"),
			inverseJoinColumns = @JoinColumn(name="stuid"))
	List<Student> studentList = new ArrayList<Student>();

	public TeacherClasses(){
		super();
	}
	public TeacherClasses(Long id, String currentYear, String semester, String teacherName, String subject,
			String classPeriod, String meetingTime, String days, String room, String studentAssigned, String duration,
			String maxLimit, String notes,List<Student> studentList) {
		super();
		this.id = id;
		this.currentYear = currentYear;
		this.semester = semester;
		this.teacherName = teacherName;
		this.subject = subject;
		this.classPeriod = classPeriod;
		this.meetingTime = meetingTime;
		this.days = days;
		this.room = room;
		this.studentAssigned = studentAssigned;
		this.duration = duration;
		this.maxLimit = maxLimit;
		this.notes = notes;
		this.studentList=studentList;
	}
	
	public void addStudents(List<Student> students) {
		studentList.addAll(students);
	}
	
	public void removeStudents(List<Student> students) {
		studentList.removeAll(students);
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

	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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
	
//	@OneToMany(targetEntity = Student.class, mappedBy = "", 
//		    cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void assignStudent(Student st) {
		this.studentList.add(st);
//    	st.getTeacherClasses().add(this);
	}
	
}
