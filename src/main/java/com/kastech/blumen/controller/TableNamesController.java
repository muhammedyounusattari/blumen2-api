package com.kastech.blumen.controller;

import com.kastech.blumen.model.TableNames;
import com.kastech.blumen.service.TableNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/table-names/v1")
public class TableNamesController {

    @Autowired
    private TableNamesService tableNamesService;

    @GetMapping
    public ResponseEntity<List<TableNames>> findAll() {
        return ResponseEntity.ok(tableNamesService.findAll());
    }

}
