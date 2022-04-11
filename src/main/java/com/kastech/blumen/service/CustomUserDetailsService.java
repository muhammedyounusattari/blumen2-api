package com.kastech.blumen.service;

import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.superadmin.SuperAdmin;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
import com.kastech.blumen.service.superadmin.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private LoggedUserServiceV1 loggedUserServiceV1;

    @Autowired
    private SuperAdminService superAdminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      return null;//loadUser(username);

    }

    public UserDetails loadUserByEmailAndOrganization(String username, String orgType) throws UsernameNotFoundException {
        return loadUser(username, orgType);
    }

    public UserDetails loadUserDetails(String username, String password, String organization) throws  UsernameNotFoundException {
        List<SuperAdmin> superAdmins =   superAdminService.findLoggedUserDetails(username, password, organization);
        SuperAdmin superAdmin = new SuperAdmin();
        if(!superAdmins.isEmpty()){
            superAdmin = superAdmins.get(0);
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }

        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        /** Here rolese will sit **/
        /*for (int i=0; i<userAccount.getRoles().size();i++)
        {
            JSONObject jsonObject = new JSONObject(userAccount.getRoles().get(i));
            String role = jsonObject.getString("role");
            gas.add(new SimpleGrantedAuthority(role));
        } */
        return new CustomUserDetails(superAdmin.getEmail(),superAdmin.getFirstName()+" "+superAdmin.getLastName(),superAdmin.getEmail(),superAdmin.getPassword(),Boolean.TRUE,null);

    }


    public CustomUserDetails loadCustomUserDetails(String username, String password, String organization) throws  UsernameNotFoundException {
        List<SuperAdmin> superAdmins =   superAdminService.findLoggedUserDetails(username, password, organization);
        SuperAdmin superAdmin = new SuperAdmin();
        if(!superAdmins.isEmpty()){
            superAdmin = superAdmins.get(0);
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }

        Collection<GrantedAuthority> grantedAuthoritySet = getAuthorities(superAdmin);

        /** Here rolese will sit **/
        /*for (int i=0; i<userAccount.getRoles().size();i++)
        {
            JSONObject jsonObject = new JSONObject(userAccount.getRoles().get(i));
            String role = jsonObject.getString("role");
            gas.add(new SimpleGrantedAuthority(role));
        } */
        return new CustomUserDetails(grantedAuthoritySet,superAdmin.getEmail(),superAdmin.getFirstName()+" "+superAdmin.getLastName(), superAdmin.getPassword(), superAdmin.getEmail(), Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, true, superAdmin.getScope(), superAdmin.getOrganizationType());
        //new CustomUserDetails(superAdmin.getEmail(),superAdmin.getFirstName()+" "+superAdmin.getLastName(),superAdmin.getEmail(),superAdmin.getPassword(),Boolean.TRUE,null);

    }

    private Collection<GrantedAuthority> getAuthorities(SuperAdmin superAdmin) {

   /*     Set<Roles> userRoles = superAdmin.getRoles();
        Collection<GrantedAuthority> authorities = new ArrayList<>(userRoles.size());
        for(Roles role: grantedAuthoritySet){
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        return authorities; */

        return null;
    }


    private CustomUserDetails loadUser(String username, String orgType) throws UsernameNotFoundException {


        Optional<LoggedUser> loggedUserOptional =  loggedUserServiceV1.findLoggedUser(username, orgType);
        LoggedUser loggedUser = new LoggedUser();

        if(!loggedUserOptional.isEmpty()){
            loggedUser = loggedUserOptional.get();
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }

        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        /** Here rolese will sit **/
        /*for (int i=0; i<userAccount.getRoles().size();i++)
        {
            JSONObject jsonObject = new JSONObject(userAccount.getRoles().get(i));
            String role = jsonObject.getString("role");
            gas.add(new SimpleGrantedAuthority(role));
        } */
        return null; //new CustomUserDetails(null,loggedUser.getUserName(),loggedUser.getUserName(),"mumbai-university.password1",Boolean.TRUE,null);

    }



}