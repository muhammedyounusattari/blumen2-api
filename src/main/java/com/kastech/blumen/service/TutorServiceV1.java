package com.kastech.blumen.service;

import com.kastech.blumen.model.Tutor;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TutorServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(TutorServiceV1.class);

    public Tutor doService(String reqBody){

        Tutor tutor = CommonUtil.convertJsonStringToPojoForTutor(reqBody);


        return tutor;
    }
}
