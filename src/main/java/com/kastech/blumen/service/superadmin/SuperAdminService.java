package com.kastech.blumen.service.superadmin;

import com.kastech.blumen.model.superadmin.SecurityQuestionsList;
import com.kastech.blumen.repository.superadmin.SecurityQuestionsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SuperAdminService {

    @Autowired
    private SecurityQuestionsListRepository securityQuestionsRepository;


    public List<SecurityQuestionsList> getSecurityQuestions(String orgCode, String questionNumber) {
        List<SecurityQuestionsList> securityQuestionsListList = new ArrayList<>();
        for(SecurityQuestionsList securityQuestions: securityQuestionsRepository.findByOrgCode(orgCode, questionNumber)){
            securityQuestionsListList.add(new SecurityQuestionsList(securityQuestions.getId(), securityQuestions.getName()));
        }
        return securityQuestionsListList;
    }
}
