package com.cloud.service;

import com.cloud.CommonResult;
import com.cloud.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE",fallback = PaymentServiceFallBack.class)
public interface PaymentService {

    @GetMapping("/payment/hystrix/timeout/{id}")
    CommonResult<Payment> testHystrix(@PathVariable("id") Long id);
}
