package com.example.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HostelEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HostelEurekaApplication.class, args);
    }

}
