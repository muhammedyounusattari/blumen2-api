package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.PullDown;

import java.util.List;

import com.kastech.blumen.model.customize.PullDownItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PullDownListRepository extends JpaRepository<PullDown,Long> {

	@Query("SELECT pd from PullDown pd where pd.selectionType = ?1")
	public List<PullDown> findByType(String type);
	
	@Query("SELECT pd from PullDown pd where pd.code = ?1")
	public List<PullDown> findByCode(String code);

}
