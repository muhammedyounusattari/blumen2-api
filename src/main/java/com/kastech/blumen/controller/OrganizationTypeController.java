package com.kastech.blumen.controller;

import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.service.OrganizationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/org-types/v1")
public class OrganizationTypeController {

    @Autowired
    private OrganizationTypeService organizationTypeService;

    @GetMapping
    public ResponseEntity<List<OrganizationType>> findAll() {
        return ResponseEntity.ok(organizationTypeService.findAll());
    }
}
