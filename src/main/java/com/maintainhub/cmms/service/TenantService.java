package com.maintainhub.cmms.service;

import com.maintainhub.cmms.entity.Tenant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service interface for tenant management operations.
 * 
 * <p>This service provides a comprehensive set of operations for managing tenants
 * in the multi-tenant CMMS system. It handles all business logic related to tenant
 * lifecycle management, including:</p>
 *
 * <ul>
 *   <li>Tenant creation and configuration</li>
 *   <li>Tenant status management (activation, deactivation, suspension)</li>
 *   <li>Tenant data retrieval and updates</li>
 *   <li>Tenant deletion (soft delete)</li>
 * </ul>
 *
 * <p>The service ensures proper data isolation between tenants and enforces
 * business rules related to tenant management.</p>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see Tenant
 * @see com.maintainhub.cmms.service.impl.TenantServiceImpl
 */
public interface TenantService {
    
    /**
     * Create a new tenant.
     *
     * <p>This method creates a new tenant with the provided information. It performs
     * necessary validations and sets up the initial tenant configuration.</p>
     *
     * @param tenant The tenant to create
     * @return The created tenant with generated ID and timestamps
     * @throws IllegalArgumentException if a tenant with the same subdomain already exists
     */
    Tenant createTenant(Tenant tenant);

    /**
     * Get a tenant by its ID.
     *
     * @param id The tenant ID
     * @return Optional containing the tenant if found, empty Optional otherwise
     */
    Optional<Tenant> getTenantById(Long id);

    /**
     * Get a tenant by its subdomain.
     *
     * @param subdomain The tenant subdomain
     * @return Optional containing the tenant if found, empty Optional otherwise
     */
    Optional<Tenant> getTenantBySubdomain(String subdomain);

    /**
     * Get all tenants with pagination.
     *
     * @param pageable The pagination information
     * @return Page of tenants
     */
    Page<Tenant> getAllTenants(Pageable pageable);

    /**
     * Update a tenant.
     *
     * <p>This method updates an existing tenant's information while preserving
     * certain fields like creation timestamp and status.</p>
     *
     * @param id The tenant ID
     * @param tenant The updated tenant data
     * @return The updated tenant
     * @throws jakarta.persistence.EntityNotFoundException if the tenant is not found
     */
    Tenant updateTenant(Long id, Tenant tenant);

    /**
     * Delete a tenant.
     *
     * <p>This method performs a soft delete of the tenant by marking it as deleted
     * rather than removing it from the database.</p>
     *
     * @param id The tenant ID
     * @throws jakarta.persistence.EntityNotFoundException if the tenant is not found
     */
    void deleteTenant(Long id);

    /**
     * Activate a tenant.
     *
     * <p>This method changes the tenant's status to ACTIVE, allowing full access
     * to the system's features.</p>
     *
     * @param id The tenant ID
     * @return The activated tenant
     * @throws jakarta.persistence.EntityNotFoundException if the tenant is not found
     */
    Tenant activateTenant(Long id);

    /**
     * Deactivate a tenant.
     *
     * <p>This method changes the tenant's status to INACTIVE, temporarily
     * restricting access to the system.</p>
     *
     * @param id The tenant ID
     * @return The deactivated tenant
     * @throws jakarta.persistence.EntityNotFoundException if the tenant is not found
     */
    Tenant deactivateTenant(Long id);

    /**
     * Suspend a tenant.
     *
     * <p>This method changes the tenant's status to SUSPENDED, typically used
     * for billing or compliance issues.</p>
     *
     * @param id The tenant ID
     * @return The suspended tenant
     * @throws jakarta.persistence.EntityNotFoundException if the tenant is not found
     */
    Tenant suspendTenant(Long id);
} 