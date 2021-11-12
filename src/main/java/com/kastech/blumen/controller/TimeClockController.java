package com.kastech.blumen.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kastech.blumen.model.staff.Staff;

@RestController
@RequestMapping("/api/blumen-api")
public class TimeClockController {

	@Autowired
	private TimeClockService timeClockService;

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@ResponseBody
	@GetMapping(path = "/getStaff/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<Staff>> getStaffList() {
		LOGGER.info("call received for getStaffList under TimeClockController");
		return ResponseEntity.ok(timeClockService.getStaffList());
	}
	
	
	@ResponseBody
	@PostMapping(path = "/postStaffTime/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Staff> postSystemPreferenceData(@RequestBody Staff staff) {
		LOGGER.info("Inside postSystemPreferenceData");
		return ResponseEntity.ok(timeClockService.saveOrUpdateStaffTime(staff));
	}

	
}
