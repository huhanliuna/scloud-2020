package com.atln.springcloud.service.impl;

import com.atln.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(value = Source.class)
@Slf4j
public class IMessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String sendMessage() {
        String value=UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(value)
                .setHeader("partitionKey", value)
                .build());
        log.info("-------------------"+value);
        return value;
    }
}
