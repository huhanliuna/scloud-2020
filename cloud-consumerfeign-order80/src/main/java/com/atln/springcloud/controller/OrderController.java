package com.atln.springcloud.controller;

import com.atln.springcloud.model.CommonResult;
import com.atln.springcloud.model.Payment;
import com.atln.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){
        CommonResult<Payment> paymentById = orderService.getPaymentById(id);
        return paymentById;
    }


}
