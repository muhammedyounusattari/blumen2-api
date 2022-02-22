package com.kastech.blumen.service.superadmin;

import com.kastech.blumen.model.superadmin.SecurityQuestionsList;
import com.kastech.blumen.repository.superadmin.SecurityQuestionsListRepository;
import com.kastech.blumen.service.keycloak.KeycloakAdminClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SuperAdminService {

    @Autowired
    private SecurityQuestionsListRepository securityQuestionsRepository;

    @Autowired
    private KeycloakAdminClientService keycloakAdminClientService;


    public List<SecurityQuestionsList> getSecurityQuestions(String orgCode, String questionNumber) {
        List<SecurityQuestionsList> securityQuestionsListList = new ArrayList<>();
        for(SecurityQuestionsList securityQuestions: securityQuestionsRepository.findByOrgCode(orgCode, questionNumber)){
            securityQuestionsListList.add(new SecurityQuestionsList(securityQuestions.getId(), securityQuestions.getName()));
        }
        return securityQuestionsListList;
    }

    public Map<String, String> validateOrgCode(String orgCode) {
        return keycloakAdminClientService.validateOrgCode(orgCode);
    }

    public Map<String, String> addSecurityQuestions(Map<String, String> requestPaylaod, String orgCode) {
        String securityQuestion = requestPaylaod.get("securityQuestion");
        String securityAnswer = requestPaylaod.get("securityAnswer");
        Map<String,String> statusMap = new HashMap<>();

        if(StringUtils.isEmpty(securityQuestion)){
            statusMap.put("status", "404");
            statusMap.put("message", "SecurityQuestion missing");
            return statusMap;
        }
        if(StringUtils.isEmpty(securityAnswer)){
            statusMap.put("status", "404");
            statusMap.put("message", "SecurityAnswer missing");
            return statusMap;
        }

        SecurityQuestionsList securityQuestionsList = new SecurityQuestionsList();
        securityQuestionsList.setQuestionType(securityAnswer);
        securityQuestionsList.setName(securityQuestion);
        securityQuestionsList.setOrgCode(orgCode);
        securityQuestionsList.setOrgId(orgCode);
        securityQuestionsRepository.save(securityQuestionsList);
        statusMap.put("status", "200");
        statusMap.put("message", "SecurityQuestion added successfully");
        return statusMap;

    }
}
