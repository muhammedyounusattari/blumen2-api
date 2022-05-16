package com.kastech.blumen.service.student.impl;

import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ServiceLayerException("student not found"));
    }
}
