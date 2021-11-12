package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.customize.GradingGroupListRepository;
import com.kastech.blumen.service.customize.GradingGroupListServiceV1;
import com.kastech.blumen.validator.customize.GradingGroupListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class GradingGroupListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradingGroupListController.class);

    GradingGroupListRepository gradingGroupListRepository;

    @Autowired
    GradingGroupListServiceV1 gradingGroupListServiceV1;


    @Autowired
    GradingGroupListValidator gradingGroupListValidator;

    Map<String, GradingGroupList> gradingGroupListMap = new HashMap<String, GradingGroupList>();

    @ResponseBody
    @GetMapping(path = "/getGradingGroupList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GradingGroupList>> getGradingGroupList() {

        return ResponseEntity.ok(gradingGroupListMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/gradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToGradingGroupList(@RequestBody String reqBody) {
        GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);
        gradingGroupListMap.put(gradingGroupList.getGradeGroupId(), gradingGroupList);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateGradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editGradingGroupList(@RequestBody String reqBody) {
        GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);
        gradingGroupListMap.put(gradingGroupList.getGradeGroupId(), gradingGroupList);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/gradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterGradingGroupList(@RequestBody String reqBody) {
        GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteGradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GradingGroupList>> deleteGradingGroupList(@RequestBody String reqBody) {

        GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);
        gradingGroupListMap.remove(gradingGroupList.getGradeGroupId());

        return ResponseEntity.status(HttpStatus.OK).body(gradingGroupListMap.values());
    }
}
