package com.donvv.logintest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class LogintestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogintestApplication.class, args);
    }

}
