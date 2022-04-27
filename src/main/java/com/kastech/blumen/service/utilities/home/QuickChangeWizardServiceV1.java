package com.kastech.blumen.service.utilities.home;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.tutor.Tutor;
import com.kastech.blumen.repository.utilities.home.QuickChangeWizardRepository;
import com.kastech.blumen.utility.CommonUtil;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QuickChangeWizardServiceV1 {
	
	@Autowired
	QuickChangeWizardRepository quickChangeWizardRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(QuickChangeWizardServiceV1.class);

    public Tutor doService(String reqBody){

        Tutor tutor = CommonUtil.convertJsonStringToPojoForTutor(reqBody);


        return tutor;
    }
    
    public List<Student> getAllStudent(){
    	return quickChangeWizardRepository.findAll(Sort.by(Sort.Direction.ASC, "ssno"));
    }
    
    public void changeFiscalYear(Long studentId, String changeTo) {
    	Optional<Student> student = quickChangeWizardRepository.findById(studentId);
    	
    	/*if(student.isPresent()) {
    		Student updateStudent = student.get();
    		updateStudent.setFiscalYear(changeTo);
    		quickChangeWizardRepository.save(updateStudent);
    	}*/
    }
}
