package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.GradingList;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.customize.GradingListRepository;
import com.kastech.blumen.service.customize.GradingListServiceV1;
import com.kastech.blumen.validator.customize.GradingListValidator;
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
public class GradingListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradingListController.class);

    GradingListRepository gradingListRepository;

    @Autowired
    GradingListServiceV1 gradingListServiceV1;


    @Autowired
    GradingListValidator gradingListValidator;

    Map<String, GradingList> gradingListMap = new HashMap<String, GradingList>();

    @ResponseBody
    @GetMapping(path = "/getGradingList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GradingList>> getGradingList() {

        return ResponseEntity.ok(gradingListMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/gradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToGradingList(@RequestBody String reqBody) {
        GradingList activityList = gradingListServiceV1.doService(reqBody);
        gradingListMap.put(activityList.getGradingId(),activityList);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateGradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editGradingList(@RequestBody String reqBody) {
        GradingList activityList = gradingListServiceV1.doService(reqBody);
        gradingListMap.put(activityList.getGradingId(),activityList);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/gradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterGradingList(@RequestBody String reqBody) {
        GradingList activityList = gradingListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteGradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GradingList>> deleteGradingList(@RequestBody String reqBody) {

        GradingList gradingList = gradingListServiceV1.doService(reqBody);
        gradingListMap.remove(gradingList.getGradingId());

        return ResponseEntity.status(HttpStatus.OK).body(gradingListMap.values());
    }
}
