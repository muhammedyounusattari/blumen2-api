package com.kastech.blumen.controller.utilities.quickedit;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.utilities.quickedit.Semester;
import com.kastech.blumen.repository.utilities.quickedit.SemesterGPAInfoRepository;
import com.kastech.blumen.service.utilities.quickedit.SemesterGPAInfoServiceV1;
import com.kastech.blumen.validator.utilities.quickedit.SemesterGPAInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/utilities/quickedit")
public class SemesterGPAInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterGPAInfoController.class);

    SemesterGPAInfoRepository semesterGPAInfoRepository;

    @Autowired
    SemesterGPAInfoServiceV1 semesterGPAInfoServiceV1;


    @Autowired
    SemesterGPAInfoValidator semesterGPAInfoValidator;

    Map<String, String> semesterList = new HashMap<>();

    List<Student> studentList = new ArrayList<>();

    Map<String, Student> studentMap = new HashMap<String, Student>();

    public void addStudentProfile() {

        Student studentOne = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentOne);
        studentMap.put(studentOne.getSsno(), studentOne);

        Student studentTwo = new Student("222-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentTwo);
        studentMap.put(studentTwo.getSsno(), studentTwo);

        Student studentThree = new Student("333-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentThree);
        studentMap.put(studentThree.getSsno(), studentThree);

        Student studentFour = new Student("444-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFour);
        studentMap.put(studentFour.getSsno(), studentFour);

        Student studentFive = new Student("555-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFive);
        studentMap.put(studentFive.getSsno(), studentFive);
    }

    public void semesterList() {
        semesterList.put("3", "Fall");
        semesterList.put("1", "Spring");
        semesterList.put("2", "Summer");
        semesterList.put("4", "Winter");
        semesterList.put("0", " ");
    }

    @ResponseBody
    @GetMapping(path = "/clickOkToContinueSemesterGPAInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> clickOkToContinueSemesterGPAInfo(@RequestBody String reqBody) {
        Semester semester = semesterGPAInfoServiceV1.doService(reqBody);
        semesterList();
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/saveSemesterGPAInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> saveSemesterGPAInfo(@RequestBody String reqBody) {

        return ResponseEntity.ok(studentList);
    }
}
