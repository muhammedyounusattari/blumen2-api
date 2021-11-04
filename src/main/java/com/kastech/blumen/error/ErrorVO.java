/*
 * ***************************************************************
 *  Copyright (c) Optum, Inc 2018.
 *  This software and documentation contain confidential and
 *  proprietary information owned by Optum, Inc.
 *  Unauthorized use and distribution are prohibited.
 * **************************************************************
 */
package com.kastech.blumen.error;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorVO implements Serializable{


    private static final long serialVersionUID = 1;

    private HttpStatus httpStatus;
    private String errorMessage;
    private String errorDescription = "";
    private ErrorStatusCode errorStatusCode;

    public ErrorVO(HttpStatus errorCode, String errorMessage){
          this.httpStatus=errorCode;
          this.errorMessage=errorMessage;
    }

    public ErrorVO(ErrorStatusCode errorStatusCode,
                   String errorDescription ){

        this.errorDescription=errorDescription;
        this.errorStatusCode=errorStatusCode;
        this.httpStatus = HttpStatus.valueOf(errorStatusCode.statusCode());
        this.errorMessage= errorStatusCode.buildErrorMessage(errorDescription);
    }


    public HttpStatus getErrorCode() {
        return httpStatus;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.httpStatus = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getErrorName() {
        return this.errorStatusCode.errorMsgCode();
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public ErrorStatusCode getErrorStatusCode() {
        return errorStatusCode;
    }

    public void setErrorStatusCode(ErrorStatusCode errorStatusCode) {
        this.errorStatusCode = errorStatusCode;
    }

}
