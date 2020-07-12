package com.luckye.springcloud.sevice.impl;

import com.luckye.springcloud.sevice.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.ConcurrentModificationException;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentSerivceImpl implements PaymentService {
    @Override
    public String isOk(Long id) {

        return "当前的线程为"+id+"的服务在线程的"+Thread.currentThread().getName()+"已经启动了！！";
    }

    /**
     * 服务降级，
     * @param id
     * @return
     */

    @Override
    @HystrixCommand(fallbackMethod = "isSleep_resove",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//数组的属性

    })
    public String isSleep(Long id)  {
        int time_out=5;
        try {
            //throw  new ConcurrentModificationException();

            TimeUnit.SECONDS.sleep(time_out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "当前的id为"+id+"的服务在"+Thread.currentThread().getName()+"已经启动了！！！";
    }

    public String isSleep_resove(Long id){

        return "我竟然是一个一个备胎,问题出现在8001的服务端，噗～"+id;
    }


}
