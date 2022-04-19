package com.kastech.blumen.exception;


import com.kastech.blumen.error.ErrorVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = ServiceLayerException.class)
    protected ResponseEntity<ErrorVO> handleServiceLayerException(
            ServiceLayerException ex) {
        ErrorVO errorVO =new ErrorVO(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        return new ResponseEntity<>(errorVO,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
