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
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagmentController.class);

    @GetMapping(path = "/test")
    @ResponseBody
    public ResponseEntity<?> healtCheck() {
        String message = "hello "+ SecurityUtil.getUserOrgId();
        return ResponseEntity.ok(message);
    }

    @PutMapping(value = "/changePassword/v1")
    public ResponseEntity<?> changePassword(@RequestBody Map<String, String> requestPayload){
        try {
            LOGGER.info("Call made to changePassword with requestPayload {}", requestPayload);
            return new ResponseEntity(loggedUserServiceV1.changePassword(requestPayload),HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Problem in performing changePassword {}", e.getMessage());
            return failure("Error occured "+e.getMessage(),HttpStatus.NOT_FOUND.value());
        }
    }

    @GetMapping(value="/validateUser/v1/{orgId}")
    public ResponseEntity<?> validateUser( @PathVariable(value = "orgId", required = true) String orgId) {
        return null;
    }

    @GetMapping(value = "/resetPassword/v1/{user}")
    public ResponseEntity<?> resetUserPassword(@PathVariable(value="user", required = true) String user) {
        String sentMail = "";
        try {
            LOGGER.info("call made for /resetPassword for user {}", user);
           sentMail =  loggedUserServiceV1.resetPasswordForUser(user, SecurityUtil.getUserOrgType());
        } catch (UsernameNotFoundException e){
            LOGGER.error("User with email {} not found ", user);
           return failure("User with email "+user+ " not found", 404);
        }
        catch (Exception e) {
            LOGGER.error("Problem in resetting password for email {}", user);
            e.printStackTrace();
           return failure("Problem in resetting password for email "+ user, 400);
        }
        return success("Email sent to address "+user+" "+sentMail, 200);
    }

    @PostMapping(value = "/updatePassword/v1/{hashedCode}")
    public ResponseEntity<?> updatePassword(@PathVariable(value = "hashedCode", required = true)String hashedCode, @RequestBody Map<String, String> requestPaylaod) {

        Map<String, String> responsePayload = new HashMap<>();
        String password = requestPaylaod.get("password");
        String confPassword = requestPaylaod.get("confPassword");

        if (StringUtils.isBlank(password)) {
            responsePayload.put("message", "Password is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(confPassword)) {
            responsePayload.put("message", "Confirm password is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }


        try {
           return new ResponseEntity(loggedUserServiceV1.updatePassword(confPassword,hashedCode),null,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return failure("Problem in updating password", 400);
        }

    }

    @PostMapping(value = RestURIConstant.FORGOT_PASSWORD)
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> requestPaylaod) {
        LOGGER.info("forgotPassword api is called {}", this.getClass());

        Map<String, String> responsePayload = new HashMap<>();
        String orgType = requestPaylaod.get("orgType");
        String email = requestPaylaod.get("email");
        String securityAnswer1 = requestPaylaod.get("securityAnswer1");
        String securityAnswer2 = requestPaylaod.get("securityAnswer2");

        LOGGER.debug("email {}, orgType {}, securityAnswer1 {}, securityAnswer2 {}", email, orgType,securityAnswer1,securityAnswer2);
        if (StringUtils.isBlank(orgType)) {
            responsePayload.put("message", "OrganizationCode is missing");
            responsePayload.put("status", "404");
            LOGGER.warn("OrgType missing {}", orgType);
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(email) && StringUtils.isBlank(securityAnswer1) && StringUtils.isBlank(securityAnswer2)) {
            responsePayload = loggedUserServiceV1.validateOrgType(orgType);
            return success(responsePayload, Integer.parseInt(responsePayload.get("status")));
        }
        if (StringUtils.isBlank(email)) {
            responsePayload.put("message", "Email is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(securityAnswer1) && StringUtils.isBlank(securityAnswer2)) {
            responsePayload = loggedUserServiceV1.getSecurityQuestions(orgType, email);
            return new ResponseEntity(responsePayload, HttpStatus.OK);
        }

        if (StringUtils.isBlank(securityAnswer1)) {
            responsePayload.put("message", "SecurityAnswer1 is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(securityAnswer2)) {
            responsePayload.put("message", "SecurityAnswer2 is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        Map<String, String> statusMap = loggedUserServiceV1.checkCredentials(orgType, email, securityAnswer1, securityAnswer2);
        return new ResponseEntity(statusMap,null, HttpStatus.OK);
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
        Map<String,Object> map = new HashMap<>();
        map.put("message", t);
        return new ResponseEntity(map,null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, int statusCode){
        Map<String,Object> errorMap = new HashMap<>();
        errorMap.put("message", t);
        return new ResponseEntity(errorMap,null, HttpStatus.valueOf(statusCode));
    }
}
