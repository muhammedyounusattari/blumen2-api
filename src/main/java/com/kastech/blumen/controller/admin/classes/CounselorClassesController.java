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

import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.service.admin.classes.CounselorClassesService;

@RestController
@RequestMapping("/api/blumen-api/admin/classes")
public class CounselorClassesController {

	@Autowired
	private CounselorClassesService counselorClassesService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getCounselorClassess/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<CounselorClasses>> getCounselorClassesList() {
		LOGGER.info("call received for getCounselorClassesList under CounselorClassesController");
		return ResponseEntity.ok(counselorClassesService.getCounselorClassesList());
	}

	@ResponseBody
	@GetMapping(path = "/getCounselorClassessByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<CounselorClasses>> getCouncellorContactsByNormalFilter(
			
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("counselor") String counselor, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getCounselorClassessByNormalFilter under CounselorClassesController");
		return ResponseEntity.ok(counselorClassesService.getCounselorClassesByNormalFilter( fiscalYear,
				active, served, reported, counselor, status, ethnicity, standing, school, eligibility, gender));
	}

	@ResponseBody
	@GetMapping(path = "/getCounselorClassessByAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<CounselorClasses>> getCouncellorContactsByAdvanceFilter(
			@RequestParam("contactDateFrom") String contactDateFrom, @RequestParam("contactDateTo") String contactDateTo,
			@RequestParam("reContactedDateFrom") String reContactedDateFrom, @RequestParam("reContactedDateTo") String reContactedDateTo,
			@RequestParam("councellorContact") String councellorContact, @RequestParam("contactType") String contactType,
			
			@RequestParam("reContacted") String reContacted) {
		LOGGER.info("call received for getCounselorClassessByAdvanceFilter under CounselorClassesController");
		return ResponseEntity.ok(counselorClassesService.getCounselorClassesByAdvanceFilter(contactDateFrom, contactDateTo,
				reContactedDateFrom, reContactedDateTo, councellorContact, contactType, reContacted));
	}
	
	@ResponseBody
	@GetMapping(path = "/getCounselorClassessByMoreFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<CounselorClasses>> getCouncellorContactsByMoreFilter(
			@RequestParam("collegeReady") String collegeReady, @RequestParam("advisor") String advisor,
			@RequestParam("codes") String codes, @RequestParam("tutor") String tutor,
			@RequestParam("entryDateFrom") String entryDateFrom, @RequestParam("entrySchool") String entrySchool,
			@RequestParam("collegeType") String collegeType, @RequestParam("collegeName") String collegeName,
			@RequestParam("entryDateTo") String entryDateTo, @RequestParam("gpaEntry") String gpaEntry,
			@RequestParam("gpaStart") String gpaStart, @RequestParam("gpaEnd") String gpaEnd) {
		LOGGER.info("call received for getCounselorClassessByAdvanceFilter under CounselorClassesController");
		return ResponseEntity.ok(counselorClassesService.getCounselorClassesByMoreFilter(collegeReady, advisor, codes, tutor,
				entryDateFrom, entrySchool, collegeType, collegeName, entryDateTo, gpaEntry, gpaStart, gpaEnd));
	}

	@ResponseBody
	@GetMapping(path = "/getCounselorClassessByMoreAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<CounselorClasses>> getCouncellorContactsByMoreAdvanceFilter(
			@RequestParam("zipCode") String zipCode, @RequestParam("major") String major,
			@RequestParam("siteLocation") String siteLocation, @RequestParam("incomeSource") String incomeSource,
			@RequestParam("entryCollege") String entryCollege, @RequestParam("cohortYear") String cohortYear) {
		LOGGER.info("call received for getCounselorClassessByMoreFilter under CounselorClassesController");
		return ResponseEntity.ok(counselorClassesService.getCounselorClassesByMoreAdvanceFilter(zipCode, major, siteLocation,
				incomeSource, entryCollege, cohortYear));
	}


}