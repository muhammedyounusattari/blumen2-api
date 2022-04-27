package com.kastech.blumen.repository.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.teacher.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
