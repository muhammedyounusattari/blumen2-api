package com.kastech.blumen.service.superadmin;

import com.kastech.blumen.repository.superadmin.SecurityQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SuperAdminService {

    @Autowired
    private SecurityQuestionsRepository securityQuestionsRepository;


}
