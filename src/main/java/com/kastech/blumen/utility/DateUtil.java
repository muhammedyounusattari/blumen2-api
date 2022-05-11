package com.kastech.blumen.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtil.class);
    public static final String DATE_FORMAT_TYPE = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    public static final ZoneId zoneid = ZoneId.of("US/Central");
    public static final LocalDateTime now = LocalDateTime.now(zoneid);
    public static final ZonedDateTime zdt = now.atZone(zoneid);
    public static final String DATE_FORMAT_TYPE_SYNC = "yyyy-MM-dd";

    public static boolean compareTwoDates(String dateTimeOne, String dateTimeTwo) {

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_TYPE_SYNC);
        Date date1 = null;
        Date date2 = null;

        try {
            date1 = sdf.parse(dateTimeOne);
            date2 = sdf.parse(dateTimeTwo);
        } catch (java.text.ParseException e) {
            LOGGER.error("Date parse exception while compareting two dates : {} ", e.getMessage());
        }

        if (null != date1 && null != date2) {
            if (date1.after(date2)) {
                return true;
            }
        } else {
            LOGGER.error("Date value is date1 : {} and date2 : {} ", date1, date2);
        }
        return false;

    }

    public static Date setDates(int date){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, date);
        dt = c.getTime();
        return dt;
    }

    public static Date setMinutes(int min){
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.MINUTE, min);
        dt = c.getTime();
        return dt;
    }
}
