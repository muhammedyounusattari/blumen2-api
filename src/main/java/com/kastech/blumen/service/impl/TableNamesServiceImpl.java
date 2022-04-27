package com.kastech.blumen.service.impl;

import com.kastech.blumen.model.TableNames;
import com.kastech.blumen.repository.utilities.TableNamesRepository;
import com.kastech.blumen.service.TableNamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableNamesServiceImpl implements TableNamesService {

    @Autowired
    private TableNamesRepository tableNamesRepository;

    @Override
    public List<TableNames> findAll() {
        return tableNamesRepository.findAll();
    }

    @Override
    public TableNames findById(long id) {
        return tableNamesRepository.findById(id).orElseThrow(() -> new RuntimeException("ID not present."));
    }
}
