package com.kastech.blumen.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputValidationException extends RuntimeException{

    private static final Logger LOGGER = LoggerFactory.getLogger(InputValidationException.class);

    public InputValidationException(String errorDesc) {
        super(errorDesc);
    }
}
