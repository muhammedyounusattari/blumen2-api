package com.kastech.blumen.repository.student.configurations;

import com.kastech.blumen.model.Configurations.StudentDataTabs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDataTabsRepository extends JpaRepository<StudentDataTabs,Long>{
}
