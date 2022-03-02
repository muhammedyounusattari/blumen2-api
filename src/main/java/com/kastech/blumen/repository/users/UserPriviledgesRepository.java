package com.kastech.blumen.repository.users;

import com.kastech.blumen.model.users.Priviledges;
import com.kastech.blumen.model.users.UserPriviledges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPriviledgesRepository extends JpaRepository<UserPriviledges, Long> {

    @Query(value = "SELECT p FROM UserPriviledges p where p.UserRoleId=?1 ")
    List<UserPriviledges> findAllByUserRoleId (@Param("UserRoleId") Long UserRoleId);

    @Query(value = "SELECT p FROM UserPriviledges p where p.UserRoleId=?1 and p.priviledgesId=?2")
    UserPriviledges findAllByUserRoleAndPriviledgeId (@Param("UserRoleId") Long UserRoleId, @Param("PriviledgesId") Long PriviledgesId);
}
