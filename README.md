# Library Management API (`library-api`)

Spring Boot RESTful API developed for **University of Moratuwa - IN3101 Enterprise Application Development (Lab Sheet 02)**.

---

## 1. Project Overview

`library-api` provides the foundational RESTful backend for managing books, supporting CRUD operations, input validation, Spring Data JPA with MySQL persistence, and OpenAPI/Swagger documentation.

---

## 2. Technology Stack

- **Java**: 21 (Eclipse Temurin LTS)
- **Framework**: Spring Boot 4.1.2
  - Spring Boot Starter Web
  - Spring Data JPA
  - Spring Boot Starter Validation
  - Springdoc OpenAPI Starter WebMVC UI (3.1.1)
  - MySQL Connector/J
- **Build Tool**: Maven 3.9.11 (via Maven Wrapper `mvnw`)
- **Database**: MySQL 8.4 (Containerized via Docker Compose)

---

## 3. Prerequisites

Ensure you have the following installed on your system:
- **Java 21**
- **Docker Desktop** (with Docker Compose and WSL2 backend)
- Terminal (PowerShell, Bash, or Command Prompt)

---

## 4. Environment Configuration

Copy the example environment file:
```powershell
Copy-Item .env.example .env
```
Or on Linux/macOS:
```bash
cp .env.example .env
```

Ensure `.env` contains:
```properties
DB_ROOT_PASSWORD=secret
DB_NAME=library_db
DB_PORT=3306
DB_HOST=localhost
DB_USERNAME=root
DB_PASSWORD=secret
SERVER_PORT=8080
```

---

## 5. Running the MySQL Database (Docker Compose)

### Start MySQL
Run the container in detached mode:
```powershell
docker compose up -d
```

### Check Container Status & Health
```powershell
docker compose ps
```
Wait until the status shows `Up (healthy)`.

### Stop MySQL Container
To stop the database container:
```powershell
docker compose down
```

To stop and remove persistent database volumes (optional):
```powershell
docker compose down -v
```

---

## 6. Building and Running the Spring Boot Application

### Build with Maven Wrapper
```powershell
.\mvnw.cmd clean package -DskipTests
```
*(On Linux/macOS: `./mvnw clean package -DskipTests`)*

### Run the Application
```powershell
.\mvnw.cmd spring-boot:run
```
*(On Linux/macOS: `./mvnw spring-boot:run`)*

---

## 7. API Documentation (OpenAPI & Swagger UI)

Once the application is running:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

