package com.example.gradleTest.gradleTest.controller;

import com.example.gradleTest.gradleTest.entity.Student;
import com.example.gradleTest.gradleTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Mono<Student> saveStudent(@RequestBody Student student){
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

