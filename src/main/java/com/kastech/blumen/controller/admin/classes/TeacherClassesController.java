package com.kastech.blumen.controller.admin.classes;

import java.util.Collection;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.repository.teacher.TeacherClassRepository;
import com.kastech.blumen.repository.teacher.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.service.admin.classes.TeacherClassesService;

@RestController
@RequestMapping("/api/blumen-api/admin/classes")
public class TeacherClassesController {

	@Autowired
	private TeacherClassRepository teacherRepository;

	@Autowired
	private TeacherClassesService teacherClassesService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getTeacherClassess/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TeacherClasses>> getTeacherClassesList() {
		LOGGER.info("call received for getTeacherClassesList under StudentTeacherClassesController");
		return ResponseEntity.ok(teacherClassesService.getTeacherClassesList());
	}

	@ResponseBody
	@GetMapping(path = "/getTeacherClassessByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TeacherClasses>> getTeacherClassesByNormalFilter(
			
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("counselor") String counselor, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getTeacherClassessByNormalFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(teacherClassesService.getTeacherClassessByNormalFilter( fiscalYear,
				active, served, reported, counselor, status, ethnicity, standing, school, eligibility, gender));
	}

	@ResponseBody
	@GetMapping(path = "/getTeacherClassessByAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TeacherClasses>> getTeacherClassesByAdvanceFilter(
			@RequestParam("contactDateFrom") String contactDateFrom, @RequestParam("contactDateTo") String contactDateTo,
			@RequestParam("reContactedDateFrom") String reContactedDateFrom, @RequestParam("reContactedDateTo") String reContactedDateTo,
			@RequestParam("councellorContact") String councellorContact, @RequestParam("contactType") String contactType,
			
			@RequestParam("reContacted") String reContacted) {
		LOGGER.info("call received for getTeacherClassessByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(teacherClassesService.getTeacherClassessByAdvanceFilter(contactDateFrom, contactDateTo,
				reContactedDateFrom, reContactedDateTo, councellorContact, contactType, reContacted));
	}
	
	@ResponseBody
	@GetMapping(path = "/getTeacherClassessByMoreFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TeacherClasses>> getCouncellorContactsByMoreFilter(
			@RequestParam("collegeReady") String collegeReady, @RequestParam("advisor") String advisor,
			@RequestParam("codes") String codes, @RequestParam("tutor") String tutor,
			@RequestParam("entryDateFrom") String entryDateFrom, @RequestParam("entrySchool") String entrySchool,
			@RequestParam("collegeType") String collegeType, @RequestParam("collegeName") String collegeName,
			@RequestParam("entryDateTo") String entryDateTo, @RequestParam("gpaEntry") String gpaEntry,
			@RequestParam("gpaStart") String gpaStart, @RequestParam("gpaEnd") String gpaEnd) {
		LOGGER.info("call received for getTeacherClassessByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(teacherClassesService.getTeacherClassessByMoreFilter(collegeReady, advisor, codes, tutor,
				entryDateFrom, entrySchool, collegeType, collegeName, entryDateTo, gpaEntry, gpaStart, gpaEnd));
	}

	@ResponseBody
	@GetMapping(path = "/getTeacherClassessByMoreAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TeacherClasses>> getTeacherClassesByMoreAdvanceFilter(
			@RequestParam("zipCode") String zipCode, @RequestParam("major") String major,
			@RequestParam("siteLocation") String siteLocation, @RequestParam("incomeSource") String incomeSource,
			@RequestParam("entryCollege") String entryCollege, @RequestParam("cohortYear") String cohortYear) {
		LOGGER.info("call received for getTeacherClassessByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(teacherClassesService.getTeacherClassessByMoreAdvanceFilter(zipCode, major, siteLocation,
				incomeSource, entryCollege, cohortYear));
	}

	@ResponseBody
	@PostMapping(path = "/addToTeacherClassesList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToTeacherClassesList(@RequestBody TeacherClasses teacherClasses) {
		teacherClasses = teacherRepository.save(teacherClasses);
		if (teacherClasses != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateTeacherClasses/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateTeacherClasses(@RequestBody TeacherClasses teacherClasses) {
		teacherClasses = teacherRepository.save(teacherClasses);
		if (teacherClasses != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}
	@ResponseBody
	@DeleteMapping(path = "/deleteTeacherClasses/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteTeacherClasses(@RequestBody TeacherClasses teacherClasses) {
		teacherRepository.delete(teacherClasses);
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}


}
