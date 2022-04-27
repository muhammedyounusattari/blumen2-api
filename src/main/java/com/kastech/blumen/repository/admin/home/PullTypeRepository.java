package com.kastech.blumen.repository.admin.home;

import com.kastech.blumen.model.admin.home.PullType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PullTypeRepository extends JpaRepository<PullType,Long> {

    @Query("SELECT pullType FROM PullType pullType WHERE ( upper(pullType.pullDesc) LIKE upper(:pullDesc)) and ( "
            + "  upper(pullType.pullType) LIKE upper(:pullType))  and  (:projType is null " +
            " or pullType.projType = :projType)")
    public List<PullType> findByPullDescStartsWithIgnoreCaseAndPullTypeStartsWithIgnoreCaseAndProjType(@Param("pullDesc")String pullDesc,@Param("pullType") String pullType , @Param("projType") Long projType);

    public List<PullType> findByPullType(String pullType);

    public List<PullType> findByPullTypeAndProjType(String pullType,Long projType);
}
