package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentAttendanceLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentAttendanceLogServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAttendanceLogServiceV1.class);

    public StudentAttendanceLog doService(String reqBody) {

        StudentAttendanceLog studentAttendanceLog = CommonUtil.convertJsonStringToPojoForStudentAttendanceLog(reqBody);


        return studentAttendanceLog;

    }
}

/*ObjectMapper mapper = new ObjectMapper();

        StudentAttendanceLog staff   = null;
        try {
            staff = mapper.readValue(CommonUtil.convertJsonStringToPojo1(reqBody), StudentAttendanceLog.class);
        } catch (IOException e) {
            e.printStackTrace();
        }*/