package com.kastech.blumen.model;

public class JWTResponse {

    private String token;
    private String ita;

    public JWTResponse(String token, String ita) {
        this.token = token;
        this.ita = ita;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIta() {
        return ita;
    }

    public void setIta(String ita) {
        this.ita = ita;
    }
}
