package com.luckye.springcloud.controller;

import com.luckye.springcloud.sevice.PaymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/payment")
@RestController
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @RequestMapping("/getok/{id}")
    public String getIsOk(@PathVariable("id") Long id){
        String ok = paymentService.isOk(id);

        return ok;


    }

    @RequestMapping("/getsleep/{id}")
    public String getSpleep(@PathVariable("id") Long id){

        String sleep = paymentService.isSleep(id);

        return sleep;


    }
}
