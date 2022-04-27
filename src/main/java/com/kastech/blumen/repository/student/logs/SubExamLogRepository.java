package com.kastech.blumen.repository.student.logs;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.logs.SubExamLogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubExamLogRepository extends JpaRepository<SubExamLogEntry, Long> {
}

