package com.kastech.blumen.controller.admin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

import com.kastech.blumen.model.AnnualPerformance;
import com.kastech.blumen.model.ConfigSettings;
import com.kastech.blumen.repository.admin.BOTFormMgmtRepository;
import com.kastech.blumen.service.admin.BOTFormMgmtService;

@RestController
@RequestMapping("/api/blumen-api/admin")
public class BOTFormMgmtController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BOTFormMgmtController.class);
	private Map<String, ?> botFormMap = new HashMap();
	

	BOTFormMgmtRepository bOTFormMgmtRepository;

	@Autowired
	BOTFormMgmtService bOTFormMgmtService;

	@ResponseBody
	@GetMapping(path = "/getBotFormList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<?>> getBOTMgmtFormList() {
		LOGGER.info("Inside getBOTMgmtFormList");
		
		return ResponseEntity.ok(bOTFormMgmtService.getBOTMgmtFormList());
	}
	
	@ResponseBody
	@GetMapping(path = "/getConfigSettingList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<ConfigSettings>> getConfigSettingList() {
		LOGGER.info("Inside getConfigSettingList");	
		return ResponseEntity.ok(bOTFormMgmtService.getConfigSettingList());
	}
	
	@ResponseBody
	@PostMapping(path = "/postSystemPreferenceData/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AnnualPerformance> postSystemPreferenceData(@RequestBody AnnualPerformance annualPerformance) {
		LOGGER.info("Inside postSystemPreferenceData");
		annualPerformance = bOTFormMgmtService.saveSystemPreferenceData(annualPerformance);
		return ResponseEntity.ok(annualPerformance);
	}
}
