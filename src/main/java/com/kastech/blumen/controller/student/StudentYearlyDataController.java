package com.kastech.blumen.controller.student;

import com.kastech.blumen.model.student.StudentYearlyData;
import com.kastech.blumen.service.student.StudentYearlyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/student-yearly-data/v1")
public class StudentYearlyDataController {

    @Autowired
    private StudentYearlyDataService service;

    @GetMapping
    public ResponseEntity<List<StudentYearlyData>> getStudentYearlyData() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping
    public ResponseEntity<StudentYearlyData> saveStudentYearlyData(@RequestBody StudentYearlyData studentYearlyData) {
        return ResponseEntity.ok(service.saveStudentYearlyData(studentYearlyData));
    }

    @GetMapping(value="/findById")
    public ResponseEntity<StudentYearlyData> findStudentYearlyDataById(@RequestParam(value = "student_yearly_data_id") Long studentYearlyDataId) {
        StudentYearlyData result = service.findStudentYearlyDataById(studentYearlyDataId);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<StudentYearlyData> updateStudentYearlyData(@RequestBody StudentYearlyData studentYearlyData) {
        return ResponseEntity.ok(service.saveStudentYearlyData(studentYearlyData));
    }
}
