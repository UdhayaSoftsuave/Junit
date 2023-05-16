package com.example.JuintTesting.controller;

import com.example.JuintTesting.entity.Student;
import com.example.JuintTesting.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
@Slf4j
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public Mono<Student> saveStudent(@RequestBody Student student){
        log.info("Student is going to save in DB" + student);
        return studentService.saveStudent(student);
    }

    @GetMapping
    public Flux<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/id/{id}")
    public Mono<Student> getById(@PathVariable("id") String id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/name/{name}")
    public Mono<Student> getByName(@PathVariable("name") String name){
        return studentService.getStudentByName(name);
    }

    @PutMapping("/{id}")
    public Mono<Student> update(@PathVariable("id") String id , @RequestBody Student student){
        return studentService.updateStudent(id , student);
    }

    @DeleteMapping("/{id}")
    public Mono<String> delete(@PathVariable("id") String id ){
        return studentService.delete(id);
    }
}
