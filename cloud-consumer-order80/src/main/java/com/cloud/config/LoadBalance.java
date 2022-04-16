package com.cloud.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;


public interface LoadBalance {
    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);
}
