package com.kastech.blumen.filter;

import com.kastech.blumen.service.CustomUserDetailsService;
import com.kastech.blumen.utility.JwtUtil;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

import static com.kastech.blumen.constants.SecurityConstants.*;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    private static final Logger LOG = LoggerFactory.getLogger(JWTAuthenticationFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader =request.getHeader(HEADER_STRING);
        String email = null;
        String jwtToken = null;
        String orgType = null;
        UserDetails userDetails = null;
        if(!StringUtils.isBlank(requestTokenHeader) && requestTokenHeader.startsWith(TOKEN_PREFIX)){


            jwtToken = requestTokenHeader.substring(7);
            email = this.jwtUtil.extractUsername(jwtToken);
            orgType = this.jwtUtil.extractKeyFromToken(jwtToken, "orgType");

            if(!(StringUtils.isBlank(email) || StringUtils.isBlank(orgType))) {
                userDetails = this.customUserDetailsService.loadUserByEmailAndOrganization(email, orgType);
                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    usernamePasswordAuthenticationToken.setAuthenticated(true);
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                } else {
                    LOG.error("TOKEN invalid ");
                }
            } else {
                LOG.error("email || orgType is missing");
            }
        }
        filterChain.doFilter(request,response);
    }

}
