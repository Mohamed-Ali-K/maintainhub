# CMMS Database Schema Design

## Implementation Checklist
- [✓] Tenant Management Schema
  - [✓] Multi-tenant Architecture
    - [✓] Tenant context management
    - [✓] Tenant-aware database connections
    - [✓] Tenant isolation mechanisms
  - [ ] Tenant Configuration
    - [ ] Tenant settings table
    - [ ] Tenant customization options
    - [ ] Tenant-specific configurations
  - [ ] Tenant Data Management
    - [ ] Tenant data partitioning
    - [ ] Tenant data migration
    - [ ] Tenant backup/restore
- [✓] Core Entities Schema
- [ ] Work Order Management Schema
- [ ] Preventive Maintenance Schema
- [ ] Inventory Management Schema
- [ ] Integration Management Schema
- [ ] Compliance Management Schema

## Multi-Tenancy Schema Design

### Tenant Management
```
tenants
- id (PK)
- name
- subdomain
- primary_domain
- status (active, inactive, suspended)
- plan_id (FK to subscription_plans)
- created_at
- updated_at

tenant_configurations
- tenant_id (PK, FK to tenants)
- logo_url
- primary_color
- secondary_color
- custom_css
- email_configuration
- date_format
- time_format
- currency
- language
- timezone
- features_enabled (JSON)
- created_at
- updated_at

subscription_plans
- id (PK)
- name
- description
- max_users
- max_assets
- features_included (JSON)
- price
- billing_cycle
- created_at
- updated_at

tenant_database_connections
- tenant_id (PK, FK to tenants)
- connection_type (same_db, separate_schema, separate_db)
- connection_string
- schema_name
- created_at
- updated_at
```

## Core Entities

### User Management
```
users
- id (PK)
- tenant_id (FK to tenants)
- username
- email
- password_hash
- first_name
- last_name
- phone
- job_title
- department_id (FK to departments)
- is_active
- last_login_at
- created_at
- updated_at

roles
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- is_system_role
- created_at
- updated_at

user_roles
- user_id (PK, FK to users)
- role_id (PK, FK to roles)

permissions
- id (PK)
- name
- description
- category
- is_tenant_specific

role_permissions
- role_id (PK, FK to roles)
- permission_id (PK, FK to permissions)
```

### Organization Structure
```
departments
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- parent_id (FK to departments)
- manager_id (FK to users)
- created_at
- updated_at

locations
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- address
- city
- state
- country
- postal_code
- geo_latitude
- geo_longitude
- parent_id (FK to locations)
- created_at
- updated_at
```

### Asset Management
```
asset_categories
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- parent_id (FK to asset_categories)
- icon
- created_at
- updated_at

assets
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- asset_number
- serial_number
- model
- manufacturer
- category_id (FK to asset_categories)
- location_id (FK to locations)
- department_id (FK to departments)
- status
- barcode
- qr_code
- purchase_date
- purchase_cost
- installation_date
- warranty_expiration_date
- expected_useful_life
- current_value
- criticality (low, medium, high, critical)
- parent_id (FK to assets)
- created_at
- updated_at

asset_attributes
- id (PK)
- asset_id (FK to assets)
- attribute_name
- attribute_value
- created_at
- updated_at

asset_documents
- id (PK)
- tenant_id (FK to tenants)
- asset_id (FK to assets)
- file_name
- file_path
- file_type
- file_size
- description
- uploaded_by (FK to users)
- upload_date
- version
```

### Custom Fields
```
custom_field_definitions
- id (PK)
- tenant_id (FK to tenants)
- entity_type (asset, work_order, inventory_item, etc.)
- field_name
- display_name
- field_type (text, number, date, dropdown, etc.)
- is_required
- default_value
- options (JSON, for dropdown fields)
- validation_rules (JSON)
- help_text
- display_order
- created_at
- updated_at

custom_field_values
- id (PK)
- custom_field_id (FK to custom_field_definitions)
- entity_type
- entity_id
- value
- created_at
- updated_at
```

