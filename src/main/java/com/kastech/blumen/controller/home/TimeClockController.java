package com.kastech.blumen.controller.home;

import java.text.SimpleDateFormat;
import java.util.*;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.repository.admin.systemtools.TimeClockManagerRepository;
import com.kastech.blumen.repository.staff.StaffRepository;
import com.kastech.blumen.service.admin.systemtools.TimeClockManagerServiceV1;
import com.kastech.blumen.validator.admin.systemtools.TimeClockManagerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.kastech.blumen.model.staff.Staff;
import com.kastech.blumen.service.home.TimeClockService;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/blumen-api")
public class TimeClockController {

    @Autowired
    private TimeClockService timeClockService;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public static final String datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";
    public static final String CONTENT_TYPE = "Content-Type";

    @Autowired
    TimeClockManagerRepository timeClockManagerRepository;

    @Autowired
    TimeClockManagerValidator timeClockManagerValidator;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping(path = "/getStaffTimeById/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getStaffClockInClockOutTime(@RequestParam(value = "staffId") String staffId) {

        ResponseEntity<String> responseEntity = null;
        List<TimeClockManager> timeClockManagerObjList = timeClockManagerRepository.findAllStaffByIdOrderByCheckoutTime(staffId);
        if (timeClockManagerObjList.isEmpty()) {
            Optional<Staff> staffObj = staffRepository.findById(Long.parseLong(staffId));
            String currentTimeStamp = new SimpleDateFormat(datePattern).format(new Date());
            Staff staff = staffObj.get();
            TimeClockManager timeClockManager = new TimeClockManager();
            timeClockManager.setStaffName(staff.getStaffName());
            timeClockManager.setStaffId(staff.getId() + "");
            timeClockManager.setCheckInTime(currentTimeStamp);
            timeClockManagerRepository.save(timeClockManager);
            String response = timeClockManager.getStaffName() + " last clocked out time on ";
            responseEntity = new ResponseEntity(new Response(200, response), null, HttpStatus.OK);
        } else if (timeClockManagerObjList.size() > 1) {
            TimeClockManager timeClockManager = timeClockManagerObjList.get(1);
            String lastClockedInTime = timeClockManager.getCheckInTime();
            String response = timeClockManager.getStaffName() + " last clocked in time on " + lastClockedInTime;
            responseEntity = new ResponseEntity(new Response(200, response), null, HttpStatus.OK);

        } else {
            TimeClockManager timeClockManager = timeClockManagerObjList.get(0);
            String highestCheckOutTime = timeClockManager.getCheckOutTime();
            String response = timeClockManager.getStaffName() + " last clocked Out on " + highestCheckOutTime;
            responseEntity = new ResponseEntity(new Response(200, response), null, HttpStatus.OK);
        }


        /*   String todayTimeStamp = new SimpleDateFormat(datePattern).format(new Date());
         *//* if (timeClockManagerValidator.compareTwoDates(todayTimeStamp, highestCheckOutTime)) {

        } else {*//*

        //JAMES last clocked Out on 01/04/2024 03:39:00 AM

        //  }*/
        return responseEntity;
    }

    @ResponseBody
    @PostMapping(path = "/postStaffTime/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> postStaffClockInClockOutTime(@RequestBody TimeClockManager timeClockManager) {
        LOGGER.info("Inside postSystemPreferenceData");
        ResponseEntity<String> responseEntity = null;
        String staffName = timeClockManager.getStaffName();
        String currentTimeStamp = new SimpleDateFormat(datePattern).format(new Date());
        String statusClockInOrOut = timeClockManager.getStatusInOut();
        if ("clock-in".equals(statusClockInOrOut)) {
            TimeClockManager createInTimeClockManagerRequest = new TimeClockManager();
            createInTimeClockManagerRequest.setCheckInTime(currentTimeStamp);
            //createTimeClockManagerRequest.setCheckOutTime(currentTimeStamp);
            createInTimeClockManagerRequest.setStaffId(timeClockManager.getStaffId());
            createInTimeClockManagerRequest.setStaffName(timeClockManager.getStaffName());
            timeClockManagerRepository.save(createInTimeClockManagerRequest);
            responseEntity = new ResponseEntity(new Response(200, staffName + " has Clocked In at " + currentTimeStamp), null, HttpStatus.OK);
        } else if ("clock-out".equals(statusClockInOrOut)) {
            TimeClockManager createOutTimeClockManagerRequest = new TimeClockManager();
            createOutTimeClockManagerRequest.setCheckInTime(timeClockManager.getCheckInTime());
            createOutTimeClockManagerRequest.setCheckOutTime(currentTimeStamp);
            createOutTimeClockManagerRequest.setStaffId(timeClockManager.getStaffId());
            createOutTimeClockManagerRequest.setStaffName(timeClockManager.getStaffName());
            createOutTimeClockManagerRequest.setDuration(TimeClockManagerServiceV1.findDifference(timeClockManager.getCheckInTime(), currentTimeStamp));
            timeClockManagerRepository.save(createOutTimeClockManagerRequest);
            responseEntity = new ResponseEntity(new Response(200, staffName + " has Clocked Out at " + currentTimeStamp), null, HttpStatus.OK);
        }

        return responseEntity;
    }


}