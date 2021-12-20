package com.kastech.blumen.controller.utilities.quickedit;

import com.kastech.blumen.model.StudentProfile;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.utilities.quickedit.StudentsDemographicInfoRepository;
import com.kastech.blumen.service.utilities.quickedit.StudentsDemographicInfoServiceV1;
import com.kastech.blumen.validator.utilities.quickedit.StudentsDemographicInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/utilities/quickedit")
public class StudentsDemographicInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentsDemographicInfoController.class);

    StudentsDemographicInfoRepository studentsDemographicInfoRepository;

    @Autowired
    StudentsDemographicInfoServiceV1 studentsDemographicInfoServiceV1;


    @Autowired
    StudentsDemographicInfoValidator studentsDemographicInfoValidator;


    List<Student> studentList = new ArrayList<>();

    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    public void addStudentProfile() {

        Student studentOne = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentOne);
        studentMap.put(studentOne.getSsno(), studentOne);

        Student studentTwo = new Student(222-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentTwo);
        studentMap.put(studentTwo.getSsno(), studentTwo);

        Student studentThree = new Student(333-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentThree);
        studentMap.put(studentThree.getSsno(), studentThree);

        Student studentFour = new Student(444-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFour);
        studentMap.put(studentFour.getSsno(), studentFour);

        Student studentFive = new Student(555-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFive);
        studentMap.put(studentFive.getSsno(), studentFive);
    }

    @ResponseBody
    @GetMapping(path = "/clickOkToContinueStudentsDemographicInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> clickOkToContinueStudentsDemographicInfo() {
        addStudentProfile();
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/saveStudentsDemographicInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> saveStudentsDemographicInfo(@RequestBody String reqBody) {
        StudentProfile studentProfile = studentsDemographicInfoServiceV1.doService(reqBody);

        return ResponseEntity.ok(studentList);
    }
}
