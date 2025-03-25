package com.maintainhub.cmms.tenant;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenantContext {
    private String tenantId;
    private String tenantName;
    private String schemaName;
    private boolean active;
} 