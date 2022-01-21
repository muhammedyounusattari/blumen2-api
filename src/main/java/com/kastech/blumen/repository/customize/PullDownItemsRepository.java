package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.PullDownItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PullDownItemsRepository extends JpaRepository<PullDownItem,Long> {

	@Query("SELECT pdi from PullDownItem pdi where pdi.pulldownId = ?1")
	public List<PullDownItem> findByPulldownId(Long pulldown_id);
	

}
