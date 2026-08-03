# 📋 Task Management System

A RESTful Task Management System built with **Spring Boot**, **PostgreSQL**, **Spring Security**, and **JWT Authentication**. The backend is fully containerized using **Docker** and **Docker Compose**.

---

## 🚀 Features

- 👤 User Registration (Sign Up)
- 🔑 User Login with JWT Authentication
- ✅ Create Tasks
- 📋 View Tasks
- ✏️ Update Tasks
- 🗑️ Delete Tasks
- 🔒 Secure REST APIs using Spring Security & JWT
- 🐳 Dockerized Backend
- 🗄️ PostgreSQL Database

---

## 🛠️ Technologies Used

- Java 25
- Spring Boot 4.1.0
- Spring Security
- Spring Data JPA
- JWT (JSON Web Token)
- PostgreSQL
- Maven
- Docker
- Docker Compose

---

## 📁 Project Structure

```
Task-Management-System/
│
├── demo/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/demo
│   │   │   │   ├── controller
│   │   │   │   ├── service
│   │   │   │   ├── repository
│   │   │   │   ├── config
│   │   │   │   ├── classesPackage
│   │   │   │   └── DemoApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/
│   │
│   ├── Dockerfile
│   ├── docker-compose.yml
│   ├── pom.xml
│   └── .dockerignore
│
└── README.md
```

---

## 🔧 Prerequisites

Before running the project, install:

- Java 25
- Maven
- Docker Desktop
- Git

---

# ▶️ Running Locally

### Clone the repository

```bash
git clone https://github.com/Mariam226/Task-Management-System.git
```

### Navigate to the project

```bash
cd Task-Management-System/demo
```

### Run the application

```bash
./mvnw spring-boot:run
```

or on Windows

```cmd
mvnw.cmd spring-boot:run
```

The API will be available at:

```
http://localhost:8080
```

---

# 🐳 Running with Docker

Build and start the containers:

```bash
docker compose up --build
```

Run in the background:

```bash
docker compose up -d
```

Stop the containers:

```bash
docker compose down
```

---

## 🗄️ Database

Database: PostgreSQL

Default Configuration:

| Property | Value |
|----------|-------|
| Database | postgres |
| Port | 5432 |

---

## 🔐 Authentication

The application uses **JWT (JSON Web Token)** authentication.

### Public Endpoints

- POST `/users/signup`
- POST `/users/login`

After a successful login, a JWT token is returned.

Include the token in the Authorization header:

```
Authorization: Bearer YOUR_TOKEN
```

for accessing protected endpoints.

---

## 📡 API Overview

### User APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/users/signup` | Register a new user |
| POST | `/users/login` | User login |

### Task APIs

| Method | Endpoint |
|---------|----------|
| GET | `/tasks` |
| POST | `/tasks` |
| PUT | `/tasks/{id}` |
| DELETE | `/tasks/{id}` |

---

## 🔒 Security

- Spring Security
- JWT Authentication
- BCrypt Password Encoding
- Stateless Authentication

---

## 📦 Docker

The backend is fully containerized using:

- Docker
- Docker Compose

Docker Compose starts:

- Spring Boot Application
- PostgreSQL Database

---

## 🌟 Future Improvements

- Angular Frontend Integration
- Task Categories
- Task Priority
- Due Dates
- Pagination
- Unit & Integration Tests
- API Documentation using Swagger/OpenAPI

---

## 👩‍💻 Author

**Mariam Hassan**

GitHub:
https://github.com/Mariam226

---

## 📜 License

This project is for educational and learning purposes.