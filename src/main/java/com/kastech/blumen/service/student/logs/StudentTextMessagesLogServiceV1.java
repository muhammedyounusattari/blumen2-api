package com.kastech.blumen.service.student.logs;

import com.kastech.blumen.model.student.logs.StudentTextMessagesLog;
import com.kastech.blumen.model.student.logs.StudentWalletLog;
import com.kastech.blumen.repository.student.logs.StudentTextMessagesLogRepository;
import com.kastech.blumen.utility.CommonUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentTextMessagesLogServiceV1 {
	
    @Autowired
    StudentTextMessagesLogRepository studentTextMessagesLogRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentTextMessagesLogServiceV1.class);

    public StudentTextMessagesLog doService(String reqBody){

        StudentTextMessagesLog studentTextMessagesLog = CommonUtil.convertJsonStringToPojoForStudentTextMessagesLog(reqBody);

        return studentTextMessagesLog;
    }
    
    public List<StudentTextMessagesLog> getAllStudentTextMessagesLog(){
    	return studentTextMessagesLogRepository.findAll();
    }

	public void save(StudentTextMessagesLog studentWalletLog) {
		studentTextMessagesLogRepository.save(studentWalletLog);
	}

	public void delete(StudentTextMessagesLog studentTextMessagesLog) {
		studentTextMessagesLogRepository.delete(studentTextMessagesLog);
	}
}
