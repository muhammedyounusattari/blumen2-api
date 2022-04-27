package com.kastech.blumen.model;

public class ErrorResponse {

    int status;
    String message;


    public ErrorResponse() {
    }

    public ErrorResponse(int code, String msg) {
        this.status = code;
        this.message = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int code) {
        this.status = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + status +
                ", msg='" + message + '\'' +
                '}';
    }
}
