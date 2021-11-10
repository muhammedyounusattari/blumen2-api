package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentNotesLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentNotesLogServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentNotesLogServiceV1.class);

    public StudentNotesLog doService(String reqBody){

        StudentNotesLog studentNotesLog = CommonUtil.convertJsonStringToPojoForStudentNotesLog(reqBody);

        return studentNotesLog;
    }
}
