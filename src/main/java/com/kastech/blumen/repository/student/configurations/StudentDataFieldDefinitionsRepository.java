package com.kastech.blumen.repository.student.configurations;

import com.kastech.blumen.model.Configurations.StudentDataFieldDefinitions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataFieldDefinitionsRepository extends JpaRepository<StudentDataFieldDefinitions,Long> {
}
