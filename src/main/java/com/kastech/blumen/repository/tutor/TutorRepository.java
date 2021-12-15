package com.kastech.blumen.repository.tutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.tutor.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
