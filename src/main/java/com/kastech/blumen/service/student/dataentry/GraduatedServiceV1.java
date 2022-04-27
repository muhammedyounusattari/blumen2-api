package com.kastech.blumen.service.student.dataentry;

import com.kastech.blumen.model.student.dataentry.AddressNotes;
import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GraduatedServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraduatedServiceV1.class);

    public GraduatedInformation doService(String reqBody){

        GraduatedInformation graduatedInformation = CommonUtil.convertJsonStringToPojoForGraduatedInformation(reqBody);

        return graduatedInformation;
    }

    public AddressNotes doServiceForAddressNotes(String reqBody){

        AddressNotes addressNotes = CommonUtil.convertJsonStringToPojoForAddressNotes(reqBody);

        return addressNotes;
    }
}
