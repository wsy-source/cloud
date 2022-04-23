package com.cloud.controller;

import com.cloud.CommonResult;
import com.cloud.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result > 0 ){
            log.info("插入结果为:{}",result+"---"+serverPort);
            return  new CommonResult(200,"插入成功",result);
        }else {
            log.error("插入结果为：{}",result);
            return  new CommonResult(404,"插入失败",null);
        }
    }

    @GetMapping("/payment/test")
    public String test(){
        return this.serverPort;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id) throws InterruptedException {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            log.info("插入成功！{}",payment+"----"+serverPort);
            return new CommonResult(200,"查询成功",payment);
        }else {
            log.error("插入失败");
            return new CommonResult(404,"查询失败，没有对应记录！"+id,null);
        }
    }

}
