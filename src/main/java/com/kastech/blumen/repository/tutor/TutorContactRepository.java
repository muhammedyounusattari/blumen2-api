package com.kastech.blumen.repository.tutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.admin.TutorClasses;
import com.kastech.blumen.model.admin.TutorContact;

@Repository
public interface TutorContactRepository extends JpaRepository<TutorContact, Long> {
}
