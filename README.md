# Task Manager

A monolithic web application built with Spring Boot for managing users and their tasks.

## Tech Stack

- Java 17
- Spring Boot 4.1.1
- Spring Security
- Spring Data JPA
- H2 Database (in-memory)
- PostgreSQL (production)
- Thymeleaf
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17+
- Maven

### Run locally

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8081`

### H2 Console

Access the database console at `http://localhost:8081/h2-console`

- JDBC URL: `jdbc:h2:mem:taskmanagerdb`
- Username: `sa`
- Password: *(leave empty)*

## API Endpoints

### Users

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users` | Get all users |
| GET | `/users/{id}` | Get user by ID |
| POST | `/users` | Create a user |
| PATCH | `/users/{id}` | Update a user |
| DELETE | `/users/{id}` | Delete a user |

### Tasks

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users/{id}/tasks` | Get all tasks for a user |
| POST | `/users/{id}/tasks` | Create a task for a user |
| PATCH | `/tasks/{id}` | Update a task |
| DELETE | `/tasks/{id}` | Delete a task |

## Task Status

Tasks can have the following statuses:

- `PENDING`
- `IN_PROGRESS`
- `DONE`

## Roadmap

- [ ] JWT Authentication
- [ ] Password encryption with BCrypt
- [ ] Frontend (Thymeleaf)
