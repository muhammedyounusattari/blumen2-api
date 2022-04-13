package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.model.customize.GradingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GradingListRepository extends JpaRepository<GradingList,Long> {

	@Query("SELECT max(ggl.id) FROM GradingList ggl where ggl.orgId=:orgId")
	Long getMaxId(@Param("orgId") long orgId);

	@Query("from GradingList gl where gl.orgId=:orgId and gl.deletedBy=0L and gl.deletedDate=null order by gl.id asc")
	Iterable<GradingList> findByOrgId(@Param("orgId") long orgId);

	@Query("from GradingList gglf where gglf.gradingId=:gradingId and gglf.orgId=:orgId and gglf.deletedBy=0L")
	GradingList findByGradingIdAndOrgId(@Param("gradingId") long gradingId,@Param("orgId") long orgId);

	@Query("from GradingList ifg where ifg.id=:id and ifg.orgId=:orgId and ifg.deletedBy!=0L and ifg.deletedDate!=null")
	GradingList findDeletedGradingByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from GradingList iff where iff.id=:id and iff.orgId=:orgId and iff.deletedBy=0L and iff.deletedDate=null")
	GradingList findByGradingId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from GradingList ifgo where ifgo.id=:id and ifgo.orgId=:orgId and ifgo.deletedBy=0L and ifgo.deletedDate=null")
	GradingList findByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from GradingList gnggno where LOWER(gnggno.gradingName)=LOWER(:gradingName) and LOWER(gnggno.gradingGroupName)=LOWER(:gradingGroupName) and gnggno.orgId=:orgId")
	GradingList findByGradingNameAndGradingGroupNameAndOrgId(@Param("gradingName") String gradingName,@Param("gradingGroupName") String gradingGroupName, @Param("orgId") long orgId);

}
