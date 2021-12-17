package com.kastech.blumen.controller.utilities.home;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.utilities.home.ChangeSSNORepository;
import com.kastech.blumen.service.utilities.home.ChangeSSNOServiceV1;
import com.kastech.blumen.validator.utilities.home.ChangeSSNOValidator;
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
public class ChangeSSNOController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChangeSSNOController.class);

    ChangeSSNORepository changeSSNORepository;

    @Autowired
    ChangeSSNOServiceV1 changeSSNOServiceV1;


    @Autowired
    ChangeSSNOValidator changeSSNOValidator;

    List<Student> studentList = new ArrayList<>();

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
    @GetMapping(path = "/searchStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> searchStudentList() {
        addStudentProfile();
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/changeSsnoToNewSsno/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> changeSsnoToNewSsno(@RequestParam("old_ssno") String oldSsno, @RequestParam("new_ssno") String newSsno) {
        if (!(oldSsno.isEmpty() && newSsno.isEmpty())) {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getSsno().equals(oldSsno)) {
                    studentList.get(i).setSsno(newSsno);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("S.S.No has been changed successfully");
    }


}