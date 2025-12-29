Student Management System (Backend)
A backend-only REST API built using Spring Boot to manage students. This project is designed to learn and demonstrate Spring Boot concepts from basic to advanced level, following clean architecture and best practices.

🛠️ Tech Stack
Java 17
Spring Boot
Spring Data JPA
Spring Security (JWT Authentication)
MySQL
Hibernate
Swagger / OpenAPI
Maven
SLF4J + Logback
✨ Features
RESTful APIs for Student management
Create, Read, Update, Delete (CRUD) operations
Request validation using Bean Validation
Global exception handling
JWT-based authentication and authorization
Pagination and sorting support
API documentation using Swagger UI
Structured logging using SLF4J & Logback
Clean layered architecture
📂 Project Structure
src/main/java/com/example/student ├── controller # REST controllers ├── service # Business logic ├── repository # JPA repositories ├── entity # JPA entities ├── dto # Data Transfer Objects ├── exception # Custom exceptions & handlers ├── security # JWT & Spring Security configuration └── config # Application configuration

📖 API Documentation
After running the application, access Swagger UI:http://localhost:8080/swagger-ui/index.html POSTMAN API

▶️ Run the Application Locally
Prerequisites
Java 17+
Maven
MySQL running locally
Configure Database
Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=your_password

mvn clean package
java -jar target/student-0.0.1-SNAPSHOT.jar

