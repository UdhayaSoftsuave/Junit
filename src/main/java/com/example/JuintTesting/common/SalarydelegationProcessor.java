package com.example.JuintTesting.common;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public class SalarydelegationProcessor implements SalaryProcessor{

    private final List<SalaryProcessor> processors;
    public SalarydelegationProcessor(List<SalaryProcessor> processors){
        this.processors=processors;
    }

    @Override
    public Mono<ResponseEntity> process(Salary salary) {
        if (salary.getClass().isAnnotationPresent(SalaryProcessedBy.class)){
            SalaryProcessedBy annotation = salary.getClass().getAnnotation(SalaryProcessedBy.class);
            Optional<SalaryProcessor> found = processors.stream()
                    .filter(processor -> annotation.value().isInstance(processor))
                    .findFirst();
            if (found.isPresent()){
                return found.get().process(salary);
            }
            return Mono.error(new RuntimeException());
        }
        return null;
    }
}
