package com.luckye.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/payment")
@RestController
@Slf4j
public class Payment8004Controller {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/zk")
    public String getZpInfor(){
        return "springcloud with  zookeeper :"+ serverPort +"\t" + UUID.randomUUID().toString();
    }
}
