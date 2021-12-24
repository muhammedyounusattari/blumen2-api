package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.repository.customize.ActivityListRepository;
import com.kastech.blumen.service.customize.ActivityListServiceV1;
import com.kastech.blumen.validator.customize.ActivityListValidator;
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
public class ActivityListController {


    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityListController.class);

    @Autowired
    ActivityListRepository activityListRepository;

    @Autowired
    ActivityListServiceV1 activityListServiceV1;


    @Autowired
    ActivityListValidator activityListValidator;

    Map<Long, ActivityList> activityListMap = new HashMap<Long, ActivityList>();

    @ResponseBody
    @GetMapping(path = "/getActivityList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ActivityList> getActivityList() {

        List<ActivityList> list = new ArrayList<>();
        Iterable<ActivityList> items = activityListRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/activityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityList addToActivityList(@RequestBody ActivityList activityList) {
     //   ActivityList activityList = activityListServiceV1.doService(reqBody);
        return activityListRepository.save(activityList);
    }

    @ResponseBody
    @PutMapping(path = "/updateActivityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<ActivityList> editActivityList(@RequestBody ActivityList activityGroupList) {


      //  ActivityList activityGroupList = activityListServiceV1.doService(reqBody);

        return activityListRepository.findById(activityGroupList.getActivityId())
                .map(oldItem -> {
                    ActivityList updated = oldItem.updateWith(activityGroupList);
                    return activityListRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/activityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterActivityList(@RequestBody ActivityList activityList) {
     //   ActivityList activityList = activityListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteActivityList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteActivityList(@RequestBody ActivityList activityGroupList) {

    //    ActivityList activityGroupList = activityListServiceV1.doService(reqBody);
        activityListRepository.delete(activityGroupList);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(path = "/getMaxActivityId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxActivityListId() {

    	return activityListRepository.getMaxId();
       
    }
}
