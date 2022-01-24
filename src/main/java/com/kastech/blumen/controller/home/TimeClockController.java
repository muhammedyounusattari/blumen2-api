package com.kastech.blumen.controller.home;

import java.text.SimpleDateFormat;
import java.util.*;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.repository.admin.systemtools.TimeClockManagerRepository;
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
    private RestTemplate restTemplate;

  /*  @ResponseBody
    @GetMapping(path = "/getStaff/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Collection<Staff>> getStaffList() {
        LOGGER.info("call received for getStaffList under TimeClockController");
        return ResponseEntity.ok(timeClockService.getStaffList());
    }


    @ResponseBody
    @PostMapping(path = "/postStaffTime/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Staff> postSystemPreferenceData(@RequestBody Staff staff) {
        LOGGER.info("Inside postSystemPreferenceData");
        return ResponseEntity.ok(timeClockService.saveOrUpdateStaffTime(staff));
    }*/


    @ResponseBody
    @GetMapping(path = "/getStaffById/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> getStaffClockInTime(@RequestParam(value = "staffId") String staffId) {

        ResponseEntity<String> responseEntity = null;
        List<TimeClockManager> timeClockManagerObjList = timeClockManagerRepository.findAllStaffById(staffId);
        TimeClockManager timeClockManager = timeClockManagerObjList.get(0);
        String highestCheckOutTime = timeClockManager.getCheckOutTime();
        String todayTimeStamp = new SimpleDateFormat(datePattern).format(new Date());
        if (timeClockManagerValidator.compareTwoDates(todayTimeStamp, highestCheckOutTime)) {

        } else {
            String response = timeClockManager.getStaffName() + " last clocked Out on " + highestCheckOutTime;
            //JAMES last clocked Out on 01/04/2024 03:39:00 AM
            responseEntity = new ResponseEntity(new Response(200, response), null, HttpStatus.OK);
        }
        return responseEntity;
    }

    @ResponseBody
    @PostMapping(path = "/postStaffTime/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> postSystemPreferenceData(@RequestBody TimeClockManager timeClockManager) {
        LOGGER.info("Inside postSystemPreferenceData");
        ResponseEntity<String> responseEntity = null;
        String staffName = timeClockManager.getStaffName();
        String currentTimeStamp = new SimpleDateFormat(datePattern).format(new Date());
        TimeClockManager createTimeClockManagerRequest = new TimeClockManager();
        createTimeClockManagerRequest.setCheckInTime(currentTimeStamp);
        //createTimeClockManagerRequest.setCheckOutTime(currentTimeStamp);
        createTimeClockManagerRequest.setStaffId(timeClockManager.getStaffId());
        createTimeClockManagerRequest.setStaffName(timeClockManager.getStaffName());

        timeClockManagerRepository.save(createTimeClockManagerRequest);

        return new ResponseEntity(new Response(200, staffName + " has clocked in at " + currentTimeStamp), null, HttpStatus.OK);
    }

      /*  LOGGER.info("call received for getStaffList under TimeClockController");
        ResponseEntity<String> responseEntity = null;
        Optional<TimeClockManager> timeClockManagerObj = timeClockManagerRepository.findById(Long.parseLong(staffId));

        if (null != timeClockManagerObj) {
            String clockInTime = timeClockManagerObj.get().getCheckInTime();
            LOGGER.info("clockintime for for staffId " + staffId + " is " + clockInTime);

            String timeClockManagerPostUrlEndPoint = "https://blumen-api.azurewebsites.net:443/api/blumen-api/admin/systemtools/timeClockManagerList/v1";
            String currentTimeStamp = new SimpleDateFormat(datePattern).format(new Date());
            System.out.println("URL" + timeClockManagerPostUrlEndPoint);

            TimeClockManager outputTimeClockManager = null;
            HttpHeaders headers = new HttpHeaders();
            headers.set(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

            TimeClockManager createTimeClockManagerRequest = new TimeClockManager();
            createTimeClockManagerRequest.setCheckInTime(clockInTime);
            createTimeClockManagerRequest.setCheckOutTime(currentTimeStamp);
            createTimeClockManagerRequest.setStaffId(staffId);
            HttpEntity<TimeClockManager> createPhoneEntity = new HttpEntity<>(createTimeClockManagerRequest, headers);
            ResponseEntity<TimeClockManager> timeClockManagerResponseEntity = postTimeClockManager(timeClockManagerPostUrlEndPoint, createPhoneEntity);

            if (HttpStatus.OK == timeClockManagerResponseEntity.getStatusCode()) {
                outputTimeClockManager = timeClockManagerResponseEntity.getBody();
            }


            responseEntity = new ResponseEntity(new Response(200, clockInTime), null, HttpStatus.OK);
        }


        return responseEntity;
    }*/

    private ResponseEntity<TimeClockManager> postTimeClockManager(String postTimeClockManagerEndPoint, HttpEntity<?> entity) {
        return restTemplate.exchange(postTimeClockManagerEndPoint, HttpMethod.POST, entity, TimeClockManager.class);
    }


   /* public void callTimeClockManagerPostApi(){
        String timeClockManagerPostUrlEndPoint = "https://blumen-api.azurewebsites.net:443/api/blumen-api/admin/systemtools/timeClockManagerList/v1";
        String currentTimeStamp = new SimpleDateFormat(datePattern).format(new Date());
        System.out.println("URL" + timeClockManagerPostUrlEndPoint);

        TimeClockManager outputTimeClockManager = null;
        HttpHeaders headers = new HttpHeaders();
        headers.set(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        TimeClockManager createTimeClockManagerRequest = new TimeClockManager();
        createTimeClockManagerRequest.setCheckInTime(currentTimeStamp);
        //createTimeClockManagerRequest.setCheckOutTime(currentTimeStamp);
        createTimeClockManagerRequest.setStaffId(staffId);
        HttpEntity<TimeClockManager> createPhoneEntity = new HttpEntity<>(createTimeClockManagerRequest, headers);
        ResponseEntity<TimeClockManager> timeClockManagerResponseEntity = postTimeClockManager(timeClockManagerPostUrlEndPoint, createPhoneEntity);

        if (HttpStatus.OK == timeClockManagerResponseEntity.getStatusCode()) {
            outputTimeClockManager = timeClockManagerResponseEntity.getBody();
        }


        responseEntity = new ResponseEntity(new Response(200, clockInTime), null, HttpStatus.OK);
    }*/


}
