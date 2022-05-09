package com.kastech.blumen.service.admin;

import com.kastech.blumen.model.SystemPreferences;
import com.kastech.blumen.repository.admin.SystemPreferencesRepository;
import com.kastech.blumen.utility.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemPreferencesService {

    @Autowired
    SystemPreferencesRepository systemPreferencesRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigSettingService.class);

    public SystemPreferences saveSystemPreferenceData(SystemPreferences systemPreferences) {
        LOGGER.info("Inside saveSystemPreferenceData ");
        systemPreferences.setOrgId(SecurityUtil.getUserOrgId());
        systemPreferences.setModifiedBy(SecurityUtil.getUserId());
        return systemPreferencesRepository.save(systemPreferences)	;
    }

    public List<SystemPreferences> getAllSystemPreferences(){
        LOGGER.info("Inside getAllSystemPreferences ");
        return systemPreferencesRepository.findByOrgId(SecurityUtil.getUserOrgId());
    }
}
