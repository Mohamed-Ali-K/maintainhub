package com.maintainhub.cmms.tenant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TenantContextHolderTest {

    @Test
    void testTenantContextHolder() {
        // Create a test tenant context
        TenantContext context = TenantContext.builder()
                .tenantId("test-tenant")
                .tenantName("Test Tenant")
                .schemaName("test_schema")
                .active(true)
                .build();

        // Test setting context
        TenantContextHolder.setContext(context);
        assertEquals(context, TenantContextHolder.getContext());

        // Test clearing context
        TenantContextHolder.clearContext();
        assertNull(TenantContextHolder.getContext());
    }

    @Test
    void testThreadLocalIsolation() throws InterruptedException {
        // Create two different contexts
        TenantContext context1 = TenantContext.builder()
                .tenantId("tenant1")
                .tenantName("Tenant 1")
                .schemaName("schema1")
                .active(true)
                .build();

        TenantContext context2 = TenantContext.builder()
                .tenantId("tenant2")
                .tenantName("Tenant 2")
                .schemaName("schema2")
                .active(true)
                .build();

        // Set context in main thread
        TenantContextHolder.setContext(context1);
        assertEquals(context1, TenantContextHolder.getContext());

        // Create and start a new thread
        Thread thread = new Thread(() -> {
            TenantContextHolder.setContext(context2);
            assertEquals(context2, TenantContextHolder.getContext());
            TenantContextHolder.clearContext();
        });
        thread.start();
        thread.join();

        // Verify main thread context is unchanged
        assertEquals(context1, TenantContextHolder.getContext());
    }
} 