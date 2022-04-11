package com.kastech.blumen.controller.superadmin;


import com.kastech.blumen.controller.customize.PullDownListController;
import com.kastech.blumen.model.superadmin.SecurityQuestionsList;
import com.kastech.blumen.service.superadmin.SuperAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/admin")
public class SuperAdminController {

    @Autowired
    private SuperAdminService superAdminService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperAdminController.class);

    @GetMapping(path = "/{orgCode}/securityQuestions",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getSecurityQuestions(@PathVariable(value = "orgCode", required = true) Long orgCode){

        LOGGER.info("call made to createSecurityQuestions() under ", this.getClass());

        //validate OrgCode
        Map<String,String> statusMap = superAdminService.validateOrgCode(orgCode);
        if("404".equals(statusMap.get("status"))){
            return failure(statusMap, 404);
        }

        Map<String, List<SecurityQuestionsList>> securityQuestionsMap = new LinkedHashMap<>();
        List<SecurityQuestionsList> securityQuestionsList1 = superAdminService.getSecurityQuestions(orgCode, "1");
        List<SecurityQuestionsList> securityQuestionsList2 = superAdminService.getSecurityQuestions(orgCode, "2");

        securityQuestionsMap.put("question1", securityQuestionsList1);
        securityQuestionsMap.put("question2",securityQuestionsList2);

        Map<String,Object> map = new HashMap<>();
        map.put("body", securityQuestionsMap);
        map.put("status", "200");
        return new ResponseEntity(map,null, HttpStatus.OK);
    }

    @PostMapping(value = "/{orgCode}/addSecurityQuestion", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> addSecurityQuestions(@PathVariable(value="orgCode", required = true) Long orgCode, @RequestBody Map<String, String> requestPaylaod) {
        LOGGER.info("call made to addSecurityQuestions() under ", this.getClass());
        //validate OrgCode
        Map<String,String> statusMap = superAdminService.validateOrgCode(orgCode);
        if("404".equals(statusMap.get("status"))){
            return failure(statusMap, 404);
        }

        return success(superAdminService.addSecurityQuestions(requestPaylaod, 1L), 200);
    }

    private ResponseEntity<?> success(Object t, Integer status ){
        return new ResponseEntity(t,null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, int statusCode){
        return new ResponseEntity(t,null, HttpStatus.valueOf(statusCode));
    }
}
