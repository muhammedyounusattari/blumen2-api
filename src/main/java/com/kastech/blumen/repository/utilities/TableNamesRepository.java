package com.kastech.blumen.repository.utilities;

import com.kastech.blumen.model.TableNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableNamesRepository extends JpaRepository<TableNames, Long> {

}

