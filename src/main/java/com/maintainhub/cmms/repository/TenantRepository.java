package com.maintainhub.cmms.repository;

import com.maintainhub.cmms.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Tenant entity operations.
 * 
 * <p>This repository provides methods for accessing and managing tenant data
 * in the database. It extends JpaRepository to provide basic CRUD operations
 * and adds custom methods for tenant-specific queries.</p>
 *
 * <p>Key features include:</p>
 * <ul>
 *   <li>Basic CRUD operations inherited from JpaRepository</li>
 *   <li>Custom queries for finding tenants by subdomain</li>
 *   <li>Existence checks for tenant subdomains</li>
 *   <li>Support for custom domain lookups</li>
 * </ul>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see Tenant
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    
    /**
     * Find a tenant by its subdomain.
     *
     * <p>This method is used to locate a tenant based on their unique subdomain.
     * The subdomain is used in the URL to identify the tenant's instance
     * (e.g., tenant1.maintainhub.com).</p>
     *
     * @param subdomain The subdomain to search for
     * @return Optional containing the tenant if found, empty Optional otherwise
     */
    Optional<Tenant> findBySubdomain(String subdomain);

    /**
     * Check if a tenant exists with the given subdomain.
     *
     * <p>This method is used during tenant creation to ensure subdomain uniqueness
     * and during tenant lookup to verify existence.</p>
     *
     * @param subdomain The subdomain to check
     * @return true if a tenant exists with the given subdomain, false otherwise
     */
    boolean existsBySubdomain(String subdomain);

    /**
     * Find a tenant by its primary domain.
     *
     * <p>This method is used to locate tenants that have configured custom domains
     * for their instance.</p>
     *
     * @param primaryDomain The primary domain to search for
     * @return Optional containing the tenant if found, empty Optional otherwise
     */
    Optional<Tenant> findByPrimaryDomain(String primaryDomain);
} 