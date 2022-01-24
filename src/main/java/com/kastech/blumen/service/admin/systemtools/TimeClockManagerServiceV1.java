package com.kastech.blumen.service.admin.systemtools;

import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeClockManagerServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteStudentsServiceV1.class);

    public static final String datePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS'Z'";

    public TimeClockManager doService(String reqBody) {


        TimeClockManager timeClockManager = CommonUtil.convertJsonStringToPojoForTimeClockManager(reqBody);


        return timeClockManager;

    }

    public TimeClockManager calculateTimeClockDuration(TimeClockManager timeClockManager) {
        final String dateStart = timeClockManager.getCheckInTime();
        final String dateStop = timeClockManager.getCheckOutTime();
        String duration = findDifference(dateStart, dateStop);
        timeClockManager.setDuration(duration);

        return timeClockManager;
    }

    public String findDifference(String start_date, String end_date) {

        String finalValue = null;
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        Date d1 = null;
        Date d2 = null;
        try {

            if (null != start_date) {
                d1 = sdf.parse(start_date);
            }

            if (null != end_date) {
                d2 = sdf.parse(end_date);
            }

           /* System.out.println("date 1 " + d1);
            System.out.println("date 2 " + d2);
            System.out.println("----------------");

            System.out.println("time 1 " + d1.getTime());
            System.out.println("time 2 " + d2.getTime());*/

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            String hours = diffHours+"";
            String minutes = diffMinutes+"";

            if (hours.length()==1) {
                hours = "0" + diffHours;
            }

            if (minutes.length()==1) {
                minutes = "0" + diffMinutes;
            }

            if (!(diffDays < 1)) {
                finalValue = diffDays + " days " + hours.replace("-", "") + ":" + minutes.replace("-", "");

            } else {
                finalValue = hours.replace("-", "") + ":" + minutes.replace("-", "");
            }

          /*  if (!(diffDays < 1)) {
                finalValue = diffDays + " days " + diffHours + ":" + diffMinutes;

            } else {
                finalValue = diffHours + ":" + diffMinutes;
            }*/


        } catch (Exception e) {
            LOGGER.error("Date exception : " + e);
        }
        return finalValue;
    }
}
