package com.luckye.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Bean
    @LoadBalanced//需要规定一个负载均衡机制
    public RestTemplate getRestTemplete(){

        return  new RestTemplate();
    }
}