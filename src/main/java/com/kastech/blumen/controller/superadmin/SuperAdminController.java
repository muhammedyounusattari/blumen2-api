package com.kastech.blumen.controller.superadmin;


import com.kastech.blumen.model.superadmin.SecurityQuestionsList;
import com.kastech.blumen.service.superadmin.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api/admin")
public class SuperAdminController {

    @Autowired
    private SuperAdminService superAdminService;


    @GetMapping(path = "/{orgCode}/securityQuestions1",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createSecurityQuestions1(@PathVariable("orgCode") String orgCode){

        List<SecurityQuestionsList> securityQuestionsList = superAdminService.getSecurityQuestions(orgCode, "1");
        Map<String,Object> map = new HashMap<>();
        map.put("body", securityQuestionsList);
        map.put("status", "200");
        return new ResponseEntity(map,null, HttpStatus.OK);

    }

    @GetMapping(path = "/{orgCode}/securityQuestions2",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createSecurityQuestions2(@PathVariable("orgCode") String orgCode){
        List<SecurityQuestionsList> securityQuestionsList = superAdminService.getSecurityQuestions(orgCode, "2");

        Map<String,Object> map = new HashMap<>();
        map.put("body", securityQuestionsList);
        map.put("status", "200");
        return new ResponseEntity(map,null, HttpStatus.OK);
    }

    @GetMapping(path = "/{orgCode}/securityQuestions/{questionType}",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createSecurityQuestions(@PathVariable("orgCode") String orgCode, @PathVariable("questionType") String questionType){

        List<SecurityQuestionsList> securityQuestionsList = superAdminService.getSecurityQuestions(orgCode, questionType);
        Map<String,Object> map = new HashMap<>();
        map.put("body", securityQuestionsList);
        map.put("status", "200");
        return new ResponseEntity(map,null, HttpStatus.OK);

    }
}
