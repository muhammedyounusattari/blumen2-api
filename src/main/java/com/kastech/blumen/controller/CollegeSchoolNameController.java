package com.kastech.blumen.controller;

import com.kastech.blumen.model.CollegeSchool;
import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.CollegeSchoolRepository;
import com.kastech.blumen.service.CollegeSchoolServiceV1;
import com.kastech.blumen.utility.RequestAPIType;
import com.kastech.blumen.validator.CollegeSchoolValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api")
public class CollegeSchoolNameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CollegeSchoolNameController.class);

    CollegeSchoolRepository collegeSchoolRepository;

    @Autowired
    CollegeSchoolServiceV1 collegeSchoolServiceV1;


    @Autowired
    CollegeSchoolValidator collegeShoolValidator;

    Map<String, CollegeSchool> schoolCollegeMap = new HashMap<String, CollegeSchool>();

    @ResponseBody
    @GetMapping(path = "/getCollegeSchoolNameList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CollegeSchool>> getCollegeSchoolNameList() {

        return ResponseEntity.ok(schoolCollegeMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/collegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToCollegeSchoolNameList(@RequestBody String reqBody) {
        CollegeSchool pullDown = collegeSchoolServiceV1.doService(reqBody);
        schoolCollegeMap.put(pullDown.getOrgName(),pullDown);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateCollegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editCollegeSchoolNameList(@RequestBody String reqBody) {
        CollegeSchool pullDown = collegeSchoolServiceV1.doService(reqBody);
        schoolCollegeMap.put(pullDown.getOrgName(),pullDown);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/collegeSchoolNamelist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterPullDownList(@RequestBody String reqBody) {
        CollegeSchool pullDown = collegeSchoolServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteCollegeSchoolNameList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<CollegeSchool>> deleteCollegeSchoolNameList(@RequestBody String reqBody) {

        CollegeSchool pullDown = collegeSchoolServiceV1.doService(reqBody);
        schoolCollegeMap.remove(pullDown.getOrgName());

        return ResponseEntity.status(HttpStatus.OK).body(schoolCollegeMap.values());
    }


    @ResponseBody
    @GetMapping(path = "/collegeSchoolName/search/v1/{name}/{value}",
            produces ={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CollegeSchool>> searchCollegeSchoolNameList(@PathVariable Map<String, String> pathVars, @RequestBody String reqBody) {
        RequestDataVO requestDataVO = collegeShoolValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody,pathVars);
        String name = requestDataVO.getInputPathVars().get("name");
        String value = requestDataVO.getInputPathVars().get("value");
        List<CollegeSchool> list = new ArrayList<>();
        if(null!=schoolCollegeMap.get(value)){
            list.add(schoolCollegeMap.get(value));
            CollegeSchool pullDown = collegeSchoolServiceV1.doService(requestDataVO.getInputReqBodyString());
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

}
