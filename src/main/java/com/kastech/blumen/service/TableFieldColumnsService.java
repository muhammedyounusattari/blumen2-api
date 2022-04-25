package com.kastech.blumen.service;

import com.kastech.blumen.model.TableFieldColumns;

import java.util.List;

public interface TableFieldColumnsService {

    List<TableFieldColumns> findAllByTableNameId(long tableNameId);
}
