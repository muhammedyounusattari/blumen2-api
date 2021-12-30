package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentTeacherContacts;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentTeacherContactsRepository;
import com.kastech.blumen.service.student.contacts.StudentTeacherContactsServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentTeacherContactsValidator;
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
public class StudentTeacherContactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTeacherContactsController.class);

    @Autowired
    StudentTeacherContactsRepository studentTeacherContactsRepository;

    @Autowired
    StudentTeacherContactsServiceV1 studentTeacherContactsServiceV1;


    @Autowired
    StudentTeacherContactsValidator studentTeacherContactsValidator;

    Map<String, StudentTeacherContacts> studentTeacherContactsMap = new HashMap<String, StudentTeacherContacts>();

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContacts/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentTeacherContacts() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<StudentTeacherContacts> getStudentTeacherContactsList() {

        List<StudentTeacherContacts> list = new ArrayList<>();
        Iterable<StudentTeacherContacts> items = studentTeacherContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/studentTeacherContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentTeacherContacts addToStudentTeacherContactsList(@RequestBody StudentTeacherContacts teacherContacts) {
      //  StudentTeacherContacts teacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        return studentTeacherContactsRepository.save(teacherContacts);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentTeacherContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<StudentTeacherContacts> editStudentTeacherContactsList(@RequestBody StudentTeacherContacts studentTeacherContacts) {
       // StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);

        return studentTeacherContactsRepository.findById(studentTeacherContacts.getSsno())
                .map(oldItem -> {
                    StudentTeacherContacts updated = oldItem.updateWith(studentTeacherContacts);
                    return studentTeacherContactsRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentTeacherContactslist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentTeacherContactsList(@RequestBody StudentTeacherContacts studentTeacherContacts) {
     //   StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentTeacherContactsList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudentTeacherContactsList(@RequestBody StudentTeacherContacts studentTeacherContacts) {

     //   StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsRepository.delete(studentTeacherContacts);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


  /*  @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByFiscalyear(@RequestBody StudentTeacherContacts studentTeacherContacts) {

      //  StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByActive(@RequestBody StudentTeacherContacts studentTeacherContacts) {

     //   StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByServed(@RequestBody StudentTeacherContacts studentTeacherContacts) {

     //   StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentTeacherContactsByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByReported(@RequestBody StudentTeacherContacts studentTeacherContacts) {

     //   StudentTeacherContacts studentTeacherContacts = studentTeacherContactsServiceV1.doService(reqBody);
        studentTeacherContactsMap.remove(studentTeacherContacts.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsMap.values());
    }*/
}
