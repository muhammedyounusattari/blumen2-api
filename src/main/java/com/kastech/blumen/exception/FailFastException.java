package com.kastech.blumen.exception;

import com.kastech.blumen.error.ErrorVO;
import com.kastech.blumen.model.RequestDataVO;

public class FailFastException extends DataInputException {
    public FailFastException(ErrorVO errorVO, RequestDataVO requestDataVO) {
        super(errorVO, requestDataVO);
    }

    public FailFastException(ErrorVO errorVO, RequestDataVO requestDataVO, Throwable cause) {
        super(errorVO, requestDataVO, cause);
    }
}
