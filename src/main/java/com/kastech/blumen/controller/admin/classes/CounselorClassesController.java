package com.kastech.blumen.controller.admin.classes;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.StaffClasses;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.CounselorClasses;
import com.kastech.blumen.model.counselor.Counselor;
import com.kastech.blumen.model.student.Student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@ResponseBody
	@PostMapping(path = "/counselorClassesList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToCounselorClassesList(@RequestBody CounselorClasses counselor) {
		counselor = counselorClassesService.saveData(counselor);
		if (counselor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateCounselorClasses/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateCounselorClasses(@RequestBody CounselorClasses counselor) {
		counselor = counselorClassesService.saveData(counselor);
		if (counselor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}
	@ResponseBody
	@DeleteMapping(path = "/deleteCounselorClasses/v1", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteCounselorClasses(@RequestBody CounselorClasses counselor) {
		counselorClassesService.deleteData(counselor.getId());
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

	@ResponseBody
    @GetMapping(path = "/getCounselorClass/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CounselorClasses getCounselorClassId(@PathVariable Long id) {
        return counselorClassesService.findById(id);
    }
	
	@ResponseBody
    @GetMapping(path = "/getCounselorClass/students/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Student> getStudentList(@PathVariable Long id) {
        return counselorClassesService.getStudents(id);
    }
	
	@ResponseBody
	@PutMapping(path = "/counselorClass/assignStudents/v1/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> assignStudents(@PathVariable Long id,
			@RequestBody Set<Long> studentIds) {
		counselorClassesService.assignStudents(id, studentIds);
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PostMapping(path = "/counselorClass/bulk/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> bulkClassesUpload(@RequestBody List<CounselorClasses> classes) {
		counselorClassesService.saveAll(classes);
	
		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}
}
