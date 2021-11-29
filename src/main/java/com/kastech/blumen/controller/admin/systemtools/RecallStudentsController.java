package com.kastech.blumen.controller.admin.systemtools;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.admin.systemtools.RecallStudentsRepository;
import com.kastech.blumen.service.admin.systemtools.RecallStudentsServiceV1;
import com.kastech.blumen.validator.admin.systemtools.RecallStudentsValidator;
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
@RequestMapping("/api/blumen-api/admin/systemtools")
public class RecallStudentsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecallStudentsController.class);

    RecallStudentsRepository recallStudentsRepository;

    @Autowired
    RecallStudentsServiceV1 recallStudentsServiceV1;


    @Autowired
    RecallStudentsValidator recallStudentsValidator;

    List<Student> studentList = new ArrayList<>();

    public void addStudentProfile() {

        Student studentOne = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentOne);

        Student studentTwo = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentTwo);
        Student studentThree = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentThree);
    }


    @ResponseBody
    @GetMapping(path = "/recallStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> recallStudentList(@RequestBody String reqBody) {
        addStudentProfile();
        studentList.clear();
        return ResponseEntity.status(HttpStatus.OK).body(studentList.size() + " no of stuents recalled");
    }
}
