# CMMS API Endpoints

## Implementation Checklist
- [✓] Tenant Management API
  - [✓] Multi-tenant Architecture
    - [✓] Tenant context management
    - [✓] Tenant-aware request handling
    - [✓] Tenant isolation mechanisms
  - [ ] Tenant Configuration API
    - [ ] Tenant settings management
    - [ ] Tenant customization options
    - [ ] Tenant-specific configurations
  - [ ] Tenant Data Management API
    - [ ] Tenant data partitioning
    - [ ] Tenant data migration
    - [ ] Tenant backup/restore
- [✓] Authentication and User Management API
- [✓] Organization Structure API
- [✓] Custom Fields API
- [✓] Asset Management API
- [✓] Work Order Management API
- [✓] Preventive Maintenance API
- [✓] Inventory Management API
- [✓] Integration Management API
- [✓] Compliance Management API

## Tenant Management API

### 1. Tenant Administration
- [✓] POST /api/v1/tenants
  - [✓] Create new tenant
  - [✓] Validate tenant data
  - [✓] Initialize tenant resources
  - [✓] Return tenant details

- [✓] GET /api/v1/tenants
  - [✓] List all tenants
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/tenants/{id}
  - [✓] Get tenant details
  - [✓] Include configuration
  - [✓] Include subscription info
  - [✓] Include usage stats

- [✓] PUT /api/v1/tenants/{id}
  - [✓] Update tenant details
  - [✓] Validate updates
  - [✓] Update configuration
  - [✓] Return updated tenant

- [✓] DELETE /api/v1/tenants/{id}
  - [✓] Delete tenant
  - [✓] Archive tenant data
  - [✓] Cleanup resources
  - [✓] Return success status

### 2. Tenant Configuration
- [✓] GET /api/v1/tenants/{id}/configurations
  - [✓] List tenant configurations
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] POST /api/v1/tenants/{id}/configurations
  - [✓] Create configuration
  - [✓] Validate configuration
  - [✓] Store configuration
  - [✓] Return configuration

- [✓] PUT /api/v1/tenants/{id}/configurations/{key}
  - [✓] Update configuration
  - [✓] Validate update
  - [✓] Store update
  - [✓] Return updated config

- [✓] DELETE /api/v1/tenants/{id}/configurations/{key}
  - [✓] Delete configuration
  - [✓] Validate deletion
  - [✓] Remove configuration
  - [✓] Return success status

## Authentication and User Management API

### 1. Authentication
- [✓] POST /api/v1/auth/login
  - [✓] Authenticate user
  - [✓] Generate JWT token
  - [✓] Set refresh token
  - [✓] Return user info

- [✓] POST /api/v1/auth/refresh
  - [✓] Refresh JWT token
  - [✓] Validate refresh token
  - [✓] Generate new token
  - [✓] Return new token

- [✓] POST /api/v1/auth/logout
  - [✓] Invalidate token
  - [✓] Clear refresh token
  - [✓] Log logout event
  - [✓] Return success status

### 2. User Management
- [✓] POST /api/v1/users
  - [✓] Create new user
  - [✓] Validate user data
  - [✓] Hash password
  - [✓] Return user details

- [✓] GET /api/v1/users
  - [✓] List all users
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/users/{id}
  - [✓] Get user details
  - [✓] Include roles
  - [✓] Include permissions
  - [✓] Return user info

- [✓] PUT /api/v1/users/{id}
  - [✓] Update user details
  - [✓] Validate updates
  - [✓] Update password if needed
  - [✓] Return updated user

- [✓] DELETE /api/v1/users/{id}
  - [✓] Delete user
  - [✓] Archive user data
  - [✓] Remove permissions
  - [✓] Return success status

## Organization Structure API

### 1. Department Management
- [✓] POST /api/v1/departments
  - [✓] Create department
  - [✓] Validate department data
  - [✓] Set hierarchy
  - [✓] Return department details

- [✓] GET /api/v1/departments
  - [✓] List departments
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/departments/{id}
  - [✓] Get department details
  - [✓] Include hierarchy
  - [✓] Include manager
  - [✓] Return department info

- [✓] PUT /api/v1/departments/{id}
  - [✓] Update department
  - [✓] Validate updates
  - [✓] Update hierarchy
  - [✓] Return updated department

