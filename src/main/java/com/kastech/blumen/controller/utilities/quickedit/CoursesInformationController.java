package com.kastech.blumen.controller.utilities.quickedit;

import com.kastech.blumen.model.utilities.quickedit.CoursesInformation;
import com.kastech.blumen.repository.utilities.quickedit.CoursesInformationRepository;
import com.kastech.blumen.service.utilities.quickedit.CoursesInformationServiceV1;
import com.kastech.blumen.validator.utilities.quickedit.CoursesInformationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/utilities/quickedit")
public class CoursesInformationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoursesInformationController.class);

    CoursesInformationRepository coursesInformationRepository;

    @Autowired
    CoursesInformationServiceV1 coursesInformationServiceV1;


    @Autowired
    CoursesInformationValidator coursesInformationValidator;

    List<String> courseNameList = new ArrayList<>();

    List<String> courseNumberList = new ArrayList<>();

    Map<String, CoursesInformation> coursesInformationHashMap = new HashMap<String, CoursesInformation>();

    Map<String, String> semesterList = new HashMap<>();

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

    public void semesterList() {
        semesterList.put("3", "Fall");
        semesterList.put("1", "Spring");
        semesterList.put("2", "Summer");
        semesterList.put("4", "Winter");
        semesterList.put("0", " ");
    }


    public void courseName() {
        courseNameList.add("English");
        courseNameList.add("Algebra");
        courseNameList.add("Advanced Maths");
        courseNameList.add("Scienve");
        courseNameList.add("Maths");
    }

    public void courseNumber() {
        courseNumberList.add("1234");
        courseNumberList.add("5678");
        courseNumberList.add("90123");
        courseNumberList.add("4567");
        courseNumberList.add("5432");
    }

    @ResponseBody
    @GetMapping(path = "/getOkToContinueCoursesInformationList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CoursesInformation>> getOkToContinueCoursesInformationList(@RequestParam("semester") String semester, @RequestParam("year") String year, @RequestParam("course-name") String courseName, @RequestParam("course-gpa") String courseGpa, @RequestParam("course-number") String courseNumber, @RequestParam("course-completed") String courseCompleted, @RequestParam("dropped-course") String droppedCourse) {
        semesterList();
        courseName();
        courseNumber();
        return ResponseEntity.ok(coursesInformationHashMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/savedCoursesInformationList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> savedCoursesInformationList(@RequestBody String reqBody) {
        semesterList();
        courseName();
        courseNumber();
        return ResponseEntity.ok("Data Save no changes ");
    }


}
