package com.kastech.blumen.service.utilities.quickedit;

import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CoursesInformationServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CoursesInformationServiceV1.class);

    public Tutor doService(String reqBody){

        Tutor tutor = CommonUtil.convertJsonStringToPojoForTutor(reqBody);


        return tutor;
    }
}
