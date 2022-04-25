package com.kastech.blumen.controller;

import com.kastech.blumen.model.MegaMaintenanceData;
import com.kastech.blumen.service.MegaMaintenanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blumen-api/mega-maintenance/v1")
public class MegaMaintenanceDataController {

    @Autowired
    private MegaMaintenanceDataService megaMaintenanceDataService;

    @PostMapping
    public ResponseEntity<MegaMaintenanceData> saveMegaMaintenanceData(@RequestBody MegaMaintenanceData megaMaintenanceData) {
        return ResponseEntity.ok(megaMaintenanceDataService.save(megaMaintenanceData));
    }

    @GetMapping
    public ResponseEntity<List<MegaMaintenanceData>> findAllByTableNamesId(@RequestParam(value = "table_name_id") long tableNameId) {
        return ResponseEntity.ok(megaMaintenanceDataService.findAllByTableNamesId(tableNameId));
    }

    @PutMapping
    public ResponseEntity<MegaMaintenanceData> updateMegaMaintenanceData(@RequestBody MegaMaintenanceData megaMaintenanceData) {
        return ResponseEntity.ok(megaMaintenanceDataService.save(megaMaintenanceData));
    }

}
