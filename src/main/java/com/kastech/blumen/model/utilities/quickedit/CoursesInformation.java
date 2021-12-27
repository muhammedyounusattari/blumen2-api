package com.kastech.blumen.model.utilities.quickedit;

public class CoursesInformation {

    private String ssnoCourse;
    private String firstName;
    private String lastName;
    private String courseCurrentYear;
    private String semester;
    private String courseNumber;
    private String courseName;
    private String courseCountInGpa;
    private String courseCompleted;
    private String courseDropped;
    private String courseDropDate;

    private String courseGpa;
    private String courseGrade;
    private String courseHours;
    private String courseInstructor;
    private String courseSection;
    private String courseNotes;

    public CoursesInformation() {
    }

    public CoursesInformation(String ssnoCourse, String firstName, String lastName, String courseCurrentYear, String semester, String courseNumber, String courseName, String courseCountInGpa, String courseCompleted, String courseDropped, String courseDropDate, String courseGpa, String courseGrade, String courseHours, String courseInstructor, String courseSection, String courseNotes) {
        this.ssnoCourse = ssnoCourse;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseCurrentYear = courseCurrentYear;
        this.semester = semester;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseCountInGpa = courseCountInGpa;
        this.courseCompleted = courseCompleted;
        this.courseDropped = courseDropped;
        this.courseDropDate = courseDropDate;
        this.courseGpa = courseGpa;
        this.courseGrade = courseGrade;
        this.courseHours = courseHours;
        this.courseInstructor = courseInstructor;
        this.courseSection = courseSection;
        this.courseNotes = courseNotes;
    }

    public String getSsnoCourse() {
        return ssnoCourse;
    }

    public void setSsnoCourse(String ssnoCourse) {
        this.ssnoCourse = ssnoCourse;
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

    public String getCourseCurrentYear() {
        return courseCurrentYear;
    }

    public void setCourseCurrentYear(String courseCurrentYear) {
        this.courseCurrentYear = courseCurrentYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCountInGpa() {
        return courseCountInGpa;
    }

    public void setCourseCountInGpa(String courseCountInGpa) {
        this.courseCountInGpa = courseCountInGpa;
    }

    public String getCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(String courseCompleted) {
        this.courseCompleted = courseCompleted;
    }

    public String getCourseDropped() {
        return courseDropped;
    }

    public void setCourseDropped(String courseDropped) {
        this.courseDropped = courseDropped;
    }

    public String getCourseDropDate() {
        return courseDropDate;
    }

    public void setCourseDropDate(String courseDropDate) {
        this.courseDropDate = courseDropDate;
    }

    public String getCourseGpa() {
        return courseGpa;
    }

    public void setCourseGpa(String courseGpa) {
        this.courseGpa = courseGpa;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }

    public String getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(String courseHours) {
        this.courseHours = courseHours;
    }

    public String getCourseInstructor() {
        return courseInstructor;
    }

    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public String getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(String courseSection) {
        this.courseSection = courseSection;
    }

    public String getCourseNotes() {
        return courseNotes;
    }

    public void setCourseNotes(String courseNotes) {
        this.courseNotes = courseNotes;
    }

    @Override
    public String toString() {
        return "CoursesInformation{" +
                "ssnoCourse='" + ssnoCourse + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseCurrentYear='" + courseCurrentYear + '\'' +
                ", semester='" + semester + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCountInGpa='" + courseCountInGpa + '\'' +
                ", courseCompleted='" + courseCompleted + '\'' +
                ", courseDropped='" + courseDropped + '\'' +
                ", courseDropDate='" + courseDropDate + '\'' +
                ", courseGpa='" + courseGpa + '\'' +
                ", courseGrade='" + courseGrade + '\'' +
                ", courseHours='" + courseHours + '\'' +
                ", courseInstructor='" + courseInstructor + '\'' +
                ", courseSection='" + courseSection + '\'' +
                ", courseNotes='" + courseNotes + '\'' +
                '}';
    }
}
