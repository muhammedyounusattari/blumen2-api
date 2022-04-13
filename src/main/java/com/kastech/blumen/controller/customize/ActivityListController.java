package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.CollegeSchool;
import com.kastech.blumen.repository.customize.ActivityListRepository;
import com.kastech.blumen.service.customize.ActivityListServiceV1;
import com.kastech.blumen.utility.SecurityUtil;
import com.kastech.blumen.validator.customize.ActivityListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@PreAuthorize("hasAuthority('Activity / Services List')")
@RestController
@RequestMapping("/api/blumen-api/customize")
public class ActivityListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityListController.class);

    /**
     * Inject the activityListRepository
     */
    @Autowired
    ActivityListRepository activityListRepository;

    /**
     * Inject the activityListServiceV1
     */
    @Autowired
    ActivityListServiceV1 activityListServiceV1;

    /**
     * Inject the activityListValidator
     */
    @Autowired
    ActivityListValidator activityListValidator;

    Map<Long, ActivityList> activityListMap = new HashMap<Long, ActivityList>();

    /**
     * Get the activity list
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getActivityList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ActivityList> getActivityList() {

        List<ActivityList> list = new ArrayList<>();
        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Iterable<ActivityList> items = activityListRepository.findByOrgId(sessionOrgId);
        items.forEach(list::add);
        return list;

    }

    /**
     * Add the activity list
     * @param activityList
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/activityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityList addToActivityList(@RequestBody ActivityList activityList) {
        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        activityList.setOrgId(sessionOrgId);
        activityList.setCreatedDate(new Date());
        ActivityList value = activityListRepository.save(activityList);

        long activityId = value.getActivityId();
        value.setCreatedBy(activityId);
        return activityListRepository.save(value);
    }

    /**
     * Update the activity list
     * @param activityList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateActivityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityList editActivityList(@RequestBody ActivityList activityList) {

        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityList item = activityListRepository.findByActivityIdAndOrgId(activityList.getActivityId(), sessionOrgId);

        activityList.setModifiedDate(new Date());
        activityList.setModifiedBy(item.getActivityId());
        activityList.setCreatedBy(item.getCreatedBy());
        activityList.setCreatedDate(item.getCreatedDate());
        activityList.setOrgId(item.getOrgId());
        return activityListRepository.save(activityList);
    }


    /**
     * Filter the activity list
     * @param activityList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/filter/activityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterActivityList(@RequestBody ActivityList activityList) {
     //   ActivityList activityList = activityListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }

    /**
     * Delete the activity record
     * @param activityList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/deleteActivityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteActivityList(@RequestBody ActivityList activityList) {

        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityList activity = activityListRepository.findByActivityIdAndOrgId(activityList.getActivityId(), sessionOrgId);
        //session param
        activity.setDeletedBy(activity.getActivityId());
        activity.setDeletedDate(new Date());
        ActivityList value = activityListRepository.save(activity);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the max activityId
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getMaxActivityId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxActivityListId() {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        return activityListRepository.getMaxId(sessionOrgId);
    }

    /**
     * Get the deleted activity by id
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getDeletedActivityById/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityList getDeletedActivityById(@PathVariable long id) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityList item = activityListRepository.findDeletedItemByIdAndOrgId(id, sessionOrgId);
        return item;
    }

    /**
     * Recover teh deleted Activity by Id
     * @param activityList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/recoverDeletedActivityById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityList recoverDeletedActivityById(@RequestBody ActivityList activityList) {

        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityList items = activityListRepository.findDeletedItemByIdAndOrgId(activityList.getId(),sessionOrgId);
        items.setDeletedBy(0L);
        items.setDeletedDate(null);
        ActivityList updatedItem =activityListRepository.save(items);
        return updatedItem;
    }

    /**
     * Update the activity By Id
     * @param activityList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateActivityById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityList updateActivityById(@RequestBody ActivityList activityList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityList item = activityListRepository.findByActivityId(activityList.getTempId(), sessionOrgId);

        item.setModifiedDate(new Date());
        item.setModifiedBy(item.getActivityId());
        item.setId(activityList.getId());
        return activityListRepository.save(item);
    }

    /**
     * Merge the activity by id
     * @param activityList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/mergeActivityById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> mergeActivityById(@RequestBody ActivityList activityList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityList activity = activityListRepository.findByIdAndOrgId(activityList.getId(), sessionOrgId);
        //session param
        activity.setDeletedBy(activity.getActivityId());
        activity.setDeletedDate(new Date());
        ActivityList value = activityListRepository.save(activity);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the activity Name And Activity Group Name
     * @param activityList
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getActivityByActivityNameAndActivityGroupName/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityList getActivityByActivityNameAndActivityGroupName(@RequestBody ActivityList activityList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
       return activityListRepository.findByActivityNameAndGroupNameAndOrgId(activityList.getActivityName(),activityList.getActivityGroupName(), sessionOrgId);
    }
}
