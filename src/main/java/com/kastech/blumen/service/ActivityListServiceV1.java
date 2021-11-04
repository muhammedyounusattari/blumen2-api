package com.kastech.blumen.service;

import com.kastech.blumen.model.ActivityList;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ActivityListServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListServiceV1.class);

    public ActivityList doService(String reqBody) {

        ActivityList activityList = CommonUtil.convertJsonStringToPojoForActivityList(reqBody);


        return activityList;
    }
}
