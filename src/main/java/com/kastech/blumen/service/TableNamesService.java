package com.kastech.blumen.service;

import com.kastech.blumen.model.TableNames;

import java.util.List;

public interface TableNamesService {

    List<TableNames> findAll();

    TableNames findById(long id);
}
