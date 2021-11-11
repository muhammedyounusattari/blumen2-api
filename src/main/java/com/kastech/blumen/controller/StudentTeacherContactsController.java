package com.kastech.blumen.controller;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentTeacherContacts;
import com.kastech.blumen.repository.StudentTeacherContactsRepository;
import com.kastech.blumen.service.StudentTeacherContactsServiceV1;
import com.kastech.blumen.validator.StudentTeacherContactsValidator;
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
public class StudentTeacherContactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTeacherContactsController.class);

    StudentTeacherContactsRepository studentTeacherContactsRepository;

    @Autowired
    StudentTeacherContactsServiceV1 studentTeacherContactsServiceV1;


    @Autowired
    StudentTeacherContactsValidator studentTeacherContactsValidator;

    Map<String, StudentTeacherContacts> studentTeacherContactsMap = new HashMap<String, StudentTeacherContacts>();

    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContacts/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsList() {

        return ResponseEntity.ok(studentTeacherContactsMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentTeacherContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentTeacherContactsList(@RequestBody String reqBody) {
        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.put(studentTeacherContacts.getSsno(),studentTeacherContacts);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTeacherContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentTeacherContactsList(@RequestBody String reqBody) {
        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.put(studentTeacherContacts.getSsno(),studentTeacherContacts);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTeacherContactslist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentTeacherContactsList(@RequestBody String reqBody) {
        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentTeacherContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> deleteStudentTeacherContactsList(@RequestBody String reqBody) {

        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByFiscalyear(@RequestBody String reqBody) {

        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByActive(@RequestBody String reqBody) {

        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByServed(@RequestBody String reqBody) {

        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByReported(@RequestBody String reqBody) {

        StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }
}
