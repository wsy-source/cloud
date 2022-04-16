package com.cloud.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//@Component
public class LoadBalanceImpl implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private Integer  count;
    private Integer next;
    public Integer getServiceIndex() {
        do {
             count = atomicInteger.get();
             next = count < Integer.MAX_VALUE ?  count + 1 : 0 ;
        } while (!atomicInteger.compareAndSet(count, next));
        return next;
    }
    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        int index = getServiceIndex() % serviceInstances.size();
        ServiceInstance serviceInstance = serviceInstances.get(index);
        return serviceInstance;
    }
}
