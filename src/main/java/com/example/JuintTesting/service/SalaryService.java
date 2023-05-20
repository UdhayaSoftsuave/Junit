package com.example.JuintTesting.service;

import com.example.JuintTesting.Entity.SalaryEntity;
import com.example.JuintTesting.common.SalaryProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Component
public class SalaryService implements SalaryProcessor<SalaryEntity> {

    @Override
    public Mono<ResponseEntity> process(SalaryEntity salary) {
        log.info("Service is called");
        salary.setAmount(1);
        return Mono.just(salary).map(ResponseEntity::ok);
    }
}
