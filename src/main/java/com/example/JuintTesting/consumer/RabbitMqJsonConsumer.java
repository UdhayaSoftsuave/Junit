package com.example.JuintTesting.consumer;

import com.example.JuintTesting.dto.Student;
import com.example.JuintTesting.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.utils.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
public class RabbitMqJsonConsumer implements MessageListener {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void onMessage(Message message) {
        log.info("Consumed message : " + new String(message.getBody(), StandardCharsets.UTF_8));
    }

    @RabbitListener(queues = {"testing_queue_json"})
    public void consume(Student message) {
        log.info("consumes 123: {}",message);
        Mono<Student> log1 = studentRepository.save(message).log();
        log.info("Saves : {} ", log1);
    }
}
