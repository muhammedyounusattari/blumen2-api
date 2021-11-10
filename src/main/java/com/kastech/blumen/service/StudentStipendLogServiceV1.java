package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentStipendLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentStipendLogServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentStipendLogServiceV1.class);

    public StudentStipendLog doService(String reqBody){

        StudentStipendLog studentStipendLog = CommonUtil.convertJsonStringToPojoForStudentStipendLog(reqBody);

        return studentStipendLog;
    }

}
