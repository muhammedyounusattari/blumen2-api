package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.contacts.StudentDispTeacherContRemi;
import com.kastech.blumen.repository.student.contacts.StudentDispTeacherContRemiRepository;
import com.kastech.blumen.service.student.contacts.StudentDispTeacherContRemiServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentDispTeacherContRemiValidator;
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
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentDispTeacherContRemiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispTeacherContRemiController.class);

    StudentDispTeacherContRemiRepository studentDispTeacherContRemiRepository;

    @Autowired
    StudentDispTeacherContRemiServiceV1 studentDispTeacherContRemiServiceV1;


    @Autowired
    StudentDispTeacherContRemiValidator studentDispTeacherContRemiValidator;

    Map<String, StudentDispTeacherContRemi> studentDispTeacherContRemiMap = new HashMap<String, StudentDispTeacherContRemi>();

    @ResponseBody
    @GetMapping(path = "/getStudentDispTeacherContRemiList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiList() {

        return ResponseEntity.ok(studentDispTeacherContRemiMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentDispTeacherContRemiList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentDispTeacherContRemiList(@RequestBody String reqBody) {
        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        studentDispTeacherContRemiMap.put(studentDispTeacherContRemi.getSsno(),studentDispTeacherContRemi);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentDispTeacherContRemiList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentDispTeacherContRemiList(@RequestBody String reqBody) {
        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        studentDispTeacherContRemiMap.put(studentDispTeacherContRemi.getSsno(),studentDispTeacherContRemi);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentDispTeacherContRemilist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentDispTeacherContRemiList(@RequestBody String reqBody) {
        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentDispTeacherContRemiList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTeacherContRemi>> deleteStudentDispTeacherContRemiList(@RequestBody String reqBody) {

        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        studentDispTeacherContRemiMap.remove(studentDispTeacherContRemi.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispTeacherContRemiByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByFiscalyear(@RequestBody String reqBody) {

        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        studentDispTeacherContRemiMap.remove(studentDispTeacherContRemi.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispTeacherContRemiByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByActive(@RequestBody String reqBody) {

        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        studentDispTeacherContRemiMap.remove(studentDispTeacherContRemi.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispTeacherContRemiByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByServed(@RequestBody String reqBody) {

        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        studentDispTeacherContRemiMap.remove(studentDispTeacherContRemi.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispTeacherContRemiByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByReported(@RequestBody String reqBody) {

        StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
        studentDispTeacherContRemiMap.remove(studentDispTeacherContRemi.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiMap.values());
    }
}
