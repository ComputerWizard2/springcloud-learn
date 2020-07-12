package com.luckye.springcloud.service.impl;

import com.luckye.springcloud.service.FeiginService;
import org.springframework.stereotype.Component;

@Component
public class FeiginServiceImpl {
   // @Override
    public String isOk(Long id) {
        return "对该服务进行熔断降级策略，备胎已经启用！！！";
    }

   // @Override
    public String isSleep(Long id) {
        return "对该服务进行熔断降级策略，备胎已经启用！！！";

    }
}
