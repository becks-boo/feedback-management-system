# Feedback Management System

The Feedback Management System is a web application to rate the skills of apprentices. It is used exclusively by Endava instructors of the apprenticeship program.

## Requirements
- Java 17 or later
- Maven 3 or later
- MySQL 8 or later

## Installation

1. Clone the repository: 

```bash
git clone git@git.exozet.com:ausbildung/apprentices/igor-stein/ausbilder-portal.git
```
2. Navigate to the project directory:
```bash
cd your_repository
```
3. Install dependencies:
```bash
mvn install
```
4. Update the `application.properties` file with your credentials in **spring.datasource.username** and **spring.datasource.password**

## Usage

1. Run the application:
AusbilderPortalApplication.java
2. Open a web browser and navigate to `http://localhost:8080/apprentices`
