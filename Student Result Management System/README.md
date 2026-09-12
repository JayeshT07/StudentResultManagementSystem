# Student Result Management System — Java Version

This is a Java/Spring Boot implementation of the Student Result Management System described in the supplied college project report.

## Stack
- Java 17
- Spring Boot
- Spring MVC / REST
- Spring Data JPA / Hibernate
- Spring Security
- MySQL
- HTML/CSS/JavaScript

## Modules
- Student registration/profile
- Course management
- Course enrollment
- Attendance
- Result/grade management
- Performance summary
- Announcements

## Run

1. Install Java 17+ and Maven.
2. Create MySQL database:
   `CREATE DATABASE student_result_db;`
3. Edit `src/main/resources/application.properties` and set your MySQL username/password.
4. Run:
   `mvn spring-boot:run`
5. Open:
   `http://localhost:8080`

## Default API authentication
For development, HTTP Basic authentication is enabled:
- username: `admin`
- password: `admin123`

Change these values before using the application beyond local development.

## Main API endpoints
- GET/POST/PUT/DELETE `/api/students`
- GET/POST/PUT/DELETE `/api/courses`
- GET/POST/PUT/DELETE `/api/enrollments`
- GET/POST/PUT/DELETE `/api/attendance`
- GET/POST/PUT/DELETE `/api/results`
- GET/POST/PUT/DELETE `/api/announcements`
- GET `/api/students/{id}/summary`

The REST API is intentionally simple so that it is easy to explain in a Java interview.
