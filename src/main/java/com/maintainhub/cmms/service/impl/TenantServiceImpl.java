package com.maintainhub.cmms.service.impl;

import com.maintainhub.cmms.entity.Tenant;
import com.maintainhub.cmms.entity.TenantStatus;
import com.maintainhub.cmms.repository.TenantRepository;
import com.maintainhub.cmms.service.TenantService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Implementation of the TenantService interface.
 * 
 * <p>This service implementation provides the concrete implementation of tenant
 * management operations. It handles:</p>
 *
 * <ul>
 *   <li>Tenant creation with validation</li>
 *   <li>Tenant status transitions</li>
 *   <li>Tenant data persistence</li>
 *   <li>Error handling and validation</li>
 * </ul>
 *
 * <p>The implementation uses Spring's transaction management to ensure data
 * consistency and proper isolation between operations.</p>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see TenantService
 * @see TenantRepository
 */
@Service
@RequiredArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    @Transactional
    public Tenant createTenant(Tenant tenant) {
        if (tenantRepository.existsBySubdomain(tenant.getSubdomain())) {
            throw new IllegalArgumentException("A tenant with the given subdomain already exists");
        }
        tenant.setStatus(TenantStatus.ACTIVE);
        return tenantRepository.save(tenant);
    }

    @Override
    public Optional<Tenant> getTenantById(Long id) {
        return tenantRepository.findById(id);
    }

    @Override
    public Optional<Tenant> getTenantBySubdomain(String subdomain) {
        return tenantRepository.findBySubdomain(subdomain);
    }

    @Override
    public Page<Tenant> getAllTenants(Pageable pageable) {
        return tenantRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Tenant updateTenant(Long id, Tenant tenant) {
        Tenant existingTenant = tenantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found with id: " + id));

        // Update fields while preserving some values
        existingTenant.setName(tenant.getName());
        existingTenant.setPrimaryDomain(tenant.getPrimaryDomain());
        existingTenant.setPlan(tenant.getPlan());

        return tenantRepository.save(existingTenant);
    }

    @Override
    @Transactional
    public void deleteTenant(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found with id: " + id));
        tenant.setStatus(TenantStatus.DELETED);
        tenantRepository.save(tenant);
    }

    @Override
    @Transactional
    public Tenant activateTenant(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found with id: " + id));
        tenant.setStatus(TenantStatus.ACTIVE);
        return tenantRepository.save(tenant);
    }

    @Override
    @Transactional
    public Tenant deactivateTenant(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found with id: " + id));
        tenant.setStatus(TenantStatus.INACTIVE);
        return tenantRepository.save(tenant);
    }

    @Override
    @Transactional
    public Tenant suspendTenant(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tenant not found with id: " + id));
        tenant.setStatus(TenantStatus.SUSPENDED);
        return tenantRepository.save(tenant);
    }
} 