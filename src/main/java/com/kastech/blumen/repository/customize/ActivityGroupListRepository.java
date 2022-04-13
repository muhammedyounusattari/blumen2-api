package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.ActivityGroupList;
import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.CollegeSchool;
import com.kastech.blumen.model.customize.GradingGroupList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ActivityGroupListRepository extends JpaRepository<ActivityGroupList,Long> {

	@Query("SELECT max(ggl.id) FROM ActivityGroupList ggl where ggl.orgId=:orgId")
	Long getMaxId(@Param("orgId") long orgId);

	@Query("from ActivityGroupList gl where gl.orgId=:orgId and gl.deletedBy=0L and gl.deletedDate=null order by gl.id asc")
	Iterable<ActivityGroupList> findByOrgId(@Param("orgId") long orgId);

	@Query("from ActivityGroupList gglf where gglf.activityGroupId=:activityGroupId and gglf.orgId=:orgId and gglf.deletedBy=0L")
	ActivityGroupList findByActivityGroupIdAndOrgId(@Param("activityGroupId") long activityGroupId,@Param("orgId") long orgId);

//	@Query("from ActivityGroupList gld where gld.orgId=:orgId and gld.deletedBy !=null and gld.deletedDate !=null order by gld.createdDate asc")
//	Iterable<ActivityGroupList> findByOrgIdAndDeletedItems(@Param("orgId") String orgId);
//
//	@Query("from ActivityGroupList ifg where ifg.activityGroupId=:activityGroupId and ifg.deletedBy!=null and ifg.deletedDate!=null")
//	ActivityGroupList findByDeletedActivityGroupId(@Param("activityGroupId") String activityGroupId);

	@Query("from ActivityGroupList ifg where ifg.id=:id and ifg.orgId=:orgId and ifg.deletedBy!=0L and ifg.deletedDate!=null")
	ActivityGroupList findDeletedItemByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from ActivityGroupList iff where iff.id=:id and iff.orgId=:orgId and iff.deletedBy=0L and iff.deletedDate=null")
	ActivityGroupList findByActivityId(@Param("id") long id, @Param("orgId") long orgId);

	@Transactional
	@Modifying
	@Query("delete from ActivityGroupList df where df.id=:id and df.orgId=:orgId")
	int deleteRecordByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from ActivityGroupList ifgo where ifgo.id=:id and ifgo.orgId=:orgId and ifgo.deletedBy=0L and ifgo.deletedDate=null")
	ActivityGroupList findByActivityIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

	@Query("from ActivityGroupList ifgag where LOWER(ifgag.activityGroupName)=LOWER(:activityGroupName) and LOWER(ifgag.activityGroupType)=LOWER(:activityGroupType) and ifgag.orgId=:orgId")
	ActivityGroupList findActivityGroupByActivityGroupNameAndActivityGroupTypeAndOrgId(@Param("activityGroupName") String activityGroupName, @Param("activityGroupType") String activityGroupType, @Param("orgId") long orgId);


}
