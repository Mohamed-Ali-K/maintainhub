package com.maintainhub.cmms.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Represents a subscription plan available for tenants.
 * 
 * <p>This entity defines the features and limitations available to tenants
 * based on their subscription level. Each plan includes:</p>
 * 
 * <ul>
 *   <li>Maximum number of users allowed</li>
 *   <li>Maximum number of assets that can be managed</li>
 *   <li>List of features included in the plan</li>
 *   <li>Pricing and billing cycle information</li>
 * </ul>
 *
 * <p>The subscription plan is used to control access to system features
 * and enforce usage limits for each tenant.</p>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see Tenant
 */
@Entity
@Table(name = "subscription_plans")
@Data
public class SubscriptionPlan {
    
    /**
     * Unique identifier for the subscription plan.
     * Auto-generated using identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Display name of the subscription plan.
     * Must be unique across all plans.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Detailed description of the plan's features and benefits.
     */
    private String description;

    /**
     * Maximum number of users allowed under this plan.
     * Null indicates unlimited users.
     */
    @Column(name = "max_users")
    private Integer maxUsers;

    /**
     * Maximum number of assets that can be managed under this plan.
     * Null indicates unlimited assets.
     */
    @Column(name = "max_assets")
    private Integer maxAssets;

    /**
     * JSON string containing the list of features included in this plan.
     * Stored as JSON for efficient querying and flexibility.
     */
    @Column(name = "features_included", columnDefinition = "json")
    private String featuresIncluded;

    /**
     * Monthly price of the subscription plan.
     */
    private Double price;

    /**
     * Billing cycle for the subscription (e.g., "MONTHLY", "ANNUAL").
     */
    @Column(name = "billing_cycle")
    private String billingCycle;

    /**
     * Timestamp when the subscription plan was created.
     * Automatically set by Hibernate.
     */
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Timestamp when the subscription plan was last updated.
     * Automatically updated by Hibernate.
     */
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
} 