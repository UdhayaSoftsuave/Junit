package com.example.JuintTesting.consumer;

import com.example.JuintTesting.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class RabbitMqJsonConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        log.info("Consumed message : " + new String(message.getBody(), StandardCharsets.UTF_8));
    }
}