- [✓] DELETE /api/v1/departments/{id}
  - [✓] Delete department
  - [✓] Handle reassignment
  - [✓] Update hierarchy
  - [✓] Return success status

### 2. Location Management
- [✓] POST /api/v1/locations
  - [✓] Create location
  - [✓] Validate location data
  - [✓] Set hierarchy
  - [✓] Return location details

- [✓] GET /api/v1/locations
  - [✓] List locations
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/locations/{id}
  - [✓] Get location details
  - [✓] Include hierarchy
  - [✓] Include assets
  - [✓] Return location info

- [✓] PUT /api/v1/locations/{id}
  - [✓] Update location
  - [✓] Validate updates
  - [✓] Update hierarchy
  - [✓] Return updated location

- [✓] DELETE /api/v1/locations/{id}
  - [✓] Delete location
  - [✓] Handle reassignment
  - [✓] Update hierarchy
  - [✓] Return success status

## Custom Fields API

### 1. Field Definition
- [✓] POST /api/v1/custom-fields
  - [✓] Create custom field
  - [✓] Validate field data
  - [✓] Set field type
  - [✓] Return field details

- [✓] GET /api/v1/custom-fields
  - [✓] List custom fields
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/custom-fields/{id}
  - [✓] Get field details
  - [✓] Include validation rules
  - [✓] Include dependencies
  - [✓] Return field info

- [✓] PUT /api/v1/custom-fields/{id}
  - [✓] Update field
  - [✓] Validate updates
  - [✓] Update validation rules
  - [✓] Return updated field

- [✓] DELETE /api/v1/custom-fields/{id}
  - [✓] Delete field
  - [✓] Handle dependencies
  - [✓] Clean up values
  - [✓] Return success status

### 2. Field Values
- [✓] POST /api/v1/custom-fields/{id}/values
  - [✓] Create field value
  - [✓] Validate value
  - [✓] Store value
  - [✓] Return value details

- [✓] GET /api/v1/custom-fields/{id}/values
  - [✓] List field values
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] PUT /api/v1/custom-fields/{id}/values/{entityId}
  - [✓] Update field value
  - [✓] Validate update
  - [✓] Store update
  - [✓] Return updated value

- [✓] DELETE /api/v1/custom-fields/{id}/values/{entityId}
  - [✓] Delete field value
  - [✓] Validate deletion
  - [✓] Remove value
  - [✓] Return success status

## Asset Management API

### 1. Asset Operations
- [✓] POST /api/v1/assets
  - [✓] Create asset
  - [✓] Validate asset data
  - [✓] Set relationships
  - [✓] Return asset details

- [✓] GET /api/v1/assets
  - [✓] List assets
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/assets/{id}
  - [✓] Get asset details
  - [✓] Include relationships
  - [✓] Include history
  - [✓] Return asset info

- [✓] PUT /api/v1/assets/{id}
  - [✓] Update asset
  - [✓] Validate updates
  - [✓] Update relationships
  - [✓] Return updated asset

- [✓] DELETE /api/v1/assets/{id}
  - [✓] Delete asset
  - [✓] Handle relationships
  - [✓] Archive history
  - [✓] Return success status

### 2. Asset Types and Categories
- [✓] POST /api/v1/asset-types
  - [✓] Create asset type
  - [✓] Validate type data
  - [✓] Set attributes
  - [✓] Return type details

- [✓] GET /api/v1/asset-types
  - [✓] List asset types
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/asset-types/{id}
  - [✓] Get type details
  - [✓] Include attributes
  - [✓] Include validation rules
  - [✓] Return type info

- [✓] PUT /api/v1/asset-types/{id}
  - [✓] Update type
  - [✓] Validate updates
  - [✓] Update attributes
  - [✓] Return updated type

- [✓] DELETE /api/v1/asset-types/{id}
  - [✓] Delete type
  - [✓] Handle dependencies
  - [✓] Clean up attributes
  - [✓] Return success status

## Work Order Management API

### 1. Work Order Operations
- [✓] POST /api/v1/work-orders
  - [✓] Create work order
  - [✓] Validate order data
  - [✓] Set relationships
  - [✓] Return order details

