package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.GradingList;
import com.kastech.blumen.repository.customize.GradingListRepository;
import com.kastech.blumen.service.customize.GradingListServiceV1;
import com.kastech.blumen.utility.SecurityUtil;
import com.kastech.blumen.validator.customize.GradingListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y','Grade / Standing List_R')")
    public List<GradingList> getGradingList() {

        List<GradingList> list = new ArrayList<>();
        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y')")
    public GradingList addToGradingList(@RequestBody GradingList gradingList) {


        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        gradingList.setOrgId(sessionOrgId);
        gradingList.setCreatedDate(new Date());
        gradingList.setCreatedBy(SecurityUtil.getUserId());
        return gradingListRepository.save(gradingList);

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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y')")
    public GradingList editGradingList(@RequestBody GradingList gradingList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        GradingList item = gradingListRepository.findByGradingIdAndOrgId(gradingList.getGradingId(), sessionOrgId);

        gradingList.setModifiedDate(new Date());
        gradingList.setModifiedBy(SecurityUtil.getUserId());
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y','Grade / Standing List_R')")
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y')")
    public ResponseEntity<?> deleteGradingList(@RequestBody GradingList gradingList) {

        long sessionOrgId = SecurityUtil.getUserOrgId();
        GradingList grading = gradingListRepository.findByGradingIdAndOrgId(gradingList.getGradingId(), sessionOrgId);
        //session param
        grading.setDeletedBy(SecurityUtil.getUserId());
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y','Grade / Standing List_R')")
    public Long getMaxGradingListId() {
        long sessionOrgId = SecurityUtil.getUserOrgId();
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y','Grade / Standing List_R')")
    public GradingList getDeletedGradingById(@PathVariable long id) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        GradingList item = gradingListRepository.findDeletedGradingByIdAndOrgId(id, sessionOrgId);
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y')")
    public GradingList recoverDeletedGradingById(@RequestBody GradingList gradingList) {

        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y')")
    public GradingList updateGradingById(@RequestBody GradingList gradingList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        GradingList item = gradingListRepository.findByGradingId(gradingList.getTempId(), sessionOrgId);

        item.setModifiedDate(new Date());
        item.setModifiedBy(SecurityUtil.getUserId());
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y')")
    public ResponseEntity<?> mergeGradingById(@RequestBody GradingList gradingList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        GradingList grading = gradingListRepository.findByIdAndOrgId(gradingList.getId(), sessionOrgId);
        //session param
        grading.setDeletedBy(SecurityUtil.getUserId());
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
    @PreAuthorize("hasAnyAuthority('Grade / Standing List_Y','Grade / Standing List_R')")
    public GradingList getGradingByGradingNameAndGradingGroupName(@RequestBody GradingList grading) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        return gradingListRepository.findByGradingNameAndGradingGroupNameAndOrgId(grading.getGradingName(),grading.getGradingGroupName(), sessionOrgId);
    }
}
