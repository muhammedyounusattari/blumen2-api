package com.kastech.blumen.constants;

public class RestURIConstant {

    public static final String ROOT = "/api/blumen-api";

    //AUTHENTICATE
    public static final String AUTHENTICATE ="/authenticate";
    public static final String LOGOUT = "/logout/v1";
    //Forgot password
    public static final String FORGOT_PASSWORD="/forgotPassword/v1";

    public static final String FILE_UPLOAD="/uploadFile/{staffId}";
    public static final String GET_FILE="/getFile/{staffId}";
    public static final String GENERATE_CODE = "/generateCode" ;
    public static final String VALIDATE_CODE = "/validateCode";
}