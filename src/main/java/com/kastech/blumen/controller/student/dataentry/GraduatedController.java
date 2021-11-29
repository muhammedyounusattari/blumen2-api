package com.kastech.blumen.controller.student.dataentry;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.repository.student.dataentry.GraduatedRepository;
import com.kastech.blumen.service.student.dataentry.GraduatedServiceV1;
import com.kastech.blumen.validator.student.dataentry.GraduatedValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-dataentry")
public class GraduatedController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraduatedController.class);

    GraduatedRepository graduatedRepository;

    @Autowired
    GraduatedServiceV1 graduatedServiceV1;


    @Autowired
    GraduatedValidator graduatedValidator;


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
    @GetMapping(path = "/saveGraduatedInfoForStudent/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> saveGraduatedInfoForStudent(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        addStudentProfile();
        GraduatedInformation graduatedInformation = graduatedServiceV1.doService(reqBody);
        graduatedInformationMap.put(graduatedInformation.getSsno(), graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/saveAddressNotesForStudent/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> saveAddressNotesForStudent(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {

        GraduatedInformation graduatedInformation = graduatedInformationMap.get(studentSsno);
        AddressNotes addressNotes = graduatedServiceV1.doServiceForAddressNotes(reqBody);
        graduatedInformation.setAddressNotes(addressNotes);

        graduatedInformationMap.put(studentSsno, graduatedInformation);

        return ResponseEntity.ok(graduatedInformationMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/editGraduated/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> editGraduated(@RequestBody String reqBody, @RequestParam("student-ssno") String studentSsno) {
        GraduatedInformation graduatedInformation = graduatedInformationMap.get(studentSsno);
        AddressNotes addressNotes = graduatedServiceV1.doServiceForAddressNotes(reqBody);
        graduatedInformation.setAddressNotes(addressNotes);
        graduatedInformationMap.put(studentSsno, graduatedInformation);
        return ResponseEntity.ok(graduatedInformationMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/deleteGraduated/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> deleteGraduated(@RequestParam("student-ssno") String studentSsno) {

        graduatedInformationMap.remove(studentSsno);

        return ResponseEntity.ok(graduatedInformationMap.values());
    }


}
