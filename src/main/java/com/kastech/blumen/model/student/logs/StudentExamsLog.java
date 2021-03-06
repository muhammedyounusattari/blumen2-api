package com.kastech.blumen.model.student.logs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exam_log" ,schema = "blumen2")
public class StudentExamsLog {

	@Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="student_exam_log_seq_gen")
    @SequenceGenerator(name="student_exam_log_seq_gen", sequenceName="STUDENT_EXAM_LOG_SEQ")
	private Long id;
    private String ssno;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String examDate;
    private String examName;
    private String marks;
    private String maxMarks;
    private String letterGrade;
    private String fiscalYear;
    private boolean active;
    private boolean served;
    private boolean reported;
    private String councelor;
    private String school;
    private String standing;

    private String examLetterGrade;
    private String subExamName;
    private String maxMumMarks;
    private String totalMarks;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<SubExamLogEntry> subExamLogEntry;
    private String examNotes;

    public StudentExamsLog() {
    }

    public StudentExamsLog(Long id, String ssno, String firstName, String lastName, String phoneNumber, String examDate, String examName, String marks, String maxMarks, String letterGrade, String fiscalYear, boolean active, boolean served, boolean reported, String councelor, String school, String standing, String examLetterGrade, String subExamName, String maxMumMarks, String totalMarks, List<SubExamLogEntry> subExamLogEntry, String examNotes) {
        this.id = id;
        this.ssno = ssno;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.examDate = examDate;
        this.examName = examName;
        this.marks = marks;
        this.maxMarks = maxMarks;
        this.letterGrade = letterGrade;
        this.fiscalYear = fiscalYear;
        this.active = active;
        this.served = served;
        this.reported = reported;
        this.councelor = councelor;
        this.school = school;
        this.standing = standing;
        this.examLetterGrade = examLetterGrade;
        this.subExamName = subExamName;
        this.maxMumMarks = maxMumMarks;
        this.totalMarks = totalMarks;
        this.subExamLogEntry = subExamLogEntry;
        this.examNotes = examNotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsno() {
        return ssno;
    }

    public void setSsno(String ssno) {
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

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(String maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public String getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(String fiscalYear) {
        this.fiscalYear = fiscalYear;
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

    public String getCouncelor() {
        return councelor;
    }

    public void setCouncelor(String councelor) {
        this.councelor = councelor;
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

    public String getExamLetterGrade() {
        return examLetterGrade;
    }

    public void setExamLetterGrade(String examLetterGrade) {
        this.examLetterGrade = examLetterGrade;
    }

    public String getSubExamName() {
        return subExamName;
    }

    public void setSubExamName(String subExamName) {
        this.subExamName = subExamName;
    }

    public String getMaxMumMarks() {
        return maxMumMarks;
    }

    public void setMaxMumMarks(String maxMumMarks) {
        this.maxMumMarks = maxMumMarks;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    public List<SubExamLogEntry> getSubExamLogEntry() {
        return subExamLogEntry;
    }

    public void setSubExamLogEntry(List<SubExamLogEntry> subExamLogEntry) {
        this.subExamLogEntry = subExamLogEntry;
    }

    public String getExamNotes() {
        return examNotes;
    }

    public void setExamNotes(String examNotes) {
        this.examNotes = examNotes;
    }

    @Override
    public String toString() {
        return "StudentExamsLog{" +
                "id=" + id +
                ", ssno='" + ssno + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", examDate='" + examDate + '\'' +
                ", examName='" + examName + '\'' +
                ", marks='" + marks + '\'' +
                ", maxMarks='" + maxMarks + '\'' +
                ", letterGrade='" + letterGrade + '\'' +
                ", fiscalYear='" + fiscalYear + '\'' +
                ", active=" + active +
                ", served=" + served +
                ", reported=" + reported +
                ", councelor='" + councelor + '\'' +
                ", school='" + school + '\'' +
                ", standing='" + standing + '\'' +
                ", examLetterGrade='" + examLetterGrade + '\'' +
                ", subExamName='" + subExamName + '\'' +
                ", maxMumMarks='" + maxMumMarks + '\'' +
                ", totalMarks='" + totalMarks + '\'' +
                ", subExamLogEntry=" + subExamLogEntry +
                ", examNotes='" + examNotes + '\'' +
                '}';
    }
}
