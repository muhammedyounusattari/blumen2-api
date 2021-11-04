package com.kastech.blumen.utility;

import com.kastech.blumen.error.ErrorStatusCode;
import com.kastech.blumen.error.ErrorVO;
import com.kastech.blumen.exception.FailFastException;
import com.kastech.blumen.model.RequestDataVO;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ValidationUtility {


    public static void parseJSONFailFast(RequestDataVO requestDataVO) {
        try {
            JSONParser parser = new JSONParser();
            requestDataVO.setParsedJSON(parser.parse(requestDataVO.getInputReqBodyString()));
        } catch (ParseException var2) {
            failFast(ErrorStatusCode.BLUEMEN_BAD_REQUEST, "Malformed json request", requestDataVO, var2);
        }

    }

    public static void failFast(ErrorStatusCode errorStatusCode, String errorDesc, RequestDataVO requestDataVO, Exception exception) {
        throw new FailFastException(new ErrorVO(errorStatusCode, errorDesc), requestDataVO, exception);
    }
}
