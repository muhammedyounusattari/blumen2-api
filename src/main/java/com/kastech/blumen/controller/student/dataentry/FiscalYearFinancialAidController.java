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

    public void addStudentProfile() {

        AddressNotes addressNotes = new AddressNotes(111L,"BANGALORE","BANGALORER","karnataka","560044","dee@gmail.com","phone1","phone2","www.deepak.com","notes ");
        GraduatedInformation graduatedInformation = new GraduatedInformation(111l,"firstname","secondname","trrarck","graduated","counselor","phole1","major","employer","ma","engineer","militiry","completed","fulltime","2021",addressNotes);

        Student studentOne = new Student(111-234-333l,"11", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017",graduatedInformation);
        studentList.add(studentOne);
        studentMap.put(studentOne.getSsno(), studentOne);

        Student studentTwo = new Student(222-234-333l,"22", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017",graduatedInformation);
        studentList.add(studentTwo);
        studentMap.put(studentTwo.getSsno(), studentTwo);

        Student studentThree = new Student(333-234-333l,"33", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017",graduatedInformation);
        studentList.add(studentThree);
        studentMap.put(studentThree.getSsno(), studentThree);

        Student studentFour = new Student(444-234-333l,"44", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018",graduatedInformation);
        studentList.add(studentFour);
        studentMap.put(studentFour.getSsno(), studentFour);

        Student studentFive = new Student(555-234-333l,"55", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018",graduatedInformation);
        studentList.add(studentFive);
        studentMap.put(studentFive.getSsno(), studentFive);
    }

    @ResponseBody
    @PostMapping(path = "/newFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> newFiscalYearFinancialAid(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
     //   GraduatedInformation graduatedInformation = fiscalYearFinancialAidServiceV1.doService(reqBody);
        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();

        return fiscalYearFinancialAidRepository.findById(graduatedInformation1.getSsno())
                .map(oldItem -> {
                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation);
                    return fiscalYearFinancialAidRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/editFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GraduatedInformation> editFiscalYearFinancialAid(@RequestBody GraduatedInformation graduatedInformation, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
      //  GraduatedInformation graduatedInformation = fiscalYearFinancialAidServiceV1.doService(reqBody);
       /* graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());*/

        Optional<Student> student = studentRepository.findById(Long.parseLong(studentSsno));
        GraduatedInformation graduatedInformation1 = student.get().getGraduatedInformation();

        return fiscalYearFinancialAidRepository.findById(graduatedInformation1.getSsno())
                .map(oldItem -> {
                    GraduatedInformation updated = oldItem.updateWith(graduatedInformation);
                    return fiscalYearFinancialAidRepository.save(updated);
                });
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteFiscalYearFinancialAid/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteFiscalYearFinancialAid(@RequestBody GraduatedInformation graduatedInformation) {
        addStudentProfile();
     //   GraduatedInformation graduatedInformation = fiscalYearFinancialAidServiceV1.doService(reqBody);
        fiscalYearFinancialAidRepository.delete(graduatedInformation);
        return ResponseEntity.ok("Deleted Successfully");
    }

}
