package com.cloud.service.impl;

import com.cloud.bean.Order;
import com.cloud.dao.OrderDao;
import com.cloud.service.AccountService;
import com.cloud.service.OrderService;
import com.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao       orderDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService service;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("开始创建订单");
        orderDao.createOrder(order);
        log.info("创建订单结束！");
        log.info("=============================================");
        log.info("开始调用库存模块");
        service.decrease(order.getProductId(), order.getCount());
        log.info("调用库存扣减模块结束");
        log.info("=============================================");
        int a = 10 / 0;
        log.info("开始调用账户模块");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("调用账户模块结束");
        log.info("=============================================");
        log.info("开始修改订单");
        orderDao.updateStatusById(order.getId(), order.getStatus());
        log.info("结束修改订单");
    }
}
