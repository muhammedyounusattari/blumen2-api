package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.contacts.StudentDispTutorContReminder;
import com.kastech.blumen.repository.student.contacts.StudentDispTutorContReminderRepository;
import com.kastech.blumen.service.student.contacts.StudentDispTutorContReminderServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentDispTutorContReminderValidator;
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
public class StudentDispTutorContReminderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispTutorContReminderController.class);

    StudentDispTutorContReminderRepository studentDispTutorContReminderRepository;

    @Autowired
    StudentDispTutorContReminderServiceV1 studentDispTutorContReminderServiceV1;


    @Autowired
    StudentDispTutorContReminderValidator studentDispTutorContReminderValidator;

    Map<String, StudentDispTutorContReminder> studentDispTutorContReminderMap = new HashMap<String, StudentDispTutorContReminder>();

    @ResponseBody
    @GetMapping(path = "/getStudentDispTutorContReminderList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderList() {

        return ResponseEntity.ok(studentDispTutorContReminderMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentDispTutorContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentDispTutorContReminderList(@RequestBody String reqBody) {
        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        studentDispTutorContReminderMap.put(studentDispTutorContReminder.getSsno(),studentDispTutorContReminder);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentDispTutorContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentDispTutorContReminderList(@RequestBody String reqBody) {
        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        studentDispTutorContReminderMap.put(studentDispTutorContReminder.getSsno(),studentDispTutorContReminder);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentDispTutorContReminderlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentDispTutorContReminderList(@RequestBody String reqBody) {
        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentDispTutorContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTutorContReminder>> deleteStudentDispTutorContReminderList(@RequestBody String reqBody) {

        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        studentDispTutorContReminderMap.remove(studentDispTutorContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispTutorContReminderByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByFiscalyear(@RequestBody String reqBody) {

        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        studentDispTutorContReminderMap.remove(studentDispTutorContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispTutorContReminderByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByActive(@RequestBody String reqBody) {

        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        studentDispTutorContReminderMap.remove(studentDispTutorContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispTutorContReminderByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByServed(@RequestBody String reqBody) {

        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        studentDispTutorContReminderMap.remove(studentDispTutorContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispTutorContReminderByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByReported(@RequestBody String reqBody) {

        StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1.doService(reqBody);
        studentDispTutorContReminderMap.remove(studentDispTutorContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderMap.values());
    }
}
