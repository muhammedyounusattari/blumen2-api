package com.kastech.blumen.repository.utilities;

import com.kastech.blumen.model.FieldTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldTypesRepository extends JpaRepository<FieldTypes, Long> {

}

