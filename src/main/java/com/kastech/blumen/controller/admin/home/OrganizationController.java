package com.kastech.blumen.controller.admin.home;

import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
import com.kastech.blumen.service.superadmin.OrganizationService;
import com.kastech.blumen.validator.admin.home.OrganizationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/api/blumen-api/admin/home")
public class OrganizationController {


    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    OrganizationValidator organizationValidator;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    LoggedUserServiceV1 loggedUserServiceV1;

    @ResponseBody
    @GetMapping(path = "/getOrganizationsList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Organization> getOrganizationsList(Authentication authentication) {
        //CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<Organization> list = new ArrayList<>();
        Iterable<Organization> items = organizationRepository.findAll(Sort.by(Sort.Direction.ASC, "orgId"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getOrganizationList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Organization> getOrganizationList(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        List<Organization> list = new ArrayList<>();
        Optional<Organization> items = organizationRepository.findById(userDetails.getOrgId());
       // items.forEach(list::add);
        return items;
    }

    @ResponseBody
    @PostMapping(path = "/addOrganization/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addOrganization(@RequestBody Organization organization) {
        try {
            LOGGER.info("call made to add organization with ppayload {}", organization);
            Map<String, Object> map = new HashMap<>();
            map.put("body", "organization onboarded succcessfully with orgId "+ organizationService.createOrganization(organization).getOrgId());
            map.put("status", "200");
            return new ResponseEntity(map, null, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Execption while onBoarding organization");
            e.printStackTrace();
            Map<String, Object> map = new HashMap<>();
            map.put("message", e.getMessage());
            map.put("status", "400");
            return new ResponseEntity(map, null, HttpStatus.OK);
        }
    }

    @ResponseBody
    @PutMapping(path = "/updateOrganization/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> updateOrganization(@RequestBody Organization organization) {
        Organization organizationObj = organizationRepository.save(organization);
        if (null != organizationObj) {
            Map<String, Object> map = new HashMap<>();
            map.put("body", organizationObj);
            map.put("status", "200");
            return new ResponseEntity(map, null, HttpStatus.OK);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("body", organizationObj);
            map.put("status", "400");
            return new ResponseEntity(map, null, HttpStatus.OK);
        }
    }

    @ResponseBody
    @PostMapping(path = "/createUser/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createUser(Authentication authentication, @RequestBody LoggedUser loggedUser) {
        LOGGER.info("Call made to createUser with payload {}", loggedUser);
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        loggedUser.setEditedBy(customUserDetails.getUsername());
        try {
            loggedUser = loggedUserServiceV1.createUser(loggedUser);
            return success(loggedUser, 200);
        } catch (Exception e) {
           LOGGER.info("problem occured while creating user");
           return failure("problem in creating a user for orgId "+loggedUser.getOrgId(), 500);
        }

    }

    @ResponseBody
    @GetMapping(path = "/usersList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<LoggedUser> getUsersList(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return loggedUserServiceV1.findByOrgId(userDetails.getOrgId());
    }


    private ResponseEntity<?> success(Object t, Integer status) {
        return new ResponseEntity(t, null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, int statusCode) {
        return new ResponseEntity(t, null, HttpStatus.valueOf(statusCode));
    }

}