- [✓] GET /api/v1/work-orders
  - [✓] List work orders
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/work-orders/{id}
  - [✓] Get order details
  - [✓] Include relationships
  - [✓] Include history
  - [✓] Return order info

- [✓] PUT /api/v1/work-orders/{id}
  - [✓] Update work order
  - [✓] Validate updates
  - [✓] Update status
  - [✓] Return updated order

- [✓] DELETE /api/v1/work-orders/{id}
  - [✓] Delete work order
  - [✓] Handle relationships
  - [✓] Archive history
  - [✓] Return success status

### 2. Work Order Tasks
- [✓] POST /api/v1/work-orders/{id}/tasks
  - [✓] Create task
  - [✓] Validate task data
  - [✓] Set assignments
  - [✓] Return task details

- [✓] GET /api/v1/work-orders/{id}/tasks
  - [✓] List tasks
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] PUT /api/v1/work-orders/{id}/tasks/{taskId}
  - [✓] Update task
  - [✓] Validate updates
  - [✓] Update status
  - [✓] Return updated task

- [✓] DELETE /api/v1/work-orders/{id}/tasks/{taskId}
  - [✓] Delete task
  - [✓] Handle dependencies
  - [✓] Update order status
  - [✓] Return success status

## Preventive Maintenance API

### 1. Maintenance Plans
- [✓] POST /api/v1/maintenance-plans
  - [✓] Create maintenance plan
  - [✓] Validate plan data
  - [✓] Set procedures
  - [✓] Return plan details

- [✓] GET /api/v1/maintenance-plans
  - [✓] List maintenance plans
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/maintenance-plans/{id}
  - [✓] Get plan details
  - [✓] Include procedures
  - [✓] Include schedule
  - [✓] Return plan info

- [✓] PUT /api/v1/maintenance-plans/{id}
  - [✓] Update plan
  - [✓] Validate updates
  - [✓] Update procedures
  - [✓] Return updated plan

- [✓] DELETE /api/v1/maintenance-plans/{id}
  - [✓] Delete plan
  - [✓] Handle dependencies
  - [✓] Clean up schedule
  - [✓] Return success status

### 2. Maintenance Schedule
- [✓] POST /api/v1/maintenance-schedules
  - [✓] Create schedule
  - [✓] Validate schedule data
  - [✓] Set next due date
  - [✓] Return schedule details

- [✓] GET /api/v1/maintenance-schedules
  - [✓] List schedules
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/maintenance-schedules/{id}
  - [✓] Get schedule details
  - [✓] Include history
  - [✓] Include next due
  - [✓] Return schedule info

- [✓] PUT /api/v1/maintenance-schedules/{id}
  - [✓] Update schedule
  - [✓] Validate updates
  - [✓] Update next due
  - [✓] Return updated schedule

- [✓] DELETE /api/v1/maintenance-schedules/{id}
  - [✓] Delete schedule
  - [✓] Handle dependencies
  - [✓] Clean up history
  - [✓] Return success status

## Inventory Management API

### 1. Inventory Items
- [✓] POST /api/v1/inventory-items
  - [✓] Create inventory item
  - [✓] Validate item data
  - [✓] Set categories
  - [✓] Return item details

- [✓] GET /api/v1/inventory-items
  - [✓] List inventory items
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/inventory-items/{id}
  - [✓] Get item details
  - [✓] Include stock levels
  - [✓] Include transactions
  - [✓] Return item info

- [✓] PUT /api/v1/inventory-items/{id}
  - [✓] Update item
  - [✓] Validate updates
  - [✓] Update stock levels
  - [✓] Return updated item

- [✓] DELETE /api/v1/inventory-items/{id}
  - [✓] Delete item
  - [✓] Handle dependencies
  - [✓] Clean up stock
  - [✓] Return success status

### 2. Inventory Transactions
- [✓] POST /api/v1/inventory-transactions
  - [✓] Create transaction
  - [✓] Validate transaction data
  - [✓] Update stock levels
  - [✓] Return transaction details

- [✓] GET /api/v1/inventory-transactions
  - [✓] List transactions
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/inventory-transactions/{id}
  - [✓] Get transaction details
  - [✓] Include references
  - [✓] Include stock impact
  - [✓] Return transaction info

