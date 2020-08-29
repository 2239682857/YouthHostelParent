package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HostelWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(HostelWebApplication.class, args);
    }

}
