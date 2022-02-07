package com.kastech.blumen.controller.utilities.quickedit;

import com.kastech.blumen.model.StudentProfile;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
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


    @ResponseBody
    @GetMapping(path = "/clickOkToContinueStudentsDemographicInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> clickOkToContinueStudentsDemographicInfo() {
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/saveStudentsDemographicInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> saveStudentsDemographicInfo(@RequestBody StudentProfile studentProfile) {
      //  StudentProfile studentProfile = studentsDemographicInfoServiceV1.doService(reqBody);

        return ResponseEntity.ok(studentList);
    }
}
