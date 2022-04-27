package com.kastech.blumen.controller.utilities.home;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
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

    Map<Long, Student> studentMap = new HashMap<Long, Student>();

    @ResponseBody
    @GetMapping(path = "/searchStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> searchStudentList() {
        return ResponseEntity.ok(studentList);
    }

    @ResponseBody
    @GetMapping(path = "/changeSsnoToNewSsno/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> changeSsnoToNewSsno(@RequestParam("old_ssno") String oldSsno, @RequestParam("new_ssno") String newSsno) {
        /*if (!(oldSsno.isEmpty() && newSsno.isEmpty())) {
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getSsno().equals(oldSsno)) {
                    studentList.get(i).setSsno(Long.parseLong(newSsno));
                }
            }
        }*/
        return ResponseEntity.status(HttpStatus.OK).body("S.S.No has been changed successfully");
    }


}
