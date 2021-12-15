package com.kastech.blumen.repository.admin;

import com.kastech.blumen.model.admin.StaffClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffClassRepository extends JpaRepository<StaffClasses, Long> {
}
