package com.kastech.blumen.service;

import com.kastech.blumen.model.Councilor;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CouncilorServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouncilorServiceV1.class);

    public Councilor doService(String reqBody){

        Councilor pullDown = CommonUtil.convertJsonStringToPojoForCouncilor(reqBody);


        return pullDown;
    }
}
