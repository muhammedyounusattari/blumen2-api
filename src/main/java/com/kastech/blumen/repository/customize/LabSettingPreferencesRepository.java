package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.LabSettingPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabSettingPreferencesRepository extends JpaRepository<LabSettingPreferences,Long> {
}
