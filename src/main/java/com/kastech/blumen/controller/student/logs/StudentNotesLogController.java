package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.StudentAttendanceLog;
import com.kastech.blumen.model.student.logs.StudentNotesLog;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.logs.StudentNotesLogRepository;
import com.kastech.blumen.service.student.logs.StudentNotesLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentNotesLogValidator;
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
public class StudentNotesLogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentNotesLogController.class);

    @Autowired
    StudentNotesLogRepository studentNotesLogRepository;

    @Autowired
    StudentNotesLogServiceV1 studentNotesLogServiceV1;


    @Autowired
    StudentNotesLogValidator studentNotesLogValidator;

    Map<String, StudentNotesLog> studentNotesLogMap = new HashMap<String, StudentNotesLog>();

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDataNotesLog/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentDataNotesLog() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<StudentNotesLog> getStudentNotesLogList() {
        List<StudentNotesLog> list = new ArrayList<>();
        Iterable<StudentNotesLog> items = studentNotesLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/studentNotesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StudentNotesLog addToStudentNotesLogList(@RequestBody StudentNotesLog studentNotesLog) {
     //   StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        return studentNotesLogServiceV1.addStudentNotesLog(studentNotesLog);

    }

    @ResponseBody
    @PutMapping(path = "/updateStudentNotesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<StudentNotesLog> editStudentNotesLogList(@RequestBody StudentNotesLog studentNotesLog) {
    //    StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        return studentNotesLogServiceV1.editStudentNotesLogList(studentNotesLog);
    }


    @ResponseBody
    @PutMapping(path = "/filter/studentNotesLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterStudentNotesLogList(@RequestBody StudentNotesLog studentNotesLog) {
     //   StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentNotesLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudentNotesLogList(@RequestBody StudentNotesLog studentNotesLog) {

      //  StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
      //  studentNotesLogMap.remove(studentNotesLog.getSsno());
        studentNotesLogRepository.delete(studentNotesLog);

        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByFiscalyear(@RequestBody StudentNotesLog studentNotesLog) {

     //   StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByActive(@RequestBody StudentNotesLog studentNotesLog) {

     //   StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByServed(@RequestBody StudentNotesLog studentNotesLog) {

       // StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }

    @ResponseBody
    @GetMapping(path = "/getStudentNotesLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentNotesLog>> getStudentNotesLogByReported(@RequestBody StudentNotesLog studentNotesLog) {

    //    StudentNotesLog studentNotesLog = studentNotesLogServiceV1.doService(reqBody);
        studentNotesLogMap.remove(studentNotesLog.getSsno());

        return ResponseEntity.status(HttpStatus.OK).body(studentNotesLogMap.values());
    }
}
