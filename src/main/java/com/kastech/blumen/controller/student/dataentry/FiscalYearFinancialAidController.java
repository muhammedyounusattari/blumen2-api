package com.kastech.blumen.controller.student.dataentry;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.dataentry.FiscalYearFinancialAidRepository;
import com.kastech.blumen.service.student.dataentry.FiscalYearFinancialAidServiceV1;
import com.kastech.blumen.validator.student.dataentry.FiscalYearFinancialAidValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-dataentry")
public class FiscalYearFinancialAidController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FiscalYearFinancialAidController.class);

    FiscalYearFinancialAidRepository fiscalYearFinancialAidRepository;

    @Autowired
    FiscalYearFinancialAidServiceV1 fiscalYearFinancialAidServiceV1;


    @Autowired
    FiscalYearFinancialAidValidator fiscalYearFinancialAidValidator;


    List<Student> studentList = new ArrayList<>();

    Map<String, GraduatedInformation> graduatedInformationMap = new HashMap<>();

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
    @GetMapping(path = "/newFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> newFiscalYearFinancialAid(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
        GraduatedInformation graduatedInformation = fiscalYearFinancialAidServiceV1.doService(reqBody);
        graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/editFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> editFiscalYearFinancialAid(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
        GraduatedInformation graduatedInformation = fiscalYearFinancialAidServiceV1.doService(reqBody);
        graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/deleteFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> deleteFiscalYearFinancialAid(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
        GraduatedInformation graduatedInformation = fiscalYearFinancialAidServiceV1.doService(reqBody);
        graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }

}
