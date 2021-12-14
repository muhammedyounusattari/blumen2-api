package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.GradingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradingListRepository extends JpaRepository<GradingList,Long> {
}
