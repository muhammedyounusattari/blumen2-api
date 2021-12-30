package com.kastech.blumen.controller.student.contacts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.contacts.StudentDispTeacherContRemi;
import com.kastech.blumen.repository.student.contacts.StudentDispTeacherContRemiRepository;
import com.kastech.blumen.service.student.contacts.StudentDispTeacherContRemiServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentDispTeacherContRemiValidator;

@RestController
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentDispTeacherContRemiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispTeacherContRemiController.class);

	@Autowired
	StudentDispTeacherContRemiRepository studentDispTeacherContRemiRepository;

	@Autowired
	StudentDispTeacherContRemiServiceV1 studentDispTeacherContRemiServiceV1;

	@Autowired
	StudentDispTeacherContRemiValidator studentDispTeacherContRemiValidator;

	@Autowired
	private StudentRepository studentRepository;

	@ResponseBody
	@GetMapping(path = "/getStudentDispTeacherContRemi/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Student> getStudentDispTeacherContRemi() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
		items.forEach(list::add);
		return list;
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTeacherContRemiList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiList() {

		return ResponseEntity.ok(studentDispTeacherContRemiRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@PostMapping(path = "/studentDispTeacherContRemiList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToStudentDispTeacherContRemiList(@RequestBody String reqBody) {
		StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
		studentDispTeacherContRemi = studentDispTeacherContRemiRepository.save(studentDispTeacherContRemi);
		if (studentDispTeacherContRemi != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateStudentDispTeacherContRemiList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> editStudentDispTeacherContRemiList(@RequestBody StudentDispTeacherContRemi studentDispTeacherContRemi) {
		//StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
		studentDispTeacherContRemi = studentDispTeacherContRemiRepository.save(studentDispTeacherContRemi);
		if (studentDispTeacherContRemi != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/filter/studentDispTeacherContRemilist/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTeacherContRemi>> filterStudentDispTeacherContRemiList(
			@RequestBody String reqBody) {
		StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
		return ResponseEntity.ok(studentDispTeacherContRemiRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@DeleteMapping(path = "/deleteStudentDispTeacherContRemiList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteStudentDispTeacherContRemiList(@RequestBody StudentDispTeacherContRemi studentDispTeacherContRemi) {

	//	StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
		studentDispTeacherContRemiRepository.delete(studentDispTeacherContRemi);

		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTeacherContRemiByFiscalyear/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByFiscalyear(
			@RequestBody StudentDispTeacherContRemi studentDispTeacherContRemi) {

	//	StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);
		return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTeacherContRemiByActive/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByActive(
			@RequestBody StudentDispTeacherContRemi studentDispTeacherContRemi) {

	//	StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);

		return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTeacherContRemiByServed/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByServed(
			@RequestBody StudentDispTeacherContRemi studentDispTeacherContRemi) {

	//	StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);

		return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTeacherContRemiByReported/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTeacherContRemi>> getStudentDispTeacherContRemiByReported(
			@RequestBody StudentDispTeacherContRemi studentDispTeacherContRemi) {

	//	StudentDispTeacherContRemi studentDispTeacherContRemi = studentDispTeacherContRemiServiceV1.doService(reqBody);

		return ResponseEntity.status(HttpStatus.OK).body(studentDispTeacherContRemiRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}
}
