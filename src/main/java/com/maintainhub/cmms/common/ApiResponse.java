package com.maintainhub.cmms.common;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Standard API response wrapper for all REST endpoints.
 * Provides consistent response structure across the application.
 *
 * @param <T> The type of data being returned in the response
 * @author MaintainHub Team
 * @version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    /**
     * Indicates whether the request was successful.
     */
    private boolean success;

    /**
     * Response message describing the result or error.
     */
    private String message;

    /**
     * Response code indicating the status or error type.
     */
    private String code;

    /**
     * The actual data payload of the response.
     */
    private T data;

    /**
     * Creates a successful response with the given data.
     *
     * @param data The data to be returned in the response
     * @param <T>  The type of the data
     * @return A new ApiResponse instance with success status
     */
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .message("Success")
                .code("200")
                .data(data)
                .build();
    }

    /**
     * Creates an error response with the given code and message.
     *
     * @param code    The error code
     * @param message The error message
     * @param <T>     The type parameter (unused in error responses)
     * @return A new ApiResponse instance with error status
     */
    public static <T> ApiResponse<T> error(String code, String message) {
        return ApiResponse.<T>builder()
                .success(false)
                .message(message)
                .code(code)
                .build();
    }
} 