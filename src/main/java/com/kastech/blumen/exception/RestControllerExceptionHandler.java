package com.kastech.blumen.exception;


import com.kastech.blumen.error.ErrorVO;
import com.kastech.blumen.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice

public class RestControllerExceptionHandler {

    @ExceptionHandler(value = {ServiceLayerException.class})
    public ResponseEntity<ErrorVO> handleServiceLayerException(
            HttpServletRequest request, ServiceLayerException ex) {
        ErrorVO errorVO =new ErrorVO(HttpStatus.BAD_REQUEST,ex.getMessage());
        return new ResponseEntity<>(errorVO,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<Object> handleDataNotFoundException(
            HttpServletRequest request, DataNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(404, ex.getMessage()),new HttpHeaders(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {DataModificationException.class})
    public ResponseEntity<Object> handleDataModificationException(
            HttpServletRequest request, DataModificationException ex) {
        return new ResponseEntity<>(new ErrorResponse(500, ex.getMessage()),new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {InputValidationException.class})
    public ResponseEntity<Object> handleInputValidationException(
            HttpServletRequest request, InputValidationException ex) {
        return new ResponseEntity<>(new ErrorResponse(400, ex.getMessage()),new HttpHeaders(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access Denied", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
