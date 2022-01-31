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
    PullDownListRepository pullDownListRepository;
    
    @Autowired
    PullDownItemsRepository pullDownItemRepository;

    @Autowired
    PullDownListServiceV1 pullDownListServiceV1;

    @Autowired
    PullDownListValidator pullDownListValidator;

    Map<Long, PullDown> pullMap = new HashMap<Long, PullDown>();

    @ResponseBody
    @GetMapping(path = "/getPullDownList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDown> getPullDownList() {
        return pullDownListRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @ResponseBody
    @GetMapping(path = "/getPulldownValidate/v1/{pullId}/{pulldownId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDownItem> getPulldownValidate(@PathVariable Integer pullId, @PathVariable Long pulldownId) {
        return pullDownItemRepository.findByIdAndPullId(pullId,pulldownId);
    }



    @ResponseBody
    @PostMapping(path = "/pullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addToPullDownList(@RequestBody PullDown pullDown) {
        List<PullDownItem> pullDownItemLst = pullDown.getpullDownItems();
        if (!pullDownItemLst.isEmpty()) {
            PullDownItem pullDownItem = pullDownItemLst.get(0);
            if (pullDownItem.getId() != null && pullDownItem.getPullId()!=null && !pullDownItemRepository.findByIdAndPullId(pullDownItem.getPullId(),pullDownItem.getId()).isEmpty()) {
                return new ResponseEntity(new Response(404, "Id is already in use, either you can edit or revoke it"), null, HttpStatus.NOT_FOUND);
            } else {
    		return ResponseEntity.ok(pullDownListRepository.save(pullDown));
            }
        }
        return new ResponseEntity(new Response(404, "pull down items missing"), null, HttpStatus.NOT_FOUND);
    		
    }
    
    @ResponseBody
    @GetMapping(path = "/pullDownList/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDown getPullDownListById(@PathVariable Long id) {
        return pullDownListRepository.findById(id).get();
    }

    @ResponseBody
    @GetMapping(path = "/pullDownItems/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PullDownItem> getPullDownItemsById(@PathVariable Long id) {
        return pullDownItemRepository.findByPulldownId(id);
    }
    
	@ResponseBody
	@PostMapping(path = "/pullDownItems/v1/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> addPullDownItem(@PathVariable Long id, @RequestBody PullDownItem pullDownItems) {
		PullDown pulldown = pullDownListRepository.findById(id).get();
		if (pulldown != null && pullDownItems.getPullId()!=null && pullDownItemRepository.findByIdAndPullId(pullDownItems.getPullId(),id).isEmpty()) {
			return ResponseEntity.ok(pullDownItemRepository.save(pullDownItems));
		} else {
			return new ResponseEntity(new Response(200, "Pullid "+pullDownItems.getPullId()+"is already in use"), null, HttpStatus.OK);
		}
	}

    @ResponseBody
    @PostMapping(path = "/nonNumericPullDownItems/v1/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> addNonNumericPullDownItems(@PathVariable Long id, @RequestBody PullDownItem pullDownItems) {
        PullDown pulldown = pullDownListRepository.findById(id).get();
        return ResponseEntity.ok(pullDownItemRepository.save(pullDownItems));
    }
    
    @ResponseBody
    @PutMapping(path = "/updatePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDown editPullDownList(@RequestBody PullDown pullDown) {
        return pullDownListRepository.save(pullDown);
               
    }

    @ResponseBody
    @PutMapping(path = "/updatePullDownItem/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PullDownItem editPullDownItem(@RequestBody PullDownItem pullDown) {
        return pullDownItemRepository.save(pullDown);

    }


    @ResponseBody
    @GetMapping(path = "/pulldownlist/type/{type}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<PullDown>> getPullDownListByType(@PathVariable String type) {
        return ResponseEntity.ok(pullDownListRepository.findByType(type));
    }
    
    @ResponseBody
    @GetMapping(path = "/pulldownlist/code/{code}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<PullDown>> getPullDownListByCode(@PathVariable String code) {
    	
        return ResponseEntity.ok(pullDownListRepository.findByCode(code));
    }


    @ResponseBody
    @DeleteMapping(path = "/deletePullDownList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deletePullDownList(@RequestBody PullDownItem pullDownItem) {
        pullDownItemRepository.delete(pullDownItem);
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
