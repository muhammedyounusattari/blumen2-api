package com.kastech.blumen.controller.admin;

import com.kastech.blumen.model.SystemPreferences;
import com.kastech.blumen.service.admin.SystemPreferencesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api/admin")
public class SystemPreferencesController {

    @Autowired
    private SystemPreferencesService systemPreferencesService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigSettingController.class);
    private Map<String, ?> successMap = new HashMap();

    @ResponseBody
    @GetMapping(path = "/getSystemPreferenceData/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Collection<SystemPreferences>> getSystemPreferenceData() {
        LOGGER.info("Inside getSystemPreferenceData");
        return ResponseEntity.ok(systemPreferencesService.getAllSystemPreferences());
    }

    @ResponseBody
    @PostMapping(path = "/postSystemPreferenceData/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<SystemPreferences> postSystemPreferenceData(@RequestBody SystemPreferences SystemPreferences) {
        LOGGER.info("Inside postSystemPreferenceData");
        SystemPreferences = systemPreferencesService.saveSystemPreferenceData(SystemPreferences);
        return ResponseEntity.ok(SystemPreferences);
    }
}
