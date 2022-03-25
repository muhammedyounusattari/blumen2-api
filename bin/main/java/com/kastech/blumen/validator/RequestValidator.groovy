/*
 * ***************************************************************
 *  Copyright (c) Optum, Inc 2018.
 *  This software and documentation contain confidential and
 *  proprietary information owned by Optum, Inc.
 *  Unauthorized use and distribution are prohibited.
 * **************************************************************
 */
package com.kastech.blumen.validator

import com.kastech.blumen.error.ErrorStatusCode
import com.kastech.blumen.exception.DataInputException
import com.kastech.blumen.model.RequestDataVO
import com.kastech.blumen.utility.RequestAPIType
import groovy.json.JsonException
import groovy.transform.CompileStatic
import org.apache.commons.lang3.StringUtils

@CompileStatic
abstract class RequestValidator {


    void checkNotBlankFailFast(String fieldValue, String errDesc, RequestDataVO requestDataVO) {
        if (!StringUtils.isNotBlank(fieldValue)) {
            ValidateReqUtils.failFast(getDefaultErrorStatusCode(), errDesc, requestDataVO)
        }
    }

    void checkLengthBoundsFailFast(String fieldValue, int min, int max, String errDesc, RequestDataVO requestDataVO) {
        if (StringUtils.isNotBlank(fieldValue) && (fieldValue.length() < min || fieldValue.length() > max)) {
            ValidateReqUtils.failFast(getDefaultErrorStatusCode(), errDesc, requestDataVO)
        }
    }

    void checkIntegerRangeFastFail(int fieldValue, int min, int max, String errDesc, RequestDataVO requestDataVO) {
        if (fieldValue < min || fieldValue > max) {
            ValidateReqUtils.failFast(getDefaultErrorStatusCode(), errDesc, requestDataVO)
        }
    }

    void checkEqualToValueFailFast(String fieldValue, String compareValue, String errDesc, RequestDataVO requestDataVO) {
        if (StringUtils.isNotBlank(fieldValue) && !compareValue.equals(fieldValue)) {
            ValidateReqUtils.failFast(getDefaultErrorStatusCode(), errDesc, requestDataVO)
        }
    }


    void parseJSONFailFast(RequestDataVO requestDataVO, String errDesc) {
        try {
            requestDataVO.parsedJSON = ValidateReqUtils.parseJSON(requestDataVO.inputReqBodyString)
        } catch (IllegalArgumentException | JsonException exception) {
            ValidateReqUtils.failFast(ErrorStatusCode.BLUEMEN_BAD_REQUEST, errDesc, requestDataVO, exception)
        }
    }

    RequestDataVO validate(RequestAPIType requestAPIType, String requestBody) {
        RequestDataVO requestDataVO = new RequestDataVO(requestAPIType, requestBody)
        return validate(requestDataVO)
    }

    RequestDataVO validate(RequestAPIType requestAPIType, String requestBody,Map<String, String> pathVars) {
        RequestDataVO requestDataVO = new RequestDataVO(requestAPIType, requestBody,pathVars);
        return this.validate(requestDataVO);
    }

    RequestDataVO validate(RequestDataVO requestDataVO) throws DataInputException {


        validateJSONBasedRequest(requestDataVO);

        return requestDataVO

    }

    String composeDupParmaterMsg(String param) {
        //could be moved to message property resource as parametized message
        return 'Invalid parameter count. More than one ' + param + ' parameter is existing. Only one can exist.'
    }

    ErrorStatusCode getDefaultErrorStatusCode() {
        return ErrorStatusCode.BLUEMEN_BAD_PARAMETER
    }

    abstract void validateJSONBasedRequest(RequestDataVO requestDataVO) throws DataInputException


}
