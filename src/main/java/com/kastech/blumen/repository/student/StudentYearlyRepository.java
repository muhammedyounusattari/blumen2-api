package com.kastech.blumen.repository.student;

import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.StudentYearlyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentYearlyRepository extends JpaRepository<StudentYearlyData, Long>  {

}
