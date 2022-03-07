package com.kastech.blumen.controller.admin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.AnnualPerformance;
import com.kastech.blumen.model.ConfigSettings;
import com.kastech.blumen.model.GeneralSetting;
import com.kastech.blumen.model.SystemPreferences;
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
	@GetMapping(path = "/getConfigSettingList/v1/{orgId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<ConfigSettings>> getConfigSettingList(@PathVariable("orgId") String orgId, @RequestParam("user") String user) {
		LOGGER.info("Inside getConfigSettingList orgId {}, name {}", orgId, user);
		return ResponseEntity.ok(bOTFormMgmtService.getConfigSettingList(orgId, user));
	}
	
	@ResponseBody
	@PostMapping(path = "/postConfigSettingList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConfigSettings> postConfigSettingList(@RequestBody ConfigSettings configSettings) {
	   LOGGER.info("Inside getConfigSettingList");
	   return ResponseEntity.ok(bOTFormMgmtService.saveConfigSettings(configSettings));
	}
	
	@ResponseBody
	@GetMapping(path = "/getSystemPreferenceData/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<SystemPreferences>> getSystemPreferenceData() {
		LOGGER.info("Inside getBOTMgmtFormList");
		return ResponseEntity.ok(bOTFormMgmtService.getAllSystemPreferences());
	}
	
	@ResponseBody
	@PostMapping(path = "/postSystemPreferenceData/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SystemPreferences> postSystemPreferenceData(@RequestBody SystemPreferences SystemPreferences) {
		LOGGER.info("Inside postSystemPreferenceData");
		SystemPreferences = bOTFormMgmtService.saveSystemPreferenceData(SystemPreferences);
		return ResponseEntity.ok(SystemPreferences);
	}
}
