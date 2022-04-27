package com.kastech.blumen.repository.student.logs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.logs.StudentTextMessagesLog;

@Repository
public interface StudentTextMessagesLogRepository extends JpaRepository<StudentTextMessagesLog, Long> {
}
