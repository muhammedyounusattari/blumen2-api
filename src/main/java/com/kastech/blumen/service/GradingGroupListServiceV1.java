package com.kastech.blumen.service;

import com.kastech.blumen.model.GradingGroupList;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GradingGroupListServiceV1 {


    private static final Logger LOGGER = LoggerFactory.getLogger(GradingGroupListServiceV1.class);

    public GradingGroupList doService(String reqBody){

        GradingGroupList gradingGroupList = CommonUtil.convertJsonStringToPojoForGradingGroupList(reqBody);


        return gradingGroupList;
    }
}
