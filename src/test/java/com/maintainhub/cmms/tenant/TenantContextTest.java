package com.maintainhub.cmms.tenant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TenantContextTest {

    @Test
    void testTenantContextCreation() {
        TenantContext context = TenantContext.builder()
                .tenantId("test-tenant")
                .tenantName("Test Tenant")
                .schemaName("test_schema")
                .active(true)
                .build();

        assertEquals("test-tenant", context.getTenantId());
        assertEquals("Test Tenant", context.getTenantName());
        assertEquals("test_schema", context.getSchemaName());
        assertTrue(context.isActive());
    }

    @Test
    void testTenantContextEquality() {
        TenantContext context1 = TenantContext.builder()
                .tenantId("test-tenant")
                .tenantName("Test Tenant")
                .schemaName("test_schema")
                .active(true)
                .build();

        TenantContext context2 = TenantContext.builder()
                .tenantId("test-tenant")
                .tenantName("Test Tenant")
                .schemaName("test_schema")
                .active(true)
                .build();

        assertEquals(context1, context2);
        assertEquals(context1.hashCode(), context2.hashCode());
    }
} 