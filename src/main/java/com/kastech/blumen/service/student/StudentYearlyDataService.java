package com.kastech.blumen.service.student;

import com.kastech.blumen.model.student.StudentYearlyData;

import java.util.List;

public interface StudentYearlyDataService {

    List<StudentYearlyData> findAll();

    StudentYearlyData saveStudentYearlyData(StudentYearlyData studentYearlyData);

    StudentYearlyData findStudentYearlyDataById(Long id);
}
