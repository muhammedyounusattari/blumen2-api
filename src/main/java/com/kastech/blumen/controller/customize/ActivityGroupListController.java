package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.CollegeSchool;
import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.repository.customize.ActivityGroupListRepository;
import com.kastech.blumen.service.customize.ActivityGroupListServiceV1;
import com.kastech.blumen.utility.SecurityUtil;
import com.kastech.blumen.validator.customize.ActivityGroupListValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@PreAuthorize("hasAuthority('Activity / Services Group List')")
@RestController
@RequestMapping("/api/blumen-api/customize")
public class ActivityGroupListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityGroupListController.class);

    /**
     * Inject the activityGroupListRepository
     */
    @Autowired
    ActivityGroupListRepository activityGroupListRepository;

    /**
     * Inject the activityGroupListServiceV1
     */
    @Autowired
    ActivityGroupListServiceV1 activityGroupListServiceV1;

    /**
     * Inject the activityGroupListValidator
     */
    @Autowired
    ActivityGroupListValidator activityGroupListValidator;

    Map<Long, ActivityGroupList> activityGroupListMap = new HashMap<Long, ActivityGroupList>();

    /**
     * Get the activity group list
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getActivityGroupList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ActivityGroupList> getActivityList() {

        List<ActivityGroupList> list = new ArrayList<>();
        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        Iterable<ActivityGroupList> items = activityGroupListRepository.findByOrgId(sessionOrgId);
        items.forEach(list::add);
        return list;
    }

    /**
     * Add the activity group list
     * @param activityList
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/activityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityGroupList addToActivityGroupList(@RequestBody ActivityGroupList activityList) {

        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        activityList.setOrgId(sessionOrgId);
        activityList.setCreatedDate(new Date());
        ActivityGroupList value = activityGroupListRepository.save(activityList);

        long activityGroupId = value.getActivityGroupId();
        value.setCreatedBy(activityGroupId);
        return activityGroupListRepository.save(value);
    }

    /**
     * Update the activity group list
     * @param activityGroupList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateActivityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityGroupList editActivityGroupList(@RequestBody ActivityGroupList activityGroupList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityGroupList item = activityGroupListRepository.findByActivityGroupIdAndOrgId(activityGroupList.getActivityGroupId(), sessionOrgId);

        activityGroupList.setModifiedDate(new Date());
        activityGroupList.setModifiedBy(item.getActivityGroupId());
        activityGroupList.setCreatedBy(item.getCreatedBy());
        activityGroupList.setCreatedDate(item.getCreatedDate());
        activityGroupList.setOrgId(item.getOrgId());
        return activityGroupListRepository.save(activityGroupList);
    }


    /**
     * Filter the activity group list
     * @param reqBody
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/filter/activityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterActivityGroupList(@RequestBody ActivityGroupList reqBody) {
     //   ActivityGroupList activityGroupList = activityGroupListServiceV1.doService(reqBody);
       // return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
        return new ResponseEntity(new Response(200, "filter pull down list"), null, HttpStatus.OK);
    }


    /**
     * deleted the activity group list
     * @param activityGroupList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/deleteActivityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteActivityGroupList(@RequestBody ActivityGroupList activityGroupList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityGroupList activity = activityGroupListRepository.findByActivityGroupIdAndOrgId(activityGroupList.getActivityGroupId(), sessionOrgId);
        //session param
        activity.setDeletedBy(activity.getActivityGroupId());
        activity.setDeletedDate(new Date());
        ActivityGroupList value = activityGroupListRepository.save(activity);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the max activity group id
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getMaxActivityGroupId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxActivityListId() {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        return activityGroupListRepository.getMaxId(sessionOrgId);
    }


    /**
     * Recover teh deleted activity group by Id
     * @param activityGroupList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/recoverDeletedActivityGroupById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityGroupList recoverDeletedActivityGroupById(@RequestBody ActivityGroupList activityGroupList) {

        //session param
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityGroupList items = activityGroupListRepository.findDeletedItemByIdAndOrgId(activityGroupList.getId(),sessionOrgId);
        items.setDeletedBy(0L);
        items.setDeletedDate(null);
        return activityGroupListRepository.save(items);
    }

    /**
     * Get the deleted group by id
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/getDeletedGroupById/v1/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityGroupList getDeletedGroupById(@PathVariable long id) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        return activityGroupListRepository.findDeletedItemByIdAndOrgId(id, sessionOrgId);
    }

    /**
     * Update the activity group id
     * @param activityGroupList
     * @return
     */
    @ResponseBody
    @PutMapping(path = "/updateActivityGroupById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityGroupList updateActivityGroupById(@RequestBody ActivityGroupList activityGroupList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityGroupList item = activityGroupListRepository.findByActivityId(activityGroupList.getTempId(), sessionOrgId);

        item.setModifiedDate(new Date());
        item.setModifiedBy(item.getActivityGroupId());
        item.setId(activityGroupList.getId());
        return activityGroupListRepository.save(item);
    }

    /**
     * Merge the activity group by id
     * @param activityGroupList
     * @return
     */
    @ResponseBody
    @DeleteMapping(path = "/mergeActivityGroupById/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> mergeActivityGroupById(@RequestBody ActivityGroupList activityGroupList) {
//        long orgId = 2;
//        activityGroupListRepository.deleteRecordByIdAndOrgId(activityGroupList.getId(), orgId);
//        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
        long sessionOrgId = SecurityUtil.getUserOrgId();
        ActivityGroupList activity = activityGroupListRepository.findByActivityIdAndOrgId(activityGroupList.getId(), sessionOrgId);
        //session param
        activity.setDeletedBy(activity.getActivityGroupId());
        activity.setDeletedDate(new Date());
        ActivityGroupList value = activityGroupListRepository.save(activity);
        int statusCode = 200;
        String message = "success";
        if (value == null) {
            statusCode = 500;
            message = "failed";
        }
        return new ResponseEntity(new Response(statusCode, message), null, HttpStatus.OK);
    }

    /**
     * Get the activity group by activity group name and activity group type and activity group type name
     * @param activityGroupList
     * @return
     */
    @ResponseBody
    @PostMapping(path = "/getActivityGroupByActivityGroupNameAndActivityGroupType/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityGroupList getActivityGroupByActivityGroupNameAndActivityGroupType(@RequestBody ActivityGroupList activityGroupList) {
        long sessionOrgId = SecurityUtil.getUserOrgId();
        return activityGroupListRepository.findActivityGroupByActivityGroupNameAndActivityGroupTypeAndOrgId(activityGroupList.getActivityGroupName(),activityGroupList.getActivityGroupType(), sessionOrgId);

    }


}
