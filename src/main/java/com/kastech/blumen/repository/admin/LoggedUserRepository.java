package com.kastech.blumen.repository.admin;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.keycloak.LoggedUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoggedUserRepository extends JpaRepository<LoggedUser, LoggedUserId> {
    @Query("from LoggedUser lu where lu.userName=:userName and lu.orgId=:orgId")
    Optional<LoggedUser> findByUserName(@Param("userName") String userName, @Param("orgId") String orgId);
}
