package com.kastech.blumen.repository.users;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.users.Priviledges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriviledgesRepository extends JpaRepository<Priviledges, Long> {

    @Query(value = "SELECT p FROM Priviledges p where p.PriviledgesParentId=?1 ")
    List<Priviledges> findAllByParentId (@Param("parentId") Long parentId);

}
