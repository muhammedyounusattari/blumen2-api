package com.kastech.blumen.controller.admin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.ConfigSettings;
import com.kastech.blumen.model.SystemPreferences;
import com.kastech.blumen.service.admin.ConfigSettingService;

import javax.ws.rs.PathParam;

@RestController
@RequestMapping("/api/blumen-api/admin")
@Deprecated
public class ConfigSettingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigSettingController.class);
	private Map<String, ?> successMap = new HashMap();
	

	//BOTFormMgmtRepository bOTFormMgmtRepository;

	@Autowired
	ConfigSettingService configSettingService;

	@ResponseBody
	@GetMapping(path = "/getBotFormList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<?>> getBOTMgmtFormList() {
		LOGGER.info("Inside getBOTMgmtFormList");
		
		return ResponseEntity.ok(configSettingService.getBOTMgmtFormList());
	}
	
	@ResponseBody
	@GetMapping(path = "/getConfigSettingList/v1/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Collection<ConfigSettings>> getConfigSettingList(@PathVariable("userId") Long userId) {
		LOGGER.info("Inside getConfigSettingList " );
		return ResponseEntity.ok(configSettingService.getConfigSettingList(SecurityUtil.getUserOrgId(), userId));
	}
	
	@ResponseBody
	@PostMapping(path = "/postConfigSettingList/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ConfigSettings> postConfigSettingList(@RequestBody ConfigSettings configSettings) {
	   LOGGER.info("Inside getConfigSettingList");
	   return ResponseEntity.ok(configSettingService.saveConfigSettings(configSettings));
	}
	

}
