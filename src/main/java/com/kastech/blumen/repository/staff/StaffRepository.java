package com.kastech.blumen.repository.staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kastech.blumen.model.staff.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
}
