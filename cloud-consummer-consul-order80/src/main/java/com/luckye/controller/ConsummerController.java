package com.luckye.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consummer")
public class ConsummerController {

    public final static  String   SERVER_POR ="http://consul-provider-payment/payment";

    @Resource
    RestTemplate restTemplate;
    @RequestMapping("/getconsul")
    public  String getConsulInfo(){


        return  restTemplate.getForObject(SERVER_POR+"/getconsul",String.class);
    }
}
