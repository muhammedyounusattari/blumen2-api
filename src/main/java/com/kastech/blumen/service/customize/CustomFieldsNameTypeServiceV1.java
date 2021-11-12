package com.kastech.blumen.service.customize;

import com.kastech.blumen.model.customize.CollegeSchool;
import com.kastech.blumen.model.customize.CustomFieldsNameType;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomFieldsNameTypeServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomFieldsNameTypeServiceV1.class);

    public CustomFieldsNameType doService(String reqBody){

        CustomFieldsNameType customFieldsNameType = CommonUtil.convertJsonStringToPojoForCustomFieldsNameType(reqBody);


        return customFieldsNameType;
    }
}
