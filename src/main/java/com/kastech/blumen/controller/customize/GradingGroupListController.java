package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.repository.customize.GradingGroupListRepository;
import com.kastech.blumen.service.customize.GradingGroupListServiceV1;
import com.kastech.blumen.validator.customize.GradingGroupListValidator;
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
public class GradingGroupListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradingGroupListController.class);

    @Autowired
    GradingGroupListRepository gradingGroupListRepository;

    @Autowired
    GradingGroupListServiceV1 gradingGroupListServiceV1;


    @Autowired
    GradingGroupListValidator gradingGroupListValidator;

    Map<Long, GradingGroupList> gradingGroupListMap = new HashMap<Long, GradingGroupList>();

    @ResponseBody
    @GetMapping(path = "/getGradingGroupList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<GradingGroupList> getGradingGroupList() {

        List<GradingGroupList> list = new ArrayList<>();
        Iterable<GradingGroupList> items = gradingGroupListRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/gradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingGroupList addToGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {
      //  GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);
        return gradingGroupListRepository.save(gradingGroupList);
    }

    @ResponseBody
    @PutMapping(path = "/updateGradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GradingGroupList> editGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {
     //   GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);

        return gradingGroupListRepository.findById(gradingGroupList.getGradeGroupId())
                .map(oldItem -> {
                    GradingGroupList updated = oldItem.updateWith(gradingGroupList);
                    return gradingGroupListRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/gradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {
     //   GradingGroupList gradingGroupList = gradingGroupListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @PutMapping(path = "/deleteGradingGroupList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<GradingGroupList>> deleteGradingGroupList(@RequestBody GradingGroupList gradingGroupList) {

      //  GradingGroupList collegeSchool = gradingGroupListServiceV1.doService(reqBody);
        gradingGroupListRepository.delete(gradingGroupList);
        return ResponseEntity.noContent().build();
    }
    
    @ResponseBody
    @GetMapping(path = "/getGradingGroupListId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxActivityListId() {

    	return gradingGroupListRepository.getMaxId();
       
    }
}
