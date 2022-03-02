package com.kastech.blumen.model.Configurations;

import com.kastech.blumen.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GenerateResponse {
    private Integer ErrorCode;
    private String Response;
    private Object ResponseModel;

    public GenerateResponse(Integer errorCode, String response, Object responseModel)
    {
        ErrorCode = errorCode;
        Response = response;
        ResponseModel = responseModel;
    }
}
