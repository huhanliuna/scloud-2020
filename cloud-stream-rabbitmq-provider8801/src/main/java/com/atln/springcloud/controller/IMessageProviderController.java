package com.atln.springcloud.controller;


import com.atln.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IMessageProviderController {

    @Resource
    private IMessageProvider iMessageProvider;

    @RequestMapping(value = "sendMessage")
    public String sendMessage(){
        String message = iMessageProvider.sendMessage();
        return message;
    }
}
