package com.maintainhub.cmms.tenant;

import org.springframework.stereotype.Component;

/**
 * Thread-safe holder for the current tenant context.
 * This class manages tenant context using ThreadLocal to ensure thread safety
 * in a multi-tenant environment.
 *
 * @author MaintainHub Team
 * @version 1.0
 */
@Component
public class TenantContextHolder {
    private static final ThreadLocal<TenantContext> contextHolder = new ThreadLocal<>();

    /**
     * Sets the tenant context for the current thread.
     *
     * @param context The tenant context to set
     */
    public static void setContext(TenantContext context) {
        contextHolder.set(context);
    }

    /**
     * Gets the tenant context for the current thread.
     *
     * @return The current tenant context, or null if not set
     */
    public static TenantContext getContext() {
        return contextHolder.get();
    }

    /**
     * Clears the tenant context for the current thread.
     * This should be called when the tenant context is no longer needed
     * to prevent memory leaks.
     */
    public static void clearContext() {
        contextHolder.remove();
    }
} 