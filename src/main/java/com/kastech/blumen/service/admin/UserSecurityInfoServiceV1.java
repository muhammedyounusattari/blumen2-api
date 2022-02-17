package com.kastech.blumen.service.admin;

import com.kastech.blumen.model.keycloak.UserSecurityInfo;
import com.kastech.blumen.model.keycloak.UserSecurityInfoId;
import com.kastech.blumen.repository.admin.UserSecurityInfoRepository;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSecurityInfoServiceV1 {

    @Autowired
    UserSecurityInfoRepository userSecurityInfoRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserSecurityInfoServiceV1.class);


    public UserSecurityInfo doService(String reqBody) {
        UserSecurityInfo userSecurityInfo = CommonUtil.convertJsonStringToPojoForUserSecurityInfo(reqBody);
        return userSecurityInfo;
    }

    public UserSecurityInfo addUserSecurityInfo(UserSecurityInfo userSecurityInfo) {
        return userSecurityInfoRepository.save(userSecurityInfo);
    }

    public UserSecurityInfo updateUserSecurityInfo(UserSecurityInfo userSecurityInfo) {
        return userSecurityInfoRepository.save(userSecurityInfo);
    }

    public Optional<UserSecurityInfo> findUserSecurityInfoById(UserSecurityInfoId id) {
        Optional<UserSecurityInfo> optionalUserMetaData=userSecurityInfoRepository.findById(id);
        return optionalUserMetaData;
    }

    public Optional<UserSecurityInfo> findUserSecurityInfoByUsername(String username, String orgId) {
        Optional<UserSecurityInfo> optionalUserSecurityInfo = userSecurityInfoRepository.findByUsername(username, orgId);
        return optionalUserSecurityInfo;
    }

    public void deleteById(UserSecurityInfoId id) {
        userSecurityInfoRepository.deleteById(id);
    }

    public Optional<UserSecurityInfo> validateHashedCode(String hashedCode) {
        return userSecurityInfoRepository.validateHashedCode(hashedCode);
    }
}