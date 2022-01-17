package com.kastech.blumen.controller.admin.systemtools;

import com.kastech.blumen.model.Response;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.repository.admin.systemtools.TimeClockManagerRepository;
import com.kastech.blumen.service.admin.systemtools.TimeClockManagerServiceV1;
import com.kastech.blumen.validator.admin.systemtools.TimeClockManagerValidator;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        Iterable<TimeClockManager> items = timeClockManagerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        items.forEach(list::add);
        return list;
    }


    @ResponseBody
    @PostMapping(path = "/timeClockManagerList/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TimeClockManager addTimeClockManagerList(@RequestBody TimeClockManager timeClockManager) {
        final String dateStart = timeClockManager.getCheckInTime();
        final String dateStop = timeClockManager.getCheckOutTime();
        String duration = findDifference(dateStart, dateStop);
        timeClockManager.setDuration(duration);
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
                    final String dateStart = timeClockManager.getCheckInTime();
                    final String dateStop = timeClockManager.getCheckOutTime();
                    String duration = findDifference(dateStart, dateStop);
                    updated.setDuration(duration);
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

    public static String
    findDifference(String start_date,
                   String end_date) {

        String durationCalculation = null;
        long daysBetween=0;
        Long difference_In_Hours = null;
        Long difference_In_Minutes = null;

        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                datePattern);

        // Try Block
        try {

            // parse method is used to parse
            // the text from a string to
            // produce the date
            Date d1 = sdf.parse(start_date);
            Date d2 = sdf.parse(end_date);

            long diff = d1.getTime()/*+28800000 */- d2.getTime()/*+28800000*/;
            daysBetween = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
            // Calucalte time difference
            // in milliseconds
            long difference_In_Time
                    = d2.getTime() - d1.getTime();

            // Calucalte time difference in
            // seconds, minutes, hours, years,
            // and days
            long difference_In_Seconds
                    = (difference_In_Time
                    / 1000)
                    % 60;

             difference_In_Minutes
                    = (difference_In_Time
                    / (1000 * 60))
                    % 60;

             difference_In_Hours
                    = (difference_In_Time
                    / (1000 * 60 * 60))
                    % 24;

        /*    long difference_In_Years
                    = (difference_In_Time
                    / (1000l * 60 * 60 * 24 * 365));

            long difference_In_Days
                    = (difference_In_Time
                    / (1000 * 60 * 60 * 24))
                    % 365;*/

            // Print the date difference in
            // years, in days, in hours, in
            // minutes, and in seconds

          /*  System.out.print(
                    "Difference "
                            + "between two dates is: ");


            difference = difference_In_Years
                    + " years, "
                    + difference_In_Days
                    + " days, "
                    + difference_In_Hours
                    + " hours, "
                    + difference_In_Minutes
                    + " minutes, "
                    + difference_In_Seconds
                    + " seconds";
            System.out.println(
                    difference_In_Years
                            + " years, "
                            + difference_In_Days
                            + " days, "
                            + difference_In_Hours
                            + " hours, "
                            + difference_In_Minutes
                            + " minutes, "
                            + difference_In_Seconds
                            + " seconds");*/
        }

        // Catch the Exception
        catch (Exception e) {
            e.printStackTrace();
        }

        String finalHours = null;
        String finalMinutes = null;
        String diffHours = difference_In_Hours+"";
        String diffMinutes = difference_In_Minutes+"";
        if(diffHours.length()==1){
            finalHours = "0"+diffHours;
        }else {
            finalHours = diffHours;
        }
        if(diffMinutes.length()==1){
            finalMinutes = "0"+diffMinutes;
        }else{
            finalMinutes = diffMinutes;
        }

        if(daysBetween>0) {

            durationCalculation = daysBetween + " days " .replace("-", "") + finalHours + ":" + finalMinutes;
        }else if(finalHours!=null && finalMinutes!=null){
            durationCalculation = finalHours + ":" + finalMinutes;
        }

        return durationCalculation;
    }

}
