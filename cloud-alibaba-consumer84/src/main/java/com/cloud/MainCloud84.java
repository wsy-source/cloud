package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainCloud84 {
    public static void main(String[] args){
        SpringApplication.run(MainCloud84.class,args);
    }
}
