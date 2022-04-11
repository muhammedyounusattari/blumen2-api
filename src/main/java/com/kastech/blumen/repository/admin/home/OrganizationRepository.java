package com.kastech.blumen.repository.admin.home;

import com.kastech.blumen.model.ConfigSettings;
import com.kastech.blumen.model.admin.home.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
