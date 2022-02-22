package com.kastech.blumen.controller.customize;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.model.customize.PullDownItem;
import com.kastech.blumen.repository.customize.PullDownItemsRepository;
import com.kastech.blumen.repository.customize.PullDownListRepository;
import com.kastech.blumen.service.customize.PullDownListServiceV1;
import com.kastech.blumen.validator.customize.PullDownListValidator;

@RestController
@RequestMapping("/api/blumen-api/customize")
public class PullDownListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListController.class);


    @Autowired
    PullDownListServiceV1 pullDownListServiceV1;

    @Autowired
    PullDownListValidator pullDownListValidator;

    Map<Long, PullDown> pullMap = new HashMap<Long, PullDown>();

    @ResponseBody
    @GetMapping(path = "/getPullDownList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDown> getPullDownList() {
        return pullDownListServiceV1.getPullDownList(Sort.by(Sort.Direction.ASC, "id"));
    }

    @ResponseBody
    @GetMapping(path = "/getPulldownValidate/v1/{pullId}/{pulldownId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDownItem> getPulldownValidate(@PathVariable Integer pullId, @PathVariable Long pulldownId) {
        LOGGER.info("Call made to getPulldownValidate() of {}", this.getClass());
        return pullDownListServiceV1.getPulldownValidate(pullId,pulldownId);
    }



    @ResponseBody
    @PostMapping(path = "/pullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addToPullDownList(@RequestBody PullDown pullDown) {
        LOGGER.info("Call made to addToPullDownList() of {}", this.getClass());

        Map<String,String> statusMap = pullDownListServiceV1.checkPullDownItemInUse(pullDown);
        String status = statusMap.get("status");
        if("404".equals(status)){
            return new ResponseEntity(new Response(404, statusMap.get("message")), null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(pullDownListServiceV1.addToPullDownList(pullDown));
    }
    
    @ResponseBody
    @GetMapping(path = "/pullDownList/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDown getPullDownListById(@PathVariable Long id) {
        LOGGER.info("Call made to getPullDownListById() of {}", this.getClass());
        return pullDownListServiceV1.getPullDownListById(id);
    }

    @ResponseBody
    @GetMapping(path = "/pullDownItems/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDownItem> getPullDownItemsById(@PathVariable Long id) {
        LOGGER.info("Call made to getPullDownItemsById() of {}", this.getClass());
        return pullDownListServiceV1.getPullDownItemsById(id);
    }

    @ResponseBody
    @GetMapping(path = "/pullDownItems/v1/code/{code}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDownItem> getPullDownItemsByCode(@PathVariable String code) {
        LOGGER.info("Call made to getPullDownItemsByCode() of {}", this.getClass());
        return pullDownListServiceV1.getPullDownItemsByCode(code);
    }
    
	@ResponseBody
	@PostMapping(path = "/pullDownItems/v1/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addPullDownItem(@PathVariable Long id, @RequestBody PullDownItem pullDownItems) {
        LOGGER.info("Call made to addPullDownItem() of {}", this.getClass());
		return pullDownListServiceV1.addPullDownItem(id,pullDownItems);
	}


    
    @ResponseBody
    @PutMapping(path = "/updatePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDown editPullDownList(@RequestBody PullDown pullDown) {
        LOGGER.info("Call made to editPullDownList() of {}", this.getClass());
        return pullDownListServiceV1.editPullDownList(pullDown);
               
    }

    @ResponseBody
    @PutMapping(path = "/updatePullDownItem/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDownItem editPullDownItem(@RequestBody PullDownItem pullDown) {
        LOGGER.info("Call made to editPullDownItem() of {}", this.getClass());
        return pullDownListServiceV1.editPullDownItem(pullDown);

    }


    @ResponseBody
    @GetMapping(path = "/pulldownlist/type/{type}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<PullDown>> getPullDownListByType(@PathVariable String type) {
        LOGGER.info("Call made to getPullDownListByType() of {}", this.getClass());
        return ResponseEntity.ok(pullDownListServiceV1.getPullDownListByType(type));
    }
    
    @ResponseBody
    @GetMapping(path = "/pulldownlist/code/{code}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<PullDown>> getPullDownListByCode(@PathVariable String code) {
        LOGGER.info("Call made to getPullDownListByCode() of {}", this.getClass());
        return ResponseEntity.ok(pullDownListServiceV1.getPullDownListByCode(code));
    }

    @ResponseBody
    @GetMapping(path = "/multiplePulldownList/code/{codes}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getMultiplePullDownListByCode(@PathVariable(value = "codes", required = true) List<String> codes) {

        LOGGER.info("Call made to getMultiplePullDownListByCode() of {} and codes {}", this.getClass(), codes);
        Map<String,Object> statusMap = new HashMap<>();
       try {
           statusMap.put("body", pullDownListServiceV1.getPullDownListByCodes(codes));
           statusMap.put("status", "200");
           return success(statusMap,200);
       } catch (Exception e){

           statusMap.put("message", "please check your request url");
           statusMap.put("status", "404");
           return failure(statusMap,404);
       }
    }


    @ResponseBody
    @DeleteMapping(path = "/deletePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletePullDownList(@RequestBody PullDownItem pullDownItem) {
        LOGGER.info("Call made to deletePullDownList() of {}", this.getClass());
        pullDownListServiceV1.deletePullDownList(pullDownItem);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

    private ResponseEntity<?> success(Object t, Integer status ){

        return new ResponseEntity(t,null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, Integer status ){
        return new ResponseEntity(t,null, HttpStatus.valueOf(status));
    }
}
