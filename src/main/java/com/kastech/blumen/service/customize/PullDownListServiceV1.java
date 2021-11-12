package com.kastech.blumen.service.customize;

import com.kastech.blumen.model.customize.PullDown;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PullDownListServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PullDownListServiceV1.class);

    public PullDown doService(String reqBody){

        PullDown pullDown = CommonUtil.convertJsonStringToPojoForPullDown(reqBody);


        return pullDown;
    }

}
