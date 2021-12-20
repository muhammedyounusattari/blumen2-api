package com.kastech.blumen.controller.utilities.home;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.utilities.home.QuickChangeWizardRepository;
import com.kastech.blumen.service.utilities.home.QuickChangeWizardServiceV1;
import com.kastech.blumen.validator.utilities.home.QuickChangeWizardValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/utilities/home")
public class QuickChangeWizardController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuickChangeWizardController.class);

    QuickChangeWizardRepository quickChangeWizardRepository;

    @Autowired
    QuickChangeWizardServiceV1 quickChangeWizardServiceV1;


    @Autowired
    QuickChangeWizardValidator quickChangeWizardValidator;

    List<Student> studentList = new ArrayList<>();

    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    List<String> list = new ArrayList<>();

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

    public void changeList(){
        list.add("APR 08 - Gender");
        list.add("APR 15 - Eligibility");
        list.add("APR 16 - Academic Needs");
        list.add("APR 19 - Entry Grade Level");
        list.add("APR 21 - Cohert Year");
        list.add("APR 22 - Participant Status");
        list.add("APR 30 - Transfer Status");
    }



    @ResponseBody
    @GetMapping(path = "/getOkToContinueQuickChangeWizardList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getOkToContinueQuickChangeWizardList() {
        addStudentProfile();
        changeList();
        return ResponseEntity.ok(studentList);
    }


    @ResponseBody
    @GetMapping(path = "/clickNextForQuickChangeWizardList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> clickNextForQuickChangeWizardList(@RequestParam("changeFrom") String changeFrom,@RequestParam("fiscalYear") String fiscalYear,@RequestParam("changeTo") String changeTo) {

        return ResponseEntity.status(HttpStatus.OK).body("Total of 1 occurrences changed ");
    }
}
