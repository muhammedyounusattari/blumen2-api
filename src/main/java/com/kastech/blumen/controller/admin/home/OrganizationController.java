package com.kastech.blumen.controller.admin.home;

import com.kastech.blumen.exception.DataModificationException;
import com.kastech.blumen.exception.DataNotFoundException;
import com.kastech.blumen.exception.InputValidationException;
import com.kastech.blumen.model.CustomUserDetails;
import com.kastech.blumen.model.admin.home.OrgInfo;
import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.service.admin.LoggedUserServiceV1;
import com.kastech.blumen.service.superadmin.OrganizationService;
import com.kastech.blumen.utility.SecurityUtil;
import com.kastech.blumen.validator.admin.home.OrganizationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.kastech.blumen.constants.ErrorMessageConstants.*;

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
    public List<Organization> getOrganizationsList() {
        List<Organization> list = new ArrayList<>();
        Iterable<Organization> items = organizationRepository.findAll(Sort.by(Sort.Direction.ASC, "orgId"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getAllOrganizations/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OrgInfo> getAllOrganizations() {
        List<OrgInfo> list = new ArrayList<>();
        Iterable<Organization> orgs = organizationRepository.findAll(Sort.by(Sort.Direction.ASC, "orgId"));
        orgs.forEach( o -> list.add(new OrgInfo(o)));
        return list;
    }

    @ResponseBody
    @GetMapping(path = "/getUsers/v1/{orgId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUsers(@PathVariable Long orgId) {

        if(StringUtils.isEmpty(orgId)){
            orgId = SecurityUtil.getUserOrgId();
        }
        List<LoggedUser> items = null;
        try {
            items = loggedUserServiceV1.findByOrgId(orgId);
            if(items.isEmpty()){
                return success("Organization with id "+ orgId +" not found", 200);
            }
            items.forEach(i -> i.getRoles().forEach( r -> r.setPrivileges(null)));
            return success(items, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return failure("Problem in accessing organization users details", 400);
        }
    }

    @ResponseBody
    @GetMapping(path = "/getOrganizationUserList/v1/{orgId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getOrganizationUserList(@PathVariable Long orgId) {

        if(StringUtils.isEmpty(orgId)){
            orgId = SecurityUtil.getUserOrgId();
        }
        List<Organization> list = new ArrayList<>();
        Optional<Organization> items = null;
        try {
            items = organizationRepository.findByOrgId(orgId);
            if(items.isEmpty()){
                return success("Organization with id "+orgId+" not found", 200);
            }
            return success(items, 200);
        } catch (Exception e) {
            e.printStackTrace();
            return failure("Problem in accessing organization users details", 400);
        }
    }

    @ResponseBody
    @PostMapping(path = "/addOrganization/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Super Admin')")
    public ResponseEntity<String> addOrganization(@RequestBody Organization organization) {

        LOGGER.info("call made to add organization with payload {}", organization);
        if(null != organization.getOrgId()) {
            throw new InputValidationException(NEW_ORGANIZATION_NOTNULL);
        }
        if (null != organization.getOrgId() &&  organization.getOrgId() == 0L) {
            throw new DataNotFoundException(ORGANIZATION_0_SETUP);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("body", organizationService.createOrganization(organization).getOrgId());
        map.put("status", "200");
        return new ResponseEntity(map, null, HttpStatus.OK);

    }

    @ResponseBody
    @PutMapping(path = "/updateOrganization/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('Super Admin')")
    public ResponseEntity<String> updateOrganization(@RequestBody Organization organization) {
        Organization organizationObj = organizationService.updateOrganization(organization);
        Map<String, Object> map = new HashMap<>();
        map.put("body", organizationObj);
        map.put("status", "200");
        return new ResponseEntity(map, null, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(path = "/createUser/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
   // @PreAuthorize("hasAnyAuthority('User Names and Password_Y', 'Super Admin')")
    /**
     * Need to check with chandra regarding access to method
     */
    public ResponseEntity<?> createUser( @RequestBody LoggedUser loggedUser) {
        LOGGER.info("Call made to createUser with payload {}", loggedUser);
        CustomUserDetails customUserDetails = SecurityUtil.getUserDetails();
        loggedUser.setEditedBy(customUserDetails.getUsername());
        loggedUser.setFirstTime(Boolean.TRUE);
        if(null != loggedUser.getId()) {
            throw new InputValidationException("User Id Id should be empty string while adding User");
        }
        loggedUser = loggedUserServiceV1.createUser(loggedUser);
        return success("Your orgCode "+ loggedUser.getOrgCode()+" email "+loggedUser.getEmail()+" tempLink "+loggedUser.getTempLink(), 200);

    }

    @ResponseBody
    @PostMapping(path = "/updateUser/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAnyAuthority('User Names and Password_Y', 'Super Admin')")
    public ResponseEntity<?> updateUser( @RequestBody LoggedUser loggedUser) {
        LOGGER.info("Call made to updateUser with payload {}", loggedUser);
        CustomUserDetails customUserDetails = SecurityUtil.getUserDetails();
        loggedUser.setEditedBy(customUserDetails.getUsername());
        loggedUserServiceV1.updateUser(loggedUser);
        return success("User updated successfully", 200);
//
//        try {
//            loggedUser = loggedUserServiceV1.updateUser(loggedUser);
//            return success("User is updated successfully", 200);
//        } catch (Exception e) {
//            LOGGER.error("problem occurred while updating user");
//            e.printStackTrace();
//            Map<String, Object> map = new HashMap<>();
//            map.put("message", "problem in updating a user for orgId "+loggedUser.getOrgId());
//            map.put("status", "400");
//            return new ResponseEntity(map, null, HttpStatus.OK);
//        }

    }

    private ResponseEntity<?> success(Object t, Integer status) {
        return new ResponseEntity(t, null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, int statusCode) {
        return new ResponseEntity(t, null, HttpStatus.valueOf(statusCode));
    }

}
