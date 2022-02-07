package com.kastech.blumen.controller.utilities.quickedit;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.utilities.quickedit.YearlyFinancialAidInfoRepository;
import com.kastech.blumen.service.utilities.quickedit.YearlyFinancialAidInfoServiceV1;
import com.kastech.blumen.validator.utilities.quickedit.YearlyFinancialAidInfoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/utilities/quickedit")
public class YearlyFinancialAidInfoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(YearlyFinancialAidInfoController.class);

    YearlyFinancialAidInfoRepository yearlyFinancialAidInfoRepository;

    @Autowired
    YearlyFinancialAidInfoServiceV1 yearlyFinancialAidInfoServiceV1;


    @Autowired
    YearlyFinancialAidInfoValidator yearlyFinancialAidInfoValidator;

    @Autowired
    StudentRepository studentRepository;


    List<Student> studentList = new ArrayList<>();

    Map<Long, Student> studentMap = new HashMap<Long, Student>();


    @ResponseBody
    @GetMapping(path = "/getAllStudentsByFiscalYearForYearly/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getAllStudentsByFiscalYearForYearly(@RequestParam("fiscalYear") String fiscalYear) {
        List<Student> studentList = studentRepository.findAllStudentbyFiscalYear(fiscalYear);

        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @PutMapping(path = "/updateSelectedStudentFieldByFiscalYear/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateSelectedStudentFieldByFiscalYear(@RequestBody List<Student> studentList) {
        ResponseEntity<String> responseEntity = null;
        if (!studentList.isEmpty()) {
            studentRepository.saveAll(studentList);
            responseEntity = new ResponseEntity(new Response(200, studentList.size() + " no of Students updated "), null, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(new Response(200, " Empty Students  "), null, HttpStatus.OK);
        }

        return responseEntity;
    }

   /* @ResponseBody
    @GetMapping(path = "/newYearlyFinancialAidInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> newYearlyFinancialAidInfo() {
        addStudentProfile();
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/editYearlyFinancialAidInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> editYearlyFinancialAidInfo(@RequestBody StudentProfile studentProfile) {
     //   StudentProfile studentProfile = yearlyFinancialAidInfoServiceV1.doService(reqBody);

        return ResponseEntity.ok(studentMap.values());
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteYearlyFinancialAidInfo/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> deleteYearlyFinancialAidInfo(@RequestBody StudentProfile studentProfile) {

        return ResponseEntity.ok(studentMap.values());
    }*/
}
