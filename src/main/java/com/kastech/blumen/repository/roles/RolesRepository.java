package com.kastech.blumen.repository.roles;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.keycloak.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {


    @Query(value = "select * from blumen2.roles role where role.org_Id=:orgId", nativeQuery = true)
    List<Roles> findByOrgId(@Param("orgId") Long orgId);
}
