package com.maintainhub.cmms.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link ApiResponse} class.
 * Tests the creation and behavior of API responses for both success and error cases.
 *
 * @author MaintainHub Team
 * @version 1.0
 */
class ApiResponseTest {

    /**
     * Tests the creation of a successful API response.
     * Verifies that the response is created with the correct success status and data.
     */
    @Test
    void testSuccessResponse() {
        String testData = "Test Data";
        ApiResponse<String> response = ApiResponse.success(testData);
        
        assertTrue(response.isSuccess());
        assertEquals("Success", response.getMessage());
        assertEquals("200", response.getCode());
        assertEquals(testData, response.getData());
    }

    /**
     * Tests the creation of an error API response.
     * Verifies that the response is created with the correct error status and code.
     */
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

    /**
     * Tests the creation of a successful API response using the builder pattern.
     * Verifies that the response is created with custom values using the builder.
     */
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