package com.kastech.blumen.repository.utilities;

import com.kastech.blumen.model.TableFieldColumns;
import com.kastech.blumen.model.TableNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TableFieldColumnsRepository extends JpaRepository<TableFieldColumns, Long> {

    List<TableFieldColumns> findByTableNames(TableNames tableNames);
}
