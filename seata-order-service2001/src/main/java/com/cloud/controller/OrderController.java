package com.cloud.controller;

import com.cloud.CommonResult;
import com.cloud.bean.Order;
import com.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/create")
    public CommonResult createOrder(Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"创建订单成功",order);
    }
}
