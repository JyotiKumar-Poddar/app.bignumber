# RestFull service to get the next big number

Create a RESTful API.
As as input it will get a number, as an output it should respond with next (bigger) number
composed of the same digits as in input (base 10). If it is not possible to generate such number
respond should be “No answer”.

The API endpoints:

GET /api/nextbignumber/{number} – returns the next big Number if the next big number generation is not possible it will return "No Answer"
the valid ragne of input is in between 0, 9223372036854775807
## Requirements

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Gradle](https://gradle.org/)

## Getting Started

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `BigNumberApplication,class` class from your IDE.

Alternatively you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/html/) like so:

```shell
gradle bootRun
```
## Application deployed on heroku

Status check: https://app-nextbignumber.herokuapp.com/actuator

GET https://app-nextbignumber.herokuapp.com/api/nextbignumber/1111 -> No Answer
GET https://app-nextbignumber.herokuapp.com/api/nextbignumber/1234 -> 1243
