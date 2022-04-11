//package com.kastech.blumen.filter;
//
//import com.kastech.blumen.service.CustomUserDetailsService;
//import com.kastech.blumen.utility.JwtUtil;
//import org.codehaus.plexus.util.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import static com.kastech.blumen.constants.SecurityConstants.HEADER_STRING;
//import static com.kastech.blumen.constants.SecurityConstants.TOKEN_PREFIX;
//
////@Component
//public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//
//
//    public JWTAuthorizationFilter(AuthenticationManager authManager) {
//        super(authManager);
//    }
//
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    private static final Logger LOG = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws IOException, ServletException {
//        String requestTokenHeader = request.getHeader(HEADER_STRING);
//        String username = null;
//        String jwtToken = null;
//        String orgType = null;
//        UserDetails userDetails = null;
//        if (!StringUtils.isBlank(requestTokenHeader) && requestTokenHeader.startsWith(TOKEN_PREFIX)) {
//
//            jwtToken = requestTokenHeader.substring(7);
//            username = this.jwtUtil.extractUsername(jwtToken);
//            orgType = this.jwtUtil.extractOrganization(jwtToken);
//            if (!(StringUtils.isBlank(username) || StringUtils.isBlank(orgType))) {
//                userDetails = this.customUserDetailsService.loadUserByEmailAndOrganization(username, orgType);
//                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//                } else {
//                    LOG.error("TOKEN invalid ");
//                }
//            } else {
//                LOG.error("username || orgType is missing");
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//
//}