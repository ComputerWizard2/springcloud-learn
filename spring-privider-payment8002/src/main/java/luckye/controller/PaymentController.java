package luckye.controller;

import com.luckye.entities.CommonResult;
import com.luckye.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import luckye.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("payment")
class PaymentController {

    @Autowired
    private PaymentService payementService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        boolean flag = payementService.create(payment);
       log.debug("=======>插入的结果：" + flag);
        if (flag) {
            return new CommonResult(200, "插入一条账单成功"+serverPort);
        } else {
            return new CommonResult(446, "插入一条流水数据失败"+serverPort);
        }


    }
    @ResponseBody
    @GetMapping(value="/get/{id}")
    public CommonResult findPaymentById(@PathVariable("id") Long id) {

        Payment paymentById = payementService.findPaymentById(id);
        log.info("查询结果" + paymentById);

        if (paymentById != null) {

            return new CommonResult(200, serverPort+"成功", paymentById);

        }

        return new CommonResult(433, serverPort+"失败");


    }

    @DeleteMapping()
    public CommonResult deletePaymentById(@PathVariable("id") Long id) {
        boolean b = payementService.deletPaymentById(id);
        if (b) {
            return new CommonResult(200, "删除成功");
        }
        return new CommonResult(400, "删除失败");

    }
    @RequestMapping("/paymentFeignTimeOut")
    public String paymentFeignTimeOut(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "请求成功！！！";


    }


}
