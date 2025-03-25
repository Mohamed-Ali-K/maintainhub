package com.maintainhub.cmms.entity;

/**
 * Represents the possible states of a tenant in the system.
 * 
 * <p>This enum defines the various states a tenant can be in, which affects
 * their access to the system and available functionality:</p>
 * 
 * <ul>
 *   <li><strong>ACTIVE</strong> - Tenant is fully operational with all features available</li>
 *   <li><strong>INACTIVE</strong> - Tenant is temporarily disabled but data is preserved</li>
 *   <li><strong>SUSPENDED</strong> - Tenant is suspended due to billing or compliance issues</li>
 *   <li><strong>DELETED</strong> - Tenant is marked for deletion (soft delete)</li>
 * </ul>
 *
 * <p>The status is used throughout the system to control access and functionality
 * available to tenants and their users.</p>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see Tenant
 */
public enum TenantStatus {
    /**
     * Tenant is active and can use all features of the system.
     * This is the normal operational state.
     */
    ACTIVE,

    /**
     * Tenant is inactive but their data is preserved.
     * Used for temporary suspension of service.
     */
    INACTIVE,

    /**
     * Tenant is suspended due to billing or compliance issues.
     * Access is restricted until issues are resolved.
     */
    SUSPENDED,

    /**
     * Tenant is marked for deletion.
     * Implements soft delete pattern.
     */
    DELETED
} 