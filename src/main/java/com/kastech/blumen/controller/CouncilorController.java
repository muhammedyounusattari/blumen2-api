package com.kastech.blumen.controller;

import com.kastech.blumen.model.Councilor;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.CouncilorRepository;
import com.kastech.blumen.service.CouncilorServiceV1;
import com.kastech.blumen.validator.CouncilorValidator;
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
@RequestMapping("/api/blumen-api")
public class CouncilorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouncilorController.class);

    CouncilorRepository councilorRepository;

    @Autowired
    CouncilorServiceV1 councilorServiceV1;


    @Autowired
    CouncilorValidator councilorValidator;

    Map<String, Councilor> councilorMap = new HashMap<String, Councilor>();

    @ResponseBody
    @GetMapping(path = "/getCouncilorList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Councilor>> getCouncilorList() {

        return ResponseEntity.ok(councilorMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/councilorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToCCouncilorList(@RequestBody String reqBody) {
        Councilor councilor = councilorServiceV1.doService(reqBody);
        councilorMap.put(councilor.getStaffId(),councilor);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updateCouncilorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editCouncilorList(@RequestBody String reqBody) {
        Councilor councilor = councilorServiceV1.doService(reqBody);
        councilorMap.put(councilor.getStaffId(),councilor);
        return new ResponseEntity(new Response(200,"success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/councilorlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterCouncilorList(@RequestBody String reqBody) {
        Councilor councilor = councilorServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteCouncilorList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Councilor>> deleteCouncilorList(@RequestBody String reqBody) {

        Councilor councilor = councilorServiceV1.doService(reqBody);
        councilorMap.remove(councilor.getStaffId());

        return ResponseEntity.status(HttpStatus.OK).body(councilorMap.values());
    }


}
