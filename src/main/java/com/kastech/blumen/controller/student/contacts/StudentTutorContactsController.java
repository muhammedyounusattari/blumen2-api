package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentStaffContacts;
import com.kastech.blumen.model.student.contacts.StudentTutorContacts;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentTutorContactsRepository;
import com.kastech.blumen.service.student.contacts.StudentTutorContactsServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentTutorContactsValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentTutorContactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTutorContactsController.class);

    @Autowired
    StudentTutorContactsRepository studentTutorContactsRepository;

    @Autowired
    StudentTutorContactsServiceV1 studentTutorContactsServiceV1;


    @Autowired
    StudentTutorContactsValidator studentTutorContactsValidator;

    Map<Long, StudentTutorContacts> studentTutorContactsMap = new HashMap<Long, StudentTutorContacts>();

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentTutorContacts/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentTutorContacts() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTutorContactsList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<StudentTutorContacts> getStudentTutorContactsList() {


        List<StudentTutorContacts> list = new ArrayList<>();
        Iterable<StudentTutorContacts> items = studentTutorContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/studentTutorContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentTutorContacts addToStudentTutorContactsList(@RequestBody StudentTutorContacts studentTutorContacts) {
      //  StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        return studentTutorContactsRepository.save(studentTutorContacts);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTutorContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentTutorContacts editStudentTutorContactsList(@RequestBody StudentTutorContacts studentTutorContacts) {
        return studentTutorContactsRepository.save(studentTutorContacts);
       /* return studentTutorContactsRepository.findById(studentTutorContacts.getSsno())
                .map(oldItem -> {
                    StudentTutorContacts updated = oldItem.updateWith(studentTutorContacts);
                    return studentTutorContactsRepository.save(updated);
                });*/
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTutorContactslist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentTutorContactsList(@RequestBody StudentTutorContacts studentTutorContacts) {
    //    StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentTutorContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudentTutorContactsList(@RequestBody StudentTutorContacts studentTutorContacts) {

     //   StudentTutorContacts studentTutorContacts = studentTutorContactsServiceV1.doService(reqBody);
        studentTutorContactsRepository.delete(studentTutorContacts);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
}
