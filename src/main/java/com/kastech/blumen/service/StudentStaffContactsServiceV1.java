package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentStaffContacts;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentStaffContactsServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentStaffContactsServiceV1.class);

    public StudentStaffContacts doService(String reqBody){

        StudentStaffContacts studentStaffContacts = CommonUtil.convertJsonStringToPojoForStudentStaffContacts(reqBody);

        return studentStaffContacts;
    }
}
