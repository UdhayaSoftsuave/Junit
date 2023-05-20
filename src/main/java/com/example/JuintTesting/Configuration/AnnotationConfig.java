package com.example.JuintTesting.Configuration;

import com.example.JuintTesting.annotation.CustomAnnotationResolver;
import com.example.JuintTesting.common.SalaryProcessor;
import com.example.JuintTesting.common.SalarydelegationProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.method.annotation.ArgumentResolverConfigurer;

import javax.inject.Inject;
import java.util.List;

@Configuration
@Slf4j
public class AnnotationConfig implements WebFluxConfigurer {

    @Inject
    private ObjectMapper objectMapper;

    @Override
    public void configureArgumentResolvers(ArgumentResolverConfigurer configurer) {
        log.info("AnnotaionConfig called!!" + "ObjectMapper : "+ objectMapper);
        configurer.addCustomResolver(new CustomAnnotationResolver(new Jackson2JsonDecoder(objectMapper)));
    }
    @Bean
    public SalaryProcessor processors(List<SalaryProcessor> processors){
        return new SalarydelegationProcessor(processors);
    }
}
