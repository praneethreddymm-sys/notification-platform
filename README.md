# Notification Platform

A notification management system built with Spring Boot that provides secure JWT-based authentication, REST APIs for notification management, PostgreSQL persistence, Kafka-based asynchronous processing, and email notification delivery.

## Features

- User registration and login
- JWT-based authentication
- Password encryption using BCrypt
- Secure REST APIs using Spring Security
- Send notifications
- Retrieve unread notifications
- Mark notifications as read
- PostgreSQL database integration using Spring Data JPA
- Kafka producer and consumer for notification processing
- Email notification service using SMTP
- Swagger/OpenAPI API documentation
- CORS configuration
- React-based notification frontend

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT
- Maven

### Database
- PostgreSQL

### Messaging
- Apache Kafka

### Email
- JavaMail / Gmail SMTP

### Frontend
- React.js

### API Documentation
- Swagger / OpenAPI

### Tools
- IntelliJ IDEA
- Postman
- Docker

## Project Structure

```text
notification-platform/
│
├── notification-system/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/notification/notification_system/
│   │   │   │       ├── config/
│   │   │   │       ├── controller/
│   │   │   │       ├── dto/
│   │   │   │       ├── entity/
│   │   │   │       ├── repository/
│   │   │   │       ├── security/
│   │   │   │       └── services/
│   │   │   └── resources/
│   │   └── test/
│   └── pom.xml
│
├── notification-frontend/
│   └── src/
│       ├── NotificationPage.js
│       └── api.js
│
├── docker-compose.yml
├── .gitignore
└── README.md
