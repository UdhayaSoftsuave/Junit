package com.example.JuintTesting.consumer;

import com.example.JuintTesting.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMqJsonConsumer {

    @RabbitListener(queues = {"testing_queue_json"})
    public void consume(Student student){
        log.info("Consumed message : " + student.toString());
    }
}
