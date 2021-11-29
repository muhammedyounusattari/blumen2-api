package com.kastech.blumen.service.utilities.quickedit;

import com.kastech.blumen.model.utilities.quickedit.Semester;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SemesterGPAInfoServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(SemesterGPAInfoServiceV1.class);

    public Semester doService(String reqBody){

        Semester semester = CommonUtil.convertJsonStringToPojoForSemester(reqBody);


        return semester;
    }
}
