package com.example.JuintTesting.producer;

import com.example.JuintTesting.dto.Student;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RabbitMqJsonProducer {

    private RabbitTemplate rabbitTemplate;

    public void sendMessage(Student student){
        log.info("Publishing {} ",student.toString());
        rabbitTemplate.convertAndSend("testing_exchange_json","testing_key_json" , student);
    }

}
