State of dev 📊
A professional survey platform specialized for the IT industry, inspired by the StackOverflow Developer Survey. Built with Spring Boot and monolith architecture.
Show Image
Show Image
Show Image
Show Image
Show Image
📑 Table of Contents

Overview
Architecture
Class Diagram
Tech Stack
Key Features
Getting Started
Development
Testing
API Documentation

Overview
State of dev is a robust survey platform designed specifically for gathering insights from the IT industry. It provides hierarchical survey structuring with subjects and sub-subjects, supporting different types of questions and tracking answer statistics across yearly editions.
Architecture
The project follows a monolith architecture built using Spring Boot.
Bounded Contexts:

Survey Management (Core)
Identity and Access (Supporting)

Class Diagram
The class diagram shows the following components:

SurveyEditionController
SurveyController
SurveyParticipationController
SurveyResultsController
SurveyEditionWithQuestionCountDTO
SurveyResultsDTO
CreateSurveyRequestDTO
UpdateSurveyRequestDTO
SurveyEdition
Survey
Owner
Chapter
Question
Answer
QuestionType
GlobalExceptionHandler
ISurveyParticipationService
ISurveyResultsService
AnswerMapper
ChapterMapper
OwnerMapper
QuestionMapper
SurveyEditionMapper
SurveyMapper
AnswerRepository
ChapterRepository
OwnerRepository
QuestionRepository
SurveyEditionRepository
SurveyRepository

Tech Stack
Core Technologies

Java 21
Spring Boot 3.2.0
Spring Cache with Redis
PostgreSQL 16
Redis 7.2

Development Tools & Practices

Test-Driven Development (TDD)
Maven
JUnit 5
AssertJ

API & Documentation

OpenAPI 3.0
Swagger UI

Key Features

📊 Hierarchical survey structure
📅 Yearly survey editions
📋 Multiple question types (Single/Multiple choice)
📈 Answer statistics tracking
🔐 Secure owner authentication
📊 Analytics capabilities
🚀 Redis caching for improved performance

Getting Started
Prerequisites

JDK 21
Maven 3.8+

Installation

Clone the repository

bashCopygit clone https://github.com/yourusername/itlens.git
cd itlens

Build the application

bashCopy./mvnw clean install

Run the application

bashCopy./mvnw spring-boot:run
The application will be available at http://localhost:8080
Development
Project Structure
itlens/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── itlens/
│   │   │           ├── ma/
│   │   │           │   └── hariti/
│   │   │           │       └── asmaa/
│   │   │           │           └── survey/
│   │   │           │               └── survey/
│   │   │           ├── config/
│   │   │           │   ├── MapperConfiguration.java
│   │   │           │   ├── OpenAPIConfiguration.java
│   │   │           │   └── RedisConfiguration.java
│   │   │           ├── controller/
│   │   │           │   ├── ChapterController.java
│   │   │           │   ├── QuestionController.java
│   │   │           │   ├── SurveyController.java
│   │   │           │   └── SurveyEditionController.java
│   │   │           ├── dto/
│   │   │           │   ├── CreateSurveyRequestDTO.java
│   │   │           │   ├── SurveyEditionWithQuestionCountDTO.java
│   │   │           │   └── SurveyResultsDTO.java
│   │   │           ├── entity/
│   │   │           │   ├── Answer.java
│   │   │           │   ├── Chapter.java
│   │   │           │   ├── Owner.java
│   │   │           │   ├── Question.java
│   │   │           │   ├── Survey.java
│   │   │           │   └── SurveyEdition.java
│   │   │           ├── enums/
│   │   │           │   └── QuestionType.java
│   │   │           ├── exception/
│   │   │           │   └── GlobalExceptionHandler.java
│   │   │           ├── repository/
│   │   │           │   ├── AnswerRepository.java
│   │   │           │   ├── ChapterRepository.java
│   │   │           │   ├── OwnerRepository.java
│   │   │           │   ├── QuestionRepository.java
│   │   │           │   ├── SurveyEditionRepository.java
│   │   │           │   └── SurveyRepository.java
│   │   │           └── service/
│   │   │               ├── ISurveyParticipationService.java
│   │   │               └── ISurveyResultsService.java
│   │   │               └── QuestionService.java
│   │   │               └── SurveyEditionService.java
│   │   │               └── SurveyService.java

│   │   └── resources/
│   │       ├── application.yml
│   │       └── assets/
│   │           └── it-survey.png
│   └── test/
│       └── java/
│           └── com/
│               └── itlens/
└── pom.xml
API Endpoints
Survey Management
Copy# Surveys
GET    /api/v1/surveys                    # List all surveys
POST   /api/v1/surveys                    # Create new survey
GET    /api/v1/surveys/{id}               # Get survey by ID
PUT    /api/v1/surveys/{id}               # Update survey
DELETE /api/v1/surveys/{id}               # Delete survey

# Survey Editions
GET    /api/v1/surveys/{id}/editions      # List editions for survey
POST   /api/v1/surveys/{id}/editions      # Create new edition
GET    /api/v1/surveys/{id}/editions/{eid} # Get specific edition
PUT    /api/v1/surveys/{id}/editions/{eid} # Update edition
DELETE /api/v1/surveys/{id}/editions/{eid} # Delete edition

# Subjects
GET    /api/v1/subjects                   # List all subjects
POST   /api/v1/subjects                   # Create new subject
GET    /api/v1/subjects/{id}              # Get subject by ID
POST   /api/v1/subjects/{id}/sub-subjects # Create sub-subject
GET    /api/v1/subjects/{id}/questions    # List questions in subject

# Questions
POST   /api/v1/questions                  # Create question
PUT    /api/v1/questions/{id}             # Update question
DELETE /api/v1/questions/{id}             # Delete question
POST   /api/v1/questions/{id}/answers     # Add answer option
Example Request/Response:
jsonCopy# POST /api/v1/surveys
Request:
{
    "title": "Developer Survey 2024",
    "description": "Annual developer survey to gather insights about IT industry trends"
}

Response:
{
    "id": 1,
    "title": "Developer Survey 2024",
    "description": "Annual developer survey to gather insights about IT industry trends",
    "createdAt": "2024-01-01T10:00:00Z",
    "status": "DRAFT"
}
Caching Configuration
Redis is used to cache:

Survey templates
Active survey editions
Frequently accessed subjects
Answer statistics

Cache configuration example in application.yml:
yamlCopyspring:
  cache:
    type: redis
    redis:
      time-to-live: 3600000
      cache-null-values: false
  redis:
    host: localhost
    port: 6379
Testing
The project follows TDD practices:
bashCopy# Run unit tests
./mvnw test

# Run integration tests
./mvnw verify -P integration-test
API Documentation
Once the application is running, you can access:

Swagger UI: http://localhost:8080/swagger-ui.html
