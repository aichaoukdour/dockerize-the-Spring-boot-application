# Dockerizing a Spring Boot Application

This guide explains how to create a Docker image for a Spring Boot application and run it inside a container.

## Prerequisites

- Java 11 or later installed
- Maven installed
- Docker installed and running on ubuntu
---
## Steps to Dockerize a Spring Boot Application

### 1. Create a simple springboot application

Just go to (https://start.spring.io/) and generate a new spring boot project.

<img width="863" alt="image" src="https://github.com/user-attachments/assets/ffe06d95-d7d7-4174-8852-ee0a343729dd" />

### 2. Build a simple REST API

view code file : SpringbootDockerDemoApplication 

### 3. Open terminal and run this commande 

Before creating a Docker image, build the Spring Boot application using Maven:

```sh
mvn clean package
```

In the root directory of your Spring Boot project, create a file named `Dockerfile` with the following content:

```dockerfile
# Use a base image with OpenJDK
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/*.jar app.jar

# Expose the application's port
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
```

### 2. Build the JAR file

Before creating a Docker image, build the Spring Boot application using Maven:

```sh
mvn clean package
```

This command will generate a JAR file inside the `target/` directory.

### 3. Build the Docker Image

Run the following command to build the Docker image:

```sh
docker build -t my-spring-boot-app .
```

Replace `my-spring-boot-app` with a suitable name for your application.

### 4. Run the Docker Container

After building the image, you can run the container with:

```sh
docker run -p 8080:8080 my-spring-boot-app
```

Now, your Spring Boot application should be accessible at `http://localhost:8080/`.

### 5. Check Running Containers

To check if the container is running, use:

```sh
docker ps
```

### 6. Stop the Container

To stop the running container, use:

```sh
docker stop <container_id>
```

Replace `<container_id>` with the actual container ID from `docker ps`.

### 7. Push to Docker Hub (Optional)

If you want to push your image to Docker Hub:

```sh
docker tag my-spring-boot-app username/my-spring-boot-app
```

```sh
docker push username/my-spring-boot-app
```

Replace `username` with your Docker Hub username.

## Conclusion

You have successfully Dockerized your Spring Boot application and can now run it inside a container!

