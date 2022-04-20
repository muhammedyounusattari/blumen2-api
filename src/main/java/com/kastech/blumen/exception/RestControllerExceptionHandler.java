package com.kastech.blumen.exception;


import com.kastech.blumen.error.ErrorVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice

public class RestControllerExceptionHandler {

    @ExceptionHandler(value = {ServiceLayerException.class})
    public ResponseEntity<ErrorVO> handleServiceLayerException(
            HttpServletRequest request, ServiceLayerException ex) {
        ErrorVO errorVO =new ErrorVO(HttpStatus.BAD_REQUEST,ex.getMessage());
        return new ResponseEntity<>(errorVO,HttpStatus.BAD_REQUEST);
    }
}
