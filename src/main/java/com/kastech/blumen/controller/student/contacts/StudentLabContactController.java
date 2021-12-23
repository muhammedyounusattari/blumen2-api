package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentLabContact;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentLabContactRepository;
import com.kastech.blumen.service.student.contacts.StudentLabContactService;
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

@RestController
@RequestMapping("/api/blumen-api/admin")
public class StudentLabContactController {

	@Autowired
	private StudentLabContactRepository studentLabContactRepository;

	@Autowired
	private StudentLabContactService labContactService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository studentRepository;

	@ResponseBody
	@GetMapping(path = "/getStudentLabContact/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Student> getStudentLabContact() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> items = studentRepository.findAll();
		items.forEach(list::add);
		return list;
	}

	@ResponseBody
	@GetMapping(path = "/getLabContacts/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<StudentLabContact> getLabContactList() {
		LOGGER.info("call received for getLabContactList under StudentLabContactController");
		List<StudentLabContact> list = new ArrayList<>();
		Iterable<StudentLabContact> items = studentLabContactRepository.findAll();
		items.forEach(list::add);
		return list;
	}

	@ResponseBody
	@GetMapping(path = "/getLabContactsByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentLabContact>> getLabContactsByNormalFilter(
			@RequestParam("checkInFrom") String checkInFrom, @RequestParam("checkInTo") String checkInTo,
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("counselor") String counselor, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getLabContactsByNormalFilter under StudentLabContactController");
		return ResponseEntity.ok(labContactService.getLabContactsByNormalFilter(checkInFrom, checkInTo, fiscalYear,
				active, served, reported, counselor, status, ethnicity, standing, school, eligibility, gender));
	}

	@ResponseBody
	@GetMapping(path = "/getLabContactsByAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentLabContact>> getLabContactsByAdvanceFilter(
			@RequestParam("collegeReady") String collegeReady, @RequestParam("advisor") String advisor,
			@RequestParam("codes") String codes, @RequestParam("tutor") String tutor,
			@RequestParam("entryDateFrom") String entryDateFrom, @RequestParam("entrySchool") String entrySchool,
			@RequestParam("collegeType") String collegeType, @RequestParam("collegeName") String collegeName,
			@RequestParam("entryDateTo") String entryDateTo, @RequestParam("gpaEntry") String gpaEntry,
			@RequestParam("gpaStart") String gpaStart, @RequestParam("gpaEnd") String gpaEnd) {
		LOGGER.info("call received for getLabContactsByAdvanceFilter under StudentLabContactController");
		return ResponseEntity.ok(labContactService.getLabContactsByAdvanceFilter(collegeReady, advisor, codes, tutor,
				entryDateFrom, entrySchool, collegeType, collegeName, entryDateTo, gpaEntry, gpaStart, gpaEnd));
	}

	@ResponseBody
	@GetMapping(path = "/getLabContactsByMoreFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentLabContact>> getLabContactsByMoreFilter(
			@RequestParam("zipCode") String zipCode, @RequestParam("major") String major,
			@RequestParam("siteLocation") String siteLocation, @RequestParam("incomeSource") String incomeSource,
			@RequestParam("entryCollege") String entryCollege, @RequestParam("cohortYear") String cohortYear) {
		LOGGER.info("call received for getLabContactsByMoreFilter under StudentLabContactController");
		return ResponseEntity.ok(labContactService.getLabContactsByMoreFilter(zipCode, major, siteLocation,
				incomeSource, entryCollege, cohortYear));
	}

	@ResponseBody
	@DeleteMapping(path = "/deleteLabContact/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> postSystemPreferenceData(@RequestParam("labContactId") String labContactId) {
		LOGGER.info("Inside postSystemPreferenceData");
		studentLabContactRepository.deleteById(Long.parseLong(labContactId));
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}

}
