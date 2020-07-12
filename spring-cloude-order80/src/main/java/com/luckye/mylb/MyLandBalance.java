package com.luckye.mylb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLandBalance {

    public ServiceInstance getInstance(List<ServiceInstance> instances);
}
