package com.cloud.dao;

import com.cloud.bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {

    void createOrder(Order order);

    void updateStatusById(@Param("userId") Long userId, @Param("status") Integer status);
}
