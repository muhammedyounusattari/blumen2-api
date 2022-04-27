package com.kastech.blumen.controller.admin.classes;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.repository.tutor.TutorClassRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.service.admin.classes.TutorClassesService;

@RestController
@RequestMapping("/api/blumen-api/admin/classes")
public class TutorClassesController {

	@Autowired
	TutorClassRepository tutorClassRepository;

	@Autowired
	private TutorClassesService tutorClassesService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getTutorClassess/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	//@Secured("Tutor Contact Data")
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesList() {
		LOGGER.info("call received for getTutorClassesList under StudentTutorClassesController");
		return ResponseEntity.ok(tutorClassesService.getTutorClassesList());
	}

	@ResponseBody
	@GetMapping(path = "/getTutorClassessSearch/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesSearch(@RequestParam(value = "search") String search){
		
		
		
		return ResponseEntity.ok(tutorClassesService.getTutorClassesList());
	}
	
	
	@ResponseBody
	@GetMapping(path = "/getTutorClassessByNormalFilter/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<TutorClasses>> getTutorClassesByNormalFilter(
			
			@RequestParam("fiscalYear") String fiscalYear, @RequestParam("active") String active,
			@RequestParam("served") String served, @RequestParam("reported") String reported,
			@RequestParam("Tutor") String Tutor, @RequestParam("status") String status,
			@RequestParam("ethnicity") String ethnicity, @RequestParam("standing") String standing,
			@RequestParam("school") String school, @RequestParam("eligibility") String eligibility,
			@RequestParam("gender") String gender) {
		LOGGER.info("call received for getTutorClassessByNormalFilter under StudentCouncellorContactController");
		return ResponseEntity.ok(tutorClassesService.getTutorClassessByNormalFilter( fiscalYear,
				active, served, reported, Tutor, status, ethnicity, standing, school, eligibility, gender));
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
	@DeleteMapping(path = "/deleteTutorClasses/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> postSystemPreferenceData(@RequestBody TutorClasses tutorClasses) {
		LOGGER.info("Inside postSystemPreferenceData");
		tutorClassesService.deleteTutorClasses(tutorClasses.getId());
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PostMapping(path = "/addToTutorClassesList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToTutorClassesList(@RequestBody TutorClasses tutorClasses) {
		tutorClasses = tutorClassRepository.save(tutorClasses);
		if (tutorClasses != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateTutorClasses/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateTutorClasses(@RequestBody TutorClasses tutorClasses) {
		tutorClasses = tutorClassRepository.save(tutorClasses);
		if (tutorClasses != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
    @GetMapping(path = "/getTutorClass/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TutorClasses getTutorClassId(@PathVariable Long id) {
        return tutorClassesService.findById(id);
    }
	
    
    @ResponseBody
    @GetMapping(path = "/getTutorClass/students/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Student> getStudentList(@PathVariable Long id) {
        return tutorClassesService.getStudents(id);
    }
    
    @ResponseBody
	@PutMapping(path = "/tutorClass/assignStudents/v1/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> assignStudents(@PathVariable Long id,
			@RequestBody Set<Long> studentIds) {
    	tutorClassesService.assignStudents(id, studentIds);
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}
    
    @ResponseBody
	@PostMapping(path = "/tutorClass/bulk/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> bulkClassesUpload(@RequestBody List<TutorClasses> classes) {
    	tutorClassesService.saveAll(classes);
	
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}

}
