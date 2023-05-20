package com.example.JuintTesting.Controller;

import com.example.JuintTesting.Entity.SalaryEntity;
import com.example.JuintTesting.annotation.CustomAnnotation;
import com.example.JuintTesting.common.Salary;
import com.example.JuintTesting.common.SalaryProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

@RestController
@RequestMapping("/salary")
@Slf4j

public class SalaryController {

    private final SalaryProcessor<Salary> salaryProcessor;

    @Inject
    public SalaryController(SalaryProcessor<Salary> salaryProcessor) {
        this.salaryProcessor = salaryProcessor;
    }

    @GetMapping
    public Mono<ResponseEntity> getHeaders(@CustomAnnotation SalaryEntity salaryEntity){
        log.info("Salary employee id : "+ salaryEntity.getEmployeeId());

        Mono<ResponseEntity> process = salaryProcessor.process(salaryEntity);
        process.subscribe( a -> log.info("Respose from Service + "+ a));
        return process;
    }
}
