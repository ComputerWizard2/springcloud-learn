package com.luckye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages="com.luckye")
@EnableEurekaClient
@EnableDiscoveryClient//服务发现的标签的开启
public class PayMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMain8001.class,args);
    }
}
