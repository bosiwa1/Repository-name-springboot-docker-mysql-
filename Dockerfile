FROM eclipse-temurin:21-jdk

# Working directory inside the container
WORKDIR /app

# Copy the built jar (use wildcard so artifactId/version changes won't break the Dockerfile)
COPY build/libs/*.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
