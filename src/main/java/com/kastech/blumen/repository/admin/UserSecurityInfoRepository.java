package com.kastech.blumen.repository.admin;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.keycloak.UserSecurityInfo;
import com.kastech.blumen.model.keycloak.UserSecurityInfoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSecurityInfoRepository extends JpaRepository<UserSecurityInfo, UserSecurityInfoId> {

    @Query("from UserSecurityInfo usi where usi.username=:username and usi.orgId=:orgId")
    Optional<UserSecurityInfo> findByUsername(@Param("username") String username, @Param("orgId") String orgId);
}
