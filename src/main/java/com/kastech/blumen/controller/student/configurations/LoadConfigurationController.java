package com.kastech.blumen.controller.student.configurations;

import com.kastech.blumen.controller.customize.PullDownListController;
import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.service.customize.PullDownListServiceV1;
import com.kastech.blumen.service.student.configurations.LoadConfigurationServiceV1;
import com.kastech.blumen.validator.customize.PullDownListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api/load-configuration")
public class LoadConfigurationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadConfigurationController.class);
    @Autowired
    LoadConfigurationServiceV1  loadConfigurationServiceV1;

    @ResponseBody
    @GetMapping(path = "/getStudentDataConfig/v1/{orgType}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OrganizationType> getStudentDataConfig(@PathVariable(name="orgType", required = true) String orgType) {

        return loadConfigurationServiceV1.getConfiguration(orgType);
    }
}
