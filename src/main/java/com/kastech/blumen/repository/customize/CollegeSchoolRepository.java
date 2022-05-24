package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.ActivityList;
import com.kastech.blumen.model.customize.CollegeSchool;
import com.kastech.blumen.model.customize.GradingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CollegeSchoolRepository extends JpaRepository<CollegeSchool,String> {

    @Query("from CollegeSchool gl where gl.orgId=:orgId and gl.deletedBy=0L and gl.deletedDate=null order by gl.createdDate asc")
    Iterable<CollegeSchool> findByOrgId(@Param("orgId") long orgId);

    @Query("from CollegeSchool gglf where gglf.collegeSchoolId=:collegeSchoolId and gglf.orgId=:orgId and gglf.deletedBy=0L")
    CollegeSchool findByCollegeSchoolIdAndOrgId(@Param("collegeSchoolId") long collegeSchoolId,@Param("orgId")  long orgId);

    @Query("from CollegeSchool ifg where LOWER(ifg.name)=LOWER(:name) and ifg.orgId=:orgId and ifg.deletedBy!=0L and ifg.deletedDate is not null and ifg.isSchool = false")
    CollegeSchool findDeletedCollegeByNameAndOrgId(@Param("name") String name, @Param("orgId") long orgId);

    @Query("from CollegeSchool ifs where LOWER(ifs.name)=LOWER(:name) and ifs.orgId=:orgId and ifs.deletedBy!=0L and ifs.deletedDate is not null and ifs.isSchool = true")
    CollegeSchool findDeletedSchoolByNameAndOrgId(@Param("name") String name, @Param("orgId") long orgId);

    @Query("from CollegeSchool iff where iff.collegeSchoolId=:collegeSchoolId and iff.orgId=:orgId and iff.deletedBy=0L and iff.deletedDate=null")
    CollegeSchool findByCollegeSchoolId(@Param("collegeSchoolId") long collegeSchoolId, @Param("orgId") long orgId);

    @Query("from CollegeSchool ifg where ifg.collegeSchoolId=:collegeSchoolId and ifg.orgId=:orgId and ifg.deletedBy!=0L and ifg.deletedDate!=null")
    CollegeSchool findDeletedCollegeSchoolByIdAndOrgId(@Param("collegeSchoolId") long collegeSchoolId, @Param("orgId") long orgId);

    @Query("from CollegeSchool cibn where LOWER(cibn.name)=LOWER(:name) and cibn.orgId=:orgId and cibn.isSchool = false")
    CollegeSchool findCollegeByNameAndOrgId(@Param("name") String name, @Param("orgId") long orgId);

    @Query("from CollegeSchool sibn where LOWER(sibn.name)=LOWER(:name) and sibn.orgId=:orgId and sibn.isSchool  = true")
    CollegeSchool findSchoolByNameAndOrgId(@Param("name") String name, @Param("orgId") long orgId);

    @Query("from CollegeSchool cibc where cibc.ncsIdFafsaId=:code and cibc.orgId=:orgId and cibc.isSchool = false")
    CollegeSchool findCollegeByCodeAndOrgId(@Param("code") String code, @Param("orgId") long orgId);

    @Query("from CollegeSchool sibc where sibc.ncsIdFafsaId=:code and sibc.orgId=:orgId and sibc.isSchool = true")
    CollegeSchool findSchoolByCodeAndOrgId(@Param("code") String code, @Param("orgId") long orgId);

    @Query("from CollegeSchool glfaf where glfaf.orgId=:orgId and glfaf.deletedBy=0L and glfaf.deletedDate=null and glfaf.isSchool = false order by glfaf.createdDate asc")
    Iterable<CollegeSchool> findByOrgIdAndFafsaId(@Param("orgId") long orgId);

    @Query("from CollegeSchool glnces where glnces.orgId=:orgId and glnces.deletedBy=0L and glnces.deletedDate=null and glnces.isSchool = true order by glnces.createdDate asc")
    Iterable<CollegeSchool> findByOrgIdAndNcesId(@Param("orgId") long orgId);

}
