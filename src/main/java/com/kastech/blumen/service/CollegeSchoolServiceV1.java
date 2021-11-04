package com.kastech.blumen.service;

import com.kastech.blumen.model.CollegeSchool;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CollegeSchoolServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListServiceV1.class);

    public CollegeSchool doService(String reqBody){

        CollegeSchool schoolCollege = CommonUtil.convertJsonStringToPojoForSchoolCollege(reqBody);


        return schoolCollege;
    }
}
