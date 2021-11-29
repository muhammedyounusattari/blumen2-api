package com.kastech.blumen.service.utilities.addto.generatesimilar;

import com.kastech.blumen.model.utilities.generatesimilar.AttendanceLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AttendanceLogServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendanceLogServiceV1.class);

    public AttendanceLog doService(String reqBody){

        AttendanceLog attendanceLog = CommonUtil.convertJsonStringToPojoForAttendanceLog(reqBody);


        return attendanceLog;
    }
}
