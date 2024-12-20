# Spring CQRS

## Overview
1. Spring JPA integrated with `PostGRES` and `Redis`.
2. Spring Modulith and JMolecules with `ArchUnit` tests to validate module and hexagonal architecture.
3. Mapping functions leveraging `Mapstructs`.
4. Example CQRS implementation.
5. Example Event Sourcing implementation.
6. Swagger API Documentation.

## Running the Application
1. Execute `gradlew bootRun`.  This will spin up needed `Redis` and `PostGRES` docker containers in addition to starting the application.
2. Open [Swagger UI](http://localhost:8080/swagger-ui.html) in a browser.
3. Use the `POST /products` API to create a product.
    ```json
        {
          "name": "Monster",
          "description": "Scary Monster",
          "sku": "1qaz-2wsx"
        }
    ```

This will cause the application to trigger an application event that will store a representation of the product in `Redis`.  A `PostGRES` database is used for creating, updating, and deleting products while `Redis` is used for performing reads.  Executing the `POST /products` API from swagger will have the product representation stored from `PostGRES`.  Executing the `GET /products` API from swagger will have the product representation returned from `Redis`.
 
### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/gradle-plugin/packaging-oci-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#features.docker-compose)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.flyway)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#actuator)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/docs/3.3.4/reference/htmlsingle/index.html#data.nosql.redis)
* [Spring Modulith](https://docs.spring.io/spring-modulith/reference/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* redis: [`redis:latest`](https://hub.docker.com/_/redis)

Please review the tags of the used images and set them to the same as you're running in production.

