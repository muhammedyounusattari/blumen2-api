package com.kastech.blumen.controller.utilities.addto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.utilities.FiscalGraduatedYearRequest;
import com.kastech.blumen.model.utilities.GraduatedInfoAddressNotesRequest;
import com.kastech.blumen.repository.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.service.utilities.addto.GraduatedListServiceV1;
import com.kastech.blumen.validator.utilities.addto.GraduatedListValidator;

@RestController
@RequestMapping("/api/blumen-api/utilities/addto")
public class GraduatedListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraduatedListController.class);

    @Autowired
    GraduatedListServiceV1 graduatedListServiceV1;

    @Autowired
    GraduatedListValidator graduatedListValidator;

    @Autowired
    StudentRepository studentRepository;

    @ResponseBody
    @GetMapping(path = "/getGraduatedList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> getGraduatedList() {
        return ResponseEntity.ok(graduatedListServiceV1.getGraduatedList());
    }

    /*@ResponseBody
    @GetMapping(path = "/getAllStudentsByFiscalYearForGraduatedList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> getAllStudentsByFiscalYearForGraduatedList(@RequestParam("fiscalYear") String fiscalYear) {
        List<Student> studentList = studentRepository.findAllStudentbyFiscalYear(fiscalYear);

        return ResponseEntity.ok(studentList);
    }*/

    @ResponseBody
    @PostMapping(path = "/moveSelectedStudentListFromFiscalYearToGraduatedYear/v1",consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Student>> moveSelectedStudentListFromFiscalYearToGraduatedYear(@RequestBody FiscalGraduatedYearRequest fiscalGraduatedYearRequest) {
        List<String> ssnoList = null;
        String graduatedYear = null;
        if (null != fiscalGraduatedYearRequest) {
            graduatedYear = fiscalGraduatedYearRequest.getFiscalYear();
            ssnoList = fiscalGraduatedYearRequest.getSsnoList();
            LOGGER.info("Students to be moved to fiscal year " + fiscalGraduatedYearRequest.getFiscalYear());
            LOGGER.info("no of received students received to move to Graduated year " + ssnoList.size());
            List<Student> studentsListObj = new ArrayList<>();
            if (!ssnoList.isEmpty()) {

                for (String ssno : ssnoList) {
                    Optional<Student> studentObj = studentRepository.findById(Long.parseLong(ssno));
//                    if (null != studentObj.get() && null != studentObj.get().getGraduatedInformation()) {
//                        studentObj.get().getGraduatedInformation().setGraduatedYear(graduatedYear);
//                    }
                    studentsListObj.add(studentObj.get());
                }
            }
            studentRepository.saveAll(studentsListObj);
        }

        return new ResponseEntity(new Response(200, ssnoList.size() + " no of Students are added to the Graduated year " + graduatedYear), null, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/updateGraduatedEntryForStudent/v1",consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateGraduatedEntryForStudent(@RequestBody GraduatedInfoAddressNotesRequest graduatedInfoAddressNotesRequest) {
        String ssno = graduatedInfoAddressNotesRequest.getSsno();
        String studentName = graduatedInfoAddressNotesRequest.getStudentName();
        GraduatedInformation graduatedInformation = graduatedInfoAddressNotesRequest.getGraduatedInformation();
        AddressNotes addressNotes = graduatedInfoAddressNotesRequest.getAddressNotes();

        Optional<Student> studentObj = studentRepository.findById(Long.parseLong(ssno));

        Student student = studentObj.get();
        graduatedInformation.setAddressNotes(addressNotes);
//        student.setGraduatedInformation(graduatedInformation);


        ResponseEntity<String> responseEntity = null;
        if (null != studentObj) {
            studentRepository.save(student);
            responseEntity = new ResponseEntity(new Response(200, " GraduatedInfo and AddressNotes updated for the given ssno " + ssno), null, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity(new Response(200, " no student found for the given ssno " + ssno), null, HttpStatus.OK);
        }

        return responseEntity;

    }


    //list of student
    //graduated year

   /* @ResponseBody
    @GetMapping(path = "/moveAllStudentsByGraduatedYear/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> moveAllStudentsByGraduatedYear(@RequestParam("fiscalYear") String fiscalYear) {
        return ResponseEntity.ok(graduatedListServiceV1.getGraduatedList());
    }
    
    @ResponseBody
	@PostMapping(path = "/graduatedList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<GraduatedInformation> createGraduatedList(@RequestBody GraduatedInformation graduatedInformation) {
    	graduatedInformation = graduatedListServiceV1.save(graduatedInformation);
		if (graduatedInformation != null)
			return ResponseEntity.ok(graduatedInformation);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/graduatedList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> updateGraduatedList(@RequestBody GraduatedInformation graduatedInformation) {
    	graduatedInformation = graduatedListServiceV1.save(graduatedInformation);
		if (graduatedInformation != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}
	
	@ResponseBody
	@DeleteMapping(path = "/graduatedList/v1", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteGraduatedList(@RequestBody Long id) {
		graduatedListServiceV1.deleteById(id);
		return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
	}*/

}
