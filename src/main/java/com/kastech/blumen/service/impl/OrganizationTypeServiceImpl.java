package com.kastech.blumen.service.impl;

import com.kastech.blumen.model.Configurations.OrganizationType;
import com.kastech.blumen.repository.student.configurations.OrganizationTypeRepository;
import com.kastech.blumen.service.OrganizationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationTypeServiceImpl implements OrganizationTypeService {

    @Autowired
    private OrganizationTypeRepository repository;

    @Override
    public List<OrganizationType> findAll() {
        return repository.findAll();
    }

    @Override
    public OrganizationType findById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ID not present."));
    }
}
