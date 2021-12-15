package com.kastech.blumen.repository.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.admin.TeacherClasses;
import com.kastech.blumen.model.admin.TutorClasses;

@Repository
public interface TeacherClassRepository extends JpaRepository<TeacherClasses, Long> {
}
