package com.kastech.blumen.controller.student.logs;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.StudentExamsLog;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.logs.StudentExamsLogRepository;
import com.kastech.blumen.service.student.logs.StudentExamsLogServiceV1;
import com.kastech.blumen.validator.student.logs.StudentExamsLogValidator;
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
public class StudentExamsLogController {


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentExamsLogController.class);

    @Autowired
    StudentExamsLogRepository studentExamsLogRepository;

    @Autowired
    StudentExamsLogServiceV1 studentExamsLogServiceV1;


    @Autowired
    StudentExamsLogValidator studentExamsLogValidator;

    Map<String, StudentExamsLog> studentExamsLogMap = new HashMap<String, StudentExamsLog>();

    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getStudentDataExamsLog/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Student> getStudentDataExamsLog() {
        List<Student> list = new ArrayList<>();
        Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
        items.forEach(list::add);
        return list;
    }


    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogList() {

        return ResponseEntity.ok(studentExamsLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    @ResponseBody
    @PostMapping(path = "/studentExamsLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToStudentExamsLogList(@RequestBody StudentExamsLog studentExamsLog) {
    	studentExamsLogRepository.save(studentExamsLog);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateStudentExamsLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> editStudentExamsLogList(@RequestBody StudentExamsLog studentExamsLog) {
		studentExamsLogRepository.save(studentExamsLog);
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}


  /*  @ResponseBody
    @PutMapping(path = "/filter/studentExamsLoglist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> filterStudentExamsLogList(@RequestBody StudentExamsLog studentExamsLog) {
        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }*/


    @ResponseBody
    @DeleteMapping(path = "/deleteStudentExamsLogList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> deleteStudentExamsLogList(@RequestBody StudentExamsLog studentExamsLog) {

    	studentExamsLogRepository.delete(studentExamsLog);
    	return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

/*
    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByFiscalyear/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByFiscalyear(@RequestBody StudentExamsLog studentExamsLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByActive/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByActive(@RequestBody StudentExamsLog studentExamsLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }


    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByServed/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByServed(@RequestBody StudentExamsLog studentExamsLog) {


        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

    @ResponseBody
    @GetMapping(path = "/getStudentExamsLogByReported/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<StudentExamsLog>> getStudentExamsLogByReported(@RequestBody StudentExamsLog studentExamsLog) {

        return ResponseEntity.status(HttpStatus.OK).body(studentExamsLogRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }*/
}
