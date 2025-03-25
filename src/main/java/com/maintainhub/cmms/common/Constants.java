package com.maintainhub.cmms.common;

public class Constants {
    // API Response Codes
    public static final String SUCCESS_CODE = "200";
    public static final String ERROR_CODE = "500";
    public static final String NOT_FOUND_CODE = "404";
    public static final String BAD_REQUEST_CODE = "400";
    public static final String UNAUTHORIZED_CODE = "401";
    public static final String FORBIDDEN_CODE = "403";

    // Security Constants
    public static final String JWT_SECRET = "${jwt.secret}";
    public static final long JWT_EXPIRATION = 86400000; // 24 hours

    // Database Constants
    public static final String DEFAULT_SCHEMA = "public";
    public static final String TENANT_SCHEMA_PREFIX = "tenant_";

    // File Upload Constants
    public static final long MAX_FILE_SIZE = 10485760; // 10MB
    public static final String[] ALLOWED_FILE_TYPES = {"jpg", "jpeg", "png", "pdf", "doc", "docx"};

    private Constants() {
        // Private constructor to prevent instantiation
    }
} 