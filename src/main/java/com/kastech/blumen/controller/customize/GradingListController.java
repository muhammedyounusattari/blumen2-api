package com.kastech.blumen.controller.customize;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.customize.GradingList;
import com.kastech.blumen.repository.customize.GradingListRepository;
import com.kastech.blumen.service.customize.GradingListServiceV1;
import com.kastech.blumen.validator.customize.GradingListValidator;
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
public class GradingListController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GradingListController.class);

    @Autowired
    GradingListRepository gradingListRepository;

    @Autowired
    GradingListServiceV1 gradingListServiceV1;


    @Autowired
    GradingListValidator gradingListValidator;

    Map<Long, GradingList> gradingListMap = new HashMap<Long, GradingList>();

    @ResponseBody
    @GetMapping(path = "/getGradingList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<GradingList> getGradingList() {

        List<GradingList> list = new ArrayList<>();
        Iterable<GradingList> items = gradingListRepository.findAll();
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/gradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public GradingList addToGradingList(@RequestBody GradingList gradingList) {

      //  GradingList activityList = gradingListServiceV1.doService(reqBody);
        return gradingListRepository.save(gradingList);

    }

    @ResponseBody
    @PutMapping(path = "/updateGradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<GradingList> editGradingList(@RequestBody GradingList gradingList) {


      //  GradingList gradingList = gradingListServiceV1.doService(reqBody);

        return gradingListRepository.findById(gradingList.getGradingId())
                .map(oldItem -> {
                    GradingList updated = oldItem.updateWith(gradingList);
                    return gradingListRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/gradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterGradingList(@RequestBody GradingList gradingList) {
      //  GradingList activityList = gradingListServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteGradingList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteGradingList(@RequestBody GradingList gradingList) {

     //   GradingList gradingList = gradingListServiceV1.doService(reqBody);
        gradingListRepository.delete(gradingList);
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping(path = "/getMaxGradingListId/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Long getMaxActivityListId() {

    	return gradingListRepository.getMaxId();
       
    }
}
