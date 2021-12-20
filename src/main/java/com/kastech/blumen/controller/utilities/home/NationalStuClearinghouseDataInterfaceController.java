package com.kastech.blumen.controller.utilities.home;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.utilities.home.NationalStuClearinghouseDataInterfaceRepository;
import com.kastech.blumen.service.utilities.home.NationalStuClearinghouseDataInterfaceServiceV1;
import com.kastech.blumen.validator.utilities.home.NationalStuClearinghouseDataInterfaceValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/utilities/home")
public class NationalStuClearinghouseDataInterfaceController {


    private static final Logger LOGGER = LoggerFactory.getLogger(NationalStuClearinghouseDataInterfaceController.class);

    NationalStuClearinghouseDataInterfaceRepository nationalStuClearinghouseDataInterfaceRepository;

    @Autowired
    NationalStuClearinghouseDataInterfaceServiceV1 nationalStuClearinghouseDataInterfaceServiceV1;


    @Autowired
    NationalStuClearinghouseDataInterfaceValidator nationalStuClearinghouseDataInterfaceValidator;

    List<Student> studentList = new ArrayList<>();

    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    Map<String, String> accountTypeList = new HashMap<>();

    public void accountType() {
        accountTypeList.put("S", "Non-Consent Based Request");
        accountTypeList.put("I", "Institute of Higher Education");
    }


    public void addStudentProfile() {

        Student studentOne = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentOne);

        Student studentTwo = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentTwo);
        Student studentThree = new Student(111-234-333l, "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017");
        studentList.add(studentThree);
    }

    @ResponseBody
    @GetMapping(path = "/getOkToContinueNationalStuClearinghouseList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getOkToContinueNationalStuClearinghouseList() {
        addStudentProfile();
        accountType();
        return ResponseEntity.ok(studentList);
    }


    @ResponseBody
    @GetMapping(path = "/clickNextNationalStuClearinghouseList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> clickNextNationalStuClearinghouseList(@RequestParam("account-type") String accountType, @RequestParam("institution-name") String institutionName, @RequestParam("account-number") String accountNumber, @RequestParam("creation-date") String creationDate, @RequestParam("search-begin-date") String searchBeginDate) {

        return ResponseEntity.ok(studentList);
    }


}
