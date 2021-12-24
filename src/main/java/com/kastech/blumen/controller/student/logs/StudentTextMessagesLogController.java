package com.kastech.blumen.controller.student.logs;


import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.StudentTextMessagesLog;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.logs.StudentTextMessagesLogRepository;
import com.kastech.blumen.service.student.logs.StudentTextMessagesLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentTextMessagesRepliesValidator;
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
public class StudentTextMessagesLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesLogController.class);

    @Autowired
    StudentTextMessagesLogServiceV1 studentTextMessagesLogServiceV1;

    @Autowired
    StudentTextMessagesRepliesValidator studentTextMessagesRepliesValidator;


    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDataTextMessagesLog/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentDataTextMessagesLog() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogList() {

        return ResponseEntity.ok(studentTextMessagesLogServiceV1.getAllStudentTextMessagesLog());
    }

    @ResponseBody
    @PostMapping(path = "/studentTextMessagesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentTextMessagesLogList(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {
    	studentTextMessagesLogServiceV1.save(studentTextMessagesLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTextMessagesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentTextMessagesLogList(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {
    	studentTextMessagesLogServiceV1.save(studentTextMessagesLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTextMessagesLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> filterStudentTextMessagesLogList(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {
        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogServiceV1.getAllStudentTextMessagesLog());
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentTextMessagesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> deleteStudentTextMessagesLogList(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {

    	studentTextMessagesLogServiceV1.delete(studentTextMessagesLog);
    	return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByFiscalyear(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogServiceV1.getAllStudentTextMessagesLog());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByActive(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogServiceV1.getAllStudentTextMessagesLog());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByServed(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogServiceV1.getAllStudentTextMessagesLog());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesLog>> getStudentTextMessagesLogByReported(@RequestBody StudentTextMessagesLog studentTextMessagesLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesLogServiceV1.getAllStudentTextMessagesLog());
    }
}
