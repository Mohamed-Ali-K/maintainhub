package com.maintainhub.cmms.tenant;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link TenantContext} class.
 * Tests the creation, equality, and data integrity of tenant context objects.
 *
 * @author MaintainHub Team
 * @version 1.0
 */
class TenantContextTest {

    /**
     * Tests the creation of a TenantContext object with all fields.
     * Verifies that all fields are correctly set and accessible.
     */
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

    /**
     * Tests the equality and hashCode methods of TenantContext.
     * Verifies that two TenantContext objects with the same data are considered equal
     * and have the same hashCode.
     */
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