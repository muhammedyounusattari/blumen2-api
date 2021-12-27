package com.kastech.blumen.repository.utilities.generatesimilar;

import com.kastech.blumen.model.utilities.generatesimilar.CustomFieldValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomFieldValueRepository extends JpaRepository<CustomFieldValue,Long> {
}
