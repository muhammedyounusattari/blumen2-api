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


    @GetMapping(path = "/{orgId}/securityQuestions1",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createSecurityQuestions1(@PathVariable("orgId") String orgId){

        List<SecurityQuestionsList> securityQuestionsList = new ArrayList<SecurityQuestionsList>();
        securityQuestionsList.add( new SecurityQuestionsList(1l,"What is your pet's name"));
        securityQuestionsList.add( new SecurityQuestionsList(2l,"What is your date of birth"));
        securityQuestionsList.add( new SecurityQuestionsList(3l,"Which city were you born in"));
        securityQuestionsList.add( new SecurityQuestionsList(4l,"What make was your first car"));
        securityQuestionsList.add( new SecurityQuestionsList(5l,"What is your favorite sports team"));
        securityQuestionsList.add( new SecurityQuestionsList(6l,"SQ 1-1"));
        securityQuestionsList.add( new SecurityQuestionsList(7l,"SQ 1-2"));
        securityQuestionsList.add( new SecurityQuestionsList(8l,"SQ 1-3"));
        securityQuestionsList.add( new SecurityQuestionsList(9l,"SQ 1-4"));
        securityQuestionsList.add( new SecurityQuestionsList(10l,"SQ 1-5"));

        //statusMap.put("body",securityQuestionsList);
        Map<String,Object> map = new HashMap<>();
        map.put("body", securityQuestionsList);
        map.put("status", "200");
        return new ResponseEntity(map,null, HttpStatus.OK);

    }

    @GetMapping(path = "/{orgId}/securityQuestions2",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createSecurityQuestions2(@PathVariable("orgId") String orgId){
        List<SecurityQuestionsList> securityQuestionsList = new ArrayList<SecurityQuestionsList>();
        securityQuestionsList.add( new SecurityQuestionsList(1l,"what is your fav food"));
        securityQuestionsList.add( new SecurityQuestionsList(2l,"which city you were born in"));
        securityQuestionsList.add( new SecurityQuestionsList(3l,"What is your pet's name"));
        securityQuestionsList.add( new SecurityQuestionsList(4l,"favorite nfl team"));
        securityQuestionsList.add( new SecurityQuestionsList(5l,"What is your favorite sports team"));
        securityQuestionsList.add( new SecurityQuestionsList(6l,"SQ 2-1"));
        securityQuestionsList.add( new SecurityQuestionsList(7l,"SQ 2-2"));
        securityQuestionsList.add( new SecurityQuestionsList(8l,"SQ 2-3"));
        securityQuestionsList.add( new SecurityQuestionsList(9l,"SQ 2-4"));
        securityQuestionsList.add( new SecurityQuestionsList(10l,"SQ 2-5"));
        securityQuestionsList.add( new SecurityQuestionsList(11l,"SQ 2-5"));

        Map<String,Object> map = new HashMap<>();
        map.put("body", securityQuestionsList);
        map.put("status", "200");
        return new ResponseEntity(map,null, HttpStatus.OK);


    }
}
