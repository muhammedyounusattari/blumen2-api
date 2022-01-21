package com.kastech.blumen.controller.utilities.addto;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @ResponseBody
    @GetMapping(path = "/getGraduatedList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GraduatedInformation>> getGraduatedList() {
        return ResponseEntity.ok(graduatedListServiceV1.getGraduatedList());
    }

    @ResponseBody
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
	}
    
}
