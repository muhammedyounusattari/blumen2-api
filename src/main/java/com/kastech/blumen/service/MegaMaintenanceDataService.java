package com.kastech.blumen.service;

import com.kastech.blumen.model.MegaMaintenanceData;

import java.util.List;

public interface MegaMaintenanceDataService {

    MegaMaintenanceData save(MegaMaintenanceData megaMaintenanceData);

    List<MegaMaintenanceData> findAllByTableNamesId(long tableNameId);
}
