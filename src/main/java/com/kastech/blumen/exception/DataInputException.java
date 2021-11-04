package com.kastech.blumen.exception;

import com.kastech.blumen.error.ErrorVO;
import com.kastech.blumen.model.RequestDataVO;
import com.kastech.blumen.utility.RequestAPIType;

public class DataInputException extends BaseRuntimeException {

    private final RequestAPIType requestAPIType;

    public DataInputException(ErrorVO errorVO, RequestDataVO requestDataVO) {
        this(errorVO, requestDataVO.getRequestAPIType());
    }

    public DataInputException(ErrorVO errorVO, RequestDataVO requestDataVO, Throwable cause) {
        this(errorVO, requestDataVO.getRequestAPIType(), cause);
    }

    public DataInputException(ErrorVO errorVO, RequestAPIType requestAPIType) {
        super(errorVO);
        this.requestAPIType = requestAPIType;
    }

    public DataInputException(ErrorVO errorVO, RequestAPIType requestAPIType, Throwable cause) {
        super(errorVO, cause);
        this.requestAPIType = requestAPIType;
    }

    public RequestAPIType getRequestAPIType() {
        return this.requestAPIType;
    }



}
