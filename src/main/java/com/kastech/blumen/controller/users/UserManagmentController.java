package com.kastech.blumen.controller.users;

import com.kastech.blumen.config.CustomAuthenticationProvider;
import com.kastech.blumen.constants.RestURIConstant;
import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.JWTRequest;
import com.kastech.blumen.model.JWTResponse;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.service.CustomUserDetailsService;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
import com.kastech.blumen.utility.JwtUtil;
import com.kastech.blumen.utility.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = RestURIConstant.ROOT)
public class UserManagmentController {

    @Autowired
    private CustomAuthenticationProvider authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private LoggedUserServiceV1 loggedUserServiceV1;

    @Autowired
    private LoggedUserRepository usersRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping(path = "/test")
    @ResponseBody
    public ResponseEntity<?> healtCheck() {
        String message = "hello "+ SecurityUtil.getUserOrgId();
        return ResponseEntity.ok(message);
    }

    @PutMapping(value = "/changePassword/v1/{id}")
    public void changePassword(@RequestHeader("Authorization") String authHeader){

    }

    @GetMapping(value="/validateUser/{orgId}")
    public ResponseEntity<?> validateUser( @PathVariable(value = "orgId", required = true) String orgId) {
        return null;
    }

    @GetMapping(value = "/resetPassword/{user}")
    public ResponseEntity<?> resetUserPassword(@PathVariable(value="user", required = true) String email) {
        loggedUserServiceV1.resetPasswordForUser(email, SecurityUtil.getUserOrgType());
        return null;
    }

    @PostMapping(value = "/forgotPassword")
    public ResponseEntity<?> forgotPasswordUpdate(@RequestBody Map<String, String> requestPaylaod) {
        return null;
    }



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

    ///should support unauthenticated access
    @GetMapping(path = "/orgCount", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Long getOrgCount(@RequestParam("email") String email) {
        return usersRepository.findByEmailId(email);
    }

    @PutMapping(value = "/resetPassword/v1/{id}")
    public ResponseEntity<?> resetPassword(@RequestBody JWTRequest jwtRequest) throws Exception {

        return null;
    }

    @GetMapping(value="/unlockUser/v1")
    public ResponseEntity<?> unlockUser(){
        return null;
    }

    @PutMapping(value = "/updateSecurityQuestions")
    public ResponseEntity<?> updateSecurityQuestions(@RequestBody Map<String,String> requestPaylaod) {
        return null;
    }

    ///should support unauthenticated access
    @GetMapping(path = "/ssoConfig")
    @ResponseBody
    public  ResponseEntity<String> getSsoConfig(@RequestParam("email") String email, @RequestParam("orgType") String orgType) {
        return  ResponseEntity.ok(usersRepository.findByUserAndOrgType(email, orgType));
    }

    private ResponseEntity<?> success(Object t, Integer status ){
        return new ResponseEntity(t,null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, int statusCode){
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("message", t);
        return new ResponseEntity(t,null, HttpStatus.valueOf(statusCode));
    }
}
