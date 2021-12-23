package com.kastech.blumen.repository.student.home;

import com.kastech.blumen.model.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalizedLettersRepository extends JpaRepository<Student,Long> {
}
