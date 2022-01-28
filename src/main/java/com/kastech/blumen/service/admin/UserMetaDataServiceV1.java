package com.kastech.blumen.service.admin;

import com.kastech.blumen.model.keycloak.UserMetaData;
import com.kastech.blumen.repository.admin.UserMetaDataRepository;
import com.kastech.blumen.utility.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserMetaDataServiceV1 {

    @Autowired
    UserMetaDataRepository userMetaDataRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMetaDataServiceV1.class);

    public UserMetaData doService(String reqBody) {
        UserMetaData userMetaData = CommonUtil.convertJsonStringToPojoForUserMetaData(reqBody);
        return userMetaData;
    }

    public UserMetaData addUserMetaData(UserMetaData userMetaData) {
        return userMetaDataRepository.save(userMetaData);
    }

    public Optional<UserMetaData> findUserMetaDataById(String id) {
        Optional<UserMetaData> optionalUserMetaData=userMetaDataRepository.findById(id);
        return optionalUserMetaData;
    }

    public void deleteById(String id) {
        userMetaDataRepository.deleteById(id);
    }

}