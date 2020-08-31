package com.atln.springcloud.service;

import com.atln.springcloud.model.CommonResult;
import com.atln.springcloud.model.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author EiletXie
 * @Since 2020/3/18 14:57
 */
@Component
public class PaymentFallbackService implements PaymentService{


    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，---PaymentFallbackService",new Payment(id,"ErrorSerial"));
    }
}
