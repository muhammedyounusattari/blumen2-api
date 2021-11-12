package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.logs.StudentTextMessagesLog;
import com.kastech.blumen.repository.student.logs.StudentTextMessagesLogRepository;
import com.kastech.blumen.service.student.logs.StudentTextMessagesLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentTextMessagesRepliesValidator;
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
@RequestMapping("/api/blumen-api/student-logs")
public class StudentTextMessagesLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesLogController.class);

    StudentTextMessagesLogRepository studentTextMessagesLogRepository;

    @Autowired
    StudentTextMessagesLogServiceV1 studentTextMessagesLogServiceV1;


    @Autowired
    StudentTextMessagesRepliesValidator studentTextMessagesRepliesValidator;

    Map<String, StudentTextMessagesLog> studentTextMessagesLogMap = new HashMap<String, StudentTextMessagesLog>();

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogList() {

        return ResponseEntity.ok(studentTextMessagesLogMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentTextMessagesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentTextMessagesLogList(@RequestBody String reqBody) {
        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        studentTextMessagesLogMap.put(studentTextMessagesLog.getSsno(),studentTextMessagesLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTextMessagesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentTextMessagesLogList(@RequestBody String reqBody) {
        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        studentTextMessagesLogMap.put(studentTextMessagesLog.getSsno(),studentTextMessagesLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTextMessagesLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentTextMessagesLogList(@RequestBody String reqBody) {
        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentTextMessagesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> deleteStudentTextMessagesLogList(@RequestBody String reqBody) {

        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        studentTextMessagesLogMap.remove(studentTextMessagesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByFiscalyear(@RequestBody String reqBody) {

        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        studentTextMessagesLogMap.remove(studentTextMessagesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByActive(@RequestBody String reqBody) {

        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        studentTextMessagesLogMap.remove(studentTextMessagesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByServed(@RequestBody String reqBody) {

        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        studentTextMessagesLogMap.remove(studentTextMessagesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByReported(@RequestBody String reqBody) {

        StudentTextMessagesLog studentTextMessagesLog = studentTextMessagesLogServiceV1.doService(reqBody);
        studentTextMessagesLogMap.remove(studentTextMessagesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogMap.values());
    }
}
