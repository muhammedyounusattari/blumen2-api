package com.kastech.blumen.authenticate;

import com.kastech.blumen.config.CustomAuthenticationProvider;
import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.service.CustomUserDetailsService;
import com.kastech.blumen.constants.RestURIConstant;
import com.kastech.blumen.model.JWTRequest;
import com.kastech.blumen.model.JWTResponse;
import com.kastech.blumen.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = RestURIConstant.ROOT)
public class BlumenUserManagmentController {

    @Autowired
    private CustomAuthenticationProvider authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = RestURIConstant.LOGIN,  consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {

        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            throw new Exception("Username not found");
        } catch (Exception e){
            e.printStackTrace();
            throw new Exception("Bad credentials ");
        }

        CustomUserDetails userDetails = this.customUserDetailsService.loadCustomUserDetails(jwtRequest.getEmail(), jwtRequest.getPassword(), jwtRequest.getOrganization());
        String token = this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JWTResponse(token, null));
    }


    @GetMapping( path="/test")
    @ResponseBody
    public ResponseEntity<?> healtCheck(){
        String message = "hello";
        return ResponseEntity.ok(message);
    }

}
