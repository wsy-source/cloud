package com.cloud.controller;

import com.cloud.CommonResult;
import com.cloud.Payment;
import com.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if (result > 0 ){
            log.info("插入结果为:{}",result);
            return  new CommonResult(200,"插入成功",result);
        }else {
            log.error("插入结果为：%d",result);
            return  new CommonResult(404,"插入失败",null);
        }
    }

    @GetMapping("/payment/test")
    public String test(){
        return this.serverPort;
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            log.info("插入成功！{}",payment);
            return new CommonResult<Payment>(200,"查询成功",payment);
        }else {
            log.error("插入失败");
            return new CommonResult(404,"查询失败，没有对应记录！"+id,null);
        }
    }

    @GetMapping("payment/discovery")
    public Object discover(){
        List<String> services = discoveryClient.getServices();
        services.forEach(log::info);
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(serviceInstance -> {
            URI uri = serviceInstance.getUri();
            String serviceId = serviceInstance.getServiceId();
            log.info("uri:{}'\t'serviceId:{}",uri.toString(),serviceId);
        });
        return discoveryClient;
    }

}
