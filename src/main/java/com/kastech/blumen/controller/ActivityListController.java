package com.kastech.blumen.controller;

import com.kastech.blumen.model.ActivityList;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.ActivityListRepository;
import com.kastech.blumen.service.ActivityListServiceV1;
import com.kastech.blumen.validator.ActivityListValidator;
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
public class ActivityListController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityListController.class);

    ActivityListRepository activityListRepository;

    @Autowired
    ActivityListServiceV1 activityListServiceV1;


    @Autowired
    ActivityListValidator activityListValidator;

    Map<String, ActivityList> activityListMap = new HashMap<String, ActivityList>();

    @ResponseBody
    @GetMapping(path = "/getActivityList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<ActivityList>> getActivityList() {

        return ResponseEntity.ok(activityListMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/activityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToActivityList(@RequestBody String reqBody) {
        ActivityList activityList = activityListServiceV1.doService(reqBody);
        activityListMap.put(activityList.getActivityId(),activityList);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateActivityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editActivityList(@RequestBody String reqBody) {
        ActivityList activityList = activityListServiceV1.doService(reqBody);
        activityListMap.put(activityList.getActivityId(),activityList);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/activityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterActivityList(@RequestBody String reqBody) {
        ActivityList activityList = activityListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteActivityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<ActivityList>> deleteActivityList(@RequestBody String reqBody) {

        ActivityList activityList = activityListServiceV1.doService(reqBody);
        activityListMap.remove(activityList.getActivityId());

        return ResponseEntity.status(HttpStatus.OK).body(activityListMap.values());
    }

}
