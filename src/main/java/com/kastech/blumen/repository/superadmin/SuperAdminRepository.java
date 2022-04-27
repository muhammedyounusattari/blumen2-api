package com.kastech.blumen.repository.superadmin;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.superadmin.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Long> {

    @Query(value="SELECT sa from SuperAdmin sa where sa.email=?1 and password=?2 and organizationType=?3 ")
    List<SuperAdmin> findByUserDetails(@Param("email") String email, @Param("password") String password, @Param("orgId") String orgId);
}
