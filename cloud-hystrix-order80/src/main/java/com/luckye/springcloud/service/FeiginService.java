package com.luckye.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value="CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface FeiginService {

    @RequestMapping("/payment/getok/{id}")
    public String isOk(@PathVariable("id") Long id);

    @RequestMapping("payment/getsleep")
    public String isSleep(@PathVariable("id") Long id);

}
