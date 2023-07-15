package com.example.JuintTesting.controller;

import com.example.JuintTesting.dto.Student;
import com.example.JuintTesting.producer.RabbitMqJsonProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RabbitJsonController {

    private RabbitMqJsonProducer rabbitMqProducer;

    @GetMapping("/student")
    public String publishMsg(@RequestBody Student student){
        rabbitMqProducer.sendMessage(student);
        return "Message Published!!";
    }
}
