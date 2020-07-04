package com.luckye.controller;

import com.luckye.entities.CommonResult;
import com.luckye.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("consummer")
public class OrderController {

    //真他妈的搞笑呀！！忘记加http Google浏览器给省略了，我就忘记加http协议了，
    //public final static  String PATH_URL="http://localhost:8002/payment";
    public final static  String PATH_URL= "http://CLOUD-PAYMENT-SERVICE/payment";
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("get/{id}")
    public CommonResult<Payment> getPayement(@PathVariable("id")Long id){
        log.info("----->"+id);

        log.info(PATH_URL+"/get/"+id);
       return restTemplate.getForObject(PATH_URL+"/get/"+id,CommonResult.class);

    }

    @RequestMapping("/create")

    public CommonResult<Payment> create(Payment payment){
         log.info("---->"+payment);
        return restTemplate.postForObject(PATH_URL+"/create",payment,CommonResult.class);
    }

}
