package com.kastech.blumen.service.admin.systemtools;

import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TimeClockManagerServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeleteStudentsServiceV1.class);

    public TimeClockManager doService(String reqBody) {


        TimeClockManager timeClockManager = CommonUtil.convertJsonStringToPojoForTimeClockManager(reqBody);


        return timeClockManager;

    }
}
