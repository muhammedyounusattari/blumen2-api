package com.kastech.blumen.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.ConfigSettings;

import java.util.List;

@Repository
public interface ConfigSettingRepository extends JpaRepository<ConfigSettings, Long> {

    @Query(value = "SELECT cs FROM ConfigSettings cs where cs.orgId=:orgId and cs.userId=:userId order by cs.id ")
    List<ConfigSettings> findByOrganizationTypeAndUserSecurityInfo(@Param("orgId") Long orgId, @Param("userId") Long userId);

}