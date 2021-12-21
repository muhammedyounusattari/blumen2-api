package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.logs.StudentStipendLog;
import com.kastech.blumen.repository.student.logs.StudentStipendLogRepository;
import com.kastech.blumen.service.student.logs.StudentStipendLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentStipendLogValidator;
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
public class StudentStipendLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentStipendLogController.class);

    StudentStipendLogRepository studentStipendLogRepository;

    @Autowired
    StudentStipendLogServiceV1 studentStipendLogServiceV1;


    @Autowired
    StudentStipendLogValidator studentStipendLogValidator;

    Map<String, StudentStipendLog> stringStudentStipendLogMap = new HashMap<String, StudentStipendLog>();

    @ResponseBody
    @GetMapping(path = "/getStudentStipendLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStipendLog>> getStudentStipendLogList() {

        return ResponseEntity.ok(stringStudentStipendLogMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentStipendLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentStipendLogList(@RequestBody StudentStipendLog studentStipendLog) {
     //   StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        stringStudentStipendLogMap.put(studentStipendLog.getSsno(),studentStipendLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentStipendLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentStipendLogList(@RequestBody StudentStipendLog studentStipendLog) {
     //   StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        stringStudentStipendLogMap.put(studentStipendLog.getSsno(),studentStipendLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentStipendLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentStipendLogList(@RequestBody StudentStipendLog studentStipendLog) {
      //  StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentStipendLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStipendLog>> deleteStudentStipendLogList(@RequestBody StudentStipendLog studentStipendLog) {

    //    StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        stringStudentStipendLogMap.remove(studentStipendLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentStipendLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentStipendLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStipendLog>> getStudentStipendLogByFiscalyear(@RequestBody StudentStipendLog studentStipendLog) {

    //    StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        stringStudentStipendLogMap.remove(studentStipendLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentStipendLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentStipendLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStipendLog>> getStudentStipendLogByActive(@RequestBody StudentStipendLog studentStipendLog) {

    //    StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        stringStudentStipendLogMap.remove(studentStipendLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentStipendLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentStipendLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStipendLog>> getStudentStipendLogByServed(@RequestBody StudentStipendLog studentStipendLog) {

   //     StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        stringStudentStipendLogMap.remove(studentStipendLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentStipendLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentStipendLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStipendLog>> getStudentStipendLogByReported(@RequestBody StudentStipendLog studentStipendLog) {

    //    StudentStipendLog studentStipendLog = studentStipendLogServiceV1.doService(reqBody);
        stringStudentStipendLogMap.remove(studentStipendLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentStipendLogMap.values());
    }
}
