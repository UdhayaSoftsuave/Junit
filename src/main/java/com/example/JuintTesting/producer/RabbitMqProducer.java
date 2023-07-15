package com.example.JuintTesting.producer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RabbitMqProducer {

    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        log.info("Publishing {} ",message);
        rabbitTemplate.convertAndSend("testing_exchange","testing_key" , message);
    }
}
