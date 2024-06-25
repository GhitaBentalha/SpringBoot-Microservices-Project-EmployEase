# Employease

Employease is a comprehensive Job Portal Application designed to streamline the job search process for both job seekers and employers. Developed using Java Spring Boot, it leverages RESTful APIs and a microservices architecture to ensure scalability, reliability, and ease of use.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Roles and Responsibilities](#roles-and-responsibilities)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Features

- **Microservices Architecture:** Decoupled services for better scalability and maintainability.
- **Service Discovery:** Eureka for dynamic service registration and discovery.
- **Inter-Service Communication:** OpenFeign for simplified REST clients.
- **Database Integration:** MySQL with JPA and Hibernate for robust data management.
- **Authentication & Authorization:** Spring Security with JWT and Okta integration.
- **Asynchronous Processing:** RabbitMQ for efficient messaging and task handling.
- **Resilience:** Resilience4j for fault tolerance and circuit breaking.
- **Distributed Tracing & Monitoring:** Zipkin for tracing requests and Spring Boot Actuator for health checks.
- **API Gateway:** Centralized routing, load balancing, and security with Spring Cloud Gateway.
- **Containerization:** Docker for consistent deployment across environments.

## Architecture

Employease is composed of multiple microservices, each responsible for a specific aspect of the application:

- **Auth Service:** Manages authentication and authorization using JWT and Okta.
- **User Service:** Handles user profiles and roles (Admin, Employee, Employer).
- **Job Service:** Manages job postings and applications.
- **Review Service:** Allows employees to provide company reviews and ratings.
- **Notification Service:** Uses RabbitMQ to send asynchronous notifications.

All services are registered with Eureka for service discovery, and inter-service communication is managed via OpenFeign.

## Roles and Responsibilities

- **Admin:**
  - Oversee and manage the entire platform.
  - Monitor user activities and system health.

- **Employer:**
  - Create and manage job postings.
  - Review and manage job applications.
  - Track the status of job applications.

- **Employee:**
  - Create and update resumes.
  - Apply for job postings.
  - Provide reviews and ratings for companies.

## Getting Started

### Prerequisites

- Java 11 or higher
- Docker
- MySQL
- RabbitMQ
- Okta Developer Account

### Installation

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/yourusername/employease.git
   cd employease
