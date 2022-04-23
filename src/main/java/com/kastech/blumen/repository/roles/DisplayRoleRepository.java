package com.kastech.blumen.repository.roles;

import com.kastech.blumen.model.keycloak.DisplayRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisplayRoleRepository extends JpaRepository<DisplayRoles, Long> {
    @Query(value = "SELECT p FROM DisplayRoles p where p.roleName IN (:role_names) ")
    List<DisplayRoles> findByRoleName(@Param("role_names") List<String> role_names);

}
