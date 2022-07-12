# frankolcar

An example of a RESTful WebServer developed using Spring & SpringBoot.

This simple server acts a Frank Car Garage Resale BAckend Application - it will return details of a warehouse details.

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

You will need:

 - Java JDK 8 or higher
 - Maven 3.1.1 or higher
 - Git
 - Clone the project and use Maven to build the server

 `$ mvn clean install`

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.frank.FrankolcarApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Running the test cases

There are several ways to test a Spring Boot application on your local machine. One way is to run class in the `com.frank.FrankolAppControllerTest` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn clean test
```

### Contact

Adarsh Agarwal - adarsh.agar211@gmail.com

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
