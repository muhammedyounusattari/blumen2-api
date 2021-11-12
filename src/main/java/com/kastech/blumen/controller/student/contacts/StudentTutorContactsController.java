package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.contacts.StudentTutorContacts;
import com.kastech.blumen.repository.student.contacts.StudentTutorContactsRepository;
import com.kastech.blumen.service.student.contacts.StudentTutorContactsServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentTutorContactsValidator;
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
public class StudentTutorContactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTutorContactsController.class);

    StudentTutorContactsRepository studentTutorContactsRepository;

    @Autowired
    StudentTutorContactsServiceV1 studentTutorContactsServiceV1;


    @Autowired
    StudentTutorContactsValidator studentTutorContactsValidator;

    Map<String, StudentTutorContacts> studentTutorContactsMap = new HashMap<String, StudentTutorContacts>();

    @ResponseBody
    @GetMapping(path = "/getStudentTutorContacts/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTutorContacts>> getStudentAttendanceLogList() {

        return ResponseEntity.ok(studentTutorContactsMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentTutorContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentTutorContactsList(@RequestBody String reqBody) {
        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsMap.put(studentTutorContacts.getSsno(),studentTutorContacts);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTutorContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentTutorContactsList(@RequestBody String reqBody) {
        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsMap.put(studentTutorContacts.getSsno(),studentTutorContacts);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTutorContactslist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentTutorContactsList(@RequestBody String reqBody) {
        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentTutorContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTutorContacts>> deleteStudentTutorContactsList(@RequestBody String reqBody) {

        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsMap.remove(studentTutorContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTutorContactsMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTutorContactsByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTutorContacts>> getStudentTutorContactsByFiscalyear(@RequestBody String reqBody) {

        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsMap.remove(studentTutorContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTutorContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTutorContactsByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTutorContacts>> getStudentTutorContactsByActive(@RequestBody String reqBody) {

        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsMap.remove(studentTutorContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTutorContactsMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTutorContactsByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTutorContacts>> getStudentTutorContactsByServed(@RequestBody String reqBody) {

        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsMap.remove(studentTutorContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTutorContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTutorContactsByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTutorContacts>> getStudentTutorContactsByReported(@RequestBody String reqBody) {

        StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsMap.remove(studentTutorContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTutorContactsMap.values());
    }
}
