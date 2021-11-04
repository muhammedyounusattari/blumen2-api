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

public enum ErrorStatusCode {

    BLUEMEN_BAD_REQUEST(400, "BLUEMEN-BAD-REQUEST", HttpStatus.BAD_REQUEST),
    BLUEMEN_BAD_PARAMETER(400, "BLUEMEN-BAD-PARAMETER", HttpStatus.BAD_REQUEST),
    BLUEMEN_INTERNAL_SERVER_ERROR(500, "BLUEMEN-INTERNAL-SERVER-ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
    BLUEMEN_SERVICE_UNAVAILABLE_ERROR(503, "BLUEMEN-SERVICE-UNAVAILABLE", HttpStatus.SERVICE_UNAVAILABLE);


    private int statusCode;
    private String errorMsgCode;
    private HttpStatus httpStatus;

    public int statusCode() {
        return statusCode;
    }

    public String errorMsgCode() {
        return errorMsgCode;
    }

    public HttpStatus httpStatus() {
        return httpStatus;
    }

    ErrorStatusCode(int statusCode, String errorMsgCode, HttpStatus httpStatus) {
        this.statusCode = statusCode;
        this.errorMsgCode = errorMsgCode;
        this.httpStatus = httpStatus;
    }

    public String buildErrorMessage(String msgDetail) {
        return "(" + this.errorMsgCode() + "): " + msgDetail;
    }
    }
