package com.kastech.blumen.repository.student.dataentry;

import com.kastech.blumen.model.student.dataentry.GraduatedInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiscalYearFinancialAidRepository extends JpaRepository<GraduatedInformation,Long> {
}
