package com.kastech.blumen.service.utilities.addto;

import com.kastech.blumen.model.utilities.quickedit.CoursesInformation;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SemesterServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterServiceV1.class);

    public CoursesInformation doService(String reqBody){

        CoursesInformation coursesInformation = CommonUtil.convertJsonStringToPojoForCoursesInformation(reqBody);


        return coursesInformation;
    }
}
