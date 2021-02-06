# spring-postgres
In this project, we want to run a Spring Boot application with the open-source database PostgreSQL.
Instead of installing PostgreSQL, we'll use Docker Compose to run PostgreSQL. 

## Usage
```bash
docker-compose up -d
```

```bash
./gradlew bootRun
```

## Destription

We use 
* PostgreSQL 13.1 
* Java 1.8
* Spring boot 2.4.2

Example of 
* Spring boot application connect to PostgreSQL
* Using java stream to sum value of product group by name and groupId
* Testing RESTful controller using mockMvc
* Using @EventListener to create example data after application ready (this is not a good practice, just want to try) 
