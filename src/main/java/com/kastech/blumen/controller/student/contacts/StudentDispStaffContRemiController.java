package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentDispCouContRemin;
import com.kastech.blumen.model.student.contacts.StudentDispStaffContReminder;
import com.kastech.blumen.model.student.contacts.StudentStaffContacts;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentDispStaffContRemiRepository;
import com.kastech.blumen.repository.student.contacts.StudentStaffContactsRepository;
import com.kastech.blumen.service.student.contacts.StudentDispStaffContRemiServiceV1;
import com.kastech.blumen.utility.DateUtil;
import com.kastech.blumen.validator.student.contacts.StudentDispStaffContRemiValidator;
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
public class StudentDispStaffContRemiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispStaffContRemiController.class);

    @Autowired
    StudentStaffContactsRepository studentStaffContactsRepository;

    @Autowired
    StudentDispStaffContRemiRepository studentDispStaffContRemiRepository;


    @Autowired
    StudentDispStaffContRemiServiceV1 studentDispStaffContRemiServiceV1;


    @Autowired
    StudentDispStaffContRemiValidator studentDispStaffContRemiValidator;

    @Autowired
    private StudentRepository studentRepository;

    Map<String, StudentDispStaffContReminder> stringStudentDispStaffContReminderMap = new HashMap<String, StudentDispStaffContReminder>();

    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContRemi/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Student> getStudentDispStaffContRemi() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<StudentStaffContacts> getStudentDispStaffContReminderList() {

        List<StudentStaffContacts> list = new ArrayList<>();
        Iterable<StudentStaffContacts> items = studentStaffContactsRepository.findAll();

        List<StudentStaffContacts> studentDispStaffContReminders = new ArrayList<StudentStaffContacts>();
        for (StudentStaffContacts studentDispStaffContReminder : items) {
            String contactDate = studentDispStaffContReminder.getStaffContactDate();
            String isRecontactDate = studentDispStaffContReminder.getStaffRecontactDate();

            //if contact date is greater than todays date then it is a reminder

            if ((null != contactDate && !contactDate.isEmpty())|| studentDispStaffContReminder.isStaffRecontacted()) {
                String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                if (DateUtil.compareTwoDates(contactDate, todayDate)) {
                    studentDispStaffContReminder.setReminder(true);
                    studentDispStaffContReminders.add(studentDispStaffContReminder);
                }
            }

        }

        // items.forEach(list::add);
        return studentDispStaffContReminders;
    }

    @ResponseBody
    @PostMapping(path = "/studentDispStaffContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentDispStaffContReminder addToStudentDispStaffContReminderList(@RequestBody StudentDispStaffContReminder studentDispStaffContReminder) {
        //   StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        return studentDispStaffContRemiRepository.save(studentDispStaffContReminder);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentDispStaffContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<StudentDispStaffContReminder> editStudentDispStaffContReminderList(@RequestBody StudentDispStaffContReminder studentDispStaffContReminder) {
        //   StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);

        return studentDispStaffContRemiRepository.findById(studentDispStaffContReminder.getSsno())
                .map(oldItem -> {
                    StudentDispStaffContReminder updated = oldItem.updateWith(studentDispStaffContReminder);
                    return studentDispStaffContRemiRepository.save(updated);
                });
    }


   /* @ResponseBody
    @PutMapping(path = "/filter/studentDispStaffContReminderlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentDispStaffContReminderList(@RequestBody String reqBody) {
        StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }*/


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentDispStaffContReminderList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteStudentDispStaffContReminderList(@RequestBody StudentDispStaffContReminder studentDispStaffContReminder) {

        //    StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        studentDispStaffContRemiRepository.delete(studentDispStaffContReminder);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


   /* @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderyFiscalyear(@RequestBody StudentDispStaffContReminder studentDispStaffContReminder) {

    //    StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderByActive(@RequestBody StudentDispStaffContReminder studentDispStaffContReminder) {

    //    StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderByServed(@RequestBody StudentDispStaffContReminder studentDispStaffContReminder) {

     //   StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentDispStaffContReminderByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentDispStaffContReminder>> getStudentDispStaffContReminderByReported(@RequestBody StudentDispStaffContReminder studentDispStaffContReminder) {

     //   StudentDispStaffContReminder studentDispStaffContReminder = studentDispStaffContRemiServiceV1.doService(reqBody);
        stringStudentDispStaffContReminderMap.remove(studentDispStaffContReminder.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentDispStaffContReminderMap.values());
    }*/
}
