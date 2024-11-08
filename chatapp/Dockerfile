# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim as builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build file and the entire project into the container
COPY chatapp/pom.xml .
COPY chatapp ./src

# Install Maven (if you don't want to use the wrapper)
RUN apt-get update && apt-get install -y maven

# Build the application using Maven

