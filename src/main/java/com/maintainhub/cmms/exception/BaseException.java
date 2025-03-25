package com.maintainhub.cmms.exception;

import lombok.Getter;

/**
 * Base exception class for the application.
 * All custom exceptions should extend this class to maintain consistent error handling.
 *
 * @author MaintainHub Team
 * @version 1.0
 */
@Getter
public class BaseException extends RuntimeException {
    private final String code;
    private final String message;

    /**
     * Constructs a new base exception with the specified error code and message.
     *
     * @param code    The error code identifying the type of error
     * @param message The detailed error message
     */
    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * Constructs a new base exception with the specified error code, message, and cause.
     *
     * @param code    The error code identifying the type of error
     * @param message The detailed error message
     * @param cause   The cause of the exception
     */
    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }
} 