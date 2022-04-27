package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.model.customize.LabSettingPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LabSettingPreferencesRepository extends JpaRepository<LabSettingPreferences,Long> {

    @Query("from LabSettingPreferences gl where gl.orgId=:orgId and gl.deletedBy=0L and gl.deletedDate=null order by gl.createdDate desc")
    Iterable<LabSettingPreferences> findByOrgId(@Param("orgId") long orgId);
}
