package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.repository.customize.ActivityGroupListRepository;
import com.kastech.blumen.service.customize.ActivityGroupListServiceV1;
import com.kastech.blumen.validator.customize.ActivityGroupListValidator;
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
public class ActivityGroupListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityGroupListController.class);

    @Autowired
    ActivityGroupListRepository activityGroupListRepository;

    @Autowired
    ActivityGroupListServiceV1 activityGroupListServiceV1;


    @Autowired
    ActivityGroupListValidator activityGroupListValidator;

    Map<Long, ActivityGroupList> activityGroupListMap = new HashMap<Long, ActivityGroupList>();

    @ResponseBody
    @GetMapping(path = "/getActivityGroupList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ActivityGroupList> getActivityList() {

        List<ActivityGroupList> list = new ArrayList<>();
        Iterable<ActivityGroupList> items = activityGroupListRepository.findAll(Sort.by(Sort.Direction.ASC, "activityGroupId"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/activityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ActivityGroupList addToActivityGroupList(@RequestBody ActivityGroupList activityList) {

    //    ActivityGroupList activityList = activityGroupListServiceV1.doService(reqBody);
        return activityGroupListRepository.save(activityList);
    }

    @ResponseBody
    @PutMapping(path = "/updateActivityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<ActivityGroupList> editActivityGroupList(@RequestBody ActivityGroupList activityGroupList) {

    //    ActivityGroupList activityGroupList = activityGroupListServiceV1.doService(reqBody);

        return activityGroupListRepository.findById(activityGroupList.getActivityGroupId())
                .map(oldItem -> {
                    ActivityGroupList updated = oldItem.updateWith(activityGroupList);
                    return activityGroupListRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/activityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterActivityGroupList(@RequestBody ActivityGroupList reqBody) {
     //   ActivityGroupList activityGroupList = activityGroupListServiceV1.doService(reqBody);
       // return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
        return new ResponseEntity(new Response(200, "filter pull down list"), null, HttpStatus.OK);
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteActivityGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteActivityGroupList(@RequestBody ActivityGroupList activityGroupList) {
      //  ActivityGroupList activityGroupList = activityGroupListServiceV1.doService(reqBody);
        activityGroupListRepository.delete(activityGroupList);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping(path = "/getMaxActivityGroupId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxActivityListId() {

    	return activityGroupListRepository.getMaxId();
       
    }
}
