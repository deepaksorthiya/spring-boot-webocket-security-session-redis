<h1 style="text-align: center;">Spring boot websocket with security and redis based session</h1>

<p style="text-align: center;">
  <a href="https://github.com/deepaksorthiya/spring-boot-webocket-security-session-redis/actions/workflows/maven-jvm-non-native-build.yml">
    <img src="https://github.com/deepaksorthiya/spring-boot-webocket-security-session-redis/actions/workflows/maven-jvm-non-native-build.yml/badge.svg" alt="Build Status"/>
  </a>
  <a href="https://hub.docker.com/r/deepaksorthiya/spring-boot-webocket-security-session-redis">
    <img src="https://img.shields.io/docker/pulls/deepaksorthiya/spring-boot-webocket-security-session-redis" alt="Docker"/>
  </a>
  <a href="https://spring.io/projects/spring-boot">
    <img src="https://img.shields.io/badge/spring--boot-3.5.5-brightgreen?logo=springboot" alt="Spring Boot"/>
  </a>
</p>

## Live Demo

TBD

---

## 📑 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Requirements](#-requirements)
- [Getting Started](#-getting-started)
    - [Clone the Repository](#1-clone-the-repository)
    - [Start Docker](#2-start-docker)
    - [Build the Project](#3-build-the-project)
    - [Run Project Locally](#4-run-the-project)
    - [Build Docker Image](#5-optional-build-docker-image-docker-should-be-running)
    - [Run Docker Image](#6-optional-running-on-docker)
    - [Deploy on Kubernetes with Helm](#7-optionalrun-on-local-minikube-kubernetes-using-helm-chart)
- [Testing](#-testing)
- [Clean Up](#-cleanup)
- [Reference Documentation](#-reference-documentation)
- [Guides](#-guides)

---

## 🚀 Overview

A modern **Spring Boot** websocket with security and redis based session support.

---

## 🚀 Features

- Spring Boot 3.5.5 (Java 24)
- RESTful API with CRUD endpoints
- Spring Data JPA (H2 in-memory DB)
- Actuator endpoints enabled
- Async & scheduled tasks
- Docker & multi-stage build
- Kubernetes manifests & Helm chart
- GitHub Actions CI/CD

---

## 📦 Requirements

- Git `2.51.0+`
- Java `24`
- Maven `3.9+`
- Spring Boot `3.5.5`
- (Optional)Docker Desktop (tested on `4.42.0`)
- (Optional) Minikube/Helm for Kubernetes

---

## 🛠️ Getting Started

### 1. Clone the Repository

```sh
git clone https://github.com/deepaksorthiya/spring-boot-webocket-security-session-redis.git
cd spring-boot-webocket-security-session-redis
```

### 2. Start Docker

```sh
docker compose up
```

### 3. Build the Project

```sh
./mvnw clean package -DskipTests
```

OR

for native build run

```bash
./mvnw clean native:compile -Pnative
```

### 4. Run the Project

```sh
./mvnw spring-boot:run
```

OR Jar file

```sh
java -jar .\target\spring-boot-webocket-security-session-redis-0.0.1-SNAPSHOT.jar
```

OR

Run native image directly

```bash
target/spring-boot-webocket-security-session-redis
```

### 5. (Optional) Build Docker Image (docker should be running)

```sh
./mvnw clean spring-boot:build-image -DskipTests
```

OR

To create the native container image, run the following goal:

```bash
./mvnw spring-boot:build-image -Pnative
```

### 6. (Optional) Running On Docker

```sh
docker run -p 8080:8080 --name spring-boot-webocket-security-session-redis deepaksorthiya/spring-boot-webocket-security-session-redis:latest
```

### 7. (Optional)Run on Local minikube Kubernetes using Helm Chart

```sh
cd helm
helm create spring-boot-webocket-security-session-redis
helm lint spring-boot-webocket-security-session-redis
helm install spring-boot-webocket-security-session-redis --values=spring-boot-webocket-security-session-redis/values.yaml spring-boot-webocket-security-session-redis
helm install spring-boot-webocket-security-session-redis spring-boot-webocket-security-session-redis
helm uninstall spring-boot-webocket-security-session-redis
```

---

## 🧪 Testing

- Access the API: [http://localhost:8080](http://localhost:8080)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### Postman API Collection

TBD

### Rest API Endpoints

TBD

### Run Unit-Integration Test Cases

```bash
./mvnw clean test
```

To run your existing tests in a native image, run the following goal:

```bash
./mvnw test -PnativeTest
```

---

## 🧹 Cleanup

```sh
docker compose down -v
```

---

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.5/maven-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.5.5/maven-plugin/build-image.html)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/3.5.5/reference/packaging/native-image/introducing-graalvm-native-images.html)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/3.5.5/reference/testing/testcontainers.html#testing.testcontainers)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.5.5/reference/actuator/index.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.5.5/reference/web/servlet.html)
* [WebSocket](https://docs.spring.io/spring-boot/3.5.5/reference/messaging/websockets.html)
* [Thymeleaf](https://docs.spring.io/spring-boot/3.5.5/reference/web/servlet.html#web.servlet.spring-mvc.template-engines)
* [Spring Security](https://docs.spring.io/spring-boot/3.5.5/reference/web/spring-security.html)
* [Spring Session for Spring Data Redis](https://docs.spring.io/spring-session/reference/)
* [Validation](https://docs.spring.io/spring-boot/3.5.5/reference/io/validation.html)
* [Testcontainers](https://java.testcontainers.org/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Using WebSocket to build an interactive web application](https://spring.io/guides/gs/messaging-stomp-websocket/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Additional Links
These additional references should also help you:

* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/3.5.5/how-to/aot.html)

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks
If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./mvnw spring-boot:build-image -Pnative
```

Then, you can run the app like any other container:

```
$ docker run --rm -p 8080:8080 spring-boot-webocket-security-session-redis:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools
Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./mvnw native:compile -Pnative
```

Then, you can run the app as follows:
```
$ target/spring-boot-webocket-security-session-redis
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./mvnw test -PnativeTest
```


### Testcontainers support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/3.5.5/reference/features/dev-services.html#features.dev-services.testcontainers).

Testcontainers has been configured to use the following Docker images:


Please review the tags of the used images and set them to the same as you're running in production.