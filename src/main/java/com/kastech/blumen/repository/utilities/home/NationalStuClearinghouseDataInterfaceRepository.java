package com.kastech.blumen.repository.utilities.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.Student;

@Repository
public interface NationalStuClearinghouseDataInterfaceRepository extends JpaRepository<Student, Long> {
}
