package com.cloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/get/{id}")
    public String getNacos(@PathVariable Long id) {
        return "hello world!" + serverPort + "\t" + id;
    }
}
