package com.luckye.controller;

import com.luckye.entities.CommonResult;
import com.luckye.entities.Payment;
import com.luckye.mylb.MyLandBalance;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("consummer")
public class OrderController {
    @Resource
    DiscoveryClient discoveryClient;

    //注册进入实现的轮训算法
    @Resource
    MyLandBalance myLandBalance;
    //真他妈的搞笑呀！！忘记加http Google浏览器给省略了，我就忘记加http协议了，
    //public final static  String PATH_URL="http://localhost:800/payment";
    public final static  String PATH_URL= "http://CLOUD-PAYMENT-SERVICE/payment";
    @Resource
    RestTemplate restTemplate;

    @RequestMapping("get/{id}")
    public CommonResult<Payment> getPayement(@PathVariable("id")Long id){
        //log.info("----->"+id);

        log.info(PATH_URL+"/get/"+id);
       return restTemplate.getForObject(PATH_URL+"/get/"+id,CommonResult.class);

    }

    @RequestMapping("getPayemntForEntities/{id}")
    public ResponseEntity<CommonResult> getPaymentForEntities(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PATH_URL + "/get/" + id, CommonResult.class);
        log.info(forEntity.toString());
        return restTemplate.getForEntity(PATH_URL+"/get/"+id,CommonResult.class);

    }

    @RequestMapping("/create")

    public CommonResult<Payment> create(Payment payment){
         log.info("---->"+payment);
        return restTemplate.postForObject(PATH_URL+"/create",payment,CommonResult.class);
    }
    //测试自己的轮训算法
    @RequestMapping("/getlb/{id}")
    public CommonResult getPaymmentForMyLB(@PathVariable("id")Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        log.error(instances.toString());
        if (instances==null||instances.size()<=0)
        {
            return new CommonResult();
        }
        ServiceInstance instance = myLandBalance.getInstance(instances);

        URI uri = instance.getUri();

        CommonResult forObject = restTemplate.getForObject(uri + "/payment/get/" + id, CommonResult.class);
        return forObject;

    }


}
