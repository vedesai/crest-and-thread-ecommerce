# Crest & Thread E-Commerce Platform

A modern fashion e-commerce website built with React, TypeScript, TailwindCSS frontend and Spring Boot Java backend.

## Project Structure

```
├── frontend/          # React + TypeScript + Vite frontend
├── backend/           # Spring Boot Java backend  
├── automation-tests/  # Selenium E2E tests with Python
└── infrastructure/    # Infrastructure as Code
```

## Tech Stack

### Frontend
- React 18 with TypeScript
- Vite build tool
- TailwindCSS for styling
- Vitest for unit testing

### Backend
- Spring Boot 3.3.0 with Java 21
- Spring Data JPA
- H2 (dev) / PostgreSQL (prod)
- Swagger/OpenAPI documentation

### Testing
- Frontend: Vitest + React Testing Library
- Backend: JUnit 5 + Mockito
- E2E: Selenium + Python + Pytest

## Getting Started

### Frontend
```bash
cd frontend
npm install
npm run dev
```

### Backend
```bash
cd backend
mvn spring-boot:run
```

The API will be available at `http://localhost:8080/api/v1`

## API Documentation

Swagger UI: `http://localhost:8080/api/swagger-ui.html`

---
*AI Generated Code by Deloitte + Cursor*
