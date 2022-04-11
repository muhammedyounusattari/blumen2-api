package com.kastech.blumen.service;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.keycloak.LoggedUser;
//import com.kastech.blumen.model.superadmin.SuperAdmin;
import com.kastech.blumen.model.keycloak.Privileges;
import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
//import com.kastech.blumen.service.superadmin.SuperAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoggedUserServiceV1 loggedUserServiceV1;

//    @Autowired
//    private SuperAdminService superAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return null;//loadUser(username);

    }

    public UserDetails loadUserByEmailAndOrganization(String email, String orgType) throws UsernameNotFoundException {
        return loadUser(email, orgType);
    }

    public UserDetails loadUserDetails(String username, String password, String organization) throws  UsernameNotFoundException {
        List<LoggedUser> loggedUsers =   loggedUserServiceV1.findLoggedUserDetails(username, password, organization);
        LoggedUser loggedUser = new LoggedUser();
        if(!loggedUsers.isEmpty()){
            loggedUser = loggedUsers.get(0);
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }

        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();


        return new CustomUserDetails(grantedAuthoritySet, loggedUser.getUsername(), loggedUser.getFirstName(), null, loggedUser.getUsername(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, loggedUser.getScope(), loggedUser.getOrgType(), loggedUser.getOrgId());
        //new CustomUserDetails(loggedUser.getUsername(),loggedUser.getFirstName()+" "+loggedUser.getLastName(),loggedUser.getUsername(),loggedUser.getPassword(),Boolean.TRUE,null);

    }


    public CustomUserDetails loadCustomUserDetails(String username, String password, String organization) throws  UsernameNotFoundException {
        List<LoggedUser> loggedUsers =   loggedUserServiceV1.findLoggedUserDetails(username, password, organization);
        LoggedUser loggedUser = new LoggedUser();
        if(!loggedUsers.isEmpty()){
            loggedUser = loggedUsers.get(0);
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }

        Collection<GrantedAuthority> grantedAuthoritySet = getAuthorities(loggedUser);

        /** Here rolese will sit **/
        /*for (int i=0; i<userAccount.getRoles().size();i++)
        {
            JSONObject jsonObject = new JSONObject(userAccount.getRoles().get(i));
            String role = jsonObject.getString("role");
            gas.add(new SimpleGrantedAuthority(role));
        } */
        return new CustomUserDetails(grantedAuthoritySet, loggedUser.getEmail(), loggedUser.getFirstName(), null, loggedUser.getUsername(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, loggedUser.getScope(), loggedUser.getOrgType(), loggedUser.getOrgId());
        //return new CustomUserDetails(grantedAuthoritySet,loggedUser.getUsername(),loggedUser.getFirstName()+" "+loggedUser.getLastName(), loggedUser.getPassword(), loggedUser.getUsername(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, true, loggedUser.getScope(), loggedUser.getOrgType());
        //new CustomUserDetails(superAdmin.getEmail(),superAdmin.getFirstName()+" "+superAdmin.getLastName(),superAdmin.getEmail(),superAdmin.getPassword(),Boolean.TRUE,null);

    }

    private Collection<GrantedAuthority> getAuthorities(LoggedUser loggedUser) {

        final Set<Roles> userRoles = loggedUser.getRoles();
        final Set<Privileges> privileges = Sets.newHashSet();
        for (final Roles roleOfUser : userRoles) {
            privileges.addAll(roleOfUser.getPrivileges());
        }

        final Function<Object, String> toStringFunction = Functions.toStringFunction();

        final Collection<String> rolesToString = Collections2.transform(privileges, toStringFunction);
        final String[] roleStringsAsArray = rolesToString.toArray(new String[rolesToString.size()]);
        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(roleStringsAsArray);

        return auths;
    }


    private CustomUserDetails loadUser(String email, String orgType) throws UsernameNotFoundException {


        Optional<LoggedUser> loggedUserOptional =  loggedUserServiceV1.findLoggedUser(email, orgType);
        LoggedUser loggedUser = new LoggedUser();

        if(!loggedUserOptional.isEmpty()){
            loggedUser = loggedUserOptional.get();
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }

        Collection<GrantedAuthority> grantedAuthoritySet = getAuthorities(loggedUser);

        /** Here rolese will sit **/
        /*for (int i=0; i<userAccount.getRoles().size();i++)
        {
            JSONObject jsonObject = new JSONObject(userAccount.getRoles().get(i));
            String role = jsonObject.getString("role");
            gas.add(new SimpleGrantedAuthority(role));
        } */
       // return null; //new CustomUserDetails(null,loggedUser.getUserName(),loggedUser.getUserName(),"mumbai-university.password1",Boolean.TRUE,null);
        return new CustomUserDetails(grantedAuthoritySet, loggedUser.getUsername(), loggedUser.getFirstName(), null, loggedUser.getUsername(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, loggedUser.getScope(), loggedUser.getOrgType(), loggedUser.getOrgId());

    }



}