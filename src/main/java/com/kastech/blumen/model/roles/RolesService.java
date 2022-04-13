package com.kastech.blumen.model.roles;

import com.kastech.blumen.controller.roles.RolesController;
import com.kastech.blumen.model.keycloak.Roles;
import com.kastech.blumen.repository.roles.RolesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesService {

    @Autowired
    public RolesRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(RolesService.class);


    public List<Roles> getRolesByOrgId(Long orgId) {
        LOGGER.info("call made to getRolesByOrgId for orgId {} ", orgId);
        return repository.findByOrgId(orgId);
    }
}