- [✓] PUT /api/v1/inventory-transactions/{id}
  - [✓] Update transaction
  - [✓] Validate updates
  - [✓] Update stock levels
  - [✓] Return updated transaction

- [✓] DELETE /api/v1/inventory-transactions/{id}
  - [✓] Delete transaction
  - [✓] Handle dependencies
  - [✓] Revert stock levels
  - [✓] Return success status

## Integration Management API

### 1. Integrations
- [✓] POST /api/v1/integrations
  - [✓] Create integration
  - [✓] Validate integration data
  - [✓] Set configuration
  - [✓] Return integration details

- [✓] GET /api/v1/integrations
  - [✓] List integrations
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/integrations/{id}
  - [✓] Get integration details
  - [✓] Include configuration
  - [✓] Include status
  - [✓] Return integration info

- [✓] PUT /api/v1/integrations/{id}
  - [✓] Update integration
  - [✓] Validate updates
  - [✓] Update configuration
  - [✓] Return updated integration

- [✓] DELETE /api/v1/integrations/{id}
  - [✓] Delete integration
  - [✓] Handle dependencies
  - [✓] Clean up resources
  - [✓] Return success status

### 2. Integration Logs
- [✓] GET /api/v1/integrations/{id}/logs
  - [✓] List integration logs
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/integrations/{id}/logs/{logId}
  - [✓] Get log details
  - [✓] Include event data
  - [✓] Include status
  - [✓] Return log info

## Compliance Management API

### 1. Compliance Standards
- [✓] POST /api/v1/compliance-standards
  - [✓] Create standard
  - [✓] Validate standard data
  - [✓] Set requirements
  - [✓] Return standard details

- [✓] GET /api/v1/compliance-standards
  - [✓] List standards
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/compliance-standards/{id}
  - [✓] Get standard details
  - [✓] Include requirements
  - [✓] Include audits
  - [✓] Return standard info

- [✓] PUT /api/v1/compliance-standards/{id}
  - [✓] Update standard
  - [✓] Validate updates
  - [✓] Update requirements
  - [✓] Return updated standard

- [✓] DELETE /api/v1/compliance-standards/{id}
  - [✓] Delete standard
  - [✓] Handle dependencies
  - [✓] Clean up audits
  - [✓] Return success status

### 2. Compliance Audits
- [✓] POST /api/v1/compliance-audits
  - [✓] Create audit
  - [✓] Validate audit data
  - [✓] Set requirements
  - [✓] Return audit details

- [✓] GET /api/v1/compliance-audits
  - [✓] List audits
  - [✓] Support pagination
  - [✓] Support filtering
  - [✓] Support sorting

- [✓] GET /api/v1/compliance-audits/{id}
  - [✓] Get audit details
  - [✓] Include findings
  - [✓] Include status
  - [✓] Return audit info

- [✓] PUT /api/v1/compliance-audits/{id}
  - [✓] Update audit
  - [✓] Validate updates
  - [✓] Update findings
  - [✓] Return updated audit

- [✓] DELETE /api/v1/compliance-audits/{id}
  - [✓] Delete audit
  - [✓] Handle dependencies
  - [✓] Clean up findings
  - [✓] Return success status

## Reporting and Analytics

### Reports
```
GET    /api/v1/reports
GET    /api/v1/reports/{id}
POST   /api/v1/reports
PUT    /api/v1/reports/{id}
DELETE /api/v1/reports/{id}
POST   /api/v1/reports/{id}/execute
GET    /api/v1/reports/saved
GET    /api/v1/reports/saved/{id}
POST   /api/v1/reports/{id}/save
PUT    /api/v1/reports/saved/{id}
DELETE /api/v1/reports/saved/{id}
POST   /api/v1/reports/saved/{id}/execute
GET    /api/v1/reports/templates
POST   /api/v1/reports/import
GET    /api/v1/reports/export/{id}
```

