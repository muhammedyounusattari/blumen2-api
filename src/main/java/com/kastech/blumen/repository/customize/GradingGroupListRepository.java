package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.model.customize.GradingGroupList;
import com.kastech.blumen.model.customize.GradingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GradingGroupListRepository extends JpaRepository<GradingGroupList, Long> {

	@Query("SELECT max(ggl.id) FROM GradingGroupList ggl where ggl.orgId=:orgId")
	Long getMaxId(@Param("orgId") long orgId);

	@Query("from GradingGroupList gl where gl.orgId=:orgId and gl.deletedBy=0L and gl.deletedDate=null order by gl.id asc")
	Iterable<GradingGroupList> findByOrgId(@Param("orgId") long orgId);

	@Query("from GradingGroupList gglf where gglf.gradeGroupId=:gradingGroupId and gglf.orgId=:orgId and gglf.deletedBy=0L")
	GradingGroupList findByGradingGroupIdAndOrgId(@Param("gradingGroupId") long gradingGroupId,@Param("orgId") long orgId);

	@Query("from GradingGroupList ifg where ifg.id=:id and ifg.orgId=:orgId and ifg.deletedBy!=0L and ifg.deletedDate!=null")
	GradingGroupList findDeletedGradingByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from GradingGroupList iff where iff.id=:id and iff.orgId=:orgId and iff.deletedBy=0L and iff.deletedDate=null")
	GradingGroupList findByGradingId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from GradingGroupList ifgo where ifgo.id=:id and ifgo.orgId=:orgId and ifgo.deletedBy=0L and ifgo.deletedDate=null")
	GradingGroupList findByGradingIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from GradingGroupList ggnggno where LOWER(ggnggno.gradeGroupName)=LOWER(:gradeGroupName) and LOWER(ggnggno.gradeGroupGradeType)=LOWER(:gradeGroupGradeType) and ggnggno.orgId=:orgId")
	GradingGroupList findByGradingGroupNameAndGradingGroupTypeAndOrgId(@Param("gradeGroupName") String gradeGroupName,@Param("gradeGroupGradeType") String gradeGroupGradeType, @Param("orgId") long orgId);

}
