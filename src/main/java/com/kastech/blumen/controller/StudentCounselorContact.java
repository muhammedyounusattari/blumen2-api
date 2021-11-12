package com.kastech.blumen.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kastech.blumen.model.StudentCouncellorContact;
import com.kastech.blumen.service.StudentCounselorContactService;


@RestController
@RequestMapping("/api/blumen-api/admin")
public class StudentCounselorContact {

	@Autowired
	private StudentCounselorContactService counsellorContactService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getCouncellorContacts/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCouncellorContact>> getCouncellorContactList() {
		LOGGER.info("call received for getCouncellorContactList under StudentCouncellorContactController");
		return ResponseEntity.ok(counsellorContactService.getCouncellorContactList());
	}

	@ResponseBody
	@GetMapping(path = "/getCouncellorContactsByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCouncellorContact>> getCouncellorContactsByNormalFilter(
			
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("counselor") String counselor, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getCouncellorContactsByNormalFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counsellorContactService.getCouncellorContactsByNormalFilter( fiscalYear,
				active, served, reported, counselor, status, ethnicity, standing, school, eligibility, gender));
	}

	@ResponseBody
	@GetMapping(path = "/getCouncellorContactsByAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCouncellorContact>> getCouncellorContactsByAdvanceFilter(
			@RequestParam("contactDateFrom") String contactDateFrom, @RequestParam("contactDateTo") String contactDateTo,
			@RequestParam("reContactedDateFrom") String reContactedDateFrom, @RequestParam("reContactedDateTo") String reContactedDateTo,
			@RequestParam("councellorContact") String councellorContact, @RequestParam("contactType") String contactType,
			
			@RequestParam("reContacted") String reContacted) {
		LOGGER.info("call received for getCouncellorContactsByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counsellorContactService.getCouncellorContactsByAdvanceFilter(contactDateFrom, contactDateTo, 
				reContactedDateFrom, reContactedDateTo, councellorContact, contactType, reContacted));
	}
	
	@ResponseBody
	@GetMapping(path = "/getCouncellorContactsByMoreFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCouncellorContact>> getCouncellorContactsByMoreFilter(
			@RequestParam("collegeReady") String collegeReady, @RequestParam("advisor") String advisor,
			@RequestParam("codes") String codes, @RequestParam("tutor") String tutor,
			@RequestParam("entryDateFrom") String entryDateFrom, @RequestParam("entrySchool") String entrySchool,
			@RequestParam("collegeType") String collegeType, @RequestParam("collegeName") String collegeName,
			@RequestParam("entryDateTo") String entryDateTo, @RequestParam("gpaEntry") String gpaEntry,
			@RequestParam("gpaStart") String gpaStart, @RequestParam("gpaEnd") String gpaEnd) {
		LOGGER.info("call received for getCouncellorContactsByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counsellorContactService.getCouncellorContactsByMoreFilter(collegeReady, advisor, codes, tutor,
				entryDateFrom, entrySchool, collegeType, collegeName, entryDateTo, gpaEntry, gpaStart, gpaEnd));
	}

	@ResponseBody
	@GetMapping(path = "/getCouncellorContactsByMoreAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StudentCouncellorContact>> getCouncellorContactsByMoreAdvanceFilter(
			@RequestParam("zipCode") String zipCode, @RequestParam("major") String major,
			@RequestParam("siteLocation") String siteLocation, @RequestParam("incomeSource") String incomeSource,
			@RequestParam("entryCollege") String entryCollege, @RequestParam("cohortYear") String cohortYear) {
		LOGGER.info("call received for getCouncellorContactsByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(counsellorContactService.getCouncellorContactsByMoreAdvanceFilter(zipCode, major, siteLocation,
				incomeSource, entryCollege, cohortYear));
	}

	@ResponseBody
	@PostMapping(path = "/deleteCouncellorContact/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> postSystemPreferenceData(@RequestParam("CouncellorContactId") String CouncellorContactId) {
		LOGGER.info("Inside postSystemPreferenceData");
		return ResponseEntity.ok(counsellorContactService.deleteCouncellorContact(CouncellorContactId));
	}

}
