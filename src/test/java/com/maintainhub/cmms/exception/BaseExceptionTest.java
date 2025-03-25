package com.maintainhub.cmms.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link BaseException} class.
 * Tests the creation and behavior of base exceptions with and without causes.
 *
 * @author MaintainHub Team
 * @version 1.0
 */
class BaseExceptionTest {

    /**
     * Tests the creation of a base exception with error code and message.
     * Verifies that the exception is created with the correct properties.
     */
    @Test
    void testBaseExceptionCreation() {
        String code = "TEST_ERROR";
        String message = "Test error message";
        
        BaseException exception = new BaseException(code, message);
        
        assertEquals(code, exception.getCode());
        assertEquals(message, exception.getMessage());
        assertNull(exception.getCause());
    }

    /**
     * Tests the creation of a base exception with error code, message, and cause.
     * Verifies that the exception is created with the correct properties and cause.
     */
    @Test
    void testBaseExceptionWithCause() {
        String code = "TEST_ERROR";
        String message = "Test error message";
        Throwable cause = new RuntimeException("Original error");
        
        BaseException exception = new BaseException(code, message, cause);
        
        assertEquals(code, exception.getCode());
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    /**
     * Tests that the base exception has a valid stack trace.
     * Verifies that the exception maintains proper stack trace information.
     */
    @Test
    void testBaseExceptionStackTrace() {
        BaseException exception = new BaseException("TEST_ERROR", "Test error message");
        
        assertNotNull(exception.getStackTrace());
        assertTrue(exception.getStackTrace().length > 0);
    }
} 