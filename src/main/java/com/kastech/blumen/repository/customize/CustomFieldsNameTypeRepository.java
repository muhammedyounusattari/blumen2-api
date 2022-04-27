package com.kastech.blumen.repository.customize;

import com.kastech.blumen.model.customize.CustomFieldsNameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomFieldsNameTypeRepository extends JpaRepository<CustomFieldsNameType,Long> {
}
