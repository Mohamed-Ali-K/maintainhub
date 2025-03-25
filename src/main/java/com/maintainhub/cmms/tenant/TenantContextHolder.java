package com.maintainhub.cmms.tenant;

import org.springframework.stereotype.Component;

@Component
public class TenantContextHolder {
    private static final ThreadLocal<TenantContext> contextHolder = new ThreadLocal<>();

    public static void setContext(TenantContext context) {
        contextHolder.set(context);
    }

    public static TenantContext getContext() {
        return contextHolder.get();
    }

    public static void clearContext() {
        contextHolder.remove();
    }
} 