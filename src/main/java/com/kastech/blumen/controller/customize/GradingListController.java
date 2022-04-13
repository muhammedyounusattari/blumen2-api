package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.model.customize.GradingList;
import com.kastech.blumen.repository.customize.GradingListRepository;
import com.kastech.blumen.service.customize.GradingListServiceV1;
import com.kastech.blumen.validator.customize.GradingListValidator;
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
public class GradingListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradingListController.class);

    /**
     * Inject the gradingListRepository
     */
    @Autowired
    GradingListRepository gradingListRepository;

    /**
     * Inject the gradingListServiceV1
     */
    @Autowired
    GradingListServiceV1 gradingListServiceV1;

    /**
     * Inject the gradingListValidator
     */
    @Autowired
    GradingListValidator gradingListValidator;

    /**
     * Get the grading lsit
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getGradingList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<GradingList> getGradingList() {

        List<GradingList> list = new ArrayList<>();
        //session param
        long sessionOrgId = 1;
        Iterable<GradingList> items = gradingListRepository.findByOrgId(sessionOrgId);
        items.forEach(list::add);
        return list;
    }

    /**
     * Add the grading record
     * @param gradingList
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/gradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingList addToGradingList(@RequestBody GradingList gradingList) {


        //session param
        long sessionOrgId = 1;
        gradingList.setOrgId(sessionOrgId);
        gradingList.setCreatedDate(new Date());
        GradingList value = gradingListRepository.save(gradingList);

        long gradingId = value.getGradingId();
        value.setCreatedBy(gradingId);
        return gradingListRepository.save(value);

    }

    /**
     * Update the grading list
     * @param gradingList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateGradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingList editGradingList(@RequestBody GradingList gradingList) {
        long sessionOrgId = 1;
        GradingList item = gradingListRepository.findByGradingIdAndOrgId(gradingList.getGradingId(), sessionOrgId);

        gradingList.setModifiedDate(new Date());
        gradingList.setModifiedBy(item.getGradingId());
        gradingList.setCreatedBy(item.getCreatedBy());
        gradingList.setCreatedDate(item.getCreatedDate());
        gradingList.setOrgId(item.getOrgId());
        return gradingListRepository.save(gradingList);
    }

    /**
     * Filter the grading list
     * @param gradingList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/filter/gradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterGradingList(@RequestBody GradingList gradingList) {
      //  GradingList activityList = gradingListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }

    /**
     * Delete the grading list
     * @param gradingList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/deleteGradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteGradingList(@RequestBody GradingList gradingList) {

        long sessionOrgId = 1;
        GradingList grading = gradingListRepository.findByGradingIdAndOrgId(gradingList.getGradingId(), sessionOrgId);
        //session param
        grading.setDeletedBy(grading.getGradingId());
        grading.setDeletedDate(new Date());
        GradingList value = gradingListRepository.save(grading);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the max grading list by orgId
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getMaxGradingListId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxGradingListId() {
        long sessionOrgId = 1;
        return gradingListRepository.getMaxId(sessionOrgId);
    }

    /**
     * Get the deleted grading By id
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getDeletedGradingById/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingList getDeletedGradingById(@PathVariable long id) {
        long orgId = 1;
        GradingList item = gradingListRepository.findDeletedGradingByIdAndOrgId(id, orgId);
        return item;
    }


    /**
     * Recover the deleted grading by Id
     * @param gradingList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/recoverDeletedGradingById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingList recoverDeletedGradingById(@RequestBody GradingList gradingList) {

        //session param
        long sessionOrgId = 1;
        GradingList items = gradingListRepository.findDeletedGradingByIdAndOrgId(gradingList.getId(),sessionOrgId);
        items.setDeletedBy(0L);
        items.setDeletedDate(null);
        GradingList updatedItem =gradingListRepository.save(items);
        return updatedItem;
    }

    /**
     * Update the grading by id
     * @param gradingList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateGradingById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingList updateGradingById(@RequestBody GradingList gradingList) {
        long orgId = 1;
        GradingList item = gradingListRepository.findByGradingId(gradingList.getTempId(), orgId);

        item.setModifiedDate(new Date());
        item.setModifiedBy(item.getGradingId());
        item.setId(gradingList.getId());
        return gradingListRepository.save(item);
    }

    /**
     * Merge the grading by id
     * @param gradingList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/mergeGradingById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> mergeGradingById(@RequestBody GradingList gradingList) {
        long sessionOrgId = 1;
        GradingList grading = gradingListRepository.findByIdAndOrgId(gradingList.getId(), sessionOrgId);
        //session param
        grading.setDeletedBy(grading.getGradingId());
        grading.setDeletedDate(new Date());
        GradingList value = gradingListRepository.save(grading);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the all grading By GradingName And GradingGroupName
     * @param grading
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getGradingByGradingNameAndGradingGroupName/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingList getGradingByGradingNameAndGradingGroupName(@RequestBody GradingList grading) {
        long orgId = 1;
        return gradingListRepository.findByGradingNameAndGradingGroupNameAndOrgId(grading.getGradingName(),grading.getGradingGroupName(), orgId);
    }
}