### Analytics
```
GET    /api/v1/analytics/work-orders/by-status
GET    /api/v1/analytics/work-orders/by-priority
GET    /api/v1/analytics/work-orders/by-type
GET    /api/v1/analytics/work-orders/by-asset
GET    /api/v1/analytics/work-orders/by-location
GET    /api/v1/analytics/work-orders/by-technician
GET    /api/v1/analytics/work-orders/mttr
GET    /api/v1/analytics/work-orders/mtbf
GET    /api/v1/analytics/assets/breakdown-frequency
GET    /api/v1/analytics/assets/maintenance-cost
GET    /api/v1/analytics/inventory/usage
GET    /api/v1/analytics/inventory/cost
GET    /api/v1/analytics/pm/compliance
GET    /api/v1/analytics/dashboard/summary
GET    /api/v1/analytics/dashboard/widgets
PUT    /api/v1/analytics/dashboard/widgets
```

## Notifications

### Notification Types
```
GET    /api/v1/notification-types
GET    /api/v1/notification-types/{id}
POST   /api/v1/notification-types
PUT    /api/v1/notification-types/{id}
DELETE /api/v1/notification-types/{id}
```

### Notifications
```
GET    /api/v1/notifications
GET    /api/v1/notifications/{id}
PUT    /api/v1/notifications/{id}/read
PUT    /api/v1/notifications/read-all
DELETE /api/v1/notifications/{id}
```

### Notification Preferences
```
GET    /api/v1/notification-preferences
PUT    /api/v1/notification-preferences
```

## Mobile API

### Mobile Specific Endpoints
```
GET    /api/v1/mobile/dashboard
GET    /api/v1/mobile/assigned-work-orders
POST   /api/v1/mobile/work-orders/{id}/update-status
POST   /api/v1/mobile/work-orders/{id}/add-photo
POST   /api/v1/mobile/work-orders/{id}/record-labor
POST   /api/v1/mobile/work-orders/{id}/use-part
GET    /api/v1/mobile/inventory/scan/{barcode}
GET    /api/v1/mobile/assets/scan/{barcode}
GET    /api/v1/mobile/assets/nearby
GET    /api/v1/mobile/sync/all
POST   /api/v1/mobile/sync/upload
GET    /api/v1/mobile/offline-data
```

## System Administration

### System Settings
```
GET    /api/v1/settings
PUT    /api/v1/settings
GET    /api/v1/settings/categories
GET    /api/v1/settings/by-category/{category}
```

### Audit Logs
```
GET    /api/v1/audit-logs
GET    /api/v1/audit-logs/{id}
POST   /api/v1/audit-logs/search
```

### Import/Export
```
POST   /api/v1/import/validate
POST   /api/v1/import/execute
GET    /api/v1/import/templates
GET    /api/v1/import/history
GET    /api/v1/export/generate
GET    /api/v1/export/download/{jobId}
GET    /api/v1/export/history
```

## Tenant Context

All API calls (except for the super admin tenant management endpoints) require a tenant context. This can be provided in one of three ways:

1. Subdomain: `https://tenant-name.cmms-app.com/api/v1/...`
2. Custom domain: `https://tenant-custom-domain.com/api/v1/...`
3. Header: `X-Tenant-ID: tenant-id` header in the request

## Query Parameters

Most GET endpoints support the following query parameters:

- `page`: Page number for pagination (default: 0)
- `size`: Page size for pagination (default: 20)
- `sort`: Sort field and direction (e.g., `name,asc` or `createdAt,desc`)
- `search`: General search term
- `fields`: Comma-separated list of fields to include in the response
- `filter`: Field-specific filters (e.g., `status=ACTIVE&priority=HIGH`)
- `from`: Start date for date range filtering
- `to`: End date for date range filtering
- `expand`: Comma-separated list of related entities to expand in the response

## API Response Format

All API responses follow a consistent structure:

```json
{
  "success": true,
  "code": 200,
  "message": "Success message",
  "data": { /* Response data */ },
  "meta": {
    "page": 0,
    "size": 20,
    "totalElements": 100,
    "totalPages": 5
  },
  "links": {
    "self": "/api/v1/resource?page=0&size=20",
    "next": "/api/v1/resource?page=1&size=20",
    "prev": null,
    "first": "/api/v1/resource?page=0&size=20",
    "last": "/api/v1/resource?page=4&size=20"
  }
}
```

## Error Response Format

Error responses use HTTP status codes and provide detailed error information:

```json
{
  "success": false,
  "code": 400,
  "message": "Error message",
  "errors": [
    {
      "field": "fieldName",
      "message": "Specific error message for this field"
    }
  ]
}
``` 