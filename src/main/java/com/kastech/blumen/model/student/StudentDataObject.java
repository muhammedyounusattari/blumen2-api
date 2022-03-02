package com.kastech.blumen.model.student;

public class StudentDataObject {
    private Long studentId;
    private Student student;
    private StudentYearlyData studentYearlyData;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public StudentYearlyData getStudentYearlyData() {
        return studentYearlyData;
    }

    public void setStudentYearlyData(StudentYearlyData studentYearlyData) {
        this.studentYearlyData = studentYearlyData;
    }
}
