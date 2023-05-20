package com.example.JuintTesting.common;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Component
public interface SalaryProcessor<C extends Salary> {

    Mono<ResponseEntity> process(C salary);
}
