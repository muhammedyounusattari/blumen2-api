package com.kastech.blumen.controller.admin.systemtools;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.repository.admin.systemtools.SearchCriteria;
import com.kastech.blumen.repository.admin.systemtools.TimeClockManagerRepository;
import com.kastech.blumen.repository.admin.systemtools.TimeClockSpecification;
import com.kastech.blumen.service.admin.systemtools.TimeClockManagerServiceV1;
import com.kastech.blumen.validator.admin.systemtools.TimeClockManagerValidator;
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
@RequestMapping("/api/blumen-api/admin/systemtools")
public class TimeClockManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeClockManagerController.class);

    public static final String datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";

    @Autowired
    TimeClockManagerRepository timeClockManagerRepository;

    @Autowired
    TimeClockManagerServiceV1 timeClockManagerServiceV1;


    @Autowired
    TimeClockManagerValidator timeClockManagerValidator;

    List<TimeClockManager> studentList = new ArrayList<TimeClockManager>();

    Map<Long, TimeClockManager> timeClockManagerMap = new HashMap<Long, TimeClockManager>();


    @ResponseBody
    @GetMapping(path = "/getTimeClockManagerList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TimeClockManager> getTimeClockManagerList() {
        List<TimeClockManager> list = new ArrayList<>();
        Iterable<TimeClockManager> items = timeClockManagerRepository.findAll(Sort.by(Sort.Direction.ASC, "staffName"));
        items.forEach(list::add);
        return list;
    }


    @ResponseBody
    @PostMapping(path = "/timeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {
        ResponseEntity<String> responseEntity = null;
        String validateResult = timeClockManagerValidator.validateTwoDates(timeClockManager);
        if ("success".equals(validateResult)) {
            TimeClockManager timeClockManagerDurationObj = timeClockManagerServiceV1.calculateTimeClockDuration(timeClockManager);

            TimeClockManager timeClockManagerResult = timeClockManagerRepository.save(timeClockManagerDurationObj);

            if (null != timeClockManagerResult) {
                responseEntity = new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
            }
        } else {
            responseEntity = new ResponseEntity(new Response(200, validateResult), null, HttpStatus.OK);
        }
        return responseEntity;
    }

    @ResponseBody
    @PutMapping(path = "/updateTimeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TimeClockManager editTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {

        TimeClockManager timeClockManagerDurationObj = timeClockManagerServiceV1.calculateTimeClockDuration(timeClockManager);

        return timeClockManagerRepository.save(timeClockManagerDurationObj);
    }


    @ResponseBody
    @PutMapping(path = "/filter/timeClockManagerlist/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TimeClockManager> filterTimeClockManagerList(@RequestParam(value = "name") String name) {

        TimeClockSpecification timeClockSpecification = new TimeClockSpecification();
        timeClockSpecification.add(new SearchCriteria("staffName", name, QueryOperator.EQUAL));
        List<TimeClockManager> timeClockManagerList = timeClockManagerRepository.findAll(timeClockSpecification);
        timeClockManagerList.forEach(System.out::println);

        return timeClockManagerList;
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteTimeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {

        timeClockManagerRepository.delete(timeClockManager);

        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }

}
