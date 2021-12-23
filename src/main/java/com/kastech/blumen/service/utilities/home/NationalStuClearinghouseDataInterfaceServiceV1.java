package com.kastech.blumen.service.utilities.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.repository.utilities.home.NationalStuClearinghouseDataInterfaceRepository;
import com.kastech.blumen.utility.CommonUtil;

@Service
public class NationalStuClearinghouseDataInterfaceServiceV1 {
	
	@Autowired
	NationalStuClearinghouseDataInterfaceRepository nationalStuClearinghouseDataInterfaceRepository;


    private static final Logger LOGGER = LoggerFactory.getLogger(NationalStuClearinghouseDataInterfaceServiceV1.class);

    public Tutor doService(String reqBody){

        Tutor tutor = CommonUtil.convertJsonStringToPojoForTutor(reqBody);


        return tutor;
    }
    
    public List<Student> getAllStudent(){
    	return nationalStuClearinghouseDataInterfaceRepository.findAll();
    }
    
}
