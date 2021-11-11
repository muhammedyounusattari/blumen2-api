package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentTutorContacts;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentTutorContactsServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTutorContactsServiceV1.class);

    public StudentTutorContacts doService(String reqBody){

        StudentTutorContacts studentTutorContacts = CommonUtil.convertJsonStringToPojoForStudentTutorContacts(reqBody);

        return studentTutorContacts;
    }

}
