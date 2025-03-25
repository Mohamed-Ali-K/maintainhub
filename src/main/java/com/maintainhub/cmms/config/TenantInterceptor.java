package com.maintainhub.cmms.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Interceptor for handling tenant-specific requests.
 * This interceptor extracts the tenant ID from the request header
 * and sets it in the TenantContext for the current request.
 */
@Component
@RequiredArgsConstructor
public class TenantInterceptor implements HandlerInterceptor {
    private final TenantConfig tenantConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tenantId = request.getHeader(tenantConfig.getHeaderName());
        if (tenantId != null && !tenantId.isEmpty()) {
            TenantContext.setCurrentTenant(tenantId);
            return true;
        }
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return false;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TenantContext.clear();
    }
} 