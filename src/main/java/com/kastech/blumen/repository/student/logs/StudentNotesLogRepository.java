package com.kastech.blumen.repository.student.logs;

import com.kastech.blumen.model.student.logs.StudentNotesLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentNotesLogRepository extends JpaRepository<StudentNotesLog, Long> {
}
