package com.kastech.blumen.model.student;

import java.util.List;

public class StudentFilterResponse {
    private List<StudentListDto> studentList;

    private long totalNumberOfPages;
    private long totalRecords;

    public List<StudentListDto> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentListDto> studentList) {
        this.studentList = studentList;
    }

    public long getTotalNumberOfPages() {
        return totalNumberOfPages;
    }

    public void setTotalNumberOfPages(long totalNumberOfPages) {
        this.totalNumberOfPages = totalNumberOfPages;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }
}
