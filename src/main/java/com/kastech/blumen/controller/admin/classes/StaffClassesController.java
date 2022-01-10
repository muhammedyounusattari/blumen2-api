package com.kastech.blumen.controller.admin.classes;

import java.util.Collection;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.model.admin.TutorClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.repository.admin.StaffClassRepository;
import com.kastech.blumen.service.admin.classes.StaffClassesService;

@RestController
@RequestMapping("/api/blumen-api/admin/classes")
public class StaffClassesController {
	
	@Autowired
	StaffClassRepository staffClassRepository;

	@Autowired
	private StaffClassesService StaffClassesService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getStaffClasses/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StaffClasses>> getStaffClassesList() {
		LOGGER.info("call received for getStaffClassesList under StudentStaffClassesController");
		return ResponseEntity.ok(StaffClassesService.getStaffClassesList());
	}

	@ResponseBody
	@GetMapping(path = "/getStaffClassesByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StaffClasses>> getStaffClassesByNormalFilter(
			
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("Staff") String Staff, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getStaffClassesByNormalFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(StaffClassesService.getStaffClassesByNormalFilter( fiscalYear,
				active, served, reported, Staff, status, ethnicity, standing, school, eligibility, gender));
	}

	@ResponseBody
	@GetMapping(path = "/getStaffClassesByAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StaffClasses>> getStaffClassesByAdvanceFilter(
			@RequestParam("contactDateFrom") String contactDateFrom, @RequestParam("contactDateTo") String contactDateTo,
			@RequestParam("reContactedDateFrom") String reContactedDateFrom, @RequestParam("reContactedDateTo") String reContactedDateTo,
			@RequestParam("councellorContact") String councellorContact, @RequestParam("contactType") String contactType,
			
			@RequestParam("reContacted") String reContacted) {
		LOGGER.info("call received for getStaffClassesByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(StaffClassesService.getStaffClassesByAdvanceFilter(contactDateFrom, contactDateTo,
				reContactedDateFrom, reContactedDateTo, councellorContact, contactType, reContacted));
	}
	
	@ResponseBody
	@GetMapping(path = "/getStaffClassesByMoreFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StaffClasses>> getStaffClassesByMoreFilter(
			@RequestParam("collegeReady") String collegeReady, @RequestParam("advisor") String advisor,
			@RequestParam("codes") String codes, @RequestParam("tutor") String tutor,
			@RequestParam("entryDateFrom") String entryDateFrom, @RequestParam("entrySchool") String entrySchool,
			@RequestParam("collegeType") String collegeType, @RequestParam("collegeName") String collegeName,
			@RequestParam("entryDateTo") String entryDateTo, @RequestParam("gpaEntry") String gpaEntry,
			@RequestParam("gpaStart") String gpaStart, @RequestParam("gpaEnd") String gpaEnd) {
		LOGGER.info("call received for getStaffClassesByAdvanceFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(StaffClassesService.getStaffClassesByMoreFilter(collegeReady, advisor, codes, tutor,
				entryDateFrom, entrySchool, collegeType, collegeName, entryDateTo, gpaEntry, gpaStart, gpaEnd));
	}

	@ResponseBody
	@GetMapping(path = "/getStaffClassesByMoreAdvanceFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<StaffClasses>> getStaffClassesByMoreAdvanceFilter(
			@RequestParam("zipCode") String zipCode, @RequestParam("major") String major,
			@RequestParam("siteLocation") String siteLocation, @RequestParam("incomeSource") String incomeSource,
			@RequestParam("entryCollege") String entryCollege, @RequestParam("cohortYear") String cohortYear) {
		LOGGER.info("call received for getStaffClassesByMoreFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(StaffClassesService.getStaffClassesByMoreAdvanceFilter(zipCode, major, siteLocation,
				incomeSource, entryCollege, cohortYear));
	}

	@ResponseBody
	@PostMapping(path = "/addToStaffClassesList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToStaffClassesList(@RequestBody StaffClasses staffClasses) {
		staffClasses = staffClassRepository.save(staffClasses);
		if (staffClasses != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateStaffClasses/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateStaffClasses(@RequestBody StaffClasses staffClasses) {
		staffClasses = staffClassRepository.save(staffClasses);
		if (staffClasses != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}
	@ResponseBody
	@DeleteMapping(path = "/deleteStaffClasses/v1",  produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteStaffClasses(@RequestBody StaffClasses staffClasses) {
		staffClassRepository.deleteById(staffClasses.getId());
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

	@ResponseBody
    @GetMapping(path = "/getStaffClass/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public StaffClasses getStaffClassId(@PathVariable Long id) {
        return StaffClassesService.findById(id);
    }
	

}
