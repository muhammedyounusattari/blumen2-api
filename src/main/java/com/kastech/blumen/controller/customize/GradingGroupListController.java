package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.model.customize.GradingList;
import com.kastech.blumen.repository.customize.GradingGroupListRepository;
import com.kastech.blumen.service.customize.GradingGroupListServiceV1;
import com.kastech.blumen.validator.customize.GradingGroupListValidator;
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
public class GradingGroupListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradingGroupListController.class);

    /**
     * Inject the gradingGroupListRepository
     */
    @Autowired
    GradingGroupListRepository gradingGroupListRepository;

    /**
     * Inject the gradingGroupListServiceV1
     */
    @Autowired
    GradingGroupListServiceV1 gradingGroupListServiceV1;

    /**
     * Inject the gradingGroupListValidator
     */
    @Autowired
    GradingGroupListValidator gradingGroupListValidator;

    Map<Long, GradingGroupList> gradingGroupListMap = new HashMap<Long, GradingGroupList>();

    /**
     * Get the grading group list by orgId
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getGradingGroupList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<GradingGroupList> getGradingGroupList() {

        List<GradingGroupList> list = new ArrayList<>();
        //session param
        long sessionOrgId = 1;
        Iterable<GradingGroupList> items = gradingGroupListRepository.findByOrgId(sessionOrgId);
        items.forEach(list::add);
        return list;
    }

    /**
     * Add the grading group list
     * @param gradingGroupList
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/gradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingGroupList addToGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {
        //session param
        long sessionOrgId = 1;
        gradingGroupList.setOrgId(sessionOrgId);
        gradingGroupList.setCreatedDate(new Date());
        GradingGroupList value = gradingGroupListRepository.save(gradingGroupList);
        value.setCreatedBy(value.getGradeGroupId());
        return gradingGroupListRepository.save(value);
    }

    /**
     * Update the all rows of Grading Group
     * @param gradingGroupList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateGradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingGroupList editGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {
        long sessionOrgId = 1;
        GradingGroupList item = gradingGroupListRepository.findByGradingGroupIdAndOrgId(gradingGroupList.getGradeGroupId(), sessionOrgId);

        gradingGroupList.setModifiedDate(new Date());
        gradingGroupList.setModifiedBy(item.getGradeGroupId());
        gradingGroupList.setCreatedBy(item.getCreatedBy());
        gradingGroupList.setCreatedDate(item.getCreatedDate());
        gradingGroupList.setOrgId(item.getOrgId());
        return gradingGroupListRepository.save(gradingGroupList);
    }


    /**
     * Get the filter data to list
     * @param gradingGroupList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/filter/gradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {
     //   GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }

    /**
     * Delete the grading group list
     * @param gradingGroupList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/deleteGradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {

        long sessionOrgId = 1;
        GradingGroupList grading = gradingGroupListRepository.findByGradingGroupIdAndOrgId(gradingGroupList.getGradeGroupId(), sessionOrgId);
        //session param
        grading.setDeletedBy(grading.getGradeGroupId());
        grading.setDeletedDate(new Date());
        GradingGroupList value = gradingGroupListRepository.save(grading);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the max grading group Id
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getMaxGradingGroupId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxGradingGroupId() {
        long sessionOrgId = 1;
        return gradingGroupListRepository.getMaxId(sessionOrgId);
    }

    /**
     * Recover the deleted grading group.
     * @param gradingGroupList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/recoverDeletedGradingGroupById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingGroupList recoverDeletedGradingGroupById(@RequestBody GradingGroupList gradingGroupList) {

        //session param
        long sessionOrgId = 1;
        GradingGroupList items = gradingGroupListRepository.findDeletedGradingByIdAndOrgId(gradingGroupList.getId(),sessionOrgId);
        items.setDeletedBy(0L);
        items.setDeletedDate(null);
        GradingGroupList updatedItem =gradingGroupListRepository.save(items);
        return updatedItem;
    }

    /**
     * Get the deleted grading groupId
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getDeletedGradingGroupById/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingGroupList getDeletedGradingGroupById(@PathVariable long id) {
        long orgId = 1;
        GradingGroupList item = gradingGroupListRepository.findDeletedGradingByIdAndOrgId(id, orgId);
        return item;
    }

    /**
     * Update the grading group for move funtionality
     * @param gradingGroupList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateGradingGroupById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingGroupList updateGradingGroupById(@RequestBody GradingGroupList gradingGroupList) {
        long orgId = 1;
        GradingGroupList item = gradingGroupListRepository.findByGradingId(gradingGroupList.getTempId(), orgId);

        item.setModifiedDate(new Date());
        item.setModifiedBy(item.getGradeGroupId());
        item.setId(gradingGroupList.getId());
        return gradingGroupListRepository.save(item);
    }

    /**
     * Merge the grading group by Id
     * @param gradingGroupList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/mergeGradingGroupById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> mergeGradingGroupById(@RequestBody GradingGroupList gradingGroupList) {
        long sessionOrgId = 1;
        GradingGroupList gradingGroup = gradingGroupListRepository.findByGradingIdAndOrgId(gradingGroupList.getId(), sessionOrgId);
        //session param
        gradingGroup.setDeletedBy(gradingGroup.getGradeGroupId());
        gradingGroup.setDeletedDate(new Date());
        GradingGroupList value = gradingGroupListRepository.save(gradingGroup);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * get the all gradingGroup By GradingGroupName And GradingGroupType
     * @param gradingGroup
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getGradingGroupByGradingGroupNameAndGradingGroupType/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingGroupList getGradingGroupByGradingGroupNameAndGradingGroupType(@RequestBody GradingGroupList gradingGroup) {
        long orgId = 1;
        return gradingGroupListRepository.findByGradingGroupNameAndGradingGroupTypeAndOrgId(gradingGroup.getGradeGroupName(),gradingGroup.getGradeGroupGradeType(), orgId);
    }
}
