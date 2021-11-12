package com.kastech.blumen.service.student.logs;

import com.kastech.blumen.model.student.logs.StudentBotFormSubmissLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentBotFormSubmissLogServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentBotFormSubmissLogServiceV1.class);

    public StudentBotFormSubmissLog doService(String reqBody){

        StudentBotFormSubmissLog studentBotFormSubmissLog = CommonUtil.convertJsonStringToPojoForStudentBotFormSubmissLog(reqBody);

        return studentBotFormSubmissLog;
    }
}
