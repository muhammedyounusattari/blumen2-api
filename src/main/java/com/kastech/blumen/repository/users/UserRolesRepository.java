package com.kastech.blumen.repository.users;

import com.kastech.blumen.model.keycloak.Roles;
//import com.kastech.blumen.model.users.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<Roles, Long> {

}
