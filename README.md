# Student Management System

A clean, layered, and enterprise-oriented **Student Management System** built with Java.

This project started as a simple console-based application and was gradually refactored into a more professional structure using clean architecture principles, Maven, unit testing, logging, dependency injection, repository abstraction, and configuration management.

The goal of this project is not only to manage student data, but also to demonstrate professional Java software engineering practices in a small, understandable, and extendable codebase.

---

## Project Purpose

The main purpose of this project is to practice and demonstrate:

- Clean project structure
- Layered architecture
- SOLID principles
- Dependency Injection
- Repository Pattern
- Unit testing with JUnit 5
- Professional logging with SLF4J and Logback
- Maven-based dependency and build management
- Configuration management using resource files
- Step-by-step enterprise-style project evolution

This project is designed to be expanded gradually through future development sprints.

---

## Current Status

The current version is focused on the core backend logic of a console-based student management system.

Implemented features include:

- Student domain model
- Repository layer for data operations
- Service layer for business logic
- Dependency injection between layers
- Basic unit tests
- Maven project structure
- Centralized configuration using `config.properties`
- Professional logging setup using SLF4J + Logback
- Separation of production and test logging configuration

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java | Main programming language |
| Maven | Build and dependency management |
| JUnit 5 | Unit testing framework |
| SLF4J | Logging abstraction |
| Logback | Logging implementation |
| Lombok  |  generating them automatically through annotations,  |
| IntelliJ IDEA | Development environment |

---

## Project Structure
```text
student-management-system
│
├── pom.xml
├── README.md
│
├── logs/
│   └── student-management-system.log
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── student/
│   │   │           ├── Main.java
│   │   │           │
│   │   │           ├── model/
│   │   │           │   └── Student.java
│   │   │           │
│   │   │           ├── repository/
│   │   │           │   ├── StudentRepository.java
│   │   │           │   └── InMemoryStudentRepository.java
│   │   │           │
│   │   │           ├── service/
│   │   │           │   └── StudentService.java
│   │   │           │
│   │   │           └── exception/
│   │   │               └── ...
│   │   │
│   │   └── resources/
│   │       ├── config.properties
│   │       └── logback.xml
│   │
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── student/
│       │           └── ...
│       │
│       └── resources/
│           └── logback-test.xml
