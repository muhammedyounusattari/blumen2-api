package com.kastech.blumen.controller;

import com.kastech.blumen.model.FieldTypes;
import com.kastech.blumen.service.FieldTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/field-types/v1")
public class FieldTypesController {

    @Autowired
    private FieldTypesService fieldTypesService;

    @GetMapping
    public ResponseEntity<List<FieldTypes>> findAll() {
        return ResponseEntity.ok(fieldTypesService.findAll());
    }
}
