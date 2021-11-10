package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentDispTutorContReminder;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentDispTutorContReminderServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispTutorContReminderServiceV1.class);

    public StudentDispTutorContReminder doService(String reqBody){

        StudentDispTutorContReminder studentDispTutorContReminder = CommonUtil.convertJsonStringToPojoForStudentDispTutorContReminder(reqBody);

        return studentDispTutorContReminder;
    }

}
