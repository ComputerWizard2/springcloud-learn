package com.luckye.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/getconsul")
    public String getConsul(){

        return "springcloud registory is "+serverPort+"/t"+ UUID.randomUUID();
    }
}
