package com.atln.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalance {
    AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncreate(){
        int current;
        int next;
        while (true){
            current=atomicInteger.get();
            next=current>=Integer.MAX_VALUE?0 : (current+1);
            if (atomicInteger.compareAndSet(current,next)){
                break;
            }
        }
        return next;

    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncreate() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
