package com.kastech.blumen.repository.admin;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.keycloak.LoggedUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoggedUserRepository extends JpaRepository<LoggedUser, Long> {
    @Query("from LoggedUser lu where lu.email=?1 and lu.orgType=?2")
    Optional<LoggedUser> findByUserEmailAndOrgType(@Param("email") String email, @Param("orgtype") String orgtype);

    @Query("from LoggedUser lu where lu.orgId=:orgId")
    Optional<LoggedUser> findByOrgId(@Param("orgId") Long orgId);

    @Query(value="SELECT lu from LoggedUser lu where lu.email=?1 and lu.password=?2 and lu.orgType=?3 ")
    List<LoggedUser> findByUserDetails(@Param("email") String email, @Param("password") String password, @Param("orgType") String orgType);

}
