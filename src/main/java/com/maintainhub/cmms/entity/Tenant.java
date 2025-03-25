package com.maintainhub.cmms.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Represents a tenant in the multi-tenant CMMS system.
 * Each tenant represents a separate organization using the system.
 * 
 * <p>This entity is central to the multi-tenant architecture, providing isolation
 * between different organizations using the system. Each tenant has its own:
 * <ul>
 *   <li>Unique subdomain for accessing the system</li>
 *   <li>Subscription plan defining available features</li>
 *   <li>Status indicating current state (active, inactive, suspended, deleted)</li>
 *   <li>Primary domain for custom domain support</li>
 * </ul>
 * </p>
 *
 * <p>The tenant entity is used throughout the system to ensure data isolation
 * and proper access control between different organizations.</p>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see TenantStatus
 * @see SubscriptionPlan
 */
@Entity
@Table(name = "tenants")
@Data
public class Tenant {
    
    /**
     * Unique identifier for the tenant.
     * Auto-generated using identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Display name of the tenant organization.
     * Must be unique across all tenants.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Unique subdomain for accessing the tenant's instance.
     * Used in URL formation (e.g., tenant1.maintainhub.com).
     */
    @Column(nullable = false, unique = true)
    private String subdomain;

    /**
     * Primary domain for the tenant's custom domain setup.
     * Optional, allows tenants to use their own domain.
     */
    @Column(name = "primary_domain")
    private String primaryDomain;

    /**
     * Current status of the tenant.
     * Controls access and functionality available to the tenant.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TenantStatus status;

    /**
     * Subscription plan associated with the tenant.
     * Defines features and limits available to the tenant.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    /**
     * Timestamp when the tenant was created.
     * Automatically set by Hibernate.
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Timestamp when the tenant was last updated.
     * Automatically updated by Hibernate.
     */
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
} 