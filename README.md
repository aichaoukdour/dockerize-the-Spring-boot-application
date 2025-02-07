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
Once maven build success, go target folder and you will be able to see the springboot-docker-demo-0.0.1-

<img width="447" alt="image" src="https://github.com/user-attachments/assets/07afdca4-8e9f-47a1-8b7e-3eba0ea969fa" />

### 3. Create Dockerfile

In the root directory of your Spring Boot project, create a file named `Dockerfile` with the following content:

```dockerfile
# Use a base image with OpenJDK
# define base docker image
FROM openjdk:11
LABEL maintainer="javaao.net"
ADD target/springboot-docker-demo-0.0.1-SNAPSHOT.jar springboot-docker-demo.jar
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]
```

### 4. Build the Docker Image

Run the following command to build the Docker image:

```sh
docker build -t springboot-docker-demo:latest  .
```

Replace `springboot-docker-demo` with a suitable name for your application.
After the build is successfully finished, we can check to see if it appears in the list of docker images available locally. To do so, we can execute the below command.

```sh
docker bimages  .
```
<img width="571" alt="image" src="https://github.com/user-attachments/assets/5ce21069-1fa9-4ccc-87e3-dfbf1dddd066" />


### 4. Run the Docker Container

After building the image, you can run the container with:

```sh
docker run -p 8081:8080 springboot-docker-demo
```

Now, your Spring Boot application should be accessible at `http://localhost:8081/welcome`.

<img width="950" alt="image" src="https://github.com/user-attachments/assets/e6701492-2ac4-46db-8bcd-5d1faa98cb04" />

<img width="960" alt="image" src="https://github.com/user-attachments/assets/65c5450a-a45b-4057-b2a0-a61a9f88612d" />


### 5. Check Running Containers

To check if the container is running, use:

```sh
docker ps
```

<img width="861" alt="image" src="https://github.com/user-attachments/assets/0eed520c-35fc-44dc-ade2-b6c0bd35d175" />


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

<img width="727" alt="image" src="https://github.com/user-attachments/assets/dd09ef63-8c27-4c10-946d-406b4c8f1ddc" />

## Conclusion

You have successfully Dockerized your Spring Boot application and can now run it inside a container!

