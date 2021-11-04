package com.kastech.blumen.controller;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.Teacher;
import com.kastech.blumen.repository.TeacherRepository;
import com.kastech.blumen.service.TeacherServiceV1;
import com.kastech.blumen.validator.TeacherValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api")
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

    TeacherRepository collegeSchoolRepository;

    @Autowired
    TeacherServiceV1 teacherServiceV1;


    @Autowired
    TeacherValidator teacherValidator;

    Map<String, Teacher> teacherMap = new HashMap<String, Teacher>();

    @ResponseBody
    @GetMapping(path = "/getTeacherList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Teacher>> getTeacherList() {

        return ResponseEntity.ok(teacherMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/teacherList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToTeacherList(@RequestBody String reqBody) {
        Teacher teacher = teacherServiceV1.doService(reqBody);
        teacherMap.put(teacher.getStaffId(),teacher);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateTeacherList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editTeacherList(@RequestBody String reqBody) {
        Teacher teacher = teacherServiceV1.doService(reqBody);
        teacherMap.put(teacher.getStaffId(),teacher);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/teacherlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterTeacherList(@RequestBody String reqBody) {
        Teacher teacher = teacherServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteTeacherList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Teacher>> deleteTeacherList(@RequestBody String reqBody) {

        Teacher teacher = teacherServiceV1.doService(reqBody);
        teacherMap.remove(teacher.getStaffId());

        return ResponseEntity.status(HttpStatus.OK).body(teacherMap.values());
    }
}
