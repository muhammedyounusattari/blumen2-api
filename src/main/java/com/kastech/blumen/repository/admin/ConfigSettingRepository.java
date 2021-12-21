package com.kastech.blumen.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.ConfigSettings;

@Repository
public interface ConfigSettingRepository extends JpaRepository<ConfigSettings, Long> {

}
