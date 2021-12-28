package com.kastech.blumen.controller.admin.systemtools;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.StudentProfile;
import com.kastech.blumen.model.student.Asset;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.admin.systemtools.DeleteStudentsRepository;
import com.kastech.blumen.service.admin.systemtools.DeleteStudentsServiceV1;
import com.kastech.blumen.validator.admin.systemtools.DeleteStudentsValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blumen-api/admin/systemtools")
public class DeleteStudentsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteStudentsController.class);

    @Autowired
    DeleteStudentsRepository deleteStudentsRepository;

    @Autowired
    DeleteStudentsServiceV1 deleteStudentsServiceV1;


    @Autowired
    DeleteStudentsValidator deleteStudentsValidator;

    @ResponseBody
    @GetMapping(path = "/getDeleteStudentList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getDeleteStudentList() {
       // addStudentProfile();
        return ResponseEntity.ok(deleteStudentsRepository.findAll());
    }

    @ResponseBody
    @DeleteMapping(path = "/deleteStudentContinue/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> submitDeleteStudentContinue(@RequestBody Long studentId) {

    	Optional<Student> student = deleteStudentsRepository.findById(studentId);
    	
		if(student!=null && student.isPresent()) {
			deleteStudentsRepository.delete(student.get()); 
			return new ResponseEntity(new Response(200, "deleted student with id : " + studentId ), null, HttpStatus.OK);
		}
			
		
//        StudentProfile studentProfile = deleteStudentsServiceV1.doService(reqBody);
//        studentList.clear();
//        int size = studentList.size();
//        for (Student student : studentList) {
//            //put logic here and filter with all the fields from student list
//        }
        return new ResponseEntity(new Response(200, "Cannot delete student with id : " + studentId ), null, HttpStatus.OK);
    }






}
