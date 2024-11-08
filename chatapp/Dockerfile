# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim as builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file into the container (if using Maven)
COPY pom.xml .

# Copy the entire project into the container
COPY src ./src

# Build the application
RUN ./mvnw clean install -DskipTests

# Create the second stage to create the final image
FROM openjdk:23-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY --from=builder /app/target/*.jar app.jar

# Expose port 8080 for the app to run
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]