package com.kastech.blumen.repository.admin;

import com.kastech.blumen.model.keycloak.UserMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMetaDataRepository extends JpaRepository<UserMetaData, String> {

}
