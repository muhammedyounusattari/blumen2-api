package com.kastech.blumen.controller.student.dataentry;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.dataentry.SemesterAndCoursesRepository;
import com.kastech.blumen.service.student.dataentry.SemesterAndCoursesServiceV1;
import com.kastech.blumen.validator.student.dataentry.SemesterAndCoursesValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-dataentry")
public class SemesterAndCoursesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterAndCoursesController.class);

    @Autowired
    SemesterAndCoursesRepository semesterAndCoursesRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SemesterAndCoursesServiceV1 semesterAndCoursesServiceV1;


    @Autowired
    SemesterAndCoursesValidator semesterAndCoursesValidator;


    List<Student> studentList = new ArrayList<>();

    Map<Long, GraduatedInformation> graduatedInformationMap = new HashMap<>();

    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    @ResponseBody
    @GetMapping(path = "/newSemesterAndCoursesStudents/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> newSemesterAndCoursesStudents(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {
        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();

        return semesterAndCoursesRepository.findById(graduatedInformation1.getSsno())
                .map(oldItem -> {
                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation);
                    return semesterAndCoursesRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/editSemesterAndCoursesStudents/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> editSemesterAndCoursesStudents(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {
        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();

        return semesterAndCoursesRepository.findById(graduatedInformation1.getSsno())
                .map(oldItem -> {
                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation);
                    return semesterAndCoursesRepository.save(updated);
                });
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteSemesterAndCoursesStudents/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteSemesterAndCoursesStudents(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {
        semesterAndCoursesRepository.delete(graduatedInformation);
        return ResponseEntity.ok("Deleted Successfully");
    }


}
