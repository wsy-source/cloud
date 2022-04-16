package com.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FeignConfig {

    //开启feign日志级别！
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.FULL;
    }
}
