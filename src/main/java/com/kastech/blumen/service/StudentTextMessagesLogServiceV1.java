package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentTextMessagesLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentTextMessagesLogServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesLogServiceV1.class);

    public StudentTextMessagesLog doService(String reqBody){

        StudentTextMessagesLog studentTextMessagesLog = CommonUtil.convertJsonStringToPojoForStudentTextMessagesLog(reqBody);

        return studentTextMessagesLog;
    }

}
