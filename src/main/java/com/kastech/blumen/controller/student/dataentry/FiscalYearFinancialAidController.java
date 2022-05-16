package com.kastech.blumen.controller.student.dataentry;

import com.kastech.blumen.model.customize.CustomFieldsNameType;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.StudentRepository;
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

    @Autowired
    FiscalYearFinancialAidRepository fiscalYearFinancialAidRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    FiscalYearFinancialAidServiceV1 fiscalYearFinancialAidServiceV1;


    @Autowired
    FiscalYearFinancialAidValidator fiscalYearFinancialAidValidator;


    List<Student> studentList = new ArrayList<>();

    Map<Long, GraduatedInformation> graduatedInformationMap = new HashMap<>();

    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    @ResponseBody
    @PostMapping(path = "/newFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> newFiscalYearFinancialAid(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {

        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
//        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();

        return null;
//        return fiscalYearFinancialAidRepository.findById(graduatedInformation1.getSsno())
//                .map(oldItem -> {
//                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation);
//                    return fiscalYearFinancialAidRepository.save(updated);
//                });
    }


    @ResponseBody
    @PutMapping(path = "/editFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> editFiscalYearFinancialAid(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {

        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
        return null;
//        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();
//
//        return fiscalYearFinancialAidRepository.findById(graduatedInformation1.getSsno())
//                .map(oldItem -> {
//                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation);
//                    return fiscalYearFinancialAidRepository.save(updated);
//                });
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteFiscalYearFinancialAid(@RequestBody GraduatedInformation graduatedInformation) {
        fiscalYearFinancialAidRepository.delete(graduatedInformation);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
