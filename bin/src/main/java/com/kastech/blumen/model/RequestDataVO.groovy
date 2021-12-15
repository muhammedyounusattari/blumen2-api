/*
 * ***************************************************************
 *  Copyright (c) Optum, Inc 2018.
 *  This software and documentation contain confidential and
 *  proprietary information owned by Optum, Inc.
 *  Unauthorized use and distribution are prohibited.
 * **************************************************************
 */
package com.kastech.blumen.model

import com.kastech.blumen.error.ErrorVO
import com.kastech.blumen.utility.RequestAPIType
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

import javax.servlet.http.HttpServletRequest


class RequestDataVO implements Serializable {


    private static final long serialVersionUID = 1
    public static final String REQUEST_BODY_ATTRIBUTE = 'reqBodyAttrib'

    String inputReqBodyString
    ErrorVO errorVO
    RequestAPIType requestAPIType;
    Map<String,String> inputPathVars;
    Object parsedJSON;

    RequestDataVO() {
    }


    RequestDataVO(RequestAPIType requestAPIType, String requestBody) {

        setLoggingAttribute(requestBody)
        this.requestAPIType = requestAPIType
        this.inputReqBodyString = requestBody
    }

    RequestDataVO(RequestAPIType requestAPIType, String requestBody, Map<String,String> pathVars){

        setLoggingAttribute(requestBody)
        this.requestAPIType = requestAPIType
        this.inputReqBodyString =requestBody
        this.inputPathVars = pathVars

    }

    RequestDataVO(RequestAPIType requestAPIType) {
        this.requestAPIType = requestAPIType

    }

    static void setLoggingAttribute(String requestBody) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes()
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest()
            if (request != null) {
                request.setAttribute(REQUEST_BODY_ATTRIBUTE, requestBody)
            }
        }
    }

    RequestAPIType getRequestAPIType() {
        return this.requestAPIType
    }


}
