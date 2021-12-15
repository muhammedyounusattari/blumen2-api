package com.kastech.blumen.repository.tutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.admin.TutorClasses;

@Repository
public interface TutorClassRepository extends JpaRepository<TutorClasses, Long> {
}
