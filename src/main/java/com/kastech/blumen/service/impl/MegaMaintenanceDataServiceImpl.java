package com.kastech.blumen.service.impl;

import com.kastech.blumen.model.MegaMaintenanceData;
import com.kastech.blumen.model.TableNames;
import com.kastech.blumen.repository.utilities.MegaMaintenanceDataRepository;
import com.kastech.blumen.service.MegaMaintenanceDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MegaMaintenanceDataServiceImpl implements MegaMaintenanceDataService {

    @Autowired
    private MegaMaintenanceDataRepository megaMaintenanceDataRepository;

    @Override
    public MegaMaintenanceData save(MegaMaintenanceData megaMaintenanceData) {
        return megaMaintenanceDataRepository.save(megaMaintenanceData);
    }

    @Override
    public List<MegaMaintenanceData> findAllByTableNamesId(long tableNameId) {
        TableNames tableNames = new TableNames();
        tableNames.setId(tableNameId);
        return megaMaintenanceDataRepository.findByTableNames(tableNames);
    }
}
