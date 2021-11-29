package com.kastech.blumen.controller.admin.systemtools;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.repository.admin.systemtools.TimeClockManagerRepository;
import com.kastech.blumen.service.admin.systemtools.TimeClockManagerServiceV1;
import com.kastech.blumen.validator.admin.systemtools.TimeClockManagerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/admin/systemtools")
public class TimeClockManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeClockManagerController.class);

    TimeClockManagerRepository timeClockManagerRepository;

    @Autowired
    TimeClockManagerServiceV1 timeClockManagerServiceV1;


    @Autowired
    TimeClockManagerValidator timeClockManagerValidator;

    List<TimeClockManager> studentList = new ArrayList<TimeClockManager>();

    Map<String, TimeClockManager> timeClockManagerMap = new HashMap<String, TimeClockManager>();


    @ResponseBody
    @GetMapping(path = "/getTimeClockManagerList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<TimeClockManager>> getTimeClockManagerList() {

        return ResponseEntity.ok(timeClockManagerMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/timeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addTimeClockManagerList(@RequestBody String reqBody) {
        TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);
        timeClockManagerMap.put(timeClockManager.getId(),timeClockManager);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateTimeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editTimeClockManagerList(@RequestBody String reqBody) {
        TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);
        timeClockManagerMap.put(timeClockManager.getId(),timeClockManager);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/timeClockManagerlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterTimeClockManagerList(@RequestBody String reqBody) {
        TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteTimeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<TimeClockManager>> deleteTimeClockManagerList(@RequestBody String reqBody) {

        TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);
        timeClockManagerMap.remove(timeClockManager.getId());

        return ResponseEntity.status(HttpStatus.OK).body(timeClockManagerMap.values());
    }
}
