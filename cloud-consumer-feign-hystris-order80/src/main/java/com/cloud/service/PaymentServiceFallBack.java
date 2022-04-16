package com.cloud.service;

import com.cloud.bean.CommonResult;
import com.cloud.bean.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallBack implements PaymentService{
    @Override
    public CommonResult<Payment> testHystrix(Long id) {
        CommonResult<Payment> objectCommonResult = new CommonResult<>();
        objectCommonResult.setCode(404);
        objectCommonResult.setMessage("服务器找不到了！");
        return objectCommonResult;
    }
}
