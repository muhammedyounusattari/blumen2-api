package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.logs.StudentWalletLog;
import com.kastech.blumen.repository.student.logs.StudentWalletLogRepository;
import com.kastech.blumen.service.student.logs.StudentWalletLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentWalletLogValidator;
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
public class StudentWalletLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentWalletLogController.class);

    StudentWalletLogRepository collegeSchoolRepository;

    @Autowired
    StudentWalletLogServiceV1 studentWalletLogServiceV1;


    @Autowired
    StudentWalletLogValidator studentWalletLogValidator;

    Map<String, StudentWalletLog> studentWalletLogMap = new HashMap<String, StudentWalletLog>();

    @ResponseBody
    @GetMapping(path = "/getStudentWalletLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getTeacherList() {

        return ResponseEntity.ok(studentWalletLogMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentWalletLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToTeacherList(@RequestBody String reqBody) {
        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        studentWalletLogMap.put(studentWalletLog.getSsNo(),studentWalletLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentWalletLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentWalletLogList(@RequestBody String reqBody) {
        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        studentWalletLogMap.put(studentWalletLog.getSsNo(),studentWalletLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentWalletLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentWalletLogList(@RequestBody String reqBody) {
        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentWalletLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> deleteStudentWalletLogList(@RequestBody String reqBody) {

        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        studentWalletLogMap.remove(studentWalletLog.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentWalletByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByFiscalyear(@RequestBody String reqBody) {

        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        studentWalletLogMap.remove(studentWalletLog.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentWalletByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByActive(@RequestBody String reqBody) {

        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        studentWalletLogMap.remove(studentWalletLog.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentWalletByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByServed(@RequestBody String reqBody) {

        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        studentWalletLogMap.remove(studentWalletLog.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentWalletByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByReported(@RequestBody String reqBody) {

        StudentWalletLog studentWalletLog = studentWalletLogServiceV1.doService(reqBody);
        studentWalletLogMap.remove(studentWalletLog.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogMap.values());
    }


}
