package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MainOrder80 {
    public static void main(String[] args){
        SpringApplication.run(MainOrder80.class,args);
    }
}
