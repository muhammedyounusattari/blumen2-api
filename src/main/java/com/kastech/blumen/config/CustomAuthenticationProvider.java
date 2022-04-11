package com.kastech.blumen.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Override
    public Authentication authenticate(Authentication authentication)
      throws AuthenticationException {
 
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        LOG.debug("Call made to authenticate provider with email {}, password {}", email, password);
        if (!(StringUtils.isEmpty(email) || StringUtils.isEmpty(password))){//shouldAuthenticateAgainstThirdPartySystem()) {
            return new UsernamePasswordAuthenticationToken(
              email, password, new ArrayList<>());
        } else {
            LOG.error("Error occured due to email {} || password {} missing", email, password);
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}