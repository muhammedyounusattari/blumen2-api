package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.LabSettingPreferences;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.customize.LabSettingPreferencesRepository;
import com.kastech.blumen.service.customize.LabSettingPreferencesServiceV1;
import com.kastech.blumen.validator.customize.LabSettingPreferencesValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class LabSettingPreferencesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LabSettingPreferencesController.class);

    LabSettingPreferencesRepository gradingListRepository;

    @Autowired
    LabSettingPreferencesServiceV1 gradingListServiceV1;


    @Autowired
    LabSettingPreferencesValidator gradingListValidator;

    List<LabSettingPreferences> labSettingPreferencesList = new ArrayList<LabSettingPreferences>();


    @ResponseBody
    @PostMapping(path = "/labSettingPreferences/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToLabSettingPreferences(@RequestBody String reqBody) {
        LabSettingPreferences labSettingPreferences = gradingListServiceV1.doService(reqBody);
        labSettingPreferencesList.add(labSettingPreferences);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


}
