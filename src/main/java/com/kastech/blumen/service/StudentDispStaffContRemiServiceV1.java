package com.kastech.blumen.service;

import com.kastech.blumen.model.StudentDispStaffContReminder;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentDispStaffContRemiServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispStaffContRemiServiceV1.class);

    public StudentDispStaffContReminder doService(String reqBody){

        StudentDispStaffContReminder studentDispStaffCont = CommonUtil.convertJsonStringToPojoForStudentDispStaffCont(reqBody);

        return studentDispStaffCont;
    }

}
