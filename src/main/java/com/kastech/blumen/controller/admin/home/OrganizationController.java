package com.kastech.blumen.controller.admin.home;

import com.kastech.blumen.model.admin.home.Organization;
import com.kastech.blumen.repository.admin.home.OrganizationRepository;
import com.kastech.blumen.service.superadmin.OrganizationService;
import com.kastech.blumen.validator.admin.home.OrganizationValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @GetMapping(path = "/getOrganizationList/v1",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Organization> getOrganizationList() {
        List<Organization> list = new ArrayList<>();
        Iterable<Organization> items = organizationRepository.findAll(Sort.by(Sort.Direction.ASC, "orgId"));
        items.forEach(list::add);
        return list;
    }

    @ResponseBody
    @PostMapping(path = "/addOrganization/v1",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addOrganization(@RequestBody Organization organization) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("body",  organizationService.createOrganization(organization));
            map.put("status", "200");
            return new ResponseEntity(map, null, HttpStatus.OK);
        } catch (Exception e) {
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

    private ResponseEntity<?> success(Object t, Integer status) {
        return new ResponseEntity(t, null, HttpStatus.valueOf(status));
    }

    private ResponseEntity<?> failure(Object t, int statusCode) {
        return new ResponseEntity(t, null, HttpStatus.valueOf(statusCode));
    }

}
