package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.GradingGroupList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradingGroupListRepository extends JpaRepository<GradingGroupList,Long> {
}
