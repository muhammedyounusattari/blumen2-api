package com.kastech.blumen.repository.admin.systemtools;

import com.kastech.blumen.controller.admin.systemtools.QueryOperator;

public class SearchCriteria {

    private String key;
    private Object value;
    private QueryOperator operation;

    public SearchCriteria() {
    }

    public SearchCriteria(String key, Object value, QueryOperator operation) {
        this.key = key;
        this.value = value;
        this.operation = operation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public QueryOperator getOperation() {
        return operation;
    }

    public void setOperation(QueryOperator operation) {
        this.operation = operation;
    }
}
