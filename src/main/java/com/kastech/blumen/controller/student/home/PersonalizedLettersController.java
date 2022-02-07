package com.kastech.blumen.controller.student.home;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentProfile;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.home.PersonalizedLettersRepository;
import com.kastech.blumen.service.student.home.PersonalizedLettersServiceV1;
import com.kastech.blumen.validator.student.home.PersonalizedLettersValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/student-home")
public class PersonalizedLettersController {


    private static final Logger LOGGER = LoggerFactory.getLogger(PersonalizedLettersController.class);

    @Autowired
    PersonalizedLettersRepository personalizedLettersRepository;

    @Autowired
    PersonalizedLettersServiceV1 personalizedLettersServiceV1;


    @Autowired
    PersonalizedLettersValidator personalizedLettersValidator;


    List<Student> studentList = new ArrayList<>();

    @ResponseBody
    @GetMapping(path = "/getPersonalizedLettersStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Student> getPersonalizedLettersStudentList() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = personalizedLettersRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/getPersonalizedLettersContinue/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> submitPersonalizedLettersContinue(@RequestBody String reqBody) {
        int size = studentList.size();
        StudentProfile studentProfile = personalizedLettersServiceV1.doService(reqBody);

        for (Student student : studentList) {
            //put logic here and filter with all the fields from student list
        }
        return new ResponseEntity(new Response(200, "submitted " + size + " students record successfully"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/printPersonalizedLetters/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> printPersonalizedLetters(@RequestBody String reqBody) {
        int size = studentList.size();
        for (Student student : studentList) {
            //put logic here and filter with all the fields from student list
        }
        return new ResponseEntity(new Response(200, "print " + size + "  students personalized letters "), null, HttpStatus.OK);
    }


}
