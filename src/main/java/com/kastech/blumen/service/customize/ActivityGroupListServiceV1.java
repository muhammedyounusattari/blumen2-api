package com.kastech.blumen.service.customize;

import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ActivityGroupListServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListServiceV1.class);

    public ActivityGroupList doService(String reqBody) {

        ActivityGroupList activityList = CommonUtil.convertJsonStringToPojoForActivityGroupList(reqBody);


        return activityList;
    }
}
