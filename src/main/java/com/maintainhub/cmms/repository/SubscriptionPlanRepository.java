package com.maintainhub.cmms.repository;

import com.maintainhub.cmms.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for SubscriptionPlan entity operations.
 * 
 * <p>This repository provides methods for accessing and managing subscription plan data
 * in the database. It extends JpaRepository to provide basic CRUD operations
 * and adds custom methods for plan-specific queries.</p>
 *
 * <p>Key features include:</p>
 * <ul>
 *   <li>Basic CRUD operations inherited from JpaRepository</li>
 *   <li>Custom queries for finding plans by name</li>
 *   <li>Existence checks for plan names</li>
 * </ul>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see SubscriptionPlan
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long> {
    
    /**
     * Find a subscription plan by its name.
     *
     * <p>This method is used to locate a subscription plan based on its unique name.
     * The name is used to identify different subscription tiers (e.g., "Basic", "Professional", "Enterprise").</p>
     *
     * @param name The name to search for
     * @return Optional containing the subscription plan if found, empty Optional otherwise
     */
    Optional<SubscriptionPlan> findByName(String name);

    /**
     * Check if a subscription plan exists with the given name.
     *
     * <p>This method is used during plan creation to ensure name uniqueness
     * and during plan lookup to verify existence.</p>
     *
     * @param name The name to check
     * @return true if a subscription plan exists with the given name, false otherwise
     */
    boolean existsByName(String name);
} 