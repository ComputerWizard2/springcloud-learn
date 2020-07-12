package com.luckye.springcloud.controller;

import com.luckye.entities.CommonResult;
import com.luckye.entities.Payment;
import com.luckye.springcloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("consummer")
@Slf4j
public class OrderController {
    @Resource
    FeignService feignService;

    @RequestMapping("/get/{id}")
    public CommonResult getProviderByFein(@PathVariable("id") Long id){

        CommonResult<Payment> paymentById = feignService.getPaymentById(id);
        return paymentById;
    }

    @PostMapping("/create")
    public CommonResult<Payment> createPaymentByFeign(Payment payment){

        log.info("payment"+payment);
        CommonResult<Payment> result = feignService.createPayment(payment);

        return result;
    }

    @RequestMapping("gettimeout")
    public String getTimeOut (){

        String timeOut = feignService.getTimeOut();

        return timeOut;

    }


}
