package com.kastech.blumen.repository.admin;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.SystemPreferences;

import java.util.List;

@Repository
public interface SystemPreferencesRepository extends JpaRepository<SystemPreferences, Long> {

    List<SystemPreferences> findByOrgId(Long orgId);
}
