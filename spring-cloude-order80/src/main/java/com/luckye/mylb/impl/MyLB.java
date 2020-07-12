package com.luckye.mylb.impl;

import com.luckye.mylb.MyLandBalance;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements MyLandBalance {

     private AtomicInteger atomicInteger=new AtomicInteger();

     public final int getInstance(){
         int current;
         int next;
         do{
             current=this.atomicInteger.get();
             next=current>Integer.MAX_VALUE?0:current+1;
         }while(!atomicInteger.compareAndSet(current,next));
         log.error("这是文件第"+next+"次访问服务器");
         return next;

     }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {
        int instance = getInstance();
        val i = instance % instances.size();
        return instances.get(i);

    }
}
