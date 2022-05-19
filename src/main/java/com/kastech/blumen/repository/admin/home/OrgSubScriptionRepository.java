package com.kastech.blumen.repository.admin.home;

import com.kastech.blumen.model.admin.home.OrgSubScriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgSubScriptionRepository extends JpaRepository<OrgSubScriptionType,Long> {
}
