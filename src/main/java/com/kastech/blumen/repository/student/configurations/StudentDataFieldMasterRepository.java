package com.kastech.blumen.repository.student.configurations;

import com.kastech.blumen.model.Configurations.StudentDataFieldMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataFieldMasterRepository extends JpaRepository<StudentDataFieldMaster,Long>{
}
