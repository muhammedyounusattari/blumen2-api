package com.kastech.blumen.service;

import com.kastech.blumen.model.FieldTypes;

import java.util.List;

public interface FieldTypesService {

    List<FieldTypes> findAll();

    FieldTypes findById(long id);
}
