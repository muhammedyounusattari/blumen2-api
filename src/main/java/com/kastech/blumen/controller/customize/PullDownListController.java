package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.repository.customize.PullDownListRepository;
import com.kastech.blumen.service.customize.PullDownListServiceV1;
import com.kastech.blumen.utility.RequestAPIType;
import com.kastech.blumen.validator.customize.PullDownListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class PullDownListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListController.class);

    @Autowired
    PullDownListRepository pullDownListRepository;

    @Autowired
    PullDownListServiceV1 pullDownListServiceV1;


    @Autowired
    PullDownListValidator pullDownListValidator;

    Map<Long, PullDown> pullMap = new HashMap<Long, PullDown>();

    @ResponseBody
    @GetMapping(path = "/getPullDownList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDown> getPullDownList() {

        List<PullDown> list = new ArrayList<>();
        Iterable<PullDown> items = pullDownListRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/pullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDown addToPullDownList(@RequestBody PullDown pullDown) {
      //  PullDown pullDown = pullDownListServiceV1.doService(reqBody);
        return pullDownListRepository.save(pullDown);
    }

    @ResponseBody
    @PutMapping(path = "/updatePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<PullDown> editPullDownList(@RequestBody PullDown pullDown) {
      //  PullDown pullDown = pullDownListServiceV1.doService(reqBody);

        return pullDownListRepository.findById(pullDown.getId())
                .map(oldItem -> {
                    PullDown updated = oldItem.updateWith(pullDown);
                    return pullDownListRepository.save(updated);
                });
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
    @DeleteMapping(path = "/deletePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletePullDownList(@RequestBody PullDown pullDown) {
      //  PullDown collegeSchool = pullDownListServiceV1.doService(reqBody);
        pullDownListRepository.delete(pullDown);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }


  /*  @ResponseBody
    @PostMapping(path = "/add/pullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addsToPullDownList(@RequestBody String reqBody) {

        RequestDataVO requestDataVO = pullDownListValidator.validate(RequestAPIType.PULL_DOWN_LIST_V1, reqBody);
        PullDown pullDown = pullDownListServiceV1.doService(requestDataVO.getInputReqBodyString());
        pullMap.put(pullDown.getId(), pullDown);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }*/

}
