package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-sentinel-com.cloud.bean.service")
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
     String getSerial(@PathVariable("id") Long id);
}
