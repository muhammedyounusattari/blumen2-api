package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.LabSettingPreferences;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.repository.customize.LabSettingPreferencesRepository;
import com.kastech.blumen.service.customize.LabSettingPreferencesServiceV1;
import com.kastech.blumen.utility.SecurityUtil;
import com.kastech.blumen.validator.customize.LabSettingPreferencesValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@PreAuthorize("hasAuthority('Lab Setting Preferences')")
@RestController
@RequestMapping("/api/blumen-api/customize")
public class LabSettingPreferencesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LabSettingPreferencesController.class);

    @Autowired
    LabSettingPreferencesRepository labSettingPreferencesRepository;

    @Autowired
    LabSettingPreferencesServiceV1 labSettingPreferencesServiceV1;


    @Autowired
    LabSettingPreferencesValidator gradingListValidator;

    List<LabSettingPreferences> labSettingPreferencesList = new ArrayList<LabSettingPreferences>();


   /* @ResponseBody
    @PostMapping(path = "/labSettingPreferences/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToLabSettingPreferences(@RequestBody String reqBody) {
        LabSettingPreferences labSettingPreferences = gradingListServiceV1.doService(reqBody);
        labSettingPreferencesList.add(labSettingPreferences);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }*/

    @ResponseBody
    @PostMapping(path = "/labSettingPreferences/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public LabSettingPreferences addToLabSettingPreferences(@RequestBody LabSettingPreferences reqBody) {
       // LabSettingPreferences labSettingPreferences = labSettingPreferencesServiceV1.doService(reqBody);
        long sessionOrgId = SecurityUtil.getUserOrgId();
        reqBody.setOrgId(sessionOrgId);
        if(reqBody.getId() !=null && reqBody.getId() != 0l) {
            reqBody.setModifiedDate(new Date());
            LabSettingPreferences peferences = labSettingPreferencesRepository.save(reqBody);
            peferences.setOrgId(peferences.getOrgId());
            peferences.setCreatedBy(peferences.getCreatedBy());
            peferences.setCreatedDate(peferences.getCreatedDate());
            return labSettingPreferencesRepository.save(peferences);
        }else {
            reqBody.setCreatedDate(new Date());
            LabSettingPreferences setting = labSettingPreferencesRepository.save(reqBody);
            setting.setCreatedBy(setting.getId());
            return labSettingPreferencesRepository.save(setting);
        }
    }

    @ResponseBody
    @GetMapping(path = "/getLabSettingPreferences/v1", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<LabSettingPreferences> getLabSettingPreferences() {
        List<LabSettingPreferences> list = new ArrayList<>();
        //        Iterable<LabSettingPreferences> items = labSettingPreferencesRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
       //        items.forEach(list::add);
        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Iterable<LabSettingPreferences> items = labSettingPreferencesRepository.findByOrgId(sessionOrgId);
        items.forEach(list::add);
        return list;
    }


}
