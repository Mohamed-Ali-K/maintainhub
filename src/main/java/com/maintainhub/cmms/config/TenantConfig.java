package com.maintainhub.cmms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

/**
 * Configuration class for tenant-specific settings.
 * This class holds configuration properties for tenant management
 * such as header names and default tenant values.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cmms.tenant")
public class TenantConfig {
    private String defaultTenant;
    private String headerName;
} 