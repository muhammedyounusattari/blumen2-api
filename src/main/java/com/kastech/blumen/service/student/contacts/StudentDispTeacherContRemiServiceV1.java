package com.kastech.blumen.service.student.contacts;

import com.kastech.blumen.model.student.contacts.StudentDispTeacherContRemi;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentDispTeacherContRemiServiceV1 {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentDispTeacherContRemiServiceV1.class);

    public StudentDispTeacherContRemi doService(String reqBody){

        StudentDispTeacherContRemi teacher = CommonUtil.convertJsonStringToPojoForStudentDispTeacherContRemi(reqBody);

        return teacher;
    }

}
