package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.StudentTextMessagesReplies;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.logs.StudentTextMessagesRepliesRepository;
import com.kastech.blumen.service.student.logs.StudentTextMessagesRepliesServiceV1;
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
public class StudentTextMessagesRepliesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesRepliesController.class);

    @Autowired
    StudentTextMessagesRepliesServiceV1 studentTextMessagesRepliesServiceV1;


    @Autowired
    StudentTextMessagesRepliesValidator studentTextMessagesRepliesValidator;


    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDataTextMessagesReplies/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentDataTextMessagesReplies() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesList() {

        return ResponseEntity.ok(studentTextMessagesRepliesServiceV1.getAllStudentTextMessagesReplies());
    }

    @ResponseBody
    @PostMapping(path = "/studentTextMessagesRepliesList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentTextMessagesRepliesList(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {
    	studentTextMessagesRepliesServiceV1.save(studentTextMessagesReplies);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTextMessagesRepliesList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentTextMessagesRepliesList(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {
    	studentTextMessagesRepliesServiceV1.save(studentTextMessagesReplies);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTextMessagesReplieslist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> filterStudentTextMessagesRepliesList(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {
     //   StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesServiceV1.getAllStudentTextMessagesReplies());
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentTextMessagesRepliesList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> deleteStudentTextMessagesRepliesList(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {
    	studentTextMessagesRepliesServiceV1.delete(studentTextMessagesReplies);
    	return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByFiscalyear(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesServiceV1.getAllStudentTextMessagesReplies());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByActive(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesServiceV1.getAllStudentTextMessagesReplies());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByServed(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesServiceV1.getAllStudentTextMessagesReplies());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByReported(@RequestBody StudentTextMessagesReplies studentTextMessagesReplies) {

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesServiceV1.getAllStudentTextMessagesReplies());
    }
}
