package com.kastech.blumen.controller;


import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentAttendanceLog;
import com.kastech.blumen.repository.StudentAttendanceLogRepository;
import com.kastech.blumen.service.StudentAttendanceLogServiceV1;
import com.kastech.blumen.validator.StudentAttendanceLogValidator;
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
public class StudentAttendanceLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAttendanceLogController.class);

    StudentAttendanceLogRepository studentAttendanceLogRepository;

    @Autowired
    StudentAttendanceLogServiceV1 studentAttendanceLogServiceV1;


    @Autowired
    StudentAttendanceLogValidator studentAttendanceLogValidator;

    Map<String, StudentAttendanceLog> stringStudentAttendanceLogMap = new HashMap<String, StudentAttendanceLog>();

    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLog/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogList() {

        return ResponseEntity.ok(stringStudentAttendanceLogMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentAttendanceLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentAttendanceLogList(@RequestBody String reqBody) {
        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.put(studentAttendanceLog.getSsno(),studentAttendanceLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentAttendanceLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentAttendanceLogList(@RequestBody String reqBody) {
        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.put(studentAttendanceLog.getSsno(),studentAttendanceLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentAttendanceLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentAttendanceLogList(@RequestBody String reqBody) {
        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentAttendanceLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> deleteStudentAttendanceLogList(@RequestBody String reqBody) {

        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByFiscalyear(@RequestBody String reqBody) {

        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByActive(@RequestBody String reqBody) {

        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByServed(@RequestBody String reqBody) {

        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByReported(@RequestBody String reqBody) {

        StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }


}
