package com.kastech.blumen.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataNotFoundException extends RuntimeException{

    private static final Logger LOGGER = LoggerFactory.getLogger(DataNotFoundException.class);

    public DataNotFoundException(String errorDesc) {
        super(errorDesc);
    }
}
