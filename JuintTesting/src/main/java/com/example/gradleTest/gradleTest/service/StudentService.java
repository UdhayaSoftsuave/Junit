package com.example.gradleTest.gradleTest.service;

import com.example.gradleTest.gradleTest.entity.Student;
import com.example.gradleTest.gradleTest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Mono<Student> saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Flux<Student> getAll(){
        return studentRepository.findAll();
    }

    public Mono<Student> getStudentById(String id){
        return studentRepository.findById(id);
    }
    public Mono<Student> getStudentByName(String name){
        return studentRepository.findByName(name);
    }

    public Mono<Student> updateStudent(String id , Student student){
        return studentRepository.findById(id)
                .map(s -> new Student(id , student.getName() , student.getAge(),student.getStd()))
                .flatMap(studentRepository::save).log();

    }
    public Mono<String> delete(String id){
        return studentRepository.deleteById(id)
                .thenReturn(new String("Successfully deleted!!"));
    }

}

