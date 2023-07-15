package com.example.JuintTesting.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqConsumer {

    @RabbitListener(queues = {"testing_queue"})
    public void consume(String message){
         log.info("Consumed message : " + message);
    }
}
