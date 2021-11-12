package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.contacts.StudentStaffContacts;
import com.kastech.blumen.repository.student.contacts.StudentStaffContactsRepository;
import com.kastech.blumen.service.student.contacts.StudentStaffContactsServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentStaffContactsValidator;
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
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentStaffContactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentStaffContactsController.class);

    StudentStaffContactsRepository studentStaffContactsRepository;

    @Autowired
    StudentStaffContactsServiceV1 studentStaffContactsServiceV1;


    @Autowired
    StudentStaffContactsValidator studentStaffContactsValidator;

    Map<String, StudentStaffContacts> studentStaffContactsMap = new HashMap<String, StudentStaffContacts>();

    @ResponseBody
    @GetMapping(path = "/getStudentStaffContacts/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStaffContacts>> getStudentStaffContactsList() {

        return ResponseEntity.ok(studentStaffContactsMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentStaffContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentStaffContactsList(@RequestBody String reqBody) {
        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        studentStaffContactsMap.put(studentStaffContacts.getSsno(),studentStaffContacts);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentStaffContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentStaffContactsList(@RequestBody String reqBody) {
        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        studentStaffContactsMap.put(studentStaffContacts.getSsno(),studentStaffContacts);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentStaffContactslist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentStaffContactsList(@RequestBody String reqBody) {
        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentStaffContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStaffContacts>> deleteStudentAttendanceLogList(@RequestBody String reqBody) {

        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        studentStaffContactsMap.remove(studentStaffContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentStaffContactsMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentStaffContactsByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStaffContacts>> getStudentStaffContactsByFiscalyear(@RequestBody String reqBody) {

        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        studentStaffContactsMap.remove(studentStaffContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentStaffContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentStaffContactsByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStaffContacts>> getStudentStaffContactsByActive(@RequestBody String reqBody) {

        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        studentStaffContactsMap.remove(studentStaffContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentStaffContactsMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentStaffContactsByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStaffContacts>> getStudentStaffContactsByServed(@RequestBody String reqBody) {

        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        studentStaffContactsMap.remove(studentStaffContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentStaffContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentStaffContactsByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentStaffContacts>> getStudentStaffContactsByReported(@RequestBody String reqBody) {

        StudentStaffContacts studentStaffContacts = studentStaffContactsServiceV1.doService(reqBody);
        studentStaffContactsMap.remove(studentStaffContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentStaffContactsMap.values());
    }
}
