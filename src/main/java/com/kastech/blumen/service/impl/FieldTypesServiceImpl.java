package com.kastech.blumen.service.impl;

import com.kastech.blumen.model.FieldTypes;
import com.kastech.blumen.repository.utilities.FieldTypesRepository;
import com.kastech.blumen.service.FieldTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldTypesServiceImpl implements FieldTypesService {

    @Autowired
    private FieldTypesRepository repository;

    @Override
    public List<FieldTypes> findAll() {
        return repository.findAll();
    }

    @Override
    public FieldTypes findById(long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("ID not present."));
    }
}
