package com.kastech.blumen.repository.admin;

import com.kastech.blumen.model.keycloak.UserMetaData;
import com.kastech.blumen.model.keycloak.UserMetaDataId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetaDataRepository extends JpaRepository<UserMetaData, UserMetaDataId> {

}
