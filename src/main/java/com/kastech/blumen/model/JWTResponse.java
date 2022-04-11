package com.kastech.blumen.model;

public class JWTResponse {

    private String access_token;
    private String ita;
    private String exp;
    private Integer status;


    public JWTResponse(String access_token, String ita, String exp, Integer status) {
        this.access_token = access_token;
        this.ita = ita;
        this.exp = exp;
        this.status = status;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getIta() {
        return ita;
    }

    public void setIta(String ita) {
        this.ita = ita;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
