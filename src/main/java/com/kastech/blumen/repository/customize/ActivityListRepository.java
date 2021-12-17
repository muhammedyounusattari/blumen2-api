package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.ActivityList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityListRepository extends JpaRepository<ActivityList,Long> {
	
	@Query("SELECT max(al.activityId) FROM ActivityList al")
	Long getMaxId();
}