### Work Order Management
```
work_order_priorities
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- color_code
- response_time_hours
- created_at
- updated_at

work_order_types
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- icon
- created_at
- updated_at

work_order_statuses
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- color_code
- is_closed
- sort_order
- created_at
- updated_at

work_orders
- id (PK)
- tenant_id (FK to tenants)
- work_order_number
- title
- description
- asset_id (FK to assets)
- location_id (FK to locations)
- type_id (FK to work_order_types)
- priority_id (FK to work_order_priorities)
- status_id (FK to work_order_statuses)
- reported_by (FK to users)
- assigned_to (FK to users)
- requested_date
- due_date
- completion_date
- estimated_hours
- actual_hours
- estimated_cost
- actual_cost
- parent_work_order_id (FK to work_orders)
- created_at
- updated_at

work_order_tasks
- id (PK)
- tenant_id (FK to tenants)
- work_order_id (FK to work_orders)
- description
- estimated_hours
- actual_hours
- status
- completed_by (FK to users)
- completion_date
- sort_order

work_order_labor
- id (PK)
- tenant_id (FK to tenants)
- work_order_id (FK to work_orders)
- user_id (FK to users)
- log_date
- hours_worked
- labor_cost
- notes

work_order_parts
- id (PK)
- tenant_id (FK to tenants)
- work_order_id (FK to work_orders)
- inventory_item_id (FK to inventory_items)
- quantity_used
- unit_cost
- total_cost
- notes
```

### Workflow Configuration
```
workflow_definitions
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- entity_type (work_order, asset, etc.)
- is_active
- created_at
- updated_at

workflow_states
- id (PK)
- workflow_id (FK to workflow_definitions)
- name
- description
- is_initial_state
- is_final_state
- created_at
- updated_at

workflow_transitions
- id (PK)
- workflow_id (FK to workflow_definitions)
- from_state_id (FK to workflow_states)
- to_state_id (FK to workflow_states)
- name
- description
- roles_allowed (JSON)
- validation_rules (JSON)
- created_at
- updated_at
```

### Preventive Maintenance
```
maintenance_plans
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- asset_id (FK to assets)
- location_id (FK to locations)
- frequency_type (days, weeks, months, years, hours, cycles, etc.)
- frequency_value
- estimated_hours
- next_due_date
- last_completed_date
- is_active
- created_at
- updated_at

maintenance_procedures
- id (PK)
- tenant_id (FK to tenants)
- maintenance_plan_id (FK to maintenance_plans)
- description
- estimated_time
- sort_order

maintenance_tasks
- id (PK)
- tenant_id (FK to tenants)
- maintenance_procedure_id (FK to maintenance_procedures)
- description
- instructions
- estimated_time
- requires_verification
- sort_order

maintenance_schedules
- id (PK)
- tenant_id (FK to tenants)
- maintenance_plan_id (FK to maintenance_plans)
- scheduled_date
- work_order_id (FK to work_orders)
- status
- notes
```

### Inventory Management
```
inventory_locations
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- location_id (FK to locations)
- parent_id (FK to inventory_locations)

inventory_categories
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- parent_id (FK to inventory_categories)

inventory_items
- id (PK)
- tenant_id (FK to tenants)
- item_number
- name
- description
- category_id (FK to inventory_categories)
- unit_of_measure
- manufacturer
- model
- barcode
- is_critical
- minimum_quantity
- reorder_point
- economic_order_quantity
- average_cost
- last_purchase_cost
- notes
- created_at
- updated_at

inventory_item_locations
- id (PK)
- tenant_id (FK to tenants)
- inventory_item_id (FK to inventory_items)
- location_id (FK to inventory_locations)
- quantity
- last_counted_date
- bin_location

inventory_transactions
- id (PK)
- tenant_id (FK to tenants)
- inventory_item_id (FK to inventory_items)
- location_id (FK to inventory_locations)
- transaction_type (issue, receipt, transfer, adjustment)
- quantity
- reference_id (work order id, purchase order id, etc.)
- reference_type
- transaction_date
- unit_cost
- total_cost
- performed_by (FK to users)
- notes

vendors
- id (PK)
- tenant_id (FK to tenants)
- name
- contact_person
- email
- phone
- address
- city
- state
- country
- postal_code
- website
- payment_terms
- notes
- created_at
- updated_at

vendor_items
- vendor_id (PK, FK to vendors)
- inventory_item_id (PK, FK to inventory_items)
- vendor_part_number
- lead_time_days
- unit_cost
- minimum_order_quantity
- is_preferred_vendor
```

