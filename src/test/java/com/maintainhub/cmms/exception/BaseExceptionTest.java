package com.maintainhub.cmms.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BaseExceptionTest {

    @Test
    void testBaseExceptionCreation() {
        String code = "TEST_ERROR";
        String message = "Test error message";
        
        BaseException exception = new BaseException(code, message);
        
        assertEquals(code, exception.getCode());
        assertEquals(message, exception.getMessage());
        assertNull(exception.getCause());
    }

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

    @Test
    void testBaseExceptionStackTrace() {
        BaseException exception = new BaseException("TEST_ERROR", "Test error message");
        
        assertNotNull(exception.getStackTrace());
        assertTrue(exception.getStackTrace().length > 0);
    }
} 