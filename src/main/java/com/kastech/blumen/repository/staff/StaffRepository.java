package com.kastech.blumen.repository.staff;

import com.kastech.blumen.model.customize.GradingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.staff.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("SELECT max(ggl.staffId) FROM Staff ggl where ggl.orgId=:orgId")
    Long getMaxId(@Param("orgId") long orgId);

    @Query("from Staff gl where gl.orgId=:orgId and gl.deletedBy=0L and gl.deletedDate=null and gl.staffActive=TRUE order by gl.staffId asc")
    Iterable<Staff> findByOrgId(@Param("orgId") long orgId);

    @Query("from Staff ifg where ifg.staffId=:staffId and ifg.orgId=:orgId and ifg.deletedBy!=0L and ifg.deletedDate!=null")
    Staff findDeletedStaffByStaffIdAndOrgId(@Param("staffId") long staffId, @Param("orgId") long orgId);

    @Query("from Staff iff where iff.staffId=:staffId and iff.orgId=:orgId and iff.deletedBy=0L and iff.deletedDate=null")
    Staff findByStaffId(@Param("staffId") long staffId, @Param("orgId") long orgId);

    @Query("from Staff ifgo where ifgo.staffId=:staffId and ifgo.orgId=:orgId and ifgo.deletedBy=0L and ifgo.deletedDate=null")
    Staff findByStaffIdAndOrgId(@Param("staffId") long staffId, @Param("orgId") long orgId);

    @Query("from Staff gnggno where LOWER(gnggno.staffName)=LOWER(:staffName) and gnggno.orgId=:orgId")
    Staff findByStaffNameAndOrgId(@Param("staffName") String staffName, @Param("orgId") long orgId);

    @Query("from Staff ifgo where ifgo.id=:id and ifgo.orgId=:orgId and ifgo.deletedBy=0L and ifgo.deletedDate=null")
    Staff findByIdAndOrgId(@Param("id") long id, @Param("orgId") long orgId);

}