### Integration Management
```
integrations
- id (PK)
- tenant_id (FK to tenants)
- name
- type (erp, iot, accounting, etc.)
- configuration (JSON)
- status
- last_sync_at
- created_at
- updated_at

integration_logs
- id (PK)
- integration_id (FK to integrations)
- status (success, error, warning)
- message
- details
- created_at
```

### Notifications
```
notification_types
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- template
- category
- created_at
- updated_at

notifications
- id (PK)
- tenant_id (FK to tenants)
- user_id (FK to users)
- notification_type_id (FK to notification_types)
- title
- message
- reference_id
- reference_type
- is_read
- created_at

notification_preferences
- user_id (PK, FK to users)
- notification_type_id (PK, FK to notification_types)
- email_enabled
- sms_enabled
- in_app_enabled
```

### Reporting
```
reports
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- query
- parameters
- created_by (FK to users)
- created_at
- updated_at

saved_reports
- id (PK)
- tenant_id (FK to tenants)
- report_id (FK to reports)
- user_id (FK to users)
- name
- parameters
- schedule
- recipients
- last_run
- created_at
```

### Compliance Management
```
compliance_standards
- id (PK)
- tenant_id (FK to tenants)
- name
- description
- standard_type (ISO, OSHA, etc.)
- reference_number
- created_at
- updated_at

compliance_requirements
- id (PK)
- compliance_standard_id (FK to compliance_standards)
- name
- description
- verification_method
- frequency_type
- frequency_value
- created_at
- updated_at

compliance_audits
- id (PK)
- tenant_id (FK to tenants)
- compliance_requirement_id (FK to compliance_requirements)
- asset_id (FK to assets)
- audit_date
- status
- findings
- performed_by (FK to users)
- created_at
- updated_at
```

## Audit Logging
```
audit_logs
- id (PK)
- tenant_id (FK to tenants)
- user_id (FK to users)
- action
- entity_type
- entity_id
- old_values
- new_values
- ip_address
- user_agent
- created_at
```

## Relationships Overview

- Tenants have users, configurations, and subscription plans
- Every entity is associated with a tenant_id for multi-tenancy
- Users belong to departments and can have multiple roles
- Roles have multiple permissions
- Assets can have parent assets (hierarchy)
- Assets belong to categories, locations, and departments
- Work orders are associated with assets and locations
- Work orders can have tasks, labor records, and parts used
- Maintenance plans are linked to assets and generate work orders
- Inventory items belong to categories and can be stored in multiple locations
- Inventory transactions track movement of inventory items
- Vendors supply inventory items
- Notifications are sent to users based on various system events
- Users can configure notification preferences by type
- Custom fields allow tenant-specific entity customization
- Workflows allow tenant-specific process customization
- Integrations connect with external systems

## Indexing Strategy

- Primary keys on all tables
- Foreign keys for all relationships
- Tenant_id should be included in all composite indexes
- Indexes on frequently queried columns:
  - tenant_id on all tables
  - work_orders: status_id, asset_id, assigned_to
  - assets: status, category_id, location_id
  - inventory_items: item_number, category_id
  - users: username, email
  - maintenance_plans: next_due_date
  - inventory_transactions: transaction_date, inventory_item_id
  
## Multi-Tenant Data Partitioning Options

### 1. Shared Schema Approach
- All tenants share the same database schema
- Every table has a tenant_id column
- Database queries always filter by tenant_id
- Benefits: Simpler schema management, more efficient resource usage
- Drawbacks: Potential "noisy neighbor" issues, security concerns

### 2. Schema-per-Tenant Approach
- Each tenant has its own database schema
- Same table structure is replicated for each tenant
- Application connects to appropriate schema based on tenant
- Benefits: Better isolation, potentially better performance
- Drawbacks: More complex management, more resource intensive

### 3. Database-per-Tenant Approach
- Each tenant has completely separate database
- Highest level of isolation
- Benefits: Complete isolation, customization flexibility
- Drawbacks: Highest management overhead, most resource intensive

### 4. Hybrid Approach
- Critical tenant-specific data in separate schemas/databases
- Shared reference data in a common schema
- Benefits: Balance of isolation and efficiency
- Drawbacks: More complex implementation 