package com.kastech.blumen.controller;

import com.kastech.blumen.model.TableFieldColumns;
import com.kastech.blumen.service.TableFieldColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/table-field-columns/v1")
public class TableFieldColumnsController {

    @Autowired
    private TableFieldColumnsService tableFieldColumnsService;

    @GetMapping
    public ResponseEntity<List<TableFieldColumns>> findAllByTableNamesId(@RequestParam(value = "table_name_id") long tableNameId) {
        return ResponseEntity.ok(tableFieldColumnsService.findAllByTableNameId(tableNameId));
    }

}
