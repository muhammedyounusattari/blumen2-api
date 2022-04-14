package com.kastech.blumen.repository.admin.home;

import com.kastech.blumen.model.ConfigSettings;
import com.kastech.blumen.model.admin.home.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query(value="select *from blumen2.organization where org_id=:orgId", nativeQuery = true)
    Optional<Organization> findByOrgId(@Param("orgId") Long orgId);
}
