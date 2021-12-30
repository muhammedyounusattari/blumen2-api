package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.StudentAttendanceLog;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.logs.StudentAttendanceLogRepository;
import com.kastech.blumen.service.student.logs.StudentAttendanceLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentAttendanceLogValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/blumen-api/student-logs")
public class StudentAttendanceLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAttendanceLogController.class);

    @Autowired
    StudentAttendanceLogRepository studentAttendanceLogRepository;

    @Autowired
    StudentAttendanceLogServiceV1 studentAttendanceLogServiceV1;


    @Autowired
    StudentAttendanceLogValidator studentAttendanceLogValidator;

    Map<String, StudentAttendanceLog> stringStudentAttendanceLogMap = new HashMap<String, StudentAttendanceLog>();

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDataAttendanceLog/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentDataAttendanceLog() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLog/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<StudentAttendanceLog> getStudentAttendanceLogList() {

        List<StudentAttendanceLog> list = new ArrayList<>();
        Iterable<StudentAttendanceLog> items = studentAttendanceLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/studentAttendanceLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentAttendanceLog addToStudentAttendanceLogList(@RequestBody StudentAttendanceLog studentAttendanceLog) {
     //   StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        return studentAttendanceLogServiceV1.addStudentAttendanceLogList(studentAttendanceLog);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentAttendanceLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<StudentAttendanceLog> editStudentAttendanceLogList(@RequestBody StudentAttendanceLog studentAttendanceLog) {
     //   StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        return studentAttendanceLogServiceV1.editStudentAttendanceLogList(studentAttendanceLog);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentAttendanceLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentAttendanceLogList(@RequestBody StudentAttendanceLog studentAttendanceLog) {
     //   StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentAttendanceLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> deleteStudentAttendanceLogList(@RequestBody StudentAttendanceLog studentAttendanceLog) {

      //  StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByFiscalyear(@RequestBody StudentAttendanceLog studentAttendanceLog) {

     //   StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByActive(@RequestBody StudentAttendanceLog studentAttendanceLog) {

    //    StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByServed(@RequestBody StudentAttendanceLog studentAttendanceLog) {

     //   StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentAttendanceLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentAttendanceLog>> getStudentAttendanceLogByReported(@RequestBody StudentAttendanceLog studentAttendanceLog) {

    //    StudentAttendanceLog studentAttendanceLog = studentAttendanceLogServiceV1.doService(reqBody);
        stringStudentAttendanceLogMap.remove(studentAttendanceLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(stringStudentAttendanceLogMap.values());
    }


}
