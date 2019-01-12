# RestFull service to get the next big number

Create a RESTful API.
As as input it will get a number, as an output it should respond with next (bigger) number
composed of the same digits as in input (base 10). If it is not possible to generate such number
respond should be “No answer”.

The API endpoints:

GET /api/nextbignumber/{number} – returns the next big Number

## Requirements

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle](https://gradle.org/)

## Getting Started

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `BigNumberApplication,class` class from your IDE.

Alternatively you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/) like so:

```shell
gradle bootRun
```


