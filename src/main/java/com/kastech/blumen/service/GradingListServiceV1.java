package com.kastech.blumen.service;

import com.kastech.blumen.model.GradingList;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GradingListServiceV1 {


    private static final Logger LOGGER = LoggerFactory.getLogger(GradingListServiceV1.class);

    public GradingList doService(String reqBody){

        GradingList gradingList = CommonUtil.convertJsonStringToPojoForGradingList(reqBody);


        return gradingList;
    }
}
