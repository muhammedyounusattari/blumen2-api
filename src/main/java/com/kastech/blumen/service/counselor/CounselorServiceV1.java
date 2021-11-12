package com.kastech.blumen.service.counselor;

import com.kastech.blumen.model.counselor.Counselor;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CounselorServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounselorServiceV1.class);

    public Counselor doService(String reqBody){

        Counselor pullDown = CommonUtil.convertJsonStringToPojoForCouncilor(reqBody);


        return pullDown;
    }
}
