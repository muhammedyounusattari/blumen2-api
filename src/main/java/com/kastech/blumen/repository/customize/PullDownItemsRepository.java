package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.PullDownItem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PullDownItemsRepository extends JpaRepository<PullDownItem,Long> {

	@Query("SELECT pdi from PullDownItem pdi where pdi.pulldownId = ?1 order by pullId")
	public List<PullDownItem> findByPulldownId(Long pulldown_id);

	@Query("SELECT pdi from PullDownItem pdi where pdi.pulldownId in( ?1 ) order by pullId")
	public List<PullDownItem> findByPulldownIds(List<Long> pulldown_id);
	
	@Query("Select pdi from PullDownItem pdi where pdi.pullId  = ?1 AND pdi.pulldownId = ?2 ")
	public List<PullDownItem> findByIdAndPullId(Integer  pullId,Long pulldownId);

}
