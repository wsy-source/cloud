package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/payment/get/{id}")
    public String getSerial(@PathVariable Long id){
        return UUID.randomUUID().toString()+id;
    }

    @GetMapping("/testA")
    @SentinelResource(value = "/testA",blockHandler = "dealTestA")
    public String testA(@RequestParam(value = "q", required = false) String q) {
        log.info(q);
        log.info(Thread.currentThread().getName());
        return "----------testA";
    }

    public String dealTestA(String q, BlockException blockException){
        return  "----------dealTestA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "----------testB";
    }
}
