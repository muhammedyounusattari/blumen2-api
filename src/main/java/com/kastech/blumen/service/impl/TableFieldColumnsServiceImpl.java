package com.kastech.blumen.service.impl;

import com.kastech.blumen.model.TableFieldColumns;
import com.kastech.blumen.model.TableNames;
import com.kastech.blumen.repository.utilities.TableFieldColumnsRepository;
import com.kastech.blumen.service.TableFieldColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableFieldColumnsServiceImpl implements TableFieldColumnsService {

    @Autowired
    private TableFieldColumnsRepository repository;

    @Override
    public List<TableFieldColumns> findAllByTableNameId(long tableNameId) {
        TableNames tableNames = new TableNames();
        tableNames.setId(tableNameId);
        return repository.findByTableNames(tableNames);
    }
}
