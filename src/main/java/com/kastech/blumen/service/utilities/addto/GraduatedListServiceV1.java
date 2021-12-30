package com.kastech.blumen.service.utilities.addto;

import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.repository.utilities.addto.GraduatedListRepository;
import com.kastech.blumen.utility.CommonUtil;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class GraduatedListServiceV1 {

	@Autowired
    GraduatedListRepository graduatedListRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(GraduatedListServiceV1.class);

    public Tutor doService(String reqBody){

        Tutor tutor = CommonUtil.convertJsonStringToPojoForTutor(reqBody);


        return tutor;
    }
    
    public List<GraduatedInformation> getGraduatedList(){
    	return graduatedListRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
