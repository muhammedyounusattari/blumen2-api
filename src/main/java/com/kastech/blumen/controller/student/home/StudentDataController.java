package com.kastech.blumen.controller.student.home;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.home.StudentData;
import com.kastech.blumen.service.student.home.StudentDataServiceV1;
import com.kastech.blumen.validator.student.home.StudentDataValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api/student-data")
public class StudentDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDataController.class);

    @Autowired
    StudentDataServiceV1 studentDataServiceV1;


    @Autowired
    StudentDataValidator studentDataValidator;

    Map<Integer, StudentData> studentMap = new HashMap<>();

    @ResponseBody
    @GetMapping(path = "/getStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentData>> getStudentList() {

        return ResponseEntity.ok(studentMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentList(@RequestBody StudentData student) {
     //   StudentData student = studentDataServiceV1.doService(reqBody);
        studentMap.put(student.getId(),student);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentList(@RequestBody StudentData student) {
     //   StudentData student = studentDataServiceV1.doService(reqBody);
        studentMap.put(student.getId(),student);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentList(@RequestBody StudentData student) {
    //    StudentData student = studentDataServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentData>> deleteStudentList(@RequestBody StudentData student) {

      //  StudentData student = studentDataServiceV1.doService(reqBody);
        studentMap.remove(student.getId());

        return ResponseEntity.status(HttpStatus.OK).body(studentMap.values());
    }
}
