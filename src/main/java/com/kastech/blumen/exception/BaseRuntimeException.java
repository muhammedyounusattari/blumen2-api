package com.kastech.blumen.exception;

import com.kastech.blumen.error.ErrorVO;

public class BaseRuntimeException extends RuntimeException {
    private final ErrorVO errorVO;

    public BaseRuntimeException(ErrorVO errorVO) {
        super(errorVO.getErrorDescription());
        this.errorVO = errorVO;
    }

    public BaseRuntimeException(ErrorVO errorVO, Throwable cause) {
        super(errorVO.getErrorDescription(), cause);
        this.errorVO = errorVO;
    }

    public ErrorVO getErrorVO() {
        return this.errorVO;
    }

    public int getStatusCode() {
        return this.getErrorVO().getErrorStatusCode().statusCode();
    }

    public String getErrorMessage() {
        return this.getErrorVO().getErrorStatusCode().buildErrorMessage(this.getErrorVO().getErrorDescription());
    }
}
