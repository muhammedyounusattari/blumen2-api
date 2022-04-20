package com.kastech.blumen.repository.admin;

import com.kastech.blumen.model.keycloak.LoggedUser;
import com.kastech.blumen.model.keycloak.LoggedUserId;
import com.kastech.blumen.model.response.LoggedUserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoggedUserRepository extends JpaRepository<LoggedUser, Long> {
    @Query("from LoggedUser lu where lu.email=?1 and lu.orgCode=?2")
    Optional<LoggedUser> findByUserEmailAndOrgCode(@Param("email") String email, @Param("orgCode") String orgCode);

    @Query("from LoggedUser lu where lu.orgId=:orgId")
    Optional<LoggedUser> findByOrgId(@Param("orgId") Long orgId);

    @Query(value="SELECT lu from LoggedUser lu where lu.email=?1 and lu.password=?2 and lu.orgCode=?3 ")
    List<LoggedUser> findByUserDetails(@Param("email") String email, @Param("password") String password, @Param("orgCode") String orgCode);

    @Query(value = "select count(1) from blumen2.users u where u.email=:emailId", nativeQuery = true)
    Long findByEmailId(@Param("emailId") String emailId);

    @Query(value = "select 'non-sso' from blumen2.users u where u.email=?1 and u.org_code=?2", nativeQuery = true)
    String findByUserAndOrgCode(@Param("emailId") String emailId, @Param("orgCode") String orgCode);

    @Query(value = "select *from blumen2.users u where u.org_Id=:orgId", nativeQuery = true)
    List<LoggedUser> getUsersList(@Param("orgId") Long orgId);

    @Query(value = "select *From blumen2.users u where u.hashed_code=:hashedCode limit 1", nativeQuery = true)
    Optional<LoggedUser> findByHashedCode(@Param("hashedCode") String hashedCode);

    @Query(value = "select * from blumen2.users u where u.email=:emailId and u.org_code=:orgCode", nativeQuery = true)
    Optional<LoggedUser> findByEmailAndOrgCode(@Param("emailId") String emailId, @Param("orgCode") String orgCode);
    @Query(value = "select * from blumen2.users u where u.email=:emailId and u.org_type=:orgType", nativeQuery = true)
    Optional<LoggedUser> findByEmailAndOrgType(@Param("emailId") String emailId, @Param("orgType") String orgType);

    Optional<LoggedUser> findByUsernameAndOrgId(@Param("username") String username, @Param("orgId") Long orgId);
}
