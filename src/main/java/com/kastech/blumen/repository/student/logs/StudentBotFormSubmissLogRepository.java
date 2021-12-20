package com.kastech.blumen.repository.student.logs;

import com.kastech.blumen.model.student.logs.StudentBotFormSubmissLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentBotFormSubmissLogRepository extends JpaRepository<StudentBotFormSubmissLog,Long>{
}
