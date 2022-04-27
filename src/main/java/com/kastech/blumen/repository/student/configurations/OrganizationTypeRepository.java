package com.kastech.blumen.repository.student.configurations;

import com.kastech.blumen.model.Configurations.OrganizationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationTypeRepository extends JpaRepository<OrganizationType,Long> {
    @Query("SELECT ot from OrganizationType ot where ot.OrgType = ?1")
    public List<OrganizationType> findByOrgType(String  type);

}
