package com.kastech.blumen.repository.customize;


import com.kastech.blumen.model.customize.PullDownMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PullDownMasterRepository extends JpaRepository<PullDownMaster,Long> {
    List<PullDownMaster> findByOrganizationidAndPulltypeAndPullId(Long organizationid,String pulltype,Long pullId );

    List<PullDownMaster> findByOrganizationidAndPulltypeAndDeletedAndProjtypeOrderByIdAsc(Long organizationid,String pulltype,Boolean isDeleted,Long projType );
}
