package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.repository.customize.PullDownListRepository;
import com.kastech.blumen.service.customize.PullDownListServiceV1;
import com.kastech.blumen.utility.RequestAPIType;
import com.kastech.blumen.validator.customize.PullDownListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class PullDownListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListController.class);

    PullDownListRepository pullDownListRepository;

    @Autowired
    PullDownListServiceV1 pullDownListServiceV1;


    @Autowired
    PullDownListValidator pullDownListValidator;

    Map<Integer, PullDown> pullMap = new HashMap<Integer, PullDown>();

    @ResponseBody
    @GetMapping(path = "/getPullDownList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<PullDown>> getPullDownList() {

        return ResponseEntity.ok(pullMap.values());
    }

    @ResponseBody
    @PostMapping(path = "/pullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addToPullDownList(@RequestBody String reqBody) {
        RequestDataVO requestDataVO = pullDownListValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody);
        PullDown pullDown = pullDownListServiceV1.doService(requestDataVO.getInputReqBodyString());
        pullMap.put(pullDown.getId(), pullDown);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @PutMapping(path = "/updatePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> editPullDownList(@RequestBody String reqBody) {
        RequestDataVO requestDataVO = pullDownListValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody);
        PullDown pullDown = pullDownListServiceV1.doService(requestDataVO.getInputReqBodyString());
        pullMap.put(pullDown.getId(), pullDown);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


    @ResponseBody
    @PutMapping(path = "/filter/pulldownlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterPullDownList(@RequestBody String reqBody) {
        RequestDataVO requestDataVO = pullDownListValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody);
        PullDown pullDown = pullDownListServiceV1.doService(requestDataVO.getInputReqBodyString());
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deletePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<PullDown>> deletePullDownList(@RequestBody String reqBody) {
        RequestDataVO requestDataVO = pullDownListValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody);
        PullDown pullDown = pullDownListServiceV1.doService(requestDataVO.getInputReqBodyString());
        pullMap.remove(pullDown.getId());

        return ResponseEntity.status(HttpStatus.OK).body(pullMap.values());
    }


    @ResponseBody
    @PostMapping(path = "/add/pullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addsToPullDownList(@RequestBody String reqBody) {

        RequestDataVO requestDataVO = pullDownListValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody);
        PullDown pullDown = pullDownListServiceV1.doService(requestDataVO.getInputReqBodyString());
        pullMap.put(pullDown.getId(), pullDown);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

}
