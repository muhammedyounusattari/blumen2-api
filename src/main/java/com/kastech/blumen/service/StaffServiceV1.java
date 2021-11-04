package com.kastech.blumen.service;

import com.kastech.blumen.model.Staff;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StaffServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaffServiceV1.class);

    public Staff doService(String reqBody){

        Staff staff = CommonUtil.convertJsonStringToPojoForStaff(reqBody);


        return staff;
    }
}
