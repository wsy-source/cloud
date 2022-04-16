package com.cloud.controller;

import com.cloud.bean.CommonResult;
import com.cloud.bean.Payment;
import com.cloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/hystrix/timeout/{id}")

    @HystrixCommand(fallbackMethod = "",commandProperties = @HystrixProperty(name = "execution ",value = ""))
    public CommonResult<Payment> testHystrix(@PathVariable("id") Long id){

        return null;
    }
}
