package com.cloud.service;

import com.cloud.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@FeignClient("seata-account-service")
public interface AccountService {

    @PostMapping("/account/{userId}/{money}")
    CommonResult decrease(@PathVariable("userId") Long userId, @PathVariable("money") BigDecimal money);

}
