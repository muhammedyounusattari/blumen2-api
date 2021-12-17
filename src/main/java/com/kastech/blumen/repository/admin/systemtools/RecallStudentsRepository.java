package com.kastech.blumen.repository.admin.systemtools;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.Student;

@Repository
public interface RecallStudentsRepository extends JpaRepository<Student, Long> {
}
