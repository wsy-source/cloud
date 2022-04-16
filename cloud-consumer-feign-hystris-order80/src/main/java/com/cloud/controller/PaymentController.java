package com.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

//    @Autowired
//    private PaymentService paymentService;

    @GetMapping("/consumer/testHystrix/{id}")
    @HystrixCommand(fallbackMethod = "test",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //3秒钟以内就是正常的业务逻辑
    })
    public String testHystrix(@PathVariable("id") Long id) throws InterruptedException {
        int n = 10 /0;

        return "paymentCommonResult";
    }

    public String test(@PathVariable("id") Long id){
        return "服务器降级了！";
    }
}
