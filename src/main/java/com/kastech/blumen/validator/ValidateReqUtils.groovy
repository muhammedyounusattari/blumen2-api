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
import com.kastech.blumen.error.ErrorVO
import com.kastech.blumen.exception.FailFastException
import com.kastech.blumen.model.RequestDataVO
import groovy.json.JsonSlurper
import org.json.JSONException
import org.json.JSONObject
import org.json.simple.parser.JSONParser
import org.json.simple.parser.ParseException

class ValidateReqUtils {


    static void failFast(ErrorStatusCode errorStatusCode, String errorDesc, RequestDataVO requestDataVO) {
        throw new FailFastException(new ErrorVO(errorStatusCode, errorDesc), requestDataVO)
    }

    static void failFast(ErrorStatusCode errorStatusCode, String errorDesc, RequestDataVO requestDataVO, Exception exception) {
        throw new FailFastException(new ErrorVO(errorStatusCode, errorDesc), requestDataVO, exception)
    }

    static JSONObject convertJSONToJSONObject(String jsonInputStr) throws JSONException, ParseException {

        JSONParser parser = new JSONParser()

        return (JSONObject) parser.parse(jsonInputStr)
    }

    static Object parseJSON(String json) {

        return new JsonSlurper().parseText(json)
    }

}
