package com.kastech.blumen.repository.superadmin;

import com.kastech.blumen.model.superadmin.SecurityQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityQuestionsRepository extends JpaRepository<SecurityQuestions, Long> {
}
