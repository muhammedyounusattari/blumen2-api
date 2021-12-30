package com.kastech.blumen.controller.student.logs;


import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.StudentBotFormSubmissLog;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.logs.StudentBotFormSubmissLogRepository;
import com.kastech.blumen.service.student.logs.StudentBotFormSubmissLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentBotFormSubmissLogValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/student-logs")
public class StudentBotFormSubmissLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentBotFormSubmissLogController.class);

    @Autowired
    StudentBotFormSubmissLogRepository studentBotFormSubmissLogRepository;

    @Autowired
    StudentBotFormSubmissLogServiceV1 studentBotFormSubmissLogServiceV1;


    @Autowired
    StudentBotFormSubmissLogValidator studentBotFormSubmissLogValidator;

    Map<Long, StudentBotFormSubmissLog> studentBotFormSubmissLogMap = new HashMap<Long, StudentBotFormSubmissLog>();

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDataBotFormSubmissLog/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentDataBotFormSubmissLog() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentBotFormSubmissLog/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<StudentBotFormSubmissLog> getStudentBotFormSubmissLogList() {

        List<StudentBotFormSubmissLog> list = new ArrayList<>();
        Iterable<StudentBotFormSubmissLog> items = studentBotFormSubmissLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/studentBotFormSubmissLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentBotFormSubmissLog addToStudentBotFormSubmissLogList(@RequestBody StudentBotFormSubmissLog studentBotFormSubmissLog) {
      //  StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        return studentBotFormSubmissLogRepository.save(studentBotFormSubmissLog);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentBotFormSubmissLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<StudentBotFormSubmissLog> editStudentBotFormSubmissLogList(@RequestBody StudentBotFormSubmissLog studentBotFormSubmissLog) {
     //   StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        return studentBotFormSubmissLogRepository.findById(studentBotFormSubmissLog.getSubmissionId())
                .map(oldItem -> {
                    StudentBotFormSubmissLog updated = oldItem.updateWith(studentBotFormSubmissLog);
                    return studentBotFormSubmissLogRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentBotFormSubmissLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentBotFormSubmissLogList(@RequestBody StudentBotFormSubmissLog studentBotFormSubmissLog) {
     //   StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentBotFormSubmissLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudentBotFormSubmissLogList(@RequestBody StudentBotFormSubmissLog studentBotFormSubmissLog) {

    //    StudentBotFormSubmissLog studentBotFormSubmissLog = studentBotFormSubmissLogServiceV1.doService(reqBody);
        studentBotFormSubmissLogRepository.delete(studentBotFormSubmissLog);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

}
