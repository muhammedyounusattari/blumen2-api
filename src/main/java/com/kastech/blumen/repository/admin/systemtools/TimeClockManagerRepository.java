package com.kastech.blumen.repository.admin.systemtools;

import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeClockManagerRepository extends JpaRepository<TimeClockManager,Long>, JpaSpecificationExecutor<TimeClockManager> {


    @Query(value = "SELECT t FROM TimeClockManager t where t.staffId=?1 ORDER BY checkOutTime")
    List<TimeClockManager> findAllStaffById(@Param("staffId") String staffId);

}
