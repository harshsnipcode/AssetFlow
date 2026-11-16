# AssetFlow

AssetFlow is an interview-friendly enterprise IT asset and service management starter built with Spring Boot, Spring Data JPA, Hibernate, MySQL, React, and Vite.

## Run locally

1. Create the existing MySQL schema once in MySQL Workbench: `CREATE DATABASE assetflow_db;` (skip this if it already exists).
2. In `backend`, copy `.env.example` values into your shell environment. Set `DB_PASSWORD` to your local password; it is not stored in source control.
3. Start the API: `mvn spring-boot:run`.
4. Start the UI: `cd frontend; npm install; npm run dev`.

With `DDL_AUTO=update`, Hibernate creates and evolves the mapped tables automatically during development. Do not use that mode for production; use migrations and `validate` instead.

## API surface

- `GET/POST/PUT/DELETE /api/employees`
- `GET/POST/PUT/DELETE /api/assets`
- `GET/POST /api/allocations`, `PUT /api/allocations/{id}/return`
- `GET/POST /api/tickets`, `PUT /api/tickets/{id}/status`
- `GET/POST /api/asset-requests`, approve/reject actions
- `GET /api/dashboard/stats`

Allocation and return operations are transactional and reject non-available assets. Database credentials are supplied through environment variables.
