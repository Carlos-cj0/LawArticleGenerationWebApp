# Start with a Maven image to build the project
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Set the working directory
WORKDIR /app

# Copy the source code
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Use a smaller image just to run the app
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=builder /app/target/LawArticleGenerationWebApp-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"] 