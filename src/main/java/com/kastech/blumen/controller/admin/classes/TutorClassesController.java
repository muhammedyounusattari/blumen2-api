package com.kastech.blumen.controller.admin.classes;

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

import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.service.admin.classes.TutorClassesService;

@RestController
@RequestMapping("/api/blumen-api/admin")
public class TutorClassesController {

	@Autowired
	private TutorClassesService tutorClassesService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getTutorClassess/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesList() {
		LOGGER.info("call received for getTutorClassesList under StudentTutorClassesController");
		return ResponseEntity.ok(tutorClassesService.getTutorClassesList());
	}

	@ResponseBody
	@GetMapping(path = "/getTutorClassessByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesByNormalFilter(
			
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("counselor") String counselor, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getTutorClassessByNormalFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(tutorClassesService.getTutorClassessByNormalFilter( fiscalYear,
				active, served, reported, counselor, status, ethnicity, standing, school, eligibility, gender));
	}

	@ResponseBody
	@GetMapping(path = "/getTutorClassessByAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesByAdvanceFilter(
			@RequestParam("contactDateFrom") String contactDateFrom, @RequestParam("contactDateTo") String contactDateTo,
			@RequestParam("reContactedDateFrom") String reContactedDateFrom, @RequestParam("reContactedDateTo") String reContactedDateTo,
			@RequestParam("councellorContact") String councellorContact, @RequestParam("contactType") String contactType,
			
			@RequestParam("reContacted") String reContacted) {
		LOGGER.info("call received for getTutorClassessByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(tutorClassesService.getTutorClassessByAdvanceFilter(contactDateFrom, contactDateTo,
				reContactedDateFrom, reContactedDateTo, councellorContact, contactType, reContacted));
	}
	
	@ResponseBody
	@GetMapping(path = "/getTutorClassessByMoreFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesByMoreFilter(
			@RequestParam("collegeReady") String collegeReady, @RequestParam("advisor") String advisor,
			@RequestParam("codes") String codes, @RequestParam("tutor") String tutor,
			@RequestParam("entryDateFrom") String entryDateFrom, @RequestParam("entrySchool") String entrySchool,
			@RequestParam("collegeType") String collegeType, @RequestParam("collegeName") String collegeName,
			@RequestParam("entryDateTo") String entryDateTo, @RequestParam("gpaEntry") String gpaEntry,
			@RequestParam("gpaStart") String gpaStart, @RequestParam("gpaEnd") String gpaEnd) {
		LOGGER.info("call received for getTutorClassessByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(tutorClassesService.getTutorClassessByMoreFilter(collegeReady, advisor, codes, tutor,
				entryDateFrom, entrySchool, collegeType, collegeName, entryDateTo, gpaEntry, gpaStart, gpaEnd));
	}

	@ResponseBody
	@GetMapping(path = "/getTutorClassessByMoreAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesByMoreAdvanceFilter(
			@RequestParam("zipCode") String zipCode, @RequestParam("major") String major,
			@RequestParam("siteLocation") String siteLocation, @RequestParam("incomeSource") String incomeSource,
			@RequestParam("entryCollege") String entryCollege, @RequestParam("cohortYear") String cohortYear) {
		LOGGER.info("call received for getTutorClassessByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(tutorClassesService.getTutorClassessByMoreAdvanceFilter(zipCode, major, siteLocation,
				incomeSource, entryCollege, cohortYear));
	}

	@ResponseBody
	@PostMapping(path = "/deleteTutorClasses/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> postSystemPreferenceData(@RequestParam("CouncellorContactId") String CouncellorContactId) {
		LOGGER.info("Inside postSystemPreferenceData");
		return ResponseEntity.ok(tutorClassesService.deleteTutorClasses(CouncellorContactId));
	}

}
