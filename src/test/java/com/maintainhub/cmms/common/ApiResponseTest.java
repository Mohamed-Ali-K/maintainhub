package com.maintainhub.cmms.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void testSuccessResponse() {
        String testData = "Test Data";
        ApiResponse<String> response = ApiResponse.success(testData);

        assertTrue(response.isSuccess());
        assertEquals("Success", response.getMessage());
        assertEquals("200", response.getCode());
        assertEquals(testData, response.getData());
    }

    @Test
    void testErrorResponse() {
        String errorCode = "400";
        String errorMessage = "Bad Request";
        ApiResponse<String> response = ApiResponse.error(errorCode, errorMessage);

        assertFalse(response.isSuccess());
        assertEquals(errorMessage, response.getMessage());
        assertEquals(errorCode, response.getCode());
        assertNull(response.getData());
    }

    @Test
    void testBuilder() {
        String testData = "Test Data";
        ApiResponse<String> response = ApiResponse.<String>builder()
                .success(true)
                .message("Custom Success")
                .code("201")
                .data(testData)
                .build();

        assertTrue(response.isSuccess());
        assertEquals("Custom Success", response.getMessage());
        assertEquals("201", response.getCode());
        assertEquals(testData, response.getData());
    }
} 