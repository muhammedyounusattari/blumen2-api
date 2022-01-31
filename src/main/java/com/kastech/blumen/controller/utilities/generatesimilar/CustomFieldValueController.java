package com.kastech.blumen.controller.utilities.generatesimilar;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.model.utilities.generatesimilar.CustomFieldValue;
import com.kastech.blumen.repository.utilities.generatesimilar.CustomFieldValueRepository;
import com.kastech.blumen.validator.utilities.generatesimilar.CustomFieldValueValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/utilities/generate-similar")
public class CustomFieldValueController {


    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFieldValueController.class);

    @Autowired
    CustomFieldValueRepository customFieldValueRepository;

    /*@Autowired
    CustomFieldValueServiceV1 customFieldValueServiceV1;*/


    @Autowired
    CustomFieldValueValidator customFieldValueValidator;

    List<Student> studentList = new ArrayList<>();


    public void addStudentProfile() {

        AddressNotes addressNotes = new AddressNotes(111L, "BANGALORE", "BANGALORER", "karnataka", "560044", "dee@gmail.com", "phone1", "phone2", "www.deepak.com", "notes ");
        GraduatedInformation graduatedInformation = new GraduatedInformation(111l,111l, "firstname", "secondname", "trrarck", "graduated", "counselor", "phole1", "major", "employer", "ma", "engineer", "militiry", "completed", "fulltime", "2021", addressNotes);

        Student studentOne = new Student(111 - 234 - 333l, "11", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017", graduatedInformation);
        studentList.add(studentOne);

        Student studentTwo = new Student(222 - 234 - 333l, "22", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017", graduatedInformation);
        studentList.add(studentTwo);
        Student studentThree = new Student(333 - 234 - 333l, "33", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2017", graduatedInformation);
        studentList.add(studentThree);

        Student studentFour = new Student(444 - 234 - 333l, "44", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018", graduatedInformation);
        studentList.add(studentFour);

        Student studentFive = new Student(555 - 234 - 333l, "55", "Craig", "Adams", "2234214", "20-11-2020", "student", "23:02", "20-11-2020", "Yes", "Yes", "Yes", "All", "All", "2018", graduatedInformation);
        studentList.add(studentFive);
    }

    @ResponseBody
    @GetMapping(path = "/getOkToContinueCustomFieldValueList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CustomFieldValue> getOkToContinueCustomFieldValueList() {
        List<CustomFieldValue> list = new ArrayList<>();
        Iterable<CustomFieldValue> items = customFieldValueRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }


    @ResponseBody
    @PostMapping(path = "/clickFinishCustomFieldValueList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomFieldValue clickFinishCustomFieldValueList(@RequestBody CustomFieldValue customFieldValue) {
        return customFieldValueRepository.save(customFieldValue);
    }


    @ResponseBody
    @PostMapping(path = "/addCustomField/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CustomFieldValue addCustomField(@RequestBody CustomFieldValue customFieldValue) {
        return customFieldValueRepository.save(customFieldValue);
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteCustomField/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteCustomField(@RequestBody CustomFieldValue customFieldValue) {
        customFieldValueRepository.delete(customFieldValue);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(path = "/getCustomFieldValueList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CustomFieldValue> getCustomFieldValuesList() {
        List<CustomFieldValue> list = new ArrayList<>();
        Iterable<CustomFieldValue> items = customFieldValueRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }
}
