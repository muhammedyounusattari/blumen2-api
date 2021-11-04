package com.kastech.blumen.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceLayerException extends RuntimeException{

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLayerException.class);

    public ServiceLayerException(String errorDesc) {
        super(errorDesc);
    }
}
