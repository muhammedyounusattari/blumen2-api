package com.kastech.blumen.controller.utilities.addto;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.utilities.addto.FiscalYearRepository;
import com.kastech.blumen.service.utilities.addto.FiscalYearServiceV1;
import com.kastech.blumen.validator.utilities.addto.FiscalYearValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/utilities/addto")
public class FiscalYearController {


    private static final Logger LOGGER = LoggerFactory.getLogger(FiscalYearController.class);

    FiscalYearRepository fiscalYearRepository;

    @Autowired
    FiscalYearServiceV1 fiscalYearServiceV1;


    @Autowired
    FiscalYearValidator fiscalYearValidator;

    List<Student> studentList = new ArrayList<>();


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
    @GetMapping(path = "/getFiscalYearList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getFiscalYearList() {
        addStudentProfile();
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/moveAllStudentsByFiscalYear/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> moveAllStudentsByFiscalYear(@RequestParam("fiscalYear") String fiscalYear) {

       for(int i=0;i<studentList.size();i++){
           studentList.get(i).setFiscalYear(fiscalYear);
       }

        return ResponseEntity.ok(studentList);
    }

}
