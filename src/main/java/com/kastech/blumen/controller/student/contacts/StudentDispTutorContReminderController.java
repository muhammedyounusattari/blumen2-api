package com.kastech.blumen.controller.student.contacts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentDispTeacherContRemi;
import com.kastech.blumen.repository.student.StudentRepository;
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
import com.kastech.blumen.model.student.contacts.StudentDispTutorContReminder;
import com.kastech.blumen.repository.student.contacts.StudentDispTutorContReminderRepository;
import com.kastech.blumen.service.student.contacts.StudentDispTutorContReminderServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentDispTutorContReminderValidator;

@RestController
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentDispTutorContReminderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispTutorContReminderController.class);

	@Autowired
	StudentDispTutorContReminderRepository studentDispTutorContReminderRepository;

	@Autowired
	StudentDispTutorContReminderServiceV1 studentDispTutorContReminderServiceV1;

	@Autowired
	StudentDispTutorContReminderValidator studentDispTutorContReminderValidator;

	@Autowired
	private StudentRepository studentRepository;

	@ResponseBody
	@GetMapping(path = "/getStudentDispTutorContReminder/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Student> getStudentDispTutorContReminder() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> items = studentRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
		items.forEach(list::add);
		return list;
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTutorContReminderList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderList() {

		List<StudentDispTutorContReminder> list = new ArrayList<>();
		Iterable<StudentDispTutorContReminder> items = studentDispTutorContReminderRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

		List<StudentDispTutorContReminder> studentDispTutorContReminderList = new ArrayList<StudentDispTutorContReminder>();
		for (StudentDispTutorContReminder studentDispTutorContReminder : items) {
			String contactDate = studentDispTutorContReminder.getContactDate();
			String isRecontactDate = studentDispTutorContReminder.getRecontactDate();

			//if contact date is greater than todays date then it is a reminder

			if ((null != contactDate && !contactDate.isEmpty())) {
				String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				if (DateUtil.compareTwoDates(contactDate, todayDate)) {
					studentDispTutorContReminder.setReminder(true);
					studentDispTutorContReminderList.add(studentDispTutorContReminder);
				}
			}

		}
		//return ResponseEntity.ok(studentDispTutorContReminderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
		return ResponseEntity.ok(studentDispTutorContReminderList);
	}

	@ResponseBody
	@PostMapping(path = "/studentDispTutorContReminderList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToStudentDispTutorContReminderList(@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {
	/*	StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);*/
		studentDispTutorContReminder = studentDispTutorContReminderRepository.save(studentDispTutorContReminder);
		if (studentDispTutorContReminder != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateStudentDispTutorContReminderList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> editStudentDispTutorContReminderList(@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {
		/*StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);*/
		studentDispTutorContReminder = studentDispTutorContReminderRepository.save(studentDispTutorContReminder);
		if (studentDispTutorContReminder != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
		else
			return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	/*@ResponseBody
	@PutMapping(path = "/filter/studentDispTutorContReminderlist/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTutorContReminder>> filterStudentDispTutorContReminderList(
			@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {
		*//*StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);*//*
		return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}*/

	@ResponseBody
	@DeleteMapping(path = "/deleteStudentDispTutorContReminderList/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteStudentDispTutorContReminderList(@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {

		/*StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);*/
		studentDispTutorContReminderRepository.delete(studentDispTutorContReminder);
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

	/*@ResponseBody
	@GetMapping(path = "/getStudentDispTutorContReminderByFiscalyear/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByFiscalyear(
			@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {

		*//*StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);*//*

		return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTutorContReminderByActive/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByActive(
			@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {

		*//*StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);*//*

		return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTutorContReminderByServed/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByServed(
			@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {

		*//*StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);
*//*
		return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}

	@ResponseBody
	@GetMapping(path = "/getStudentDispTutorContReminderByReported/v1", consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentDispTutorContReminder>> getStudentDispTutorContReminderByReported(
			@RequestBody StudentDispTutorContReminder studentDispTutorContReminder) {

		*//*StudentDispTutorContReminder studentDispTutorContReminder = studentDispTutorContReminderServiceV1
				.doService(reqBody);*//*

		return ResponseEntity.status(HttpStatus.OK).body(studentDispTutorContReminderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
	}*/
}
