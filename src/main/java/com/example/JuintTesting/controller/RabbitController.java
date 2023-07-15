package com.example.JuintTesting.controller;

import com.example.JuintTesting.producer.RabbitMqProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RabbitController {

    private RabbitMqProducer rabbitMqProducer;

    @GetMapping("/{name}")
    public String publishMsg(@PathVariable("name") String name){
        rabbitMqProducer.sendMessage(name);
        return "Message Published!!";
    }
}
