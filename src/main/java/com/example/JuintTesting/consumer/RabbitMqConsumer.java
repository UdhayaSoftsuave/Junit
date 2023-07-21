package com.example.JuintTesting.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class RabbitMqConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String result = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("Consumed message : " +  result.substring(1, result.length()-1));
    }
}
