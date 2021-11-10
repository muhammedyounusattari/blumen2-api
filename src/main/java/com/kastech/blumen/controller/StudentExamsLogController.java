package com.kastech.blumen.controller;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentExamsLog;
import com.kastech.blumen.repository.StudentExamsLogRepository;
import com.kastech.blumen.service.StudentExamsLogServiceV1;
import com.kastech.blumen.validator.StudentExamsLogValidator;
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
public class StudentExamsLogController {


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentExamsLogController.class);

    StudentExamsLogRepository studentExamsLogRepository;

    @Autowired
    StudentExamsLogServiceV1 studentExamsLogServiceV1;


    @Autowired
    StudentExamsLogValidator studentExamsLogValidator;

    Map<String, StudentExamsLog> studentExamsLogMap = new HashMap<String, StudentExamsLog>();

    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogList() {

        return ResponseEntity.ok(studentExamsLogMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentExamsLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentExamsLogList(@RequestBody String reqBody) {
        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        studentExamsLogMap.put(studentExamsLog.getSsno(),studentExamsLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentExamsLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentExamsLogList(@RequestBody String reqBody) {
        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        studentExamsLogMap.put(studentExamsLog.getSsno(),studentExamsLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentExamsLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentExamsLogList(@RequestBody String reqBody) {
        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentExamsLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> deleteStudentExamsLogList(@RequestBody String reqBody) {

        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        studentExamsLogMap.remove(studentExamsLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByFiscalyear(@RequestBody String reqBody) {

        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        studentExamsLogMap.remove(studentExamsLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByActive(@RequestBody String reqBody) {

        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        studentExamsLogMap.remove(studentExamsLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByServed(@RequestBody String reqBody) {

        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        studentExamsLogMap.remove(studentExamsLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByReported(@RequestBody String reqBody) {

        StudentExamsLog studentExamsLog = studentExamsLogServiceV1.doService(reqBody);
        studentExamsLogMap.remove(studentExamsLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogMap.values());
    }
}
