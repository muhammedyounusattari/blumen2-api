package com.kastech.blumen.service.student.logs;

import com.kastech.blumen.model.student.logs.StudentTextMessagesReplies;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StudentTextMessagesRepliesServiceV1 {


    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesRepliesServiceV1.class);

    public StudentTextMessagesReplies doService(String reqBody){

        StudentTextMessagesReplies studentTextMessagesReplies = CommonUtil.convertJsonStringToPojoForStudentTextMessagesReplies(reqBody);

        return studentTextMessagesReplies;
    }

}
