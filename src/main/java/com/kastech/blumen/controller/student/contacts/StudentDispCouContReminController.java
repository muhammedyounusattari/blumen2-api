package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.contacts.StudentDispCouContRemin;
import com.kastech.blumen.repository.student.contacts.StudentDispCouContReminRepository;
import com.kastech.blumen.service.student.contacts.StudentDispCouContReminServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentDispCouContReminValidator;
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
public class StudentDispCouContReminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispCouContReminController.class);

    @Autowired
    StudentDispCouContReminRepository studentDispCouContReminRepository;

    @Autowired
    StudentDispCouContReminServiceV1 studentDispCouContReminServiceV1;


    @Autowired
    StudentDispCouContReminValidator studentDispCouContReminValidator;

    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminList() {
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll());
    }

    @ResponseBody
    @PostMapping(path = "/studentDispCouContReminList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentDispCouContReminList(@RequestBody String reqBody) {
        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        studentDispCouContRemin = studentDispCouContReminRepository.save(studentDispCouContRemin);
		if (studentDispCouContRemin != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentDispCouContReminList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentDispCouContReminList(@RequestBody String reqBody) {
    	StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        studentDispCouContRemin = studentDispCouContReminRepository.save(studentDispCouContRemin);
		if (studentDispCouContRemin != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentDispCouContReminlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> filterStudentDispCouContReminList(@RequestBody String reqBody) {
        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll());
    }


    @ResponseBody
    @PutMapping(path = "/deleteStudentDispCouContReminList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudentDispCouContReminList(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        studentDispCouContReminRepository.delete(studentDispCouContRemin);

        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByFiscalyear(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByActive(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByServed(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByReported(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll());
    }
}
