package com.kastech.blumen.controller.utilities.addto;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.model.utilities.FiscalGraduatedYearRequest;
import com.kastech.blumen.model.utilities.SemesterRequest;
import com.kastech.blumen.model.utilities.quickedit.CoursesInformation;
import com.kastech.blumen.repository.student.StudentRepository;
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

    @Autowired
    StudentRepository studentRepository;

    /*@ResponseBody
    @GetMapping(path = "/getAllStudentsByFiscalYearForSemester/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getAllStudentsByFiscalYearForSemester(@RequestParam("fiscalYear") String fiscalYear) {
        List<Student> studentList = studentRepository.findAllStudentbyFiscalYear(fiscalYear);

        return ResponseEntity.ok(studentList);
    }*/

   /* need to be implemnted here
   @ResponseBody
    @PostMapping(path = "/moveSelectedStudentListFromFiscalYearForSemester/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> moveSelectedStudentListFromFiscalYearForSemester(@RequestBody SemesterRequest semesterRequest) {
        List<String> ssnoList = null;
        String graduatedYear = null;
        if (null != fiscalGraduatedYearRequest) {
            graduatedYear = fiscalGraduatedYearRequest.getFiscalYear();
            ssnoList = fiscalGraduatedYearRequest.getSsnoList();
            LOGGER.info("Students to be moved to fiscal year " + fiscalGraduatedYearRequest.getFiscalYear());
            LOGGER.info("no of received students received to move to fiscal year " + ssnoList.size());
            List<Student> studentsListObj = new ArrayList<>();
            if (!ssnoList.isEmpty()) {

                for (String ssno : ssnoList) {
                    Optional<Student> studentObj = studentRepository.findById(Long.parseLong(ssno));
                    if (null != studentObj.get() && null != studentObj.get().getGraduatedInformation()) {
                        studentObj.get().getGraduatedInformation().setGraduatedYear(graduatedYear);
                    }
                    studentsListObj.add(studentObj.get());
                }
            }
            studentRepository.saveAll(studentsListObj);
        }

        return new ResponseEntity(new Response(200, ssnoList.size() + " no of Students are added to the Graduated year " + graduatedYear), null, HttpStatus.OK);
    }*/



    /*@ResponseBody
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
    public ResponseEntity<Collection<CoursesInformation>> addSemesterCourses(@RequestBody CoursesInformation coursesInformation) {
      //  CoursesInformation coursesInformation = semesterServiceV1.doService(reqBody);
        coursesInformationHashMap.put(coursesInformation.getSsnoCourse(),coursesInformation);
        return ResponseEntity.ok(coursesInformationHashMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/editSemesterCourses/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CoursesInformation>> editSemesterCourses(@RequestBody CoursesInformation coursesInformation) {
      //  CoursesInformation coursesInformation = semesterServiceV1.doService(reqBody);
        coursesInformationHashMap.put(coursesInformation.getSsnoCourse(),coursesInformation);
        return ResponseEntity.ok(coursesInformationHashMap.values());
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteSemesterCourses/v1",
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
    public ResponseEntity<String> getSemesterCoursesNotes(@RequestBody CoursesInformation coursesInformation) {
        courseInformationData();
        return ResponseEntity.status(HttpStatus.OK).body("Data updated successfully " );
    }*/
}
