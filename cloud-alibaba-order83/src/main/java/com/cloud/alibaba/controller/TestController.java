package com.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Value("${service.paymentUrl}")
    public  String serverUrl;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/nacos/get/{id}")
    public String sayHello(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverUrl+"/payment/nacos/get/"+ id,String.class);
    }
}
