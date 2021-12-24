package com.kastech.blumen.service.student.logs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.student.logs.StudentTextMessagesReplies;
import com.kastech.blumen.repository.student.logs.StudentTextMessagesRepliesRepository;
import com.kastech.blumen.utility.CommonUtil;

@Service
public class StudentTextMessagesRepliesServiceV1 {

    @Autowired
    StudentTextMessagesRepliesRepository studentTextMessagesRepliesRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesRepliesServiceV1.class);

    public StudentTextMessagesReplies doService(String reqBody){

        StudentTextMessagesReplies studentTextMessagesReplies = CommonUtil.convertJsonStringToPojoForStudentTextMessagesReplies(reqBody);

        return studentTextMessagesReplies;
    }
    
    public List<StudentTextMessagesReplies> getAllStudentTextMessagesReplies(){
    	return studentTextMessagesRepliesRepository.findAll();
    }

	public void save(StudentTextMessagesReplies studentWalletLog) {
		studentTextMessagesRepliesRepository.save(studentWalletLog);
	}

	public void delete(StudentTextMessagesReplies studentTextMessagesReplies) {
		studentTextMessagesRepliesRepository.delete(studentTextMessagesReplies);
		
	}

}
