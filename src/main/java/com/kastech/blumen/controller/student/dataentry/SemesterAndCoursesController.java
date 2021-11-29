package com.kastech.blumen.controller.student.dataentry;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.dataentry.SemesterAndCoursesRepository;
import com.kastech.blumen.service.student.dataentry.SemesterAndCoursesServiceV1;
import com.kastech.blumen.validator.student.dataentry.SemesterAndCoursesValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-dataentry")
public class SemesterAndCoursesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterAndCoursesController.class);

    SemesterAndCoursesRepository semesterAndCoursesRepository;

    @Autowired
    SemesterAndCoursesServiceV1 semesterAndCoursesServiceV1;


    @Autowired
    SemesterAndCoursesValidator semesterAndCoursesValidator;


    List<Student> studentList = new ArrayList<>();

    Map<String, GraduatedInformation> graduatedInformationMap = new HashMap<>();

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

    @ResponseBody
    @GetMapping(path = "/newSemesterAndCoursesStudents/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> newSemesterAndCoursesStudents(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
        GraduatedInformation graduatedInformation = semesterAndCoursesServiceV1.doService(reqBody);
        graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/editSemesterAndCoursesStudents/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> editSemesterAndCoursesStudents(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
        GraduatedInformation graduatedInformation = semesterAndCoursesServiceV1.doService(reqBody);
        graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/deleteSemesterAndCoursesStudents/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> deleteSemesterAndCoursesStudents(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
        GraduatedInformation graduatedInformation = semesterAndCoursesServiceV1.doService(reqBody);
        graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }


}
