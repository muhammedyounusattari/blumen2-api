package com.kastech.blumen.service.utilities.addto;

import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FiscalYearServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(FiscalYearServiceV1.class);

    public Tutor doService(String reqBody){

        Tutor tutor = CommonUtil.convertJsonStringToPojoForTutor(reqBody);


        return tutor;
    }
}
