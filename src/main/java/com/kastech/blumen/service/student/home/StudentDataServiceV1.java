package com.kastech.blumen.service.student.home;

import com.kastech.blumen.model.student.home.StudentData;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentDataServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDataServiceV1.class);

    public StudentData doService(String reqBody){

        StudentData student = CommonUtil.convertJsonStringToPojoForStudent(reqBody);

        return student;
    }
}
