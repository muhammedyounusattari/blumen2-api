package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.ActivityList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ActivityListRepository extends JpaRepository<ActivityList,Long> {

	@Query("SELECT max(ggl.id) FROM ActivityList ggl where ggl.orgId=:orgId")
	Long getMaxId(@Param("orgId") long orgId);

	@Query("from ActivityList gl where gl.orgId=:orgId and gl.deletedBy=0L and gl.deletedDate=null order by gl.id asc")
	Iterable<ActivityList> findByOrgId(@Param("orgId") long orgId);

	@Query("from ActivityList gglf where gglf.activityId=:activityId and gglf.orgId=:orgId and gglf.deletedBy=0L")
	ActivityList findByActivityIdAndOrgId(@Param("activityId") long activityId,@Param("orgId") long orgId);

	@Query("from ActivityList ifg where ifg.id=:id and ifg.orgId=:orgId and ifg.deletedBy!=0L and ifg.deletedDate!=null")
	ActivityList findDeletedItemByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from ActivityList iff where iff.id=:id and iff.orgId=:orgId and iff.deletedBy=0L and iff.deletedDate=null")
	ActivityList findByActivityId(@Param("id") long id, @Param("orgId") long orgId);

	@Transactional
	@Modifying
	@Query("delete from ActivityList df where df.id=:id and df.orgId=:orgId")
	int deleteRecordByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from ActivityList ifgo where ifgo.id=:id and ifgo.orgId=:orgId and ifgo.deletedBy=0L and ifgo.deletedDate=null")
	ActivityList findByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from ActivityList ifgoo where LOWER(ifgoo.activityName)=LOWER(:activityName) and LOWER(ifgoo.activityGroupName)=LOWER(:activityGroupName) and ifgoo.orgId=:orgId")
	ActivityList findByActivityNameAndGroupNameAndOrgId(@Param("activityName") String activityName,@Param("activityGroupName") String activityGroupName, @Param("orgId") long orgId);
}
