package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.ActivityGroupList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityGroupListRepository extends JpaRepository<ActivityGroupList,Long> {
}
