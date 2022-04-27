package com.kastech.blumen.validator.admin.systemtools;

import com.kastech.blumen.controller.admin.systemtools.TimeClockManagerController;
import com.kastech.blumen.exception.DataInputException;
import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.utility.ValidationUtility;
import com.kastech.blumen.validator.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.kastech.blumen.service.admin.systemtools.TimeClockManagerServiceV1.datePattern;

@Component
public class TimeClockManagerValidator extends RequestValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeClockManagerValidator.class);

    @Override
    public void validateJSONBasedRequest(RequestDataVO requestDataVO) throws DataInputException {

        ValidationUtility.parseJSONFailFast(requestDataVO);

    }

    public String validateTwoDates(TimeClockManager timeClockManager) {

        String responseMessage = null;
        final String dateStart = timeClockManager.getCheckInTime();
        final String dateStop = timeClockManager.getCheckOutTime();

        String finalValue = null;
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        Date d1 = null;
        Date d2 = null;
        try {

            if (null != dateStart) {
                d1 = sdf.parse(dateStart);
            }

            if (null != dateStop) {
                d2 = sdf.parse(dateStop);
            }

            //  if (null != dateStart && null != dateStop) {
            if (d1.after(d2) || d1.equals(d2)) {
                return "Clock Out Time Should be greater Than Clock in Time";
            }
            // }

        } catch (
                Exception e) {
            LOGGER.error("Exception while parsing " + e);
            responseMessage = "Start date or End date not correct";
            return responseMessage;
        }

        return "success";
    }


    public boolean compareTwoDates(String dateStart, String dateStop) {
        boolean status = false;
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);

        Date d1 = null;
        Date d2 = null;
        try {

            if (null != dateStart) {
                d1 = sdf.parse(dateStart);
            }

            if (null != dateStop) {
                d2 = sdf.parse(dateStop);
            }

            if (d1.after(d2)) {
                status = true;
            }

        } catch (Exception e) {
            LOGGER.error("Exception while parsing " + e);
        }

        return status;
    }
}
