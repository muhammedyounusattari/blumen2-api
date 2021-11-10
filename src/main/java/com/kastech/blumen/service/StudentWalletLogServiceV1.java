package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentWalletLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentWalletLogServiceV1 {


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentWalletLogServiceV1.class);

    public StudentWalletLog doService(String reqBody){

        StudentWalletLog studentWalletLog = CommonUtil.convertJsonStringToPojoForStudentWalletLog(reqBody);

        return studentWalletLog;
    }

}
