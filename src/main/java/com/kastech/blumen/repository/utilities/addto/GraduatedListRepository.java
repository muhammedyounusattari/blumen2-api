package com.kastech.blumen.repository.utilities.addto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.student.dataentry.GraduatedInformation;

@Repository
public interface GraduatedListRepository extends JpaRepository<GraduatedInformation, Long> {
}
