package com.kastech.blumen.service.student.impl;

import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.student.StudentYearlyData;
import com.kastech.blumen.repository.student.StudentYearlyDataRepository;
import com.kastech.blumen.service.student.StudentYearlyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentYearlyDataServiceImpl implements StudentYearlyDataService {

    @Autowired
    private StudentYearlyDataRepository repository;

    @Override
    public List<StudentYearlyData> findAll() {
        return repository.findAll();
    }

    @Override
    public StudentYearlyData saveStudentYearlyData(StudentYearlyData studentYearlyData) {
        return repository.save(studentYearlyData);
    }

    @Override
    public StudentYearlyData findStudentYearlyDataById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ServiceLayerException("student yearly data not found"));
    }
}
