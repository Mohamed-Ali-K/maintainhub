package com.maintainhub.cmms.controller;

import com.maintainhub.cmms.entity.Tenant;
import com.maintainhub.cmms.service.TenantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for tenant management operations.
 * 
 * <p>This controller provides HTTP endpoints for managing tenants in the system.
 * It handles all tenant-related operations including:</p>
 *
 * <ul>
 *   <li>Tenant creation and configuration</li>
 *   <li>Tenant status management</li>
 *   <li>Tenant data retrieval</li>
 *   <li>Tenant updates and deletion</li>
 * </ul>
 *
 * <p>All endpoints are documented using OpenAPI (Swagger) annotations for
 * automatic API documentation generation.</p>
 *
 * @author M-M-M-A-KENIS
 * @version 1.0
 * @see TenantService
 * @see Tenant
 */
@RestController
@RequestMapping("/api/v1/tenants")
@RequiredArgsConstructor
@Tag(name = "Tenant Management", description = "APIs for managing tenants")
public class TenantController {

    private final TenantService tenantService;

    /**
     * Create a new tenant.
     *
     * @param tenant The tenant data to create
     * @return The created tenant with HTTP 201 status
     */
    @PostMapping
    @Operation(summary = "Create a new tenant")
    public ResponseEntity<Tenant> createTenant(@Valid @RequestBody Tenant tenant) {
        return new ResponseEntity<>(tenantService.createTenant(tenant), HttpStatus.CREATED);
    }

    /**
     * Get a tenant by ID.
     *
     * @param id The tenant ID
     * @return The tenant if found, HTTP 404 otherwise
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get a tenant by ID")
    public ResponseEntity<Tenant> getTenant(@PathVariable Long id) {
        return tenantService.getTenantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get all tenants with pagination.
     *
     * @param pageable The pagination information
     * @return Page of tenants
     */
    @GetMapping
    @Operation(summary = "Get all tenants")
    public ResponseEntity<Page<Tenant>> getAllTenants(Pageable pageable) {
        return ResponseEntity.ok(tenantService.getAllTenants(pageable));
    }

    /**
     * Update a tenant.
     *
     * @param id The tenant ID
     * @param tenant The updated tenant data
     * @return The updated tenant
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a tenant")
    public ResponseEntity<Tenant> updateTenant(@PathVariable Long id, @Valid @RequestBody Tenant tenant) {
        return ResponseEntity.ok(tenantService.updateTenant(id, tenant));
    }

    /**
     * Delete a tenant.
     *
     * @param id The tenant ID
     * @return HTTP 204 No Content on success
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a tenant")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long id) {
        tenantService.deleteTenant(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Activate a tenant.
     *
     * @param id The tenant ID
     * @return The activated tenant
     */
    @PostMapping("/{id}/activate")
    @Operation(summary = "Activate a tenant")
    public ResponseEntity<Tenant> activateTenant(@PathVariable Long id) {
        return ResponseEntity.ok(tenantService.activateTenant(id));
    }

    /**
     * Deactivate a tenant.
     *
     * @param id The tenant ID
     * @return The deactivated tenant
     */
    @PostMapping("/{id}/deactivate")
    @Operation(summary = "Deactivate a tenant")
    public ResponseEntity<Tenant> deactivateTenant(@PathVariable Long id) {
        return ResponseEntity.ok(tenantService.deactivateTenant(id));
    }

    /**
     * Suspend a tenant.
     *
     * @param id The tenant ID
     * @return The suspended tenant
     */
    @PostMapping("/{id}/suspend")
    @Operation(summary = "Suspend a tenant")
    public ResponseEntity<Tenant> suspendTenant(@PathVariable Long id) {
        return ResponseEntity.ok(tenantService.suspendTenant(id));
    }
} 