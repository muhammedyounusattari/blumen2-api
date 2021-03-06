package com.kastech.blumen.constants;

public class SecurityConstants {

  public static final String SECRET_KEY = "blumen2";
  public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;
  public static final String TOKEN_PREFIX = "Bearer ";
  public static final String HEADER_STRING = "Authorization";
  public static final String SIGN_UP_URL = "/**/**/authenticate";
  public static final String API_URL = "/api/blumen-api/**";
  public static final String PRE_LOGIN_URL_1 = API_URL+ "/orgCount";
  public static final String PRE_LOGIN_URL_2 = API_URL+ "/ssoConfig";
  public static final String UPDATE_PASSWORD = API_URL+"/updatePassword/**";
  public static final String FORGOT_PASSWORD = API_URL+"/forgotPassword/**";

  public static final String AUTHORITIES = "roles";
}