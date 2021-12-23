package com.kastech.blumen.controller.student;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudents/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/addStudents/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Student addStudents(@RequestBody Student student) {

        return studentRepository.save(student);
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteStudents/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<String> deleteStudents(@RequestBody Student student) {

         studentRepository.delete(student);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
