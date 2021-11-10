package com.kastech.blumen.controller;


import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentBotFormSubmissLog;
import com.kastech.blumen.repository.StudentBotFormSubmissLogRepository;
import com.kastech.blumen.service.StudentBotFormSubmissLogServiceV1;
import com.kastech.blumen.validator.StudentBotFormSubmissLogValidator;
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
public class StudentBotFormSubmissLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentBotFormSubmissLogController.class);

    StudentBotFormSubmissLogRepository studentBotFormSubmissLogRepository;

    @Autowired
    StudentBotFormSubmissLogServiceV1 studentBotFormSubmissLogServiceV1;


    @Autowired
    StudentBotFormSubmissLogValidator studentBotFormSubmissLogValidator;

    Map<String, StudentBotFormSubmissLog> studentBotFormSubmissLogMap = new HashMap<String, StudentBotFormSubmissLog>();

    @ResponseBody
    @GetMapping(path = "/getStudentBotFormSubmissLog/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentBotFormSubmissLog>> getStudentBotFormSubmissLogList() {

        return ResponseEntity.ok(studentBotFormSubmissLogMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentBotFormSubmissLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentBotFormSubmissLogList(@RequestBody String reqBody) {
        StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        studentBotFormSubmissLogMap.put(studentBotFormSubmissLog.getSubmissionId(),studentBotFormSubmissLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentBotFormSubmissLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentBotFormSubmissLogList(@RequestBody String reqBody) {
        StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        studentBotFormSubmissLogMap.put(studentBotFormSubmissLog.getSubmissionId(),studentBotFormSubmissLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentBotFormSubmissLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentBotFormSubmissLogList(@RequestBody String reqBody) {
        StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentBotFormSubmissLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentBotFormSubmissLog>> deleteStudentBotFormSubmissLogList(@RequestBody String reqBody) {

        StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        studentBotFormSubmissLogMap.remove(studentBotFormSubmissLog.getSubmissionId());

        return ResponseEntity.status(HttpStatus.OK).body(studentBotFormSubmissLogMap.values());
    }

}
