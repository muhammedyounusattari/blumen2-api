package com.kastech.blumen.controller.teacher;

import com.google.gson.Gson;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.teacher.Teacher;
import com.kastech.blumen.repository.teacher.TeacherRepository;
import com.kastech.blumen.service.teacher.TeacherServiceV1;
import com.kastech.blumen.validator.teacher.TeacherValidator;
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
@RequestMapping("/api/blumen-api/teacher")
public class TeacherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherServiceV1 teacherServiceV1;


    @Autowired
    TeacherValidator teacherValidator;

    Map<String, Teacher> teacherMap = new HashMap<String, Teacher>();

    @ResponseBody
    @GetMapping(path = "/getTeacherList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Teacher>> getTeacherList() {
    	
        return ResponseEntity.ok(teacherRepository.findAll());
    }

	@ResponseBody
	@PostMapping(path = "/teacherList/v1", 
			consumes = { MediaType.APPLICATION_JSON_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToTeacherList(@RequestBody Teacher teacher) {

		teacher = teacherRepository.save(teacher);
		if (teacher != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

    @ResponseBody
    @PutMapping(path = "/updateTeacherList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editTeacherList(@RequestBody Teacher teacher) {
        teacher = teacherRepository.save(teacher);
		if (teacher != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/teacherlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterTeacherList(@RequestBody Teacher teacher) {
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson(teacherRepository.findById(teacher.getId())));
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteTeacherList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Teacher>> deleteTeacherList(@RequestBody Teacher teacher) {

        teacherRepository.delete(teacher);

        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
}
