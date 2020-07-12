package com.luckye.springcloud.service;

import com.luckye.entities.CommonResult;
import com.luckye.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface FeignService {
    @RequestMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @RequestMapping("/payment/create")
    public CommonResult<Payment> createPayment(Payment payment);

    @RequestMapping("/payment/paymentFeignTimeOut")
    public String  getTimeOut();

}
