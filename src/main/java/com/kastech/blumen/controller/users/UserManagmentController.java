package com.kastech.blumen.controller.users;

import com.kastech.blumen.config.CustomAuthenticationProvider;
import com.kastech.blumen.constants.ErrorMessageConstants;
import com.kastech.blumen.constants.RestURIConstant;
import com.kastech.blumen.exception.DataNotFoundException;
import com.kastech.blumen.exception.InputValidationException;
import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.JWTRequest;
import com.kastech.blumen.model.JWTResponse;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.LoggedUserRepository;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
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

import java.util.*;

import static com.kastech.blumen.constants.SecurityConstants.EXPIRATION_TIME;

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
    private OrganizationRepository organizationRepository;

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

    @GetMapping(value = "/resetPassword/v1/{user}/{orgCode}")
    public ResponseEntity<?> resetUserPassword(@PathVariable(value="user", required = true) String user,@PathVariable(value="orgCode", required = true) String orgCode) {
        String sentMail = "";
        try {
            LOGGER.info("call made for /resetPassword for user {} and ", user, orgCode);
            sentMail =  loggedUserServiceV1.resetPasswordForUser(user, orgCode);
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
        String orgCode = requestPaylaod.get("orgCode");
        String email = requestPaylaod.get("email");
        String securityAnswer1 = requestPaylaod.get("securityAnswer1");
        String securityAnswer2 = requestPaylaod.get("securityAnswer2");

        LOGGER.debug("email {}, orgCode {}, securityAnswer1 {}, securityAnswer2 {}", email, orgCode,securityAnswer1,securityAnswer2);
        if (StringUtils.isBlank(orgCode)) {
            responsePayload.put("message", "OrganizationCode is missing");
            responsePayload.put("status", "404");
            LOGGER.warn("orgCode missing {}", orgCode);
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(email) && StringUtils.isBlank(securityAnswer1) && StringUtils.isBlank(securityAnswer2)) {
            responsePayload = loggedUserServiceV1.validateOrgCode(orgCode);
            return success(responsePayload, Integer.parseInt(responsePayload.get("status")));
        }
        if (StringUtils.isBlank(email)) {
            responsePayload.put("message", "Email is missing");
            responsePayload.put("status", "404");
            return failure(responsePayload, 404);
        }

        if (StringUtils.isBlank(securityAnswer1) && StringUtils.isBlank(securityAnswer2)) {
            responsePayload = loggedUserServiceV1.getSecurityQuestions(orgCode, email);
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

        Map<String, String> statusMap = loggedUserServiceV1.checkCredentials(orgCode, email, securityAnswer1, securityAnswer2);
        return new ResponseEntity(statusMap,null, HttpStatus.OK);
    }

    @GetMapping(path = RestURIConstant.LOGOUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> logout(){
        Map<String, Object> payload = new HashMap<>();
        try {
            LOGGER.info("Request made to logout ");
            payload = loggedUserServiceV1.logoutUser();
            return new ResponseEntity<>(payload,null, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.info("Exception occured while request made to logout {}", e);
            payload.put("message", "Exception occured while request made to logout");
            payload.put("status", 400);
            return new ResponseEntity<>(payload,null, HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(path = RestURIConstant.AUTHENTICATE, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        Authentication authentication = null;
        CustomUserDetails customUserDetails = null;
        String token = "";
        JWTResponse jwtResponse = null;
        try {
            LOGGER.info("Call made to /authenticate api");
            authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getEmail(), jwtRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            customUserDetails = this.customUserDetailsService.loadCustomUserDetails(jwtRequest.getEmail(), jwtRequest.getPassword(), jwtRequest.getOrganization());
            token = this.jwtUtil.generateToken(authentication, customUserDetails);
            Optional<Organization> organizations = organizationRepository.findByOrgId(customUserDetails.getOrgId());
            Organization organization = new Organization();
            LoggedUser loggedUser = null;
            if(!organizations.isEmpty()){
                organization = organizations.get();
                loggedUser = usersRepository.findById(customUserDetails.getUserId()).get();
            } else {
                throw new DataNotFoundException(ErrorMessageConstants.INVALID_ORGANIZATION_SETUP);
            }

            if (!organization.getOrgActive()) {
                throw new DataNotFoundException(ErrorMessageConstants.ORGANIZATION_INACTIVE);
            } else if(!loggedUser.getActive()) { // || loggedUser.getWrongAttempt() > 3)
                throw new DataNotFoundException(ErrorMessageConstants.USER_INACTIVE);
            }
            String maskEmail = customUserDetails.getEmail();
            String emailSplit[] = maskEmail.split("@");
            maskEmail = maskEmail.charAt(0) + "*****" + emailSplit[0].charAt(emailSplit[0].length() - 1)+"@"+emailSplit[1];

            jwtResponse = new JWTResponse(token, this.jwtUtil.extractKeyFromToken(token,"iat"), this.jwtUtil.extractKeyFromToken(token,"exp"), 200,
                    organization.getOrgName(),organization.getOrgId(),organization.getOrgProgramType(),
                    organization.getOrgCode(), customUserDetails.getRoleName(),
                    organization.getOrgTwoFactor(),maskEmail, organization.getOrgSiteLocation(),
                    loggedUser.getFirstTime(), organization.getOrgDaysToExpire(), organization.getOrgRemindOne(), organization.getOrgRemindTwo() );
            loggedUser.setIssueDate(new Date());
            loggedUser.setExpiryDate(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
            usersRepository.save(loggedUser);

        } catch (UsernameNotFoundException e) {
            LOGGER.error("Exception occured due to bad credentials");
            e.printStackTrace();
            return success(e.getMessage(),403);
        } catch (DataNotFoundException e) {
            throw  e;
        } catch (Exception e) {
            LOGGER.error("Problem occurred while authenticating a user");
            e.printStackTrace();
            throw new Exception("Bad credentials ");
        }

        return ResponseEntity.ok(jwtResponse);
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
    @GetMapping(path = "/ssoConfig", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public  ResponseEntity<Map<String,Object>> getSsoConfig(@RequestParam("email") String email, @RequestParam("orgCode") String orgCode) {
       LOGGER.info("call made to getSSOConfig, with email {} and orgCode {}", email, orgCode);
       Map<String,Object> resultMap = loggedUserServiceV1.validateEmailAndOrgCode(email,orgCode);
       return ResponseEntity.ok(resultMap);
    }

    @GetMapping(path= RestURIConstant.GENERATE_CODE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> generateMFACode(){
        LOGGER.info("call made to generateMFACode ");
        try {
            loggedUserServiceV1.generateCode();
            return success("Code sent to an email", 200);
        } catch (Exception e) {
            LOGGER.info("Exception occured while generating authCode {} ", e);
            throw new InputValidationException("Problem in generating authCode "+e.getMessage());
        }
    }

    @PostMapping(path = RestURIConstant.VALIDATE_CODE, produces =  {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> validateMFACode(@RequestBody Map<String,Integer> requestPaylaod) {
       Integer authCode =  requestPaylaod.get("authCode");
       LOGGER.info("call made to validateCode for authCode {}", authCode);
       if(authCode != null){
           try {
               loggedUserServiceV1.validateMFACode(authCode);
               return success("Validate successfully", 200);
           } catch(Exception e) {
               throw new InputValidationException("authCode is invalid");
           }
       }
       LOGGER.info("authCode is missing ");
       return failure ("AuthCode is required ", 404);
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
