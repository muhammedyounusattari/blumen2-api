package com.kastech.blumen.service.utilities.quickedit;

import com.kastech.blumen.model.StudentProfile;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentsDemographicInfoServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentsDemographicInfoServiceV1.class);

    public StudentProfile doService(String reqBody){

        StudentProfile studentProfile = CommonUtil.convertJsonStringToPojoForStudentProfile(reqBody);


        return studentProfile;
    }
}
