package com.kastech.blumen.controller.utilities.addto;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.utilities.quickedit.CoursesInformation;
import com.kastech.blumen.repository.utilities.addto.SemesterRepository;
import com.kastech.blumen.service.utilities.addto.SemesterServiceV1;
import com.kastech.blumen.validator.utilities.addto.SemesterValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/utilities/addto")
public class SemesterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterController.class);

    SemesterRepository semesterRepository;

    @Autowired
    SemesterServiceV1 semesterServiceV1;


    @Autowired
    SemesterValidator semesterValidator;

    List<Student> studentList = new ArrayList<>();

    Map<String, String> semesterList = new HashMap<>();

    public void semesterList() {
        semesterList.put("3", "Fall");
        semesterList.put("1", "Spring");
        semesterList.put("2", "Summer");
        semesterList.put("4", "Winter");
        semesterList.put("0", " ");
    }

    Map<String, CoursesInformation> coursesInformationHashMap = new HashMap<String, CoursesInformation>();


    public void courseInformationData() {
        CoursesInformation coursesInformation1 = new CoursesInformation("753-15-9456", "John", "Adams", "2017", "3", "1234", "ADVANCED MATHS", "True", "False", "False", "", "0", "", "3", "ALICIA", "", "");
        coursesInformationHashMap.put(coursesInformation1.getSsnoCourse(), coursesInformation1);
        CoursesInformation coursesInformation2 = new CoursesInformation("753-15-9456", "John", "Adams", "2017", "3", "B4875", "ALGEBRA II", "True", "False", "False", "", "", "", "3", "ALICIA", "", "");
        coursesInformationHashMap.put(coursesInformation2.getSsnoCourse(), coursesInformation2);
        CoursesInformation coursesInformation3 = new CoursesInformation("999-00-1101", "John", "Adams", "2017", "3", "B4875", "ALGEBRA II", "True", "False", "False", "", "", "", "3", "ALICIA", "", "");
        coursesInformationHashMap.put(coursesInformation3.getSsnoCourse(), coursesInformation3);
        CoursesInformation coursesInformation4 = new CoursesInformation("852-15-9743", "Savannah", "Avery", "", "3", "B4875", "ALGEBRA II", "True", "False", "False", "", "", "", "3", "ALICIA", "", "");
        coursesInformationHashMap.put(coursesInformation4.getSsnoCourse(), coursesInformation4);
        CoursesInformation coursesInformation5 = new CoursesInformation("781-26-5345", "Sean", "Avery", "2017", "3", "8888", "ALGEBRA II", "True", "False", "False", "", "", "", "3", "ALICIA", "", "");
        coursesInformationHashMap.put(coursesInformation5.getSsnoCourse(), coursesInformation5);

    }


    public void addStudentProfile() {

        Student studentOne = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentOne);

        Student studentTwo = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentTwo);
        Student studentThree = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentThree);

        Student studentFour = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFour);

        Student studentFive = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFive);
    }

    @ResponseBody
    @GetMapping(path = "/getOkToContinueSemesterList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getOkToContinueSemesterList() {
        addStudentProfile();
        semesterList();
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/getFinishForSemesterList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getFinishForSemesterList(@RequestParam("semesterSeason") String semesterSeason, @RequestParam("year") String year, @RequestParam("fiscalyear") String fiscalyear) {
        return ResponseEntity.status(HttpStatus.OK).body("Added students to the " + semesterSeason);
    }

    @ResponseBody
    @GetMapping(path = "/getAllSemesterCourses/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CoursesInformation>> getAllSemesterCourses() {
        courseInformationData();
        return ResponseEntity.ok(coursesInformationHashMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/addSemesterCourses/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CoursesInformation>> addSemesterCourses(@RequestBody String reqBody) {
        CoursesInformation coursesInformation = semesterServiceV1.doService(reqBody);
        coursesInformationHashMap.put(coursesInformation.getSsnoCourse(),coursesInformation);
        return ResponseEntity.ok(coursesInformationHashMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/editSemesterCourses/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CoursesInformation>> editSemesterCourses(@RequestBody String reqBody) {
        CoursesInformation coursesInformation = semesterServiceV1.doService(reqBody);
        coursesInformationHashMap.put(coursesInformation.getSsnoCourse(),coursesInformation);
        return ResponseEntity.ok(coursesInformationHashMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/deleteSemesterCourses/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CoursesInformation>> deleteSemesterCourses(@RequestParam("course-number") String courseNumber) {
        courseInformationData();
        for (var map : coursesInformationHashMap.entrySet()) {
            if (courseNumber.equals(map.getValue().getCourseNumber())) {
                coursesInformationHashMap.remove(map.getKey());
            }
        }

        return ResponseEntity.ok(coursesInformationHashMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getSemesterCoursesNotes/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getSemesterCoursesNotes(@RequestBody String reqBody) {
        courseInformationData();
        return ResponseEntity.status(HttpStatus.OK).body("Data updated successfully " );
    }
}
