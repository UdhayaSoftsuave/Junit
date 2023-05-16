package com.example.JuintTesting.service;

import com.example.JuintTesting.entity.Student;
import com.example.JuintTesting.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {

    private StudentRepository studentRepository;

    public Mono<Student> saveStudent(Student student){
        return studentRepository.save(student);
    }

    public Flux<Student> getAll(){
        return studentRepository.findAll();
    }

    public Mono<Student> getStudentById(String id){
        return studentRepository.findById(id).doOnNext(stud ->log.info("Student : " + stud));
    }
    public Mono<Student> getStudentByName(String name){
        return studentRepository.findByName(name);
    }

    public Mono<Student> updateStudent(String id , Student student){
        return studentRepository.findById(id)
                .map(s -> new Student(id , student.name() , student.age(),student.std()))
                .flatMap(studentRepository::save).log();

    }
    public Mono<String> delete(String id){
        return studentRepository.deleteById(id)
                .thenReturn(new String("Successfully deleted!!"));
    }

}
