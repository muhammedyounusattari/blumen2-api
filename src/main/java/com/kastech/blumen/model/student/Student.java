package com.kastech.blumen.model.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kastech.blumen.controller.student.Activities;
import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "student" ,schema = "blumen2")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_seq_gen")
    @SequenceGenerator(name="student_seq_gen", sequenceName="student_SEQ")
    private Long ssno;
    private String orgId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String fiscalYear;
    private String active;
    private String served;
    private String reported;
    private String staff;
    private String school;
    private String standing;

    private String contactDate;

    private String contactTime;
    private String recontactDate;




    private String grade;
    private String gradeNotes;

    //private EndOfYearStatus endOfYearStatus;
    @OneToOne(cascade = {CascadeType.ALL})
    private GraduatedInformation graduatedInformation;
    //  private Activities activities;
    
    //@JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<TeacherClasses> teacherClasses = new HashSet<TeacherClasses>();
    
    //@JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<CounselorClasses> counselorClasses = new HashSet<CounselorClasses>();
    
    //@JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<StaffClasses> staffClasses = new HashSet<StaffClasses>();
    
    //@JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "studentList")
    private Set<TutorClasses> tutorClasses = new HashSet<TutorClasses>();

    private boolean isDeletedStudent;

    public Student() {
    }

    public Student(Long ssno, String orgId, String firstName, String lastName, String phoneNumber, String fiscalYear, String active, String served, String reported, String staff, String school, String standing, String contactDate, String contactTime, String recontactDate, String grade, String gradeNotes, GraduatedInformation graduatedInformation, Set<TeacherClasses> teacherClasses, Set<CounselorClasses> counselorClasses, Set<StaffClasses> staffClasses, Set<TutorClasses> tutorClasses, boolean isDeletedStudent) {
        this.ssno = ssno;
        this.orgId = orgId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.staff = staff;
        this.school = school;
        this.standing = standing;
        this.contactDate = contactDate;
        this.contactTime = contactTime;
        this.recontactDate = recontactDate;
        this.grade = grade;
        this.gradeNotes = gradeNotes;
        this.graduatedInformation = graduatedInformation;
        this.teacherClasses = teacherClasses;
        this.counselorClasses = counselorClasses;
        this.staffClasses = staffClasses;
        this.tutorClasses = tutorClasses;
        this.isDeletedStudent = isDeletedStudent;
    }

    public boolean isDeletedStudent() {
        return isDeletedStudent;
    }

    public void setDeletedStudent(boolean deletedStudent) {
        isDeletedStudent = deletedStudent;
    }

    public void assignTeacherClasses(TeacherClasses teacherClass) {
    	this.teacherClasses.add(teacherClass);
    	teacherClass.getStudentList().add(this);
    }
    
    public void removeTeacherClasses(TeacherClasses teacherClass) {
    	this.teacherClasses.remove(teacherClass);
    	teacherClass.getStudentList().remove(this);
    }
    
    public void assignCounselorClasses(CounselorClasses CounselorClass) {
    	this.counselorClasses.add(CounselorClass);
    	CounselorClass.getStudentList().add(this);
    }
    
    public void removeCounselorClasses(CounselorClasses CounselorClass) {
    	this.counselorClasses.remove(CounselorClass);
    	CounselorClass.getStudentList().remove(this);
    }
    
    public void assignStaffClasses(StaffClasses StaffClass) {
    	this.staffClasses.add(StaffClass);
    	StaffClass.getStudentList().add(this);
    }
    
    public void removeStaffClasses(StaffClasses StaffClass) {
    	this.staffClasses.remove(StaffClass);
    	StaffClass.getStudentList().remove(this);
    }
    
    public void assignTutorClasses(TutorClasses tutorClass) {
    	this.tutorClasses.add(tutorClass);
    	tutorClass.getStudentList().add(this);
    }
    
    public void removeTutorClasses(TutorClasses tutorClass) {
    	this.tutorClasses.remove(tutorClass);
    	tutorClass.getStudentList().remove(this);
    }

    public Long getSsno() {
        return ssno;
    }

    public void setSsno(Long ssno) {
        this.ssno = ssno;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getServed() {
        return served;
    }

    public void setServed(String served) {
        this.served = served;
    }

    public String getReported() {
        return reported;
    }

    public void setReported(String reported) {
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

    public GraduatedInformation getGraduatedInformation() {
        return graduatedInformation;
    }

    public void setGraduatedInformation(GraduatedInformation graduatedInformation) {
        this.graduatedInformation = graduatedInformation;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeNotes() {
        return gradeNotes;
    }

    public void setGradeNotes(String gradeNotes) {
        this.gradeNotes = gradeNotes;
    }

    //    class EndOfYearStatus {
//        private List<EndStatus> endStatusList;
//
//        public List<EndStatus> getEndStatusList() {
//            return endStatusList;
//        }
//
//        public void setEndStatusList(List<EndStatus> endStatusList) {
//            this.endStatusList = endStatusList;
//        }
//    }
//
//    class StudentActivities implements Serializable{
//        private Integer id;
//        private String name;
//
//    }
    
	public Set<TeacherClasses> getTeacherClasses() {
		return teacherClasses;
	}

	public void setTeacherClasses(Set<TeacherClasses> teacherClasses) {
		this.teacherClasses = teacherClasses;
	}

	public Set<CounselorClasses> getCounselorClasses() {
		return counselorClasses;
	}

	public void setCounselorClasses(Set<CounselorClasses> counselorClasses) {
		this.counselorClasses = counselorClasses;
	}

	public Set<StaffClasses> getStaffClasses() {
		return staffClasses;
	}

	public void setStaffClasses(Set<StaffClasses> staffClasses) {
		this.staffClasses = staffClasses;
	}

	public Set<TutorClasses> getTutorClasses() {
		return tutorClasses;
	}

	public void setTutorClasses(Set<TutorClasses> tutorClasses) {
		this.tutorClasses = tutorClasses;
	}
}
