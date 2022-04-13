package com.kastech.blumen.repository.roles;

import com.kastech.blumen.model.keycloak.Privileges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriviledgesRepository extends JpaRepository<Privileges, Long> {

    @Query(value = "SELECT p FROM Privileges p where p.parentId=?1 ")
    List<Privileges> findAllByParentId(@Param("parentId") Long parentId);


}
