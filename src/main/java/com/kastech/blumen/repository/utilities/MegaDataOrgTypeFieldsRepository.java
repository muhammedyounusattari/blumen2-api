package com.kastech.blumen.repository.utilities;

import com.kastech.blumen.model.MegaDataOrgTypeFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MegaDataOrgTypeFieldsRepository extends JpaRepository<MegaDataOrgTypeFields, Long> {

}

