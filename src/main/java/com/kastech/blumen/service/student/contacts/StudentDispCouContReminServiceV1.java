package com.kastech.blumen.service.student.contacts;

import com.kastech.blumen.model.student.contacts.StudentDispCouContRemin;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentDispCouContReminServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispCouContReminServiceV1.class);

    public StudentDispCouContRemin doService(String reqBody){

        StudentDispCouContRemin studentDispCouContRemin = CommonUtil.convertJsonStringToPojoForStudentDispCouContRemin(reqBody);

        return studentDispCouContRemin;
    }

}
