package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.CollegeSchool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeSchoolRepository extends JpaRepository<CollegeSchool,String> {
}
