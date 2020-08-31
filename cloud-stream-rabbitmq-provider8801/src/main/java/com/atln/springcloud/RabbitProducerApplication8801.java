package com.atln.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class RabbitProducerApplication8801 {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication8801.class,args);
    }
}
