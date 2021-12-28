package com.kastech.blumen.controller.admin.systemtools;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.repository.admin.systemtools.TimeClockManagerRepository;
import com.kastech.blumen.service.admin.systemtools.TimeClockManagerServiceV1;
import com.kastech.blumen.validator.admin.systemtools.TimeClockManagerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/admin/systemtools")
public class TimeClockManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeClockManagerController.class);

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
        Iterable<TimeClockManager> items = timeClockManagerRepository.findAll();
        items.forEach(list::add);
        return list;
    }


    @ResponseBody
    @PostMapping(path = "/timeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TimeClockManager addTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {
     //   TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);
        return timeClockManagerRepository.save(timeClockManager);
    }

    @ResponseBody
    @PutMapping(path = "/updateTimeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<TimeClockManager> editTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {
     //   TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);

        return timeClockManagerRepository.findById(timeClockManager.getId())
                .map(oldItem -> {
                    TimeClockManager updated = oldItem.updateWith(timeClockManager);
                    return timeClockManagerRepository.save(updated);
                });
    }


    @ResponseBody
    @PutMapping(path = "/filter/timeClockManagerlist/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> filterTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {
     //   TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);
        return ResponseEntity.status(HttpStatus.OK).body("filter pull down list");
    }


    @ResponseBody
    @DeleteMapping(path = "/deleteTimeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> deleteTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {


      //  TimeClockManager timeClockManager = timeClockManagerServiceV1.doService(reqBody);
        timeClockManagerRepository.delete(timeClockManager);
       // return ResponseEntity.noContent().build();
        return new ResponseEntity(new Response(200, "success"), null, HttpStatus.OK);
    }
}
