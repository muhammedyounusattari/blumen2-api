package com.kastech.blumen.controller;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentNotesLog;
import com.kastech.blumen.repository.StudentNotesLogRepository;
import com.kastech.blumen.service.StudentNotesLogServiceV1;
import com.kastech.blumen.validator.StudentNotesLogValidator;
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
@RequestMapping("/api/blumen-api")
public class StudentNotesLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentNotesLogController.class);

    StudentNotesLogRepository studentNotesLogRepository;

    @Autowired
    StudentNotesLogServiceV1 studentNotesLogServiceV1;


    @Autowired
    StudentNotesLogValidator studentNotesLogValidator;

    Map<String, StudentNotesLog> studentNotesLogMap = new HashMap<String, StudentNotesLog>();

    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogList() {

        return ResponseEntity.ok(studentNotesLogMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentNotesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentNotesLogList(@RequestBody String reqBody) {
        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.put(studentNotesLog.getSsno(),studentNotesLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentNotesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentNotesLogList(@RequestBody String reqBody) {
        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.put(studentNotesLog.getSsno(),studentNotesLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentNotesLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentNotesLogList(@RequestBody String reqBody) {
        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentNotesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> deleteStudentNotesLogList(@RequestBody String reqBody) {

        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByFiscalyear(@RequestBody String reqBody) {

        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByActive(@RequestBody String reqBody) {

        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByServed(@RequestBody String reqBody) {

        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByReported(@RequestBody String reqBody) {

        StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }
}
