package com.kastech.blumen.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataModificationException extends RuntimeException{

    private static final Logger LOGGER = LoggerFactory.getLogger(DataModificationException.class);

    public DataModificationException(String errorDesc) {
        super(errorDesc);
    }
}
