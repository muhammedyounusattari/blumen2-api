package com.kastech.blumen.utility;


import com.kastech.blumen.model.keycloak.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Optional;

public class KeycloakUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeycloakUtil.class);


    private KeycloakUtil(){

    }

    public static User convertCreateUserRequestToUser(CreateUserRequest createUserRequest)  {
        User user = new User();
        if(createUserRequest != null) {
            if(StringUtils.isNotBlank(createUserRequest.getUsername())) {
                user.setUsername(createUserRequest.getUsername());
            }
            if(StringUtils.isNotBlank(createUserRequest.getEmail())) {
                user.setEmail(createUserRequest.getEmail());
            }
            if(StringUtils.isNotBlank(createUserRequest.getFirstName())) {
                user.setFirstName(createUserRequest.getFirstName());
            }
            if(StringUtils.isNotBlank(createUserRequest.getLastName())) {
                user.setLastName(createUserRequest.getLastName());
            }

            if(createUserRequest.getCredentials() != null && !createUserRequest.getCredentials().isEmpty()) {
                user.setCredentials(createUserRequest.getCredentials());
            }
                user.setEnabled(createUserRequest.isEnabled());
                user.setEmailVerified(createUserRequest.isEmailVerified());

            }
        return user;
        }

    public static UserInfo convertUserPlusMetaToUserInfo(User user, UserMetaData userMetaData)  {
        UserInfo userInfo= new UserInfo();
        if(user != null) {
            if(StringUtils.isNotBlank(user.getUsername())) {
                userInfo.setUsername(user.getUsername());
            }
            if(StringUtils.isNotBlank(user.getEmail())) {
                userInfo.setEmail(user.getEmail());
            }
            if(StringUtils.isNotBlank(user.getFirstName())) {
                userInfo.setFirstName(user.getFirstName());
            }
            if(StringUtils.isNotBlank(user.getLastName())) {
                userInfo.setLastName(user.getLastName());
            }
            userInfo.setEnabled(user.isEnabled());
        }
        if(userMetaData != null) {
            if(StringUtils.isNotBlank(userMetaData.getRoleName())) {
                userInfo.setRoleName(userMetaData.getRoleName());
            }
            if(StringUtils.isNotBlank(userMetaData.getId())) {
                userInfo.setUserId(userMetaData.getId());
            }
            if(StringUtils.isNotBlank(userMetaData.getPassword())) {
                userInfo.setPassword(userMetaData.getPassword());
            }
            if(StringUtils.isNotBlank(userMetaData.getOrgId())) {
                userInfo.setOrgId(userMetaData.getOrgId());
            }
            if(StringUtils.isNotBlank(userMetaData.getSiteLocation())) {
                userInfo.setSiteLocation(userMetaData.getSiteLocation());
            }
            if(StringUtils.isNotBlank(userMetaData.getSiteLocation())) {
                userInfo.setActive(userMetaData.isActive());
            }
        }
        return userInfo;
    }

    public static UserInfo convertUserLinkedHashmapToUserInfo(LinkedHashMap userLinkedHashMap, Optional<UserMetaData> optionalUserMetaData) {
        UserInfo userInfo = new UserInfo();
        String userId = null;
        if(userLinkedHashMap != null) {
           if(userLinkedHashMap.get("id") != null) {
               userId = userLinkedHashMap.get("id").toString();
                userInfo.setUserId(userId);
           }
            if(userLinkedHashMap.get("username") != null) {
                userInfo.setUsername(userLinkedHashMap.get("username").toString());
            }
            if(userLinkedHashMap.get("firstName") != null) {
                userInfo.setFirstName(userLinkedHashMap.get("firstName").toString());
            }
            if(userLinkedHashMap.get("lastName") != null) {
                userInfo.setLastName(userLinkedHashMap.get("lastName").toString());
            }
            if(userLinkedHashMap.get("email") != null) {
                userInfo.setEmail(userLinkedHashMap.get("email").toString());
            }
            if(userLinkedHashMap.get("enabled") != null) {
                userInfo.setEnabled((Boolean) userLinkedHashMap.get("enabled"));
            }
            if(userLinkedHashMap.get("emailVerified") != null) {
                userInfo.setEmailVerified((Boolean) userLinkedHashMap.get("emailVerified"));
            }

            if(optionalUserMetaData != null && optionalUserMetaData.isPresent()) {
                UserMetaData userMetaData = optionalUserMetaData.get();
                if(userMetaData != null) {
                    if(StringUtils.isNotBlank(userMetaData.getOrgId())) {
                        userInfo.setOrgId(userMetaData.getOrgId());
                    }
                    if(StringUtils.isNotBlank(userMetaData.getRoleName())) {
                        userInfo.setRoleName(userMetaData.getRoleName());
                    }
                    if(StringUtils.isNotBlank(userMetaData.getSiteLocation())) {
                        userInfo.setSiteLocation(userMetaData.getSiteLocation());
                    }
                    if(StringUtils.isNotBlank(userMetaData.getPassword())) {
                        userInfo.setPassword(userMetaData.getPassword());
                    }
                }
            }

       }
        return userInfo;
    }

}