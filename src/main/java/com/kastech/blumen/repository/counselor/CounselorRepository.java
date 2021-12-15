package com.kastech.blumen.repository.counselor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.counselor.Counselor;

@Repository
public interface CounselorRepository extends JpaRepository<Counselor, Long> {
}
