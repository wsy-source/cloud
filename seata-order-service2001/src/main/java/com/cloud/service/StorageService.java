package com.cloud.service;

import com.cloud.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease/{productId}/{count}")
    CommonResult decrease(@PathVariable("productId") Long productId,@PathVariable("count") Integer count);

}
