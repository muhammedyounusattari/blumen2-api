package com.kastech.blumen.controller;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentDispStaffContReminder;
import com.kastech.blumen.repository.StudentDispStaffContRemiRepository;
import com.kastech.blumen.service.StudentDispStaffContRemiServiceV1;
import com.kastech.blumen.validator.StudentDispStaffContRemiValidator;
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
public class StudentDispStaffContRemiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispStaffContRemiController.class);

    StudentDispStaffContRemiRepository studentDispStaffContRemiRepository;

    @Autowired
    StudentDispStaffContRemiServiceV1 studentDispStaffContRemiServiceV1;


    @Autowired
    StudentDispStaffContRemiValidator studentDispStaffContRemiValidator;

    Map<String, StudentDispStaffContReminder> stringStudentDispStaffContReminderMap = new HashMap<String, StudentDispStaffContReminder>();

    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderList() {

        return ResponseEntity.ok(stringStudentDispStaffContReminderMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/studentDispStaffContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentDispStaffContReminderList(@RequestBody String reqBody) {
        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.put(studentDispStaffContReminder.getSsno(),studentDispStaffContReminder);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentDispStaffContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentDispStaffContReminderList(@RequestBody String reqBody) {
        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.put(studentDispStaffContReminder.getSsno(),studentDispStaffContReminder);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentDispStaffContReminderlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentDispStaffContReminderList(@RequestBody String reqBody) {
        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentDispStaffContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> deleteStudentDispStaffContReminderList(@RequestBody String reqBody) {

        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderyFiscalyear(@RequestBody String reqBody) {

        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderByActive(@RequestBody String reqBody) {

        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderByServed(@RequestBody String reqBody) {

        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderByReported(@RequestBody String reqBody) {

        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }
}
