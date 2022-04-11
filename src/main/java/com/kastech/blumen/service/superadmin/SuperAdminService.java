package com.kastech.blumen.service.superadmin;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.superadmin.SecurityQuestionsList;
import com.kastech.blumen.model.superadmin.SuperAdmin;
import com.kastech.blumen.repository.superadmin.SecurityQuestionsListRepository;
import com.kastech.blumen.repository.superadmin.SuperAdminRepository;
import com.kastech.blumen.service.keycloak.KeycloakAdminClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

@Component
public class SuperAdminService {

    @Autowired
    private SecurityQuestionsListRepository securityQuestionsRepository;

    @Autowired
    private SuperAdminRepository superAdminRepository;

    @Autowired
    private KeycloakAdminClientService keycloakAdminClientService;


    public List<SecurityQuestionsList> getSecurityQuestions(Long orgCode, String questionNumber) {
        List<SecurityQuestionsList> securityQuestionsListList = new ArrayList<>();
        for(SecurityQuestionsList securityQuestions: securityQuestionsRepository.findByOrgCode(orgCode, questionNumber)){
            securityQuestionsListList.add(new SecurityQuestionsList(securityQuestions.getId(), securityQuestions.getName(),null, null));
        }
        return securityQuestionsListList;
    }

    public Map<String, String> validateOrgCode(Long orgCode) {
        return keycloakAdminClientService.validateOrgCode(orgCode);
    }

    public Map<String, String> addSecurityQuestions(Map<String, String> requestPaylaod, Long orgId) {
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
        securityQuestionsList.setOrgId(orgId);

        securityQuestionsRepository.save(securityQuestionsList);
        statusMap.put("status", "200");
        statusMap.put("message", "SecurityQuestion added successfully");
        return statusMap;

    }

    public List<SuperAdmin> findLoggedUserDetails(String userName, String password, String orgId) {
        List<SuperAdmin> superAdmins = superAdminRepository.findByUserDetails(userName,password, orgId);
        return superAdmins;
    }
}
