package com.kastech.blumen.service.admin;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoggedUserServiceV1 {

    @Autowired
    LoggedUserRepository loggedUserRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggedUserServiceV1.class);

    public LoggedUser doService(String reqBody) {

        LoggedUser loggedUser = CommonUtil.convertJsonStringToPojoForLoggedUser(reqBody);


        return loggedUser;

    }

    public LoggedUser addLoggedUser(LoggedUser loggedUser) {
        return loggedUserRepository.save(loggedUser);
    }

    public Optional<LoggedUser> findLoggedUser(String userName) {
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findByUserName(userName);
        return optionalLoggedUser;
    }

    public Optional<LoggedUser> findLoggedUserById(String id) {
        Optional<LoggedUser> optionalLoggedUser=loggedUserRepository.findById(id);
        return optionalLoggedUser;
    }

    public void deleteById(String id) {
        loggedUserRepository.deleteById(id);
    }


}