package com.kastech.blumen.repository.admin.systemtools;

import com.kastech.blumen.model.admin.systemtools.TimeClockManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeClockManagerRepository extends JpaRepository<TimeClockManager,Long> {
}
