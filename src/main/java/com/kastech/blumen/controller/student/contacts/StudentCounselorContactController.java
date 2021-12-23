package com.kastech.blumen.controller.student.contacts;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.contacts.StudentCounselorContact;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.contacts.StudentCounselorContactRepository;
import com.kastech.blumen.service.student.contacts.StudentCounselorContactService;
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
public class StudentCounselorContactController {

	@Autowired
	private StudentCounselorContactRepository studentCounselorContactRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentCounselorContactService counselorContactService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getStudentCounselorContact/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Student> getStudentCounselorContact() {
		List<Student> list = new ArrayList<>();
		Iterable<Student> items = studentRepository.findAll();
		items.forEach(list::add);
		return list;
	}


	@ResponseBody
	@GetMapping(path = "/getCounselorContacts/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<StudentCounselorContact> getCounselorContactList() {
		LOGGER.info("call received for getCounselorContactList under StudentCounselorContactController");
		List<StudentCounselorContact> list = new ArrayList<>();
		Iterable<StudentCounselorContact> items = studentCounselorContactRepository.findAll();
		items.forEach(list::add);
		return list;
	}

	@ResponseBody
	@GetMapping(path = "/getCounselorContactsByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCounselorContact>> getCouncellorContactsByNormalFilter(

			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("counselor") String counselor, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getCounselorContactsByNormalFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counselorContactService.getCounselorContactsByNormalFilter( fiscalYear,
				active, served, reported, counselor, status, ethnicity, standing, school, eligibility, gender));
	}

	@ResponseBody
	@GetMapping(path = "/getCounselorContactsByAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCounselorContact>> getCouncellorContactsByAdvanceFilter(
			@RequestParam("contactDateFrom") String contactDateFrom, @RequestParam("contactDateTo") String contactDateTo,
			@RequestParam("reContactedDateFrom") String reContactedDateFrom, @RequestParam("reContactedDateTo") String reContactedDateTo,
			@RequestParam("councellorContact") String councellorContact, @RequestParam("contactType") String contactType,

			@RequestParam("reContacted") String reContacted) {
		LOGGER.info("call received for getCounselorContactsByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counselorContactService.getCounselorContactsByAdvanceFilter(contactDateFrom, contactDateTo,
				reContactedDateFrom, reContactedDateTo, councellorContact, contactType, reContacted));
	}

	@ResponseBody
	@GetMapping(path = "/getCounselorContactsByMoreFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCounselorContact>> getCouncellorContactsByMoreFilter(
			@RequestParam("collegeReady") String collegeReady, @RequestParam("advisor") String advisor,
			@RequestParam("codes") String codes, @RequestParam("tutor") String tutor,
			@RequestParam("entryDateFrom") String entryDateFrom, @RequestParam("entrySchool") String entrySchool,
			@RequestParam("collegeType") String collegeType, @RequestParam("collegeName") String collegeName,
			@RequestParam("entryDateTo") String entryDateTo, @RequestParam("gpaEntry") String gpaEntry,
			@RequestParam("gpaStart") String gpaStart, @RequestParam("gpaEnd") String gpaEnd) {
		LOGGER.info("call received for getCounselorContactsByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counselorContactService.getCounselorContactsByMoreFilter(collegeReady, advisor, codes, tutor,
				entryDateFrom, entrySchool, collegeType, collegeName, entryDateTo, gpaEntry, gpaStart, gpaEnd));
	}

	@ResponseBody
	@GetMapping(path = "/getCounselorContactsByMoreAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCounselorContact>> getCouncellorContactsByMoreAdvanceFilter(
			@RequestParam("zipCode") String zipCode, @RequestParam("major") String major,
			@RequestParam("siteLocation") String siteLocation, @RequestParam("incomeSource") String incomeSource,
			@RequestParam("entryCollege") String entryCollege, @RequestParam("cohortYear") String cohortYear) {
		LOGGER.info("call received for getCounselorContactsByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counselorContactService.getCounselorContactsByMoreAdvanceFilter(zipCode, major, siteLocation,
				incomeSource, entryCollege, cohortYear));
	}

	@ResponseBody
	@DeleteMapping(path = "/deleteCounselorContact/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> postSystemPreferenceData(@RequestParam("CouncellorContactId") String CouncellorContactId) {
		LOGGER.info("Inside postSystemPreferenceData");
		studentCounselorContactRepository.deleteById(Long.parseLong(CouncellorContactId));
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}

}
