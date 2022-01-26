package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentCounselorContact;
import com.kastech.blumen.model.student.contacts.StudentDispCouContRemin;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentCounselorContactRepository;
import com.kastech.blumen.repository.student.contacts.StudentDispCouContReminRepository;
import com.kastech.blumen.service.student.contacts.StudentDispCouContReminServiceV1;
import com.kastech.blumen.utility.DateUtil;
import com.kastech.blumen.validator.student.contacts.StudentDispCouContReminValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentDispCouContReminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispCouContReminController.class);

    @Autowired
    StudentDispCouContReminRepository studentDispCouContReminRepository;

    @Autowired
    StudentCounselorContactRepository studentCounselorContactRepository;

    @Autowired
    StudentDispCouContReminServiceV1 studentDispCouContReminServiceV1;


    @Autowired
    StudentDispCouContReminValidator studentDispCouContReminValidator;

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContRemin/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Student> getStudentDispCouContRemin() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentCounselorContact>> getStudentDispCouContReminList() {
        List<StudentCounselorContact> studentDispCouContReminList = studentCounselorContactRepository.findAll();

        List<StudentCounselorContact> studentDispCouContReminListData = new ArrayList<StudentCounselorContact>();
        for (StudentCounselorContact studentDispCouContRemin : studentDispCouContReminList) {
            String contactDate = studentDispCouContRemin.getStaffContactDate();
            String isRecontactDate = studentDispCouContRemin.getStaffRecontactDate();

            //if contact date is greater than todays date then it is a reminder

            if ((null != contactDate && !contactDate.isEmpty()) || studentDispCouContRemin.isStaffRecontacted()) {
                String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                if (DateUtil.compareTwoDates(contactDate, todayDate)) {
                    studentDispCouContRemin.setReminder(true);
                    studentDispCouContReminListData.add(studentDispCouContRemin);
                }
            }

        }

        return ResponseEntity.ok(studentDispCouContReminListData);
    }

    @ResponseBody
    @PostMapping(path = "/studentDispCouContReminList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentDispCouContReminList(@RequestBody StudentCounselorContact studentDispCouContRemin) {
        studentDispCouContRemin = studentCounselorContactRepository.save(studentDispCouContRemin);
        if (studentDispCouContRemin != null)
            return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
        else
            return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentDispCouContReminList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editStudentDispCouContReminList(@RequestBody StudentDispCouContRemin studentDispCouContRemin) {
        studentDispCouContRemin = studentDispCouContReminRepository.save(studentDispCouContRemin);
        if (studentDispCouContRemin != null)
            return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
        else
            return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }


    /*@ResponseBody
    @PutMapping(path = "/filter/studentDispCouContReminlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> filterStudentDispCouContReminList(@RequestBody String reqBody) {
        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }*/


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentDispCouContReminList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudentDispCouContReminList(@RequestBody StudentDispCouContRemin studentDispCouContRemin) {
        studentDispCouContReminRepository.delete(studentDispCouContRemin);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


   /* @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByFiscalyear(@RequestBody String reqBody) {

        return ResponseEntity.ok(studentDispCouContReminRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByActive(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByServed(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispCouContReminByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispCouContRemin>> getStudentDispCouContReminByReported(@RequestBody String reqBody) {

        StudentDispCouContRemin studentDispCouContRemin = studentDispCouContReminServiceV1.doService(reqBody);
        return ResponseEntity.ok(studentDispCouContReminRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }*/
}
