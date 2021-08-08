package com.learn.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class LoggingApplication {

    private static final Logger logger = LoggerFactory.getLogger(LoggingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    @RequestMapping("/hello")
    String home() {
        logger.info("HElLO WORLD!!!");
        System.out.println("hello world!!!");
        return "helloworld";
    }

    @RequestMapping("/hello2")
    String home2() {
        logger.info("HElLO WORLD222!!!");
        // Make an exception.
        System.out.println("a:" + 10/0);
        return "helloworld";
    }

}
