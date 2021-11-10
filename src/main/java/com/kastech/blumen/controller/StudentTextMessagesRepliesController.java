package com.kastech.blumen.controller;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentTextMessagesReplies;
import com.kastech.blumen.repository.StudentTextMessagesRepliesRepository;
import com.kastech.blumen.service.StudentTextMessagesRepliesServiceV1;
import com.kastech.blumen.validator.StudentTextMessagesRepliesValidator;
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
public class StudentTextMessagesRepliesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesRepliesController.class);

    StudentTextMessagesRepliesRepository studentTextMessagesRepliesRepository;

    @Autowired
    StudentTextMessagesRepliesServiceV1 studentTextMessagesRepliesServiceV1;


    @Autowired
    StudentTextMessagesRepliesValidator studentTextMessagesRepliesValidator;

    Map<String, StudentTextMessagesReplies> studentTextMessagesRepliesMap = new HashMap<String, StudentTextMessagesReplies>();

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesList() {

        return ResponseEntity.ok(studentTextMessagesRepliesMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentTextMessagesRepliesList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentTextMessagesRepliesList(@RequestBody String reqBody) {
        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        studentTextMessagesRepliesMap.put(studentTextMessagesReplies.getSsNo(),studentTextMessagesReplies);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTextMessagesRepliesList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentTextMessagesRepliesList(@RequestBody String reqBody) {
        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        studentTextMessagesRepliesMap.put(studentTextMessagesReplies.getSsNo(),studentTextMessagesReplies);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTextMessagesReplieslist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentTextMessagesRepliesList(@RequestBody String reqBody) {
        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentTextMessagesRepliesList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> deleteStudentTextMessagesRepliesList(@RequestBody String reqBody) {

        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        studentTextMessagesRepliesMap.remove(studentTextMessagesReplies.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByFiscalyear(@RequestBody String reqBody) {

        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        studentTextMessagesRepliesMap.remove(studentTextMessagesReplies.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByActive(@RequestBody String reqBody) {

        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        studentTextMessagesRepliesMap.remove(studentTextMessagesReplies.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByServed(@RequestBody String reqBody) {

        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        studentTextMessagesRepliesMap.remove(studentTextMessagesReplies.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTextMessagesRepliesByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTextMessagesReplies>> getStudentTextMessagesRepliesByReported(@RequestBody String reqBody) {

        StudentTextMessagesReplies studentTextMessagesReplies = studentTextMessagesRepliesServiceV1.doService(reqBody);
        studentTextMessagesRepliesMap.remove(studentTextMessagesReplies.getSsNo());

        return ResponseEntity.status(HttpStatus.OK).body(studentTextMessagesRepliesMap.values());
    }
}
