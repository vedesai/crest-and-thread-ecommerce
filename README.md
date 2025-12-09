# Crest & Thread E-Commerce Platform

A modern e-commerce platform built with Spring Boot backend and React frontend.

## Project Structure

```
├── backend/                 # Spring Boot REST API
│   ├── src/main/java/      # Java source code
│   ├── src/main/resources/ # Configuration files
│   └── src/test/           # Unit tests
└── frontend/               # React + TypeScript frontend (coming soon)
```

## Backend Stack

- **Framework**: Spring Boot 3.3.0
- **Language**: Java 21
- **Database**: H2 (dev) / PostgreSQL (prod)
- **ORM**: Spring Data JPA
- **Security**: Spring Security
- **Documentation**: OpenAPI/Swagger
- **Testing**: JUnit 5, Mockito

## Features

- **Product Management**: CRUD operations for products with categories
- **Category Management**: Organize products into categories
- **Newsletter Subscription**: Email subscription management
- **API Documentation**: Swagger UI for API exploration

## API Endpoints

### Products
- `GET /api/v1/products` - Get all products (paginated)
- `GET /api/v1/products/{id}` - Get product by ID
- `GET /api/v1/products/new-arrivals` - Get new arrival products
- `GET /api/v1/products/featured` - Get featured products
- `GET /api/v1/products/category/{slug}` - Get products by category
- `POST /api/v1/products` - Create a new product
- `PUT /api/v1/products/{id}` - Update a product
- `DELETE /api/v1/products/{id}` - Delete a product

### Categories
- `GET /api/v1/categories` - Get all categories
- `GET /api/v1/categories/{id}` - Get category by ID
- `GET /api/v1/categories/slug/{slug}` - Get category by slug
- `POST /api/v1/categories` - Create a new category
- `PUT /api/v1/categories/{id}` - Update a category
- `DELETE /api/v1/categories/{id}` - Delete a category

### Newsletter
- `POST /api/v1/newsletter/subscribe` - Subscribe to newsletter
- `POST /api/v1/newsletter/unsubscribe` - Unsubscribe from newsletter
- `GET /api/v1/newsletter/check` - Check subscription status

## Getting Started

### Prerequisites
- Java 21+
- Maven 3.9+

### Running the Backend

```bash
cd backend
mvn spring-boot:run
```

The API will be available at `http://localhost:8080/api`

### API Documentation

Once running, access Swagger UI at:
- `http://localhost:8080/api/swagger-ui.html`

### H2 Console (Development)

Access the H2 database console at:
- `http://localhost:8080/api/h2-console`

## Testing

```bash
cd backend
mvn test
```

## License

MIT License
