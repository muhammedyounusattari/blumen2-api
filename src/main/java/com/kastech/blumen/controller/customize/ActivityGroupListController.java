package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.customize.ActivityGroupListRepository;
import com.kastech.blumen.service.customize.ActivityGroupListServiceV1;
import com.kastech.blumen.validator.customize.ActivityGroupListValidator;
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
public class ActivityGroupListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityGroupListController.class);

    ActivityGroupListRepository activityGroupListRepository;

    @Autowired
    ActivityGroupListServiceV1 activityGroupListServiceV1;


    @Autowired
    ActivityGroupListValidator activityGroupListValidator;

    Map<String, ActivityGroupList> activityGroupListMap = new HashMap<String, ActivityGroupList>();

    @ResponseBody
    @GetMapping(path = "/getActivityGroupList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<ActivityGroupList>> getActivityList() {

        return ResponseEntity.ok(activityGroupListMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/activityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToActivityGroupList(@RequestBody String reqBody) {
        ActivityGroupList activityList = activityGroupListServiceV1.doService(reqBody);
        activityGroupListMap.put(activityList.getActivityGroupId(),activityList);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateActivityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editActivityGroupList(@RequestBody String reqBody) {
        ActivityGroupList activityGroupList = activityGroupListServiceV1.doService(reqBody);
        activityGroupListMap.put(activityGroupList.getActivityGroupId(),activityGroupList);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/activityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterActivityGroupList(@RequestBody String reqBody) {
        ActivityGroupList activityGroupList = activityGroupListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteActivityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<ActivityGroupList>> deleteActivityGroupList(@RequestBody String reqBody) {

        ActivityGroupList activityGroupList = activityGroupListServiceV1.doService(reqBody);
        activityGroupListMap.remove(activityGroupList.getActivityGroupId());

        return ResponseEntity.status(HttpStatus.OK).body(activityGroupListMap.values());
    }
}
