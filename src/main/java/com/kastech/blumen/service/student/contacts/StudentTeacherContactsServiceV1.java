package com.kastech.blumen.service.student.contacts;

import com.kastech.blumen.model.student.contacts.StudentTeacherContacts;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentTeacherContactsServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTeacherContactsServiceV1.class);

    public StudentTeacherContacts doService(String reqBody){

        StudentTeacherContacts studentTeacherContacts = CommonUtil.convertJsonStringToPojoForStudentTeacherContacts(reqBody);

        return studentTeacherContacts;
    }

}
