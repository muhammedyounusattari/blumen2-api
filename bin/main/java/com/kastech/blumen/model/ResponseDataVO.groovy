/*
 * ***************************************************************
 *  Copyright (c) Optum, Inc 2018.
 *  This software and documentation contain confidential and
 *  proprietary information owned by Optum, Inc.
 *  Unauthorized use and distribution are prohibited.
 * **************************************************************
 */
package com.kastech.blumen.model

import com.kastech.blumen.utility.RequestAPIType
import groovy.transform.CompileStatic
import org.springframework.http.HttpStatus


@CompileStatic
class ResponseDataVO implements Serializable {


    private static final long serialVersionUID = 1

    private final String responseStr
    private final Object responseObject
    private final HttpStatus httpStatus = HttpStatus.OK   //default to Success response

    private RequestAPIType requestAPIType

    ResponseDataVO(String responseStr) {
        this.responseStr = responseStr
    }


    ResponseDataVO(String responseStr, int statusCode) {
        this.responseStr = responseStr
        this.httpStatus = HttpStatus.valueOf(statusCode)
    }


    String getResponseStr() {
        return this.responseStr
    }

    HttpStatus getHttpStatus() {
        return this.httpStatus
    }

    RequestAPIType getRequestAPIType() {
        return this.requestAPIType
    }

    void setRequestAPIType(RequestAPIType requestAPIType) {
        this.requestAPIType = requestAPIType
    }

}
