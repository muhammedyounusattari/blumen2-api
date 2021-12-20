package com.kastech.blumen.repository.student.logs;

import com.kastech.blumen.model.student.logs.StudentAttendanceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAttendanceLogRepository extends JpaRepository<StudentAttendanceLog, Long> {
}
