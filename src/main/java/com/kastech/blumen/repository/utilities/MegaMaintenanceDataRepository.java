package com.kastech.blumen.repository.utilities;

import com.kastech.blumen.model.MegaMaintenanceData;
import com.kastech.blumen.model.TableNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MegaMaintenanceDataRepository extends JpaRepository<MegaMaintenanceData, Long> {

    List<MegaMaintenanceData> findByTableNames(TableNames tableNames);
}

