package com.kastech.blumen.service;

import com.kastech.blumen.model.Configurations.OrganizationType;

import java.util.List;

public interface OrganizationTypeService {

    List<OrganizationType> findAll();

    OrganizationType findById(long id);
}
