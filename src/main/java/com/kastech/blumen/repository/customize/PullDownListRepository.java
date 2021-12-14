package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.PullDown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PullDownListRepository extends JpaRepository<PullDown,Long> {



}
