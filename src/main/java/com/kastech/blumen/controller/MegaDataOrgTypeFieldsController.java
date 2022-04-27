package com.kastech.blumen.controller;

import com.kastech.blumen.model.MegaDataOrgTypeFields;
import com.kastech.blumen.service.MegaDataOrgTypeFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blumen-api/mega-org-fields/v1")
public class MegaDataOrgTypeFieldsController {

    @Autowired
    private MegaDataOrgTypeFieldsService megaDataOrgTypeFieldsService;

    @PostMapping
    public ResponseEntity<MegaDataOrgTypeFields> saveMegaDataOrgTypeFields(@RequestBody MegaDataOrgTypeFields megaDataOrgTypeFields) {
        return ResponseEntity.ok(megaDataOrgTypeFieldsService.save(megaDataOrgTypeFields));
    }

    @PutMapping
    public ResponseEntity<MegaDataOrgTypeFields> updateMegaDataOrgTypeFields(@RequestBody MegaDataOrgTypeFields megaDataOrgTypeFields) {
        return ResponseEntity.ok(megaDataOrgTypeFieldsService.save(megaDataOrgTypeFields));
    }

    @GetMapping
    public ResponseEntity<MegaDataOrgTypeFields> getMegaDataOrgTypeFieldsById(@RequestParam(value = "id") long id) {
        return ResponseEntity.ok(megaDataOrgTypeFieldsService.getMegaDataOrgTypeFieldsById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMegaDataOrgTypeFieldsById(@RequestParam(value = "id") long id) {
        megaDataOrgTypeFieldsService.deleteMegaDataOrgTypeFieldsById(id);
        return ResponseEntity.ok().build();
    }
}
