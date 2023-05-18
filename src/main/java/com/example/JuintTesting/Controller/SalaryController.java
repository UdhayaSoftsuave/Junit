package com.example.JuintTesting.Controller;

import com.example.JuintTesting.Entity.SalaryEntity;
import com.example.JuintTesting.annotation.CustomAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
@Slf4j
public class SalaryController {

    @GetMapping
    public Integer getHeaders(@CustomAnnotation SalaryEntity salaryEntity){
        log.info("Salary employee id : "+ salaryEntity.getEmployeeId());
        return salaryEntity.getEmployeeId();
    }
}
