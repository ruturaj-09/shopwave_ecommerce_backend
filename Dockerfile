# Use the official OpenJDK 17 image as a base
FROM maven:3.8.4-openjdk-17 AS build

# Set the working directory inside the container
WORKDIR /app

## Add a volume to store logs
#VOLUME /tmp

# Copy the JAR file to the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose port 9090 (or your configured port)
EXPOSE 9090

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
