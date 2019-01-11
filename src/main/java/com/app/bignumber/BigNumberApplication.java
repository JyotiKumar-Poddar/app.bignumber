package com.app.bignumber;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BigNumberApplication {

    @Value("${api.welcome-message}")
    public String welcomeMessage;

    @GetMapping(path = "/")
    public String getHome() {
        return welcomeMessage;
    }

    public static void main(String[] args) {
        SpringApplication.run(BigNumberApplication.class, args);
    }

}

