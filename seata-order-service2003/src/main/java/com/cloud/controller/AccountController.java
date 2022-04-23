package com.cloud.controller;

import com.cloud.CommonResult;
import com.cloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/{userId}/{money}")
    public CommonResult decrease(@PathVariable("userId") Long userId , @PathVariable("money")BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"减少余额成功");
    }
}
