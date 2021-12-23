package com.kastech.blumen.repository.student.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.logs.StudentExamsLog;

@Repository
public interface StudentExamsLogRepository extends JpaRepository<StudentExamsLog, Long> {
}
