package com.kastech.blumen.service.impl;

import com.kastech.blumen.model.MegaDataOrgTypeFields;
import com.kastech.blumen.model.MegaMaintenanceData;
import com.kastech.blumen.repository.utilities.MegaDataOrgTypeFieldsRepository;
import com.kastech.blumen.service.MegaDataOrgTypeFieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MegaDataOrgTypeFieldsServiceImpl implements MegaDataOrgTypeFieldsService {

    @Autowired
    private MegaDataOrgTypeFieldsRepository repository;

    @Override
    public MegaDataOrgTypeFields save(MegaDataOrgTypeFields megaDataOrgTypeFields) {
        MegaMaintenanceData megaMaintenanceData = new MegaMaintenanceData();
        megaMaintenanceData.setId(megaDataOrgTypeFields.getMegaMaintenanceDataId());
        megaDataOrgTypeFields.setMegaMaintenanceData(megaMaintenanceData);
        return repository.save(megaDataOrgTypeFields);
    }

    @Override
    public MegaDataOrgTypeFields getMegaDataOrgTypeFieldsById(long id) {
        MegaDataOrgTypeFields megaDataOrgTypeFields = repository.findById(id).orElseThrow(() -> new RuntimeException("ID not present."));
        megaDataOrgTypeFields.setMegaMaintenanceDataId(megaDataOrgTypeFields.getMegaMaintenanceData().getId());
        return megaDataOrgTypeFields;
    }

    @Override
    public void deleteMegaDataOrgTypeFieldsById(long id) {
        repository.deleteById(id);
    }
}
