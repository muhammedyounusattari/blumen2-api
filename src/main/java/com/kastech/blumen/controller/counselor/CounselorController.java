package com.kastech.blumen.controller.counselor;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.counselor.Counselor;
import com.kastech.blumen.service.counselor.CounselorServiceV1;
import com.kastech.blumen.validator.counselor.CounselorValidator;

@RestController
@RequestMapping("/api/blumen-api/counselor")
public class CounselorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CounselorController.class);

	@Autowired
	CounselorServiceV1 counselorServiceV1;

	@Autowired
	CounselorValidator counselorValidator;

	@ResponseBody
	@GetMapping(path = "/getCounselorList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<Counselor>> getCounselorList() {

		return ResponseEntity.ok(counselorServiceV1.findAll());
	}

	@ResponseBody
	@PostMapping(path = "/counselorList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addToCounselorList(@RequestBody Counselor counselor) {
		counselor = counselorServiceV1.save(counselor);
		if (counselor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/updateCounselorList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> editCounselorList(@RequestBody Counselor counselor) {
		counselor = counselorServiceV1.save(counselor);
		if (counselor != null)
			return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);

		return new ResponseEntity(new Response(200, "Failed"), null, HttpStatus.OK);
	}

	@ResponseBody
	@PutMapping(path = "/filter/counselorlist/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<Counselor>> filterCounselorList(@RequestBody Counselor counselor) {
		return ResponseEntity.status(HttpStatus.OK).body(counselorServiceV1.findAll());
	}

	@ResponseBody
	@PutMapping(path = "/deleteCounselorList/v1", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> deleteCounselorList(@RequestBody Long id) {
		counselorServiceV1.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}

}
