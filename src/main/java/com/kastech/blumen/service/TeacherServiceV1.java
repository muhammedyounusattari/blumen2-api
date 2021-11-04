package com.kastech.blumen.service;

import com.kastech.blumen.model.Teacher;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TeacherServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherServiceV1.class);

    public Teacher doService(String reqBody){

        Teacher teacher = CommonUtil.convertJsonStringToPojoForTeacher(reqBody);


        return teacher;
    }
}
