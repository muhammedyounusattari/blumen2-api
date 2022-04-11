package com.kastech.blumen.controller.users;

import com.kastech.blumen.config.CustomAuthenticationProvider;
import com.kastech.blumen.constants.RestURIConstant;
import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.JWTRequest;
import com.kastech.blumen.model.JWTResponse;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.service.CustomUserDetailsService;
import com.kastech.blumen.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RestURIConstant.ROOT)
public class UserManagmentController {

    @Autowired
    private CustomAuthenticationProvider authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = RestURIConstant.LOGIN, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        Authentication authentication = null;
        try {
            authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Username not found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Bad credentials ");
        }

        CustomUserDetails customUserDetails = this.customUserDetailsService.loadCustomUserDetails(jwtRequest.getEmail(), jwtRequest.getPassword(), jwtRequest.getOrganization());
        String token = this.jwtUtil.generateToken(authentication, customUserDetails);
        return ResponseEntity.ok(new JWTResponse(token, this.jwtUtil.extractKeyFromToken(token,"ita"), this.jwtUtil.extractKeyFromToken(token,"exp"), 200));
    }


    @GetMapping(path = "/test")
    @ResponseBody
    public ResponseEntity<?> healtCheck() {
        String message = "hello";
        return ResponseEntity.ok(message);
    }

}
