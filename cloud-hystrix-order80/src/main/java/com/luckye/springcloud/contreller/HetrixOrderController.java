package com.luckye.springcloud.contreller;

import com.luckye.springcloud.service.FeiginService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consummer")
@Slf4j
@DefaultProperties(defaultFallback = "defaultGlobleMethond")
public class HetrixOrderController {

    @Resource
    FeiginService feiginService;

    @RequestMapping("/getok/{id}")
    public String  getOk(@PathVariable("id") Long id){

        return feiginService.isOk(id);

    }
    //干掉局部的降级方法，来测试全局的配置是否起效
    @RequestMapping("/getsleep/{id}")
   //@HystrixCommand(fallbackMethod = "paymentTimeOutFallBack" ,commandProperties = {
   //       @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")
  //  })
    @HystrixCommand
    public String gerIsleep(@PathVariable("id") Long id){
            int age =10 /0;
        return feiginService.isSleep(id);
    }
    //这个是局部的服务降级的方法
   public String paymentTimeOutFallBack(@PathVariable("id")Long id){
       return "我是消费者80端，对方的支付系统繁忙请10秒后再试或者自己运行出错，请检查自己的问题";
   }

    //这个是全局的服务降级的方法
   public String defaultGlobleMethond(){

        return "这个是全局的方法，如果没有falbackMethod ，就用我来顶一顶";
   }


}
