package com.kastech.blumen.controller.student.contacts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentDispStaffContReminder;
import com.kastech.blumen.model.student.contacts.StudentTeacherContacts;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentTeacherContactsRepository;
import com.kastech.blumen.utility.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.service.student.contacts.StudentTeacherContactsServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentTeacherContactsValidator;

@RestController
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentDispTeacherContRemiController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentTeacherContactsController.class);

	@Autowired
	StudentTeacherContactsRepository studentTeacherContactsRepository;

	@Autowired
	StudentTeacherContactsServiceV1 StudentTeacherContactsServiceV1;

	@Autowired
	StudentTeacherContactsValidator studentTeacherContactsValidator;

	@Autowired
	private StudentRepository studentRepository;

//	@ResponseBody
//	@GetMapping(path = "/getStudentDispTeacherContRemi/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public List<Student> getStudentTeacherContacts() {
//		List<Student> list = new ArrayList<>();
//		Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
//		items.forEach(list::add);
//		return list;
//	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTeacherContRemiList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsList() {

		List<StudentTeacherContacts> list = new ArrayList<>();
		Iterable<StudentTeacherContacts> items = studentTeacherContactsRepository.findAll();

		List<StudentTeacherContacts> StudentTeacherContactsList = new ArrayList<StudentTeacherContacts>();
		for (StudentTeacherContacts studentTeacherContacts : items) {
			String contactDate = studentTeacherContacts.getStaffContactDate();
			String isRecontactDate = studentTeacherContacts.getStaffRecontactDate();

			//if contact date is greater than todays date then it is a reminder

			if ((null != contactDate && !contactDate.isEmpty()) || studentTeacherContacts.isStaffRecontacted()) {
				String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				if (DateUtil.compareTwoDates(contactDate, todayDate)) {
					studentTeacherContacts.setReminder(true);
					StudentTeacherContactsList.add(studentTeacherContacts);
				}
			}

		}

		return ResponseEntity.ok(StudentTeacherContactsList);
		//return ResponseEntity.ok(studentTeacherContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@PostMapping(path = "/studentDispTeacherContRemiList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToStudentTeacherContactsList(@RequestBody String reqBody) {
		StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);
		StudentTeacherContacts = studentTeacherContactsRepository.save(StudentTeacherContacts);
		if (StudentTeacherContacts != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateStudentDispTeacherContRemiList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> editStudentTeacherContactsList(@RequestBody StudentTeacherContacts StudentTeacherContacts) {
		//StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);
		StudentTeacherContacts = studentTeacherContactsRepository.save(StudentTeacherContacts);
		if (StudentTeacherContacts != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	/*@ResponseBody
	@PutMapping(path = "/filter/StudentTeacherContactslist/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentTeacherContacts>> filterStudentTeacherContactsList(
			@RequestBody String reqBody) {
		StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);
		return ResponseEntity.ok(studentTeacherContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}*/

	@ResponseBody
	@DeleteMapping(path = "/deleteStudentDispTeacherContRemiList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteStudentTeacherContactsList(@RequestBody StudentTeacherContacts StudentTeacherContacts) {

	//	StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);
		studentTeacherContactsRepository.delete(StudentTeacherContacts);

		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

/*	@ResponseBody
	@GetMapping(path = "/getStudentTeacherContactsByFiscalyear/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByFiscalyear(
			@RequestBody StudentTeacherContacts StudentTeacherContacts) {

	//	StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);
		return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentTeacherContactsByActive/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByActive(
			@RequestBody StudentTeacherContacts StudentTeacherContacts) {

	//	StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);

		return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentTeacherContactsByServed/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByServed(
			@RequestBody StudentTeacherContacts StudentTeacherContacts) {

	//	StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);

		return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentTeacherContactsByReported/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentTeacherContacts>> getStudentTeacherContactsByReported(
			@RequestBody StudentTeacherContacts StudentTeacherContacts) {

	//	StudentTeacherContacts StudentTeacherContacts = StudentTeacherContactsServiceV1.doService(reqBody);

		return ResponseEntity.status(HttpStatus.OK).body(studentTeacherContactsRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}*/
}
