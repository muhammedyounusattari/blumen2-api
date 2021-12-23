package com.kastech.blumen.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.AnnualPerformance;

@Repository
public interface AnnualPerformanceRepository extends JpaRepository<AnnualPerformance, Long> {

}
