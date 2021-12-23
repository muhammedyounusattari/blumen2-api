package com.kastech.blumen.service.student.logs;

import com.kastech.blumen.model.student.logs.StudentWalletLog;
import com.kastech.blumen.repository.student.logs.StudentWalletLogRepository;
import com.kastech.blumen.utility.CommonUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentWalletLogServiceV1 {

    @Autowired
    StudentWalletLogRepository studentWalletLogRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentWalletLogServiceV1.class);

    public StudentWalletLog doService(String reqBody){

        StudentWalletLog studentWalletLog = CommonUtil.convertJsonStringToPojoForStudentWalletLog(reqBody);

        return studentWalletLog;
    }
    
    public List<StudentWalletLog> getAllStudentWalletLog(){
    	return studentWalletLogRepository.findAll();
    }

	public void save(StudentWalletLog studentWalletLog) {
		studentWalletLogRepository.save(studentWalletLog);
	}

}
