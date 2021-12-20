package com.kastech.blumen.repository.utilities.generatesimilar;

import com.kastech.blumen.model.utilities.generatesimilar.AttendanceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceLogRepository extends JpaRepository<AttendanceLog,Long> {
}
