package com.kastech.blumen.controller.utilities.addto;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.utilities.addto.GraduatedListRepository;
import com.kastech.blumen.service.utilities.addto.GraduatedListServiceV1;
import com.kastech.blumen.validator.utilities.addto.GraduatedListValidator;
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
public class GraduatedListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraduatedListController.class);

    GraduatedListRepository graduatedListRepository;

    @Autowired
    GraduatedListServiceV1 graduatedListServiceV1;


    @Autowired
    GraduatedListValidator graduatedListValidator;

    List<Student> studentList = new ArrayList<>();


    public void addStudentProfile() {

        Student studentOne = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentOne);

        Student studentTwo = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentTwo);
        Student studentThree = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentThree);

        Student studentFour = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFour);

        Student studentFive = new Student("111-234-333", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018");
        studentList.add(studentFive);
    }

    @ResponseBody
    @GetMapping(path = "/getGraduatedList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getGraduatedList() {
        addStudentProfile();
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/moveAllStudentsByGraduatedYear/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> moveAllStudentsByGraduatedYear(@RequestParam("fiscalYear") String fiscalYear) {

        for(int i=0;i<studentList.size();i++){
            studentList.get(i).setFiscalYear(fiscalYear);
        }

        return ResponseEntity.ok(studentList);
    }
}
