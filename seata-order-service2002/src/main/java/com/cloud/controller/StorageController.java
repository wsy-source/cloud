package com.cloud.controller;

import com.cloud.CommonResult;
import com.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease/{productId}/{count}")
    public CommonResult decrease(@PathVariable("productId") Long productId,@PathVariable("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"库存修改成功");
    }

}
