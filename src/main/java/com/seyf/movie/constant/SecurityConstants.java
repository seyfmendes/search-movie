package com.seyf.movie.constant;


public class SecurityConstants {

    public static final String SECRET_KEY = "com.seyf";
    public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_TOKEN_KEY = "Authorization";

}
