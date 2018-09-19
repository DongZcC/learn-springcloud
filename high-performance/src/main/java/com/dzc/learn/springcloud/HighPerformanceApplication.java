package com.dzc.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HighPerformanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HighPerformanceApplication.class, args);
    }
}
