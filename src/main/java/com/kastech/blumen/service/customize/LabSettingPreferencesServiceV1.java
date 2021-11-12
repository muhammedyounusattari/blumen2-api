package com.kastech.blumen.service.customize;

import com.kastech.blumen.model.customize.LabSettingPreferences;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LabSettingPreferencesServiceV1 {


    private static final Logger LOGGER = LoggerFactory.getLogger(LabSettingPreferencesServiceV1.class);

    public LabSettingPreferences doService(String reqBody){

        LabSettingPreferences gradingList = CommonUtil.convertJsonStringToPojoForLabSettingPreferences(reqBody);


        return gradingList;
    }
}
