package com.kastech.blumen.repository.counselor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.admin.CounselorClasses;

@Repository
public interface CounselorClassRepository extends JpaRepository<CounselorClasses, Long> {
}
