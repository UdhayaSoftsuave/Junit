package com.example.JuintTesting.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    //create a queue
    @Bean
    public Queue queue(){
        return  new Queue("testing_queue");
    }

    @Bean
    public Queue queueJson(){
        return  new Queue("testing_queue_json");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("testing_exchange");
    }

    @Bean
    public TopicExchange topicExchangeJson(){
        return new TopicExchange("testing_exchange_json");
    }

    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with("testing_key");
    }

    @Bean
    public Binding bindingJson(){
        return BindingBuilder
                .bind(queueJson())
                .to(topicExchangeJson())
                .with("testing_key_json");
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}
