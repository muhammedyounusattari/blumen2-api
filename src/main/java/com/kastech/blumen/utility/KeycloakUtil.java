package com.kastech.blumen.utility;


import com.kastech.blumen.model.keycloak.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public class KeycloakUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeycloakUtil.class);


    private KeycloakUtil(){

    }

    public static User convertUserInfoToUser(UserInfo userInfo, boolean isCreate, String password)  {
        User.UserBuilder userBuilder = new User.UserBuilder();
        List<Credentials> credentialsList = new ArrayList<>();
        if(userInfo != null) {
            if(isCreate) {
                Credentials.CredentialsBuilder credentialsBuilder = new Credentials.CredentialsBuilder();
                Credentials credentials = credentialsBuilder.type("password").value(password).temporary(false).buildCredentials();

                credentialsList.add(credentials);
            }
            userBuilder.username(userInfo.getUsername()).email(userInfo.getEmail())
                    .firstName(userInfo.getFirstName()).lastName(userInfo.getLastName())
                    .enabled(userInfo.isEnabled()).emailVerified(userInfo.isEmailVerified());
            if(isCreate) {
                userBuilder.credentials(credentialsList);
            }
        }
        return userBuilder.buildUser();
    }

    public static UserInfo convertUserPlusMetaToUserInfo(User user, UserMetaData userMetaData)  {
        UserInfo.UserInfoBuilder userInfoBuilder = new UserInfo.UserInfoBuilder();
        if(user != null) {
            userInfoBuilder.id(user.getId())
                    .username(user.getUsername()).email(user.getEmail()).firstName(user.getFirstName())
                    .lastName(user.getLastName()).enabled(user.isEnabled());
        }

        if(userMetaData != null) {
            userInfoBuilder.roleName(userMetaData.getRoleName()).id(userMetaData.getId()).orgId(userMetaData.getOrgId())
                    .siteLocation(userMetaData.getSiteLocation()).active(userMetaData.isActive())
                    .address1(userMetaData.getAddress1()).address2(userMetaData.getAddress2())
                    .city(userMetaData.getCity()).state(userMetaData.getState())
                    .zipcode(userMetaData.getZipcode()).phone2(userMetaData.getPhone2())
                    .fax(userMetaData.getFax()).notes(userMetaData.getNotes())
                    .sendMail(userMetaData.isSendMail());
        }
        return userInfoBuilder.buildUserInfo();
    }

    public static UserInfo convertUserLinkedHashmapToUserInfo(LinkedHashMap userLinkedHashMap, Optional<UserMetaData> optionalUserMetaData) {
        UserInfo.UserInfoBuilder userInfoBuilder = new UserInfo.UserInfoBuilder();
        String userId = null;
        if(userLinkedHashMap != null) {
           if(userLinkedHashMap.get("id") != null) {
               userId = userLinkedHashMap.get("id").toString();
                userInfoBuilder.id(userId);
           }
            if(userLinkedHashMap.get("username") != null) {
                userInfoBuilder.username(userLinkedHashMap.get("username").toString());
            }
            if(userLinkedHashMap.get("firstName") != null) {
                userInfoBuilder.firstName(userLinkedHashMap.get("firstName").toString());
            }
            if(userLinkedHashMap.get("lastName") != null) {
                userInfoBuilder.lastName(userLinkedHashMap.get("lastName").toString());
            }
            if(userLinkedHashMap.get("email") != null) {
                userInfoBuilder.email(userLinkedHashMap.get("email").toString());
            }
            if(userLinkedHashMap.get("enabled") != null) {
                userInfoBuilder.enabled((Boolean) userLinkedHashMap.get("enabled"));
            }
            if(userLinkedHashMap.get("emailVerified") != null) {
                userInfoBuilder.emailVerified((Boolean) userLinkedHashMap.get("emailVerified"));
            }

            if(optionalUserMetaData != null && optionalUserMetaData.isPresent()) {
                UserMetaData userMetaData = optionalUserMetaData.get();
                if(userMetaData != null) {
                    userInfoBuilder.roleName(userMetaData.getRoleName()).id(userMetaData.getId()).orgId(userMetaData.getOrgId())
                            .siteLocation(userMetaData.getSiteLocation()).active(userMetaData.isActive())
                            .address1(userMetaData.getAddress1()).address2(userMetaData.getAddress2())
                            .city(userMetaData.getCity()).state(userMetaData.getState())
                            .zipcode(userMetaData.getZipcode()).phone2(userMetaData.getPhone2())
                            .fax(userMetaData.getFax()).notes(userMetaData.getNotes())
                            .sendMail(userMetaData.isSendMail());
                }
            }
       }
        return userInfoBuilder.buildUserInfo();
    }

}