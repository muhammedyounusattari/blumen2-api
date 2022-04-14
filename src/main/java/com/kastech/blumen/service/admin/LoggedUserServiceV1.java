package com.kastech.blumen.service.admin;

import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.keycloak.LoggedUserId;
import com.kastech.blumen.model.response.LoggedUserResponse;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.service.superadmin.OrganizationService;
import com.kastech.blumen.utility.CommonUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoggedUserServiceV1 {

    @Autowired
    LoggedUserRepository loggedUserRepository;

    @Autowired
    OrganizationService organizationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggedUserServiceV1.class);

    public LoggedUser doService(String reqBody) {

        LoggedUser loggedUser = CommonUtil.convertJsonStringToPojoForLoggedUser(reqBody);
        return loggedUser;

    }

    public LoggedUser addLoggedUser(LoggedUser loggedUser) {
        return loggedUserRepository.save(loggedUser);
    }

    public Optional<LoggedUser> findLoggedUser(String email, String orgType) {
        Optional<LoggedUser> optionalLoggedUser = loggedUserRepository.findByUserEmailAndOrgType(email, orgType);
        return optionalLoggedUser;
    }

    public Optional<LoggedUser> findLoggedUserById(Long id) {
        Optional<LoggedUser> optionalLoggedUser=loggedUserRepository.findById(id);
        return optionalLoggedUser;
    }

    public void deleteById(Long id) {
        loggedUserRepository.deleteById(id);
    }

    public Optional<LoggedUser> findByOrgId(Long orgCode) {
        return loggedUserRepository.findByOrgId(orgCode);
    }

    public List<LoggedUser> findLoggedUserDetails(String userName, String password, String orgId) {
        List<LoggedUser> loggedUsers = loggedUserRepository.findByUserDetails(userName,password, orgId);
        return loggedUsers;
    }

    public LoggedUser createUser(LoggedUser loggedUser) throws Exception{
        loggedUser = loggedUserRepository.save(loggedUser);
        if("Admin".equalsIgnoreCase(loggedUser.getRoleName())){
            Organization organization = new Organization();
            organization.setOrgId(loggedUser.getOrgId());
            organization.setOrgOrganizationType(loggedUser.getOrgType());
            organizationService.batchUpdateForOrgAdmin(loggedUser,organization);
        }

        return loggedUser;
    }


    public List<LoggedUser> loadUsers(Long userOrgId) {
        return  loggedUserRepository.getUsersList(userOrgId);
    }

    public String resetPasswordForUser(String email, String orgType) {

        //check if the user exist in database or not
       Optional<LoggedUser> loggedUsers = loggedUserRepository.findByUserEmailAndOrgType(email, orgType);
       if(loggedUsers.isEmpty()){
           return "User "+email+" doesn't exist";
       }
       String randomPassword = RandomStringUtils.randomAlphanumeric(15);

       LoggedUser loggedUser = loggedUsers.get();
       loggedUser.setPassword(randomPassword);
       loggedUserRepository.save(loggedUser);

       return randomPassword;
    }
}