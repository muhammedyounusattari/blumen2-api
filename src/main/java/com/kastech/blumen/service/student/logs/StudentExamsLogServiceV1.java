package com.kastech.blumen.service.student.logs;

import com.kastech.blumen.model.student.logs.StudentExamsLog;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentExamsLogServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentExamsLogServiceV1.class);

    public StudentExamsLog doService(String reqBody){

        StudentExamsLog studentExamsLog = CommonUtil.convertJsonStringToPojoForStudentExamsLog(reqBody);

        return studentExamsLog;
    }

}
