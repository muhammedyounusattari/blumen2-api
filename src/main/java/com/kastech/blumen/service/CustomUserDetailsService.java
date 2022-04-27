package com.kastech.blumen.service;

import com.google.common.collect.Sets;
import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.keycloak.LoggedUser;
//import com.kastech.blumen.model.superadmin.SuperAdmin;
import com.kastech.blumen.model.keycloak.Privileges;
import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.kastech.blumen.utility.Constants.SUPER_ADMIN;

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

    public UserDetails loadUserByEmailAndOrganization(String email, String orgCode) throws UsernameNotFoundException {
        return loadUser(email, orgCode);
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


        return new CustomUserDetails(grantedAuthoritySet, loggedUser.getEmail(), loggedUser.getFirstName(), null, loggedUser.getUsername(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, loggedUser.getScope(), loggedUser.getOrgCode(), loggedUser.getOrgId(), loggedUser.getId(), loggedUser.getRoleName());
        //new CustomUserDetails(loggedUser.getUsername(),loggedUser.getFirstName()+" "+loggedUser.getLastName(),loggedUser.getUsername(),loggedUser.getPassword(),Boolean.TRUE,null);

    }

    boolean isSuperAdmin(LoggedUser loggedUser) {
        return  loggedUser.getOrgId() == 0 && loggedUser.getRoleName().equals(SUPER_ADMIN);
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

        return new CustomUserDetails(grantedAuthoritySet, loggedUser.getEmail(), loggedUser.getFirstName(), null, loggedUser.getUsername(),
                Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, loggedUser.getScope(), loggedUser.getOrgCode(),
                loggedUser.getOrgId(), loggedUser.getId(), loggedUser.getRoleName());

    }

    /*
    *  Each Privilege has three kinds of subdivision making each privilege effectively 3 of them
    *  privilge-name_Y - full privilege
    *  privilge-name_N -  no privilege
    *  privilge-name_R - readonly privilege
    */
    private Collection<GrantedAuthority> getAuthorities(LoggedUser loggedUser) {
        final Set<Roles> userRoles = loggedUser.getRoles();
        final Set<Privileges> privileges = Sets.newHashSet();
        for (final Roles roleOfUser : userRoles) {
            privileges.addAll(roleOfUser.getPrivileges());
        }
        List<String> roleStringsList = Arrays.stream(privileges.toArray()).
                map(a -> ((Privileges)a).getName() + "_"+ ((Privileges)a).getAccessType()).
                collect(Collectors.toUnmodifiableList()).stream().collect(Collectors.toList());
        if (isSuperAdmin(loggedUser))  {
            roleStringsList.add(SUPER_ADMIN);
        }
        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(
                roleStringsList.stream().toArray(String[]::new));
        return auths;
    }


    private CustomUserDetails loadUser(String email, String orgCode) throws UsernameNotFoundException {


        Optional<LoggedUser> loggedUserOptional =  loggedUserServiceV1.findLoggedUser(email, orgCode);
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
        return new CustomUserDetails(grantedAuthoritySet, loggedUser.getEmail(), loggedUser.getFirstName(),
                null, loggedUser.getUsername(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE,
                loggedUser.getScope(), loggedUser.getOrgCode(), loggedUser.getOrgId(), loggedUser.getId(), loggedUser.getRoleName());

    }



}