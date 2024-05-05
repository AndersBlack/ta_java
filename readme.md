# Technical Assignment - Autorola , JAVA
This is a technical assignment for Autorola written with Spring and Java.

## Running the appilication

The application requires Java 17 or higher to run.

Running the application is acheived using 
```
./mvnw spring-boot:run
```

The service should then be available at https://localhost:9090

For the urls for calling the application please use:

Get all cars: https://localhost:9090/cars (Get)
Get single car: https://localhost:9090/cars/vin (Get)
Add car: https://localhost:9090/cars (Post)
Update car: https://localhost:9090/cars/vin (Post)
Delete car: https://localhost:9090/cars/vin (Delete)