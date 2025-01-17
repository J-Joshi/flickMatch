# Football Stats Website

## Overview
This is a Football Stats Web Application built using **Spring Boot** for the backend and **Vaadin** for the frontend. The application fetches match statistics based on a given match ID and displays them in a structured format.

## Features
- Fetch match statistics via a REST API.
- Display match stats in a structured format.
- Built using **Spring Boot** (Backend) and **Vaadin** (Frontend).
- Uses **Maven** for dependency management.

## Getting Started

### 1. Clone the Repository
```sh
git clone https://github.com/your-username/football-stats.git
cd football-stats
```

### 2. Setup the Backend (Spring Boot)

#### Navigate to the backend directory
```sh
cd backend
```
#### Build and run the Spring Boot application
```sh
mvn clean install
mvn spring-boot:run
```

By default, the backend will run on `http://localhost:8080`.

### 3. Setup the Frontend (Vaadin)

#### Navigate to the frontend directory
```sh
cd frontend
```
#### Build and run the Vaadin application
```sh
mvn clean install
mvn spring-boot:run
```

By default, the frontend will be available at `http://localhost:8081`.

## API Endpoints
- `GET /getMatchStats?matchId={matchId}` - Fetches match statistics for the given match ID.
