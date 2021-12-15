package com.kastech.blumen.repository.admin.systemtools;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.Student;

@Repository
public interface DeleteStudentsRepository  extends JpaRepository<Student,Long> {

	Optional<Student> findById(Long id);
	
}
