package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.StudentWalletLog;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.logs.StudentWalletLogRepository;
import com.kastech.blumen.service.student.logs.StudentWalletLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentWalletLogValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-logs")
public class StudentWalletLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentWalletLogController.class);

    @Autowired
    StudentWalletLogServiceV1 studentWalletLogServiceV1;


    @Autowired
    StudentWalletLogValidator studentWalletLogValidator;

    Map<String, StudentWalletLog> studentWalletLogMap = new HashMap<String, StudentWalletLog>();

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDataWalletLog/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentDataWalletLog() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentWalletLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getTeacherList() {
    	
        return ResponseEntity.ok(studentWalletLogServiceV1.getAllStudentWalletLog());
    }

    @ResponseBody
    @PostMapping(path = "/studentWalletLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToTeacherList(@RequestBody StudentWalletLog studentWalletLog) {
    	studentWalletLogServiceV1.save(studentWalletLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentWalletLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentWalletLogList(@RequestBody StudentWalletLog studentWalletLog) {
    	studentWalletLogServiceV1.save(studentWalletLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentWalletLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> filterStudentWalletLogList(@RequestBody StudentWalletLog studentWalletLog) {
        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogServiceV1.getAllStudentWalletLog());
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentWalletLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> deleteStudentWalletLogList(@RequestBody StudentWalletLog studentWalletLog) {
    	studentWalletLogServiceV1.delete(studentWalletLog);
    	return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping(path = "/getStudentWalletByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByFiscalyear(@RequestBody StudentWalletLog studentWalletLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogServiceV1.getAllStudentWalletLog());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentWalletByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByActive(@RequestBody StudentWalletLog studentWalletLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogServiceV1.getAllStudentWalletLog());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentWalletByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByServed(@RequestBody StudentWalletLog studentWalletLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogServiceV1.getAllStudentWalletLog());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentWalletByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentWalletLog>> getStudentWalletByReported(@RequestBody StudentWalletLog studentWalletLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentWalletLogServiceV1.getAllStudentWalletLog());
    }


}
