package com.kastech.blumen.controller.student.contacts;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentTutorContacts;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentTutorContactsRepository;
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
import com.kastech.blumen.service.student.contacts.StudentDispTutorContReminderServiceV1;
import com.kastech.blumen.validator.student.contacts.StudentDispTutorContReminderValidator;

@RestController
@RequestMapping("/api/blumen-api/student-contacts")
public class StudentDispTutorContReminderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispTutorContReminderController.class);

	@Autowired
	StudentTutorContactsRepository studentTutorContactsRepository;

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
	public ResponseEntity<Collection<StudentTutorContacts>> getStudentDispTutorContReminderList() {

		List<StudentTutorContacts> items = studentTutorContactsRepository.findAll();

		List<StudentTutorContacts> studentDispTutorContReminderList = new ArrayList<StudentTutorContacts>();
		for (StudentTutorContacts studentDispTutorContReminder : items) {
			String contactDate = studentDispTutorContReminder.getStaffContactDate();
			String isRecontactDate = studentDispTutorContReminder.getStaffRecontactDate();

			//if contact date is greater than todays date then it is a reminder

			if ((null != contactDate && !contactDate.isEmpty()) || studentDispTutorContReminder.isStaffRecontacted()) {
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


}
