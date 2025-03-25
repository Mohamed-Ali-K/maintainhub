package com.maintainhub.cmms.config;

/**
 * Thread-local context holder for tenant information.
 * 
 * <p>This class provides a thread-safe way to store and access the current tenant's
 * information throughout the request lifecycle. It uses ThreadLocal to ensure
 * tenant isolation between different requests.</p>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 */
public class TenantContext {
    
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();
    
    /**
     * Set the current tenant identifier.
     *
     * @param tenantId The tenant identifier to set
     */
    public static void setCurrentTenant(String tenantId) {
        currentTenant.set(tenantId);
    }
    
    /**
     * Get the current tenant identifier.
     *
     * @return The current tenant identifier, or null if not set
     */
    public static String getCurrentTenant() {
        return currentTenant.get();
    }
    
    /**
     * Clear the current tenant identifier.
     * Should be called at the end of each request to prevent memory leaks.
     */
    public static void clear() {
        currentTenant.remove();
    }
} 