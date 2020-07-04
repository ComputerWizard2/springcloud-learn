package com.luckye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderMainApp {


    public static void main(String[] args) {
        SpringApplication.run(OrderMainApp.class,args);
    }
}
